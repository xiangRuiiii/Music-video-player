package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.myapplication.R.*;

/**
 * Created by Administrator on 2023/3/13.
 */

public class ListViewMain extends AppCompatActivity{

    private List<ListViewItem> foodList;
    private ListViewItem listViewItem;
    private myAdapter adapter;
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.list_view_layout);
        initView();
        //创建适配器
        adapter = new myAdapter(ListViewMain.this,foodList);
        //ListView绑定适配器
        listView.setAdapter(adapter);
        //执行点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                listViewItem = foodList.get(position);
                Toast.makeText(ListViewMain.this,listViewItem.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        listView = (ListView)findViewById(id.list_view);
        //创建集合用来存放food
        foodList = new ArrayList <ListViewItem>();
        //初始化food并添加到集合中
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));
        foodList.add(new ListViewItem("名字","球员的描述", drawable.c_luo));

    }


}
