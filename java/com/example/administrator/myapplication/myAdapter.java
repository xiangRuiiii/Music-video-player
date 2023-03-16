package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import static com.example.administrator.myapplication.R.*;

/**
 * Created by Administrator on 2023/3/13.
 */

public class myAdapter extends BaseAdapter{

        private Context context;
        private List<ListViewItem> foodList;
        public myAdapter(Context context, List<ListViewItem> foodList){
            this.context = context;
            this.foodList = foodList;
        }
        //填充的item的个数
        public int getCount() {
            return foodList.size();
        }

        //指定索引对应的item的数据项
        public Object getItem(int position) {
            return null;
        }
        //指定索引对应的item的id值
        public long getItemId(int position) {
            return position;
        }
        //填充每个item的内容
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view = null;
            ViewHolder viewHolder = null;
            if(convertView == null){
                //加载布局文件，将布局文件转换成View对象
                view = LayoutInflater.from(context).inflate(layout.list_view_item,null);
                //创建ViewHolder对象
                viewHolder = new ViewHolder();
                //实例化ViewHolder
                viewHolder.foodImage = view.findViewById(id.item_image);
                viewHolder.foodName = view.findViewById(id.item_name);
                viewHolder.describe = view.findViewById(id.describe_text);
                //将viewHolder的对象存储到View中
                view.setTag(viewHolder);
            }else{
                view = convertView;
                //取出ViewHolder
                viewHolder = (ViewHolder)view.getTag();
            }
            //给item中各控件赋值
            viewHolder.foodImage.setImageResource(foodList.get(position).getImageId());
            viewHolder.foodName.setText(foodList.get(position).getName());
            viewHolder.describe.setText(foodList.get(position).getDescribe());
            return view;
        }
    }


    //存放item中的所有控件
    class ViewHolder{
        ImageView foodImage;
        TextView foodName;
        TextView describe;
    }

