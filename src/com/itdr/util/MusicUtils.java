package com.itdr.util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MusicUtils {
    public static void getMusic(String path){
        try {
            InputStream inputStream = new FileInputStream(path);
            AudioStream stream = new AudioStream(inputStream);
            AudioPlayer.player.start(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
