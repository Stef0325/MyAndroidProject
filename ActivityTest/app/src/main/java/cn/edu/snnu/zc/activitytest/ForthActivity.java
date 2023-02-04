package cn.edu.snnu.zc.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ForthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_layout);
        Button button4 = (Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                构建一个Intent,不用来调用活动,二十用来传递消息
                Intent intent = new Intent();
                intent.putExtra("data_return","Hello,ThirdActivity");
//              设置想要返回的结果和数据
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.callTel:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.sendData:
                String data="Hello, FirstActivity";
                Intent intent2 = new Intent(ForthActivity.this, FifthActivity.class);
                intent2.putExtra("extra_data",data);
                startActivity(intent2);
                break;
            default:
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello ThirdActivity");
//              设置想要返回的结果和数据
        setResult(RESULT_OK,intent);
        finish();
    }
}