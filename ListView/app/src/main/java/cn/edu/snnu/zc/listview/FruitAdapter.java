package cn.edu.snnu.zc.listview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//自定义一个适配器，使其实现ArrayAdapter，并指定泛型为Fruit类
//该适配器用来接收要传给ListView的数据
public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;
//重写了弗雷的一组构造方法，分别传入活动上下文、ListView子项布局的id和需要展示的数据
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
//        ListView子项布局的Id
        resourceId=textViewResourceId;
    }

//    重写getView方法，这个方法在ListView的每个子项被滚动到屏幕内是会被调用
//    convertView参数，这个参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        获取当前项的Fruit实例
        Fruit fruit = getItem(position);
//        LayoutInflater.from()方法构建一个Layoutflater对象，加载布局管理器
//        调用inflate方法布局文件转换为view对象
//        parent代表是为第一个参数指定的父布局。,
//        false代表不将第一个参数表示的布局添加到第二参数的布局中
        View view;
/**

 新增了一个类ViewHolder，用于对ImageView和TextView的控件实例进行缓存，当convertView为null的时候，创建一个
 ViewHolder对象，并将控件的实例存放在ViewHolder里，然后调用View的setTag()方法，将ViewHolder对象存储在View中。
 当convertView不为null的时候，则调用View的getTag()方法，把ViewHolder重新取出。这样所有控件的实例都缓存在了ViewHolder里，
 就没有必要每次都通过findViewById()方法来获取控件实例了。
  */
        ViewHolder viewHolder;
/**
  如果convertView为null，则使用
  LayoutInflater去加载布局；如果不为null，则直接对convertView进行重用。这样就
  大大提高了ListView的运行效率，在快速滚动的时候可以表现出更好的性能。
 */
        if (convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView=(ImageView)view.findViewById(R.id.fruit_iamge);
            viewHolder.fruitName=(TextView)view.findViewById(R.id.fruit_name);
//            将View存储在ViewHolder中
            view.setTag(viewHolder);
        }else{
            view=convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

//       调用findViewById查找fruit的image和name对应的控件
//        在Android重,如何想查找非setContentView方法重加载的布局文件,则需要先获取那个布局文件再调用该布局文件实例对应的findViewById方法
//        ImageView fruitImage = (ImageView)view.findViewById(R.id.fruit_iamge);
//        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
//        fruitImage.setImageResource(fruit.getImageId());
//        fruitName.setText(fruit.getName());
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.imageView.setImageResource(fruit.getImageId());
        return view;
    }
}
