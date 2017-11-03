package com.jimmie.java.基本测试.all.common.classloader;

/**
 * Created by Jay on 5/4/17.
 */
public class MusicPlayer {

    public void start() {
        System.out.printf("start Play Music");
    }

    public void end() {
        System.out.printf("end play music");
    }

    private MusicPlayer instance;
    
    public void setMusicPlayer(Object musicPlayer2) {
        this.instance = (MusicPlayer) musicPlayer2;
    }

}
