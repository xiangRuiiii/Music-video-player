package cn.itcast.ks.androidks.fragment;

import android.support.v7.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.adapter.VideoAdapter;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Administrator on 2023/4/7.
 */

public class VideoMain extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ListView mListView;
    private VideoAdapter mAdapter;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_listview_layout);
        mListView =  findViewById(R.id.list_view);
        mAdapter = new VideoAdapter(this);
        mListView.setAdapter(mAdapter);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
        JCVideoPlayer.releaseAllVideos();
        Log.e(TAG, "onPause");
    }
}
