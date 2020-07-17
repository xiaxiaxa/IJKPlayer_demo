package com.example.ijkplayer.activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Button;
import com.mgtv.exodemo.R;

import org.xutils.view.annotation.ViewInject;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Context mContext;
    @ViewInject(R.id.ijk_btn)
    private Button mHlsButton;//hls 流点击播放

    public int getLayoutRes() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return R.layout.activity_main;
    }


    @Override
    public void init() {
        mContext = this;
        mHlsButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == mHlsButton) {
            Intent intent = new Intent(mContext, IJKPlayerActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
