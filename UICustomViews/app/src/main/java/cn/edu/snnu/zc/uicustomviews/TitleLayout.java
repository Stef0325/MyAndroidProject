package cn.edu.snnu.zc.uicustomviews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout {

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        调用LayoutFlater类的from方法，构建出一个Layoutflater对象，然后调用inflate方法，动态加载布局文件
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button titleBack = (Button) findViewById(R.id.titleBack);
        Button titleEdit = (Button) findViewById(R.id.titleEdit);
        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
        titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(((Activity)getContext()),"You clickeed the title Edit button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
