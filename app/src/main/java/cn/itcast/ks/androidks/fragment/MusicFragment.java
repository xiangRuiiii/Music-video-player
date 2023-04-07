package cn.itcast.ks.androidks.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.ks.androidks.service.MusicActivityPage;
import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.adapter.MusicAdapter;
import cn.itcast.ks.androidks.bean.MusicBean;

/**
 * Created by Administrator on 2023/4/4.
 */

public class MusicFragment extends Fragment {

    private List<MusicBean> musicBeanList;
    private MusicBean musicBean;
    private MusicAdapter musicAdapter;
    private ListView listView;

    public static int[] icons = {R.drawable.zhoujielun,R.drawable.xuezhiqian,R.drawable.beyond,R.drawable.caijianya};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View messageLayout = inflater.inflate(R.layout.music_listview_layout, container, false);
        listView = messageLayout.findViewById(R.id.listView_music);
        initView();

        // 创建适配器
        musicAdapter = new MusicAdapter(this.getContext(),musicBeanList);
        // listView绑定适配器
        listView.setAdapter(musicAdapter);
        // 执行点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {
                musicBean = musicBeanList.get(i);
                // 执行点击事件  点击加载音乐
                Intent intent = new Intent(MusicFragment.this.getContext(), MusicActivityPage.class);
                intent.putExtra("name",musicBean.getMusicName());
                intent.putExtra("singer",musicBean.getMusicSinger());
                intent.putExtra("image",String.valueOf(i));

                // 开始跳转
                startActivity(intent);

//                Log.i("Tag",musicBean.getMusicName());
            }
        });

        return messageLayout;
    }


    private void initView(){
        // 创建集合存放音乐
        musicBeanList = new ArrayList<>();

        //初始化音乐并放入集合中
        musicBeanList.add(new MusicBean("夏   天","周杰伦",R.drawable.zhoujielun));
        musicBeanList.add(new MusicBean("绅   士","薛之谦",R.drawable.xuezhiqian));
        musicBeanList.add(new MusicBean("海阔天空","Beyond",R.drawable.beyond));
        musicBeanList.add(new MusicBean("Letting go~","蔡健雅",R.drawable.caijianya));

    }
}
