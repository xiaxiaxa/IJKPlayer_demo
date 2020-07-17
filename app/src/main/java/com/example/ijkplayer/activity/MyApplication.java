package com.example.ijkplayer.activity;

import android.app.Application;


import java.io.File;

public class MyApplication extends Application {
    protected String userAgent;
    private static final String DOWNLOAD_CONTENT_DIRECTORY = "downloads";
    private File downloadDirectory;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private File getDownloadDirectory() {
        if (downloadDirectory == null) {
            downloadDirectory = getExternalFilesDir(null);
            if (downloadDirectory == null) {
                downloadDirectory = getFilesDir();
            }
        }
        return downloadDirectory;
    }
}

