package com.app.suit.customviewp.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.LruCache;
import android.widget.ImageView;

/**
 * @author: 李刘欢
 * @date：2019/7/5 14:23
 * @version:1.0.0
 * @description: TestBitmap
 */
public class TestBitmap {
    int maxMemory = (int) Runtime.getRuntime().maxMemory(); // 获取应用的最大可用内存
    int cacheMemory = maxMemory / 8;	// 设置LruCache缓存最大值
    LruCache<String, Bitmap> mLruCache = new LruCache<String, Bitmap>(cacheMemory) {
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes() * value.getHeight();
        }
    };

    /**
     *
     * @param url
     * @param imageView
     */
    public void showImageByAsyncTask(String url, ImageView imageView) {
        // 1.先从内存缓存获取Bitmap
        Bitmap bitmap = getBitmapFromMemoryCache(url);
        if (bitmap == null) {
            // 当内存缓存没有的时候，从SD卡获取
            bitmap = getBitmapFromSD(url);
            if (bitmap == null) {
                // SD卡也没有的时候，联网获取
                BitmapWorkerTask myAsyncTask = new BitmapWorkerTask(imageView,url);
                myAsyncTask.execute();
            } else {
                if ((url).equals(imageView.getTag())) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        } else {
            if ((url).equals(imageView.getTag())) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    private Bitmap getBitmapFromSD(String url) {
        return null;
    }

    // 通过图片url获取缓存在LruCache中的Bitmap
    private Bitmap getBitmapFromMemoryCache(String url) {
        return mLruCache.get(url);
    }

    // 把获取到的Bitmap缓存到LruCache
    private void addCache(String url, Bitmap bitmap) {
        if (getBitmapFromMemoryCache(url) == null) {
            mLruCache.put(url, bitmap);
        }
    }

    /** 并发问题
     * @param url
     * @param imageView
     */
    public static void loadBitmap(String url, ImageView imageView) {
        if (cancelPotentialWork(url, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(imageView,"url");
            final AsyncDrawable asyncDrawable = new AsyncDrawable(Resources.getSystem(), null, task);
            imageView.setImageDrawable(asyncDrawable);
            task.execute();
        }
    }

    private static boolean cancelPotentialWork(String url, ImageView imageView) {
        final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

        if (bitmapWorkerTask != null) {
            final String bitmapData = bitmapWorkerTask.url;
            if (bitmapData == null || !bitmapData.equals(url)) {
                // Cancel previous task
                bitmapWorkerTask.cancel(true);
            } else {
                // The same work is already in progress
                return false;
            }
        }
        // No task associated with the ImageView, or an existing task was cancelled
        return true;
    }

    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }
}
