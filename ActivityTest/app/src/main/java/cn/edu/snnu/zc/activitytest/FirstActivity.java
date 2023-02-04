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
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

//    创建活动，在该方法中完成活动的初始化，加载布局，绑定事件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        调用父类的onCreate方法创建一个Activity
        super.onCreate(savedInstanceState);
//        加载名为first——layout的布局文件
        setContentView(R.layout.first_layout);
//        通过ViewId查找指定的View，并将其从View强转为Button
        Button button1 = (Button)findViewById(R.id.button_1);
//        将Button设置为监听器，监听点击OnClick事件,以匿名内部类的方式传入需要执行的方法
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
//            重写OnClick方法,当点击button1时就执行该方法
            public void onClick(View view) {
//                调用makeText方法创建一个Toast对象，并调用show方法显示
//                makeText方法要求传入Toast的上下文对象,即FirstActivity
                Toast.makeText(FirstActivity.this,
                        "You click Button 1",Toast.LENGTH_SHORT).show();
//              显式Intent实现应用间的跳转
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//               调用startActivity,接收Intent类型的参数,启动Intent对象想启动的活动
//                startActivity(intent);

//                隐式Intent实现应用的跳转
                Intent intent = new Intent("cn.edu.snnu.zc.activitytest.ACTION_START");
//                给Intent对象添加Category
                intent.addCategory("cn.edu.snnu.zc.activitytest.MY_CATEGORY");
                startActivity(intent);
//                结束活动
//                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
/*
MenuInflater是用来实例化Menu目录下的Menu布局文件的。
传统意义上的菜单定义需要Override Activity的onCreateOptionsMenu，
然后在里面调用Menu.add把Menu的一个个item加进来，比较复杂。而通过使用MenuInflater可以把Menu的构造直接放在Menu布局文件中，
 真正实现模型（Model）与视图（View）的分离。
调用getMenuInflater方法获得MenuInflater对象,再调用MenuInflater对象的inflater方法给当前活动创建菜单
 */
        getMenuInflater().inflate(R.menu.main,menu);
//        inflate方法的第一个参数表示加载哪一个menu布局文件来创建menu,第二个方法表示创建的菜单添加给哪一个menu对象
//        返回true,表示允许创建的菜单显示出来;返回false,创建的菜单不允许显示
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clickked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return false;
    }
}