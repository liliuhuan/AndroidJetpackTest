package com.app.suit.customviewp.annotation;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.app.suit.customviewp.R;
@Bind(value = R.layout.activity_bind)
public class BindActivity extends AppCompatActivity {
    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BindHandler.handleBind(this);
    }

    @Bind(R.id.btn)
    public void clickBtn(){
        Toast.makeText(this,"bind 事件",Toast.LENGTH_LONG).show();
        String str = "事件1122222222222222222221122ssjsjsjsjsjsjsjsjsjsjsjsjsjsjjsjsjsjsjsjsj哈哈哈哈哈哈哈";
        tvFirst.setText(str);
        autoSplitText(tvFirst);
    }

    private void autoSplitText(final TextView tv) {
        final String rawText = tv.getText().toString(); //原始文本
        final Paint tvPaint = tv.getPaint(); //paint，包含字体等信息
        final float tvWidth = tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight(); //控件可用宽度
        //将原始文本按行拆分
        String[] rawTextLines = rawText.replaceAll("\r", "").split("\n");
        StringBuilder sbNewText = new StringBuilder();
        for (String rawTextLine : rawTextLines) {
            if (tvPaint.measureText(rawTextLine) <= tvWidth) {
                //如果整行宽度在控件可用宽度之内，就不处理了
                sbNewText.append(rawTextLine);
            } else {
                //如果整行宽度超过控件可用宽度，则按字符测量，在超过可用宽度的前一个字符处手动换行
                float lineWidth = 0;
                for (int cnt = 0; cnt != rawTextLine.length(); ++cnt) {
                    char ch = rawTextLine.charAt(cnt);
                    lineWidth += tvPaint.measureText(String.valueOf(ch));
                    if (lineWidth <= tvWidth) {
                        sbNewText.append(ch);
                    } else {
                        sbNewText.append("\n");
                        lineWidth = 0;
                        --cnt;
                    }
                }
            }
            sbNewText.append("\n");
        }
        //把结尾多余的\n去掉
        if (!rawText.endsWith("\n")) {
            sbNewText.deleteCharAt(sbNewText.length() - 1);
        }
        tv.setText(sbNewText.toString());
    }
}
