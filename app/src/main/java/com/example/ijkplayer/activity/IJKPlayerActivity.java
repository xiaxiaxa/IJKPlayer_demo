package com.example.ijkplayer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ijkplayer.VideoListener;
import com.example.ijkplayer.view.PlayerView;
import com.mgtv.exodemo.R;

import java.io.IOException;

import tv.danmaku.ijk.media.player.IMediaPlayer;

public class IJKPlayerActivity extends Activity implements VideoListener {
    private PlayerView mMediaPlayer = null;
    private String videoUrlRtp = "rtp://239.76.245.115:1234";
    private String videoUrlHls = "http://10.255.30.137:8082/EDS/RedirectPlay/000000000000/vod/f95e41c67ca2410c89b335ee5f5eecb8/3cc6fae6d07740aa8d57934e26cc2632?UserToken=123456789&UserName=6830018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ijkplayer);
        mMediaPlayer = findViewById(R.id.ijk_player);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initIJKPlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseData();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseData();
    }

    private void releaseData() {
        if (isFinishing()) {
            if (mMediaPlayer != null) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
                mMediaPlayer = null;
            }
        }
    }

    /**
     * 初始化播放器
     */
    private void initIJKPlayer() {
        mMediaPlayer.setVideoListener(this);
        mMediaPlayer.setPath(videoUrlRtp);
        /**false 软解，true:硬解 默认使用硬解码*/
        mMediaPlayer.setEnableMediaCodec(true);
        try {
            mMediaPlayer.load();
        } catch (IOException e) {
            Toast.makeText(this, "播放失败", Toast.LENGTH_SHORT);
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        mMediaPlayer.start();
    }

    @Override
    public void onSeekComplete(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

    }

}
