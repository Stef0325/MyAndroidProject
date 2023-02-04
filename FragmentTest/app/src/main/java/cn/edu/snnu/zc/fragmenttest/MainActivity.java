package cn.edu.snnu.zc.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        replaceFragment(new AnotherRightFragment());
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void replaceFragment(Fragment fragment){
//      调用getSupportFragmentManager()方法获取取FragmentManager，
        FragmentManager fragmentManager = getSupportFragmentManager();
//       调用beginTransaction()方法开启事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//       向容器内添加或替换Fragment，传入容器的id和待添加的Fragment实例。
//        transaction.replace(R.id.rightLayout,fragment);
//      将该事务添加至返回栈中
        transaction.addToBackStack(null);
//        提交事务，调用commit()方法来完成
        transaction.commit();
    }

}