package com.app.suit.customviewp.other;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 粒子背景效果
 */
public class ParticleBackgroundView extends SurfaceView implements SurfaceHolder.Callback, Runnable, Serializable {

    //每秒钟绘制的帧数(帧率)
    private int framesPerSecond = 60;
    //页面上绘制的圆点数量
    private int dotCount = 30;
    //圆点连线的极限距离(px)
    private int lineDistance = 500;
    //背景颜色
    private int backgroundColor = 0xFFE18C3A;
    //圆点颜色(0x)
    private int dotColor = 0x50ffffff;
    //连线颜色(0x)
    private int lineColor = 0x30ffffff;
    //圆点移动速度
    private int dotSpeed = 3;
    //连线宽度(px)
    private int lineSize = 3;
    //圆点最大值
    private int dotSizeMax = 10;
    //圆点最小值
    private int dotSizeMin = 4;

    private SurfaceHolder surfaceHolder;
    private Paint paintDot, paintLine;
    private int viewWidth, viewHeight;
    private boolean isDrawing;
    private List<Dot> dots;

    public ParticleBackgroundView(@NonNull Context context) {
        this(context, null);
    }

    public ParticleBackgroundView(@NonNull Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParticleBackgroundView(@NonNull Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化视图
        init(context, attrs);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new Thread(this).start();
        isDrawing = true;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
    }

    @Override
    public void run() {
        while (isDrawing) {
            long startTime = System.currentTimeMillis();
            drawing();
            long endTime = System.currentTimeMillis();
            //按照fps计算得出的每帧绘制的间隙(一秒/fps-绘制时间)
            long frameSleepTime = 1000 / framesPerSecond - (endTime - startTime);
            //睡眠时间小于等于0则直接下一帧
            if (frameSleepTime <= 0) continue;
            try {
                Thread.sleep(frameSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (viewWidth == 0 && viewHeight == 0) {
            this.viewHeight = getMeasuredHeight();
            this.viewWidth = getMeasuredWidth();
            Random random = new Random();
            for (int i = 0; i < dotCount; i++) {
                //添加点的随机位置，包括xy坐标和角度
                dots.add(new Dot(random.nextInt(viewWidth),
                        random.nextInt(viewHeight), dotSpeed,
                        random.nextInt(dotSizeMax) + dotSizeMin));
            }
        }
    }

    /**
     * 初始化方法
     */
    private void init(@NonNull Context context, AttributeSet attrs) {
        //获取holder
        this.surfaceHolder = getHolder();
        this.surfaceHolder.addCallback(this);
        //设置参数
        this.setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        this.setFocusable(true);
        //创建画笔
        this.paintLine = new Paint();
        paintLine.setAntiAlias(true);
        paintLine.setColor(lineColor);
        this.paintDot = new Paint();
        paintDot.setAntiAlias(true);
        paintDot.setColor(dotColor);
        //初始化点数
        this.dots = new ArrayList<>();
    }

    /**
     * 绘制内容
     */
    private void drawing() {
        if (null == surfaceHolder || null == dots || dots.size() <= 0) {
            isDrawing = false;
            return;
        }
        //开始绘制
        Canvas canvas = surfaceHolder.lockCanvas();
        if (null == canvas) return;
        canvas.drawColor(backgroundColor);
        try {
            //移动圆点并绘制移动后的点
            for (int i = 0; i < dots.size(); i++) {
                Dot dot = dots.get(i);
                dot.move(viewWidth, viewHeight);
                canvas.drawCircle(dot.x, dot.y, dot.size, paintDot);
            }
            //连线
            for (Dot dotA : dots) {
                for (Dot dotB : dots) {
                    double distance = dotA.distanceBy(dotB);
                    if (distance <= lineDistance) {
                        double ratio = 1 - distance * 1.0 / lineDistance;
                        paintLine.setStrokeWidth((int) (ratio * lineSize));
                        canvas.drawLine(dotA.x, dotA.y, dotB.x, dotB.y, paintLine);
                    }
                }
            }
        } finally {
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    /**
     * 点坐标
     */
    private class Dot {
        int x;
        int y;
        int size;
        double mx;
        double my;

        Dot(int x, int y, int dotSpeed, int dotSize) {
            this.mx = Math.random() * dotSpeed;
            this.my = Math.random() * dotSpeed;
            this.x = x;
            this.y = y;
            this.size = dotSize;
        }

        /**
         * 移动圆点
         */
        void move(int viewWidth, int viewHeight) {
            this.mx = (x < viewWidth && x > 0) ? mx : -mx;
            this.my = (y < viewHeight && y > 0) ? my : -my;
            this.x += mx;
            this.y += my;
        }

        /**
         * 计算两点间距离
         *
         * @param dot
         * @return
         */
        double distanceBy(@NonNull Dot dot) {
            int dx = x - dot.x;
            int dy = y - dot.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }
}