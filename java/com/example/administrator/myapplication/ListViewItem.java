package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2023/3/13.
 */

public class ListViewItem {

    private String name;
    private String describe;
    private int imageId;//图片id

    public ListViewItem(String name, String describe, int imageId) {
        this.name = name;
        this.describe = describe;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}



