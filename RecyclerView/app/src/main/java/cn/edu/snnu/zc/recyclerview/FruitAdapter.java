package cn.edu.snnu.zc.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Fruit> mFruitList;

//    viewHolder内部类

    public FruitAdapter(List<Fruit> fruitList) {
        this.mFruitList = fruitList;
    }

//加载fruit_item布局,创建ViewHolder

    /**RecyclerView也必须能响应点击事件才可以，不过不同于ListView的是，RecyclerView并没有提供类似于
     setOnItemClickListener()这样的注册监听器方法，而是需要我们自己给子项具体的View去注册点击事件。
     */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked view "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"You clicked the image "+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
//        holder.fruitView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                Fruit fruit = mFruitList.get(position);
//                Toast.makeText(v.getContext(),"You clicked the TextView "+fruit.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });
        return holder;
    }

//    用于对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行，这里我们通过
//position参数得到当前项的Fruit实例，然后再将数据设置到ViewHolder的ImageView和TextView当中即可。
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        Log.e("debug", "fruit:"+fruit);
        Log.e("debug", "holder:"+holder);
        Log.e("debug", "onBindViewHolder+fruitImage:"+holder.fruitImage);
        Log.e("debug", "onBlindViewHolder+fruitName:"+holder.fruitName);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
