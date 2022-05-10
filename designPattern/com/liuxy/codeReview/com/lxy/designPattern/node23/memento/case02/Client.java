package com.liuxy.codeReview.com.lxy.designPattern.node23.memento.case02;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        // 创建一个备忘录管理者
    }
}

/**
 * 视频播放器
 */
class Player {
    private PlayData playData;
    public PlayData getPlayData() {
        return playData;
    }
    public void setPlayData(PlayData playData) {
        this.playData = playData;
    }

}

/**
 * 播放进度
 */
class Progress {
    private PlayData playData;
    public Progress(PlayData playData) {
        this.playData = playData;
    }
    public PlayData getPlayData() {
        return playData;
    }
}

/**
 * 播放记录
 */
class Record {
    private Map<String,Progress> dataMap = new HashMap<>();
    public void put (Progress progress) {
        dataMap.put(progress.getPlayData().getVideoName(),progress);
    }
    public Progress get (String videoName) {
        return dataMap.get(videoName);
    }
}
/**
 *  播放状态描述
 */
class PlayData {
    private String videoName;

    public String playTime;

    public PlayData(String videoName, String playTime) {
        this.videoName = videoName;
        this.playTime = playTime;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
}
