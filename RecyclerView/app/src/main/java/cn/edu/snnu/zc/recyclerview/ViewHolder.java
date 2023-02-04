package cn.edu.snnu.zc.recyclerview;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

//保存外层视图布局
    View fruitView;
    ImageView fruitImage;
    TextView fruitName;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        fruitView=itemView;
        this.fruitImage=(ImageView) itemView.findViewById(R.id.fruit_image);
        this.fruitName=(TextView) itemView.findViewById(R.id.fruit_name);
        Log.e("Viewholder的构造函数", "fruitImage: "+this.fruitImage);
        Log.e("Viewholder的构造函数", "fruitName: "+this.fruitName);
    }

}
