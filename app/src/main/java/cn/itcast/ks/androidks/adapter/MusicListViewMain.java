package cn.itcast.ks.androidks.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.bean.MusicBean;

/**
 * Created by Administrator on 2023/4/5.
 */

public class MusicListViewMain extends AppCompatActivity {

    private List<MusicBean> musicBeanList;
    private MusicBean musicBean;
    private MusicAdapter musicAdapter;
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_listview_layout);
        initView();

        // 创建适配器
        musicAdapter = new MusicAdapter(MusicListViewMain.this,musicBeanList);
        // listView绑定适配器
        listView.setAdapter(musicAdapter);
        // 执行点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {
                musicBean = musicBeanList.get(i);
                // 执行点击事件

                Toast.makeText(MusicListViewMain.this,musicBean.getMusicName(),Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initView(){

        listView = findViewById(R.id.listView_music);
        // 创建集合存放音乐
        musicBeanList = new ArrayList <>();

        //初始化音乐并放入集合中
        musicBeanList.add(new MusicBean("我的天空","Beyond",R.drawable.love));
        musicBeanList.add(new MusicBean("我的天空","Beyond",R.drawable.love));
        musicBeanList.add(new MusicBean("我的天空","Beyond",R.drawable.love));
        musicBeanList.add(new MusicBean("我的天空","Beyond",R.drawable.love));

    }

}

