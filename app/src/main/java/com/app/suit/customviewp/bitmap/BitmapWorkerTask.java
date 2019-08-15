package com.app.suit.customviewp.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * @author: 李刘欢
 * @date：2019/7/5 14:09
 * @version:1.0.0
 * @description: BitmapWorkerTask
 */
public class BitmapWorkerTask extends AsyncTask<Void, Void, Bitmap> {
    private WeakReference<ImageView> imageViewReference;
    public String url;

    public BitmapWorkerTask(ImageView imageView, String url) {
        imageViewReference = new WeakReference<ImageView>(imageView);
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        return getBitmapFromServer(url);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
            if (this == bitmapWorkerTask && imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
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

    private Bitmap getBitmapFromServer(String url) {
        URL httpUrl = null;
        Bitmap bitmap = null;
        InputStream is = null;
        try {
            httpUrl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
            is = new BufferedInputStream(httpURLConnection.getInputStream());
            bitmap = decodeSampledBitmap(is, 90);
            httpURLConnection.disconnect();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @param ins
     * @param quality
     * @return
     */
    private Bitmap decodeSampledBitmap(InputStream ins, int quality) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        Bitmap bm = null;
        ByteArrayOutputStream baos = null;
        try {
            byte[] bytes = readStream(ins);
            opts.inJustDecodeBounds = true;
            bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);
            opts.inJustDecodeBounds = false;
            int picWidth = opts.outWidth;// 得到图片宽度
            int picHeight = opts.outHeight;// 得到图片高度
            Log.e("原图片高度：", picHeight + "");
            Log.e("原图片宽度：", picWidth + "");
            opts.inSampleSize = 2;//设置缩放比例
            bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, opts);
            int picWidth2 = opts.outWidth;// 得到图片宽度
            int picHeight2 = opts.outHeight;// 得到图片高度
            Log.e("压缩后的图片宽度：", picWidth2 + "");
            Log.e("压缩后的图片高度：", picHeight2 + "");
            Log.e("压缩后的图占用内存：", bm.getByteCount() + "");
            // 开始质量压缩
            baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, quality, baos);
            byte[] b = baos.toByteArray();
            bm = BitmapFactory.decodeByteArray(b, 0, b.length, opts);
            Log.e("质量压缩后的占用内存：", bm.getByteCount() + "");
            return bm;
        } catch (Exception e) {
            e.printStackTrace();
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
            }
        }
        return bm;
    }

    /**
     * 得到图片字节流 数组大小
     */
    private byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 保存Image的方法。
     * 需要注意的地方有：1、判断是否有SD卡；2、判断SD卡存储空间是否够用。
     *
     * @param fileName
     * @param bitmap
     * @throws IOException
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void savaBitmap(String fileName, Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            if (bitmap == null) {
                return;
            }
            String path = Objects.requireNonNull(this.getClass().getPackage()).getName() + "/pic";
            File folderFile = new File(path);
            if (!folderFile.exists()) {
                folderFile.mkdirs();
            }
            File file = new File(path + File.separator + fileName);
            file.createNewFile();
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (IOException E) {

        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
