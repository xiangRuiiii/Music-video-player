package cn.itcast.ks.androidks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


// 音乐播放器

public class MusicPage extends Service {
    public MusicPage() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
