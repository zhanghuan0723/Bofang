package com.cbh.entity;

import java.io.Serializable;

/**
 * Created by Simon on 2014/5/16.
 */
public class Program implements Serializable {
    private String id;
    private String url;
    private String title;

    private String duration;      // 节目总长
    private String currPosition;  // 节目播放当前位置
    private int progressPosition; // 进度条当前位置
    private int seekbarProgress;  // 进度条总长

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCurrPosition() {
        return currPosition;
    }

    public void setCurrPosition(String currPosition) {
        this.currPosition = currPosition;
    }

    public int getProgressPosition() {
        return progressPosition;
    }

    public void setProgressPosition(int progressPosition) {
        this.progressPosition = progressPosition;
    }

    public int getSeekbarProgress() {
        return seekbarProgress;
    }

    public void setSeekbarProgress(int seekbarProgress) {
        this.seekbarProgress = seekbarProgress;
    }
}
