package cn.itcast.ks.androidks.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.itcast.ks.androidks.R;

/**
 * Created by Administrator on 2023/4/4.
 */

public class FragmentMain extends Activity implements View.OnClickListener{

    // 用于展示music和video的Fragment
    private MusicFragment musicFragment;
    private VideoFragment videoFragment;
    private LoveFragment loveFragment;

    // 音乐和视频界面布局
    private ImageView musicImageView;
    private ImageView videoImageView;
    private ImageView likeImageView;

    // 用于对Fragment继续管理
    private FragmentManager fragmentManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navi_bar_layout);
        init();
        fragmentManager = getFragmentManager();

        setTabSelection(0);

    }


    // 初始化控件
    public void init(){
        musicImageView = findViewById(R.id.imageView_music);
        videoImageView = findViewById(R.id.imageView_video);
        likeImageView = findViewById(R.id.imageView_love);
        musicImageView.setOnClickListener(this);
        videoImageView.setOnClickListener(this);
        likeImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_music:
                // 当点击了music时，选中第1个tab
                setTabSelection(0);
                break;

            case R.id.imageView_love:

                // 实现业务：跳转到我喜欢页面
                setTabSelection(1);

                break;

            case R.id.imageView_video:
//                setTabSelection(2);
                // 直接实现跳转到视频界面
                Intent intent = new Intent(this,VideoMain.class);
                startActivity(intent);
                break;
        }
    }



    // 根据传入参数选择tab页
    private void setTabSelection(int index){

        // 每次选择之前先清除掉上一次选中的Tab
        clearSelection();
        // 开启一个Fragment
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment,防止多个Fragment显示在界面上的情况
        hideFragment(transaction);


        switch (index){

            case 0:
                musicImageView.setImageResource(R.drawable.beclick);
                if(musicFragment == null){
                    // 如果musicFragment为空，创建一个并添加到界面上
                    musicFragment = new MusicFragment();
                    transaction.add(R.id.fl_content,musicFragment);
                }else {
                    // 如果musicFragment不为空，直接将其显示出来
                    transaction.show(musicFragment);
                }
                break;

            case 1:
                // 当点击视频时，改变控件颜色
                likeImageView.setImageResource(R.drawable.likeclick);

//                 实现点击我喜欢点击事件
                if(loveFragment == null){
                    loveFragment = new LoveFragment();
                    transaction.add(R.id.fl_content,loveFragment);
                }else {
                    transaction.show(loveFragment);
                }
                break;

            case 2:
                // 当点击视频时，改变控件颜色
                videoImageView.setImageResource(R.drawable.beclick);

                if(videoFragment == null){
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.fl_content,videoFragment);
                }else {
                    transaction.show(videoFragment);
                }
                break;
        }

        transaction.commit();

    }


    // 将所有的Fragment都置为隐藏状态
    private void hideFragment(FragmentTransaction fragmentTransaction){

        if (musicFragment != null){
            fragmentTransaction.hide(musicFragment);
        }
        if (videoFragment != null){
            fragmentTransaction.hide(videoFragment);
        }
        if (loveFragment != null){
            fragmentTransaction.hide(loveFragment);
        }
    }


    // 清除掉所有选中状态
    private void clearSelection() {
        musicImageView.setImageResource(R.drawable.music);
        videoImageView.setImageResource(R.drawable.video);
        likeImageView.setImageResource(R.drawable.love);

        musicImageView.setBackgroundColor(234226232);
        videoImageView.setBackgroundColor(234226232);
        likeImageView.setBackgroundColor(234226232);
    }
}
