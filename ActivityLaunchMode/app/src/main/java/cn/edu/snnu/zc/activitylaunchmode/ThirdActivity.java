package cn.edu.snnu.zc.activitylaunchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecActivity", "Task id is "+getTaskId());
        setContentView(R.layout.thirdactivity_layout);
    }
}