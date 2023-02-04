package cn.edu.snnu.zc.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;


//定义一个广播接收者，并重写onReceive方法，每次接收到广播，广播接收者就会调用onReceive方法
public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"network changes",Toast.LENGTH_SHORT).show();
    }
}