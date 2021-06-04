package com.example.user.model;

import lombok.Data;

@Data
public class PublicMaterialBase {
    private String pid;
    private byte[] thumbnail;
    private String picture_url;

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getPicture_url() {
        return picture_url;
    }
    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}