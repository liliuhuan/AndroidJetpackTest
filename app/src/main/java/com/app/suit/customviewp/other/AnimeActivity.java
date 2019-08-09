package com.app.suit.customviewp.other;

import android.accounts.NetworkErrorException;
import android.animation.Animator;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.Scroller;

import com.app.suit.customviewp.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AnimeActivity extends AppCompatActivity {
    private static final int PORT = 8080;
    Button button, fab;
    View mPuppet;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);
        button = findViewById(R.id.button);
        fab = findViewById(R.id.fab);
//        button.setBackgroundResource(R.drawable.ripple0);

        fab.post(new Runnable() {
            @Override
            public void run() {
                Log.e("tt---","post_Runnable:w="+fab.getMeasuredWidth()+",h="+fab.getMeasuredHeight());
            }
        });
        setRipple(button);

        udpSendMessage("!123");

        receiveUdp();

        sendTcp("11");

        receiveTcp();

        get("url");

        post("url","content");

        testThread();
    }

    private void testThread() {
//        ConcurrentHashMap
//        HandlerThread
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                10,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()
                ,new ThreadPoolExecutor.AbortPolicy());

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return f(10);
            }
        });

        try {
            Log.e("tt----",future.get()+"");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer f(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return f(i - 1) + f(i - 2);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            Log.e("tt---","onWindowFocusChanged:w="+fab.getMeasuredWidth()+",h="+fab.getMeasuredHeight());
        }
    }

    private String post(String url, String content) {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection cnn = (HttpURLConnection) httpUrl.openConnection();
            cnn.setRequestMethod("POST");
            cnn.setReadTimeout(5000);
            cnn.setConnectTimeout(10000);
            // 设置此方法,允许向服务器输出内容
            cnn.setDoOutput(true);

            OutputStream out = cnn.getOutputStream();
            out.write(content.getBytes());
            out.flush();
            out.close();

            int responseCode = cnn.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = cnn.getInputStream();
                String response = getStringFromInputStream(inputStream);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String get(String url) {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection cnn = (HttpURLConnection) httpUrl.openConnection();
            cnn.setRequestMethod("GET");
            cnn.setReadTimeout(5000);
            cnn.setConnectTimeout(10000);
            int responseCode = cnn.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = cnn.getInputStream();
                String response = getStringFromInputStream(inputStream);
                return response;
            } else {
                throw new NetworkErrorException("response status is "+responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getStringFromInputStream(InputStream in) {
        try {
            BufferedOutputStream out = new BufferedOutputStream(new ByteArrayOutputStream());
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            in.close();
            String response = out.toString();
            out.close();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void receiveTcp() {
        try {
            //1.建立连接，监听端口
            ServerSocket ss = new ServerSocket(PORT);
            //2.连接客户端对象
            while (true) {
                //阻塞式方法，只有客户端连接了才会继续往下运行
                Socket accept = ss.accept();
                //获取ip
                String ip = accept.getInetAddress().getHostAddress();
                //3.获取客户端发送过来的数据
                InputStream in = accept.getInputStream();
                //4.开始读取,获取输入信息
                BufferedReader bff = new BufferedReader(new InputStreamReader(in));
                //读取信息
                String line;
                final StringBuilder sb = new StringBuilder();
                while ((line = bff.readLine()) != null) {
                    sb.append(line);
                }
                Message message = new Message();
                message.obj = sb.toString();
//                handler.sendMessage(message);
                //5.关闭
                //ss.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendTcp(String serverAddress) {
        try {
            Socket s = new Socket(serverAddress, PORT);
            //为了发送数据，应该获得socket流中的输出流
            OutputStream out = s.getOutputStream();
            String content = "yang";
            out.write(content.getBytes());
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void receiveUdp() {
        try {
            DatagramSocket ds = new DatagramSocket(PORT);
            // 创建一个数据包(接收容器)
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys, bys.length);
            // 调用Socket对象接收方法接收数据包
            ds.receive(dp);

            // 获取对方的ip
            String ip = dp.getAddress().getHostAddress();
            // 解析数据
            String data = new String(dp.getData(), 0, dp.getLength());
            Message message = new Message();
            message.obj = data;
            message.what = 2;
//            handler.sendMessage(message);
            // 关闭数据库
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void udpSendMessage(String serverAddress) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String content = "1234";
            byte[] bys = content.getBytes();
            InetAddress byName = InetAddress.getByName(serverAddress);
            DatagramPacket datagramPacket = new DatagramPacket(bys, bys.length, byName, PORT);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 水波纹
     */
    private void setRipple(View mView) {
        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        typedArray.recycle();
        mView.setBackgroundResource(backgroundResource);
    }

    /**
     * Reveal Animation 揭露动画
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revealAnime(View mView) {
        //求出第2个和第3个参数
        int[] vLocation = new int[2];
        fab.getLocationInWindow(vLocation);
        int centerX = vLocation[0] + fab.getWidth() / 2;
        int centerY = vLocation[1] + fab.getHeight() / 2;

        //求出要揭露 View 的对角线，来作为扩散圆的最大半径
        int hypotenuse = (int) Math.hypot(mPuppet.getWidth(), mPuppet.getHeight());

        if (flag) {//隐藏 揭露对象
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(mPuppet, centerX, centerY, hypotenuse, 0);
            circularReveal.setDuration(2000);
            circularReveal.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    mPuppet.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                }
            });
            circularReveal.start();
            flag = false;
        } else {//显示 揭露对象
            Animator circularReveal = ViewAnimationUtils.createCircularReveal(mPuppet, centerX, centerY, 0, hypotenuse);
            circularReveal.setDuration(2000);
            //注意：这里显示 mPuppet 调用并没有在监听方法里，并且是在动画开始前调用。
            mPuppet.setVisibility(View.VISIBLE);
            circularReveal.start();
            flag = true;
        }
    }
}
