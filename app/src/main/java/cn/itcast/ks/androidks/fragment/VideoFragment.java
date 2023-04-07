package cn.itcast.ks.androidks.fragment;

import android.app.Fragment;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.adapter.VideoAdapter;


import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Administrator on 2023/4/4.
 */

public class VideoFragment extends Fragment {

    private ListView listView;
    private static final String TAG = "MainActivity";
    private VideoAdapter mAdapter;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View messageLayout = inflater.inflate(R.layout.video_listview_layout, container, false);
        listView = messageLayout.findViewById(R.id.list_view);

        mAdapter = new VideoAdapter(this.getContext());
        listView.setAdapter(mAdapter);
        mSensorManager = (SensorManager)this.getContext().getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();

        return messageLayout;
    }


    @Override
    public void onResume() {
        super.onResume();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (JCVideoPlayer.backPress()) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
        JCVideoPlayer.releaseAllVideos();
        Log.e(TAG, "onPause");
    }
}
