package cn.itcast.ks.androidks.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.bean.MusicBean;

/**
 * Created by Administrator on 2023/4/5.
 */

public class MusicAdapter extends BaseAdapter{

    private Context context;
    private List<MusicBean> musicBeanList;

    // 构造函数
    public MusicAdapter(Context context, List <MusicBean> musicBeanList) {
        this.context = context;
        this.musicBeanList = musicBeanList;
    }


    // 填充item的个数
    @Override
    public int getCount() {
        return musicBeanList.size();
    }

    // 指定索引对应的item数据项
    @Override
    public Object getItem(int i) {
        return null;
    }

    // 指定索引对应的item的id
    @Override
    public long getItemId(int i) {
        return i;
    }

    // 填充每个item的内容
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = null;
        ViewHolder viewHolder = null;

        if (convertView == null){
            //加载布局文件，将布局文件转换成View对象
            view = LayoutInflater.from(context).inflate(R.layout.music_listview_item,null);
            viewHolder = new ViewHolder();
            //实例化ViewHolder
            viewHolder.musicImage = view.findViewById(R.id.imageView_music);
            viewHolder.musicName = view.findViewById(R.id.textView_name);
            viewHolder.musicSinger = view.findViewById(R.id.textView_singer);
            // 将viewHolder的对象储存在View中
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        // 给item中各个控件赋值
        viewHolder.musicImage.setImageResource(musicBeanList.get(i).getMusicImage());
        viewHolder.musicName.setText(musicBeanList.get(i).getMusicName());
        viewHolder.musicSinger.setText(musicBeanList.get(i).getMusicSinger());

        return view;
    }


    class ViewHolder{
        ImageView musicImage;
        TextView musicName;
        TextView musicSinger;
    }
}
