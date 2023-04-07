package cn.itcast.ks.androidks.bean;

/**
 * Created by Administrator on 2023/4/5.
 */

public class MusicBean {

    private String musicName;
    private String musicSinger;
    private int musicImage;

    public MusicBean(String musicName, String musicSinger, int musicImage) {
        this.musicName = musicName;
        this.musicSinger = musicSinger;
        this.musicImage = musicImage;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public int getMusicImage() {
        return musicImage;
    }

    public void setMusicImage(int musicImage) {
        this.musicImage = musicImage;
    }
}
