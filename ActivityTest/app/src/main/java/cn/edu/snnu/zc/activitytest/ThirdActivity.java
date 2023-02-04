package cn.edu.snnu.zc.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this,"send data to forthActivity",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this, ForthActivity.class);
//      调用startActivityForResult()方法启动活动,被启动的活动在销毁时可以返回一个结果给调用startActivityForResult的活动
                startActivityForResult(intent,1);
            }
        });

    }

//    被startActivityForResult调用的活动在结束后,会回调OnActivityResult来判断结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        requestCode判断数据来源,resultCode判断处理结果是否成功,data从上一个活动返回数据
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (requestCode == RESULT_OK) {
                    String dataReturn = data.getStringExtra("data_return");
                    Log.d("ThirdActivity", dataReturn);
                }
                break;
            default:
        }
    }
}