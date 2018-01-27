package com.example.aditya.project_onyx;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/**
 * Created by andi on 1/27/2018.
 */

public class splash_screen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            VideoView videoView = new VideoView(this);
            setContentView(videoView);
            Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash_vid);
            videoView.setVideoURI(path);
            videoView.setLayoutParams(new FrameLayout.LayoutParams(
                            Resources.getSystem().getDisplayMetrics().widthPixels,
                    Resources.getSystem().getDisplayMetrics().heightPixels));
            videoView.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    jump();
                }
            });
            videoView.start();
        }
        catch (Exception e){
            e.printStackTrace();
            jump();
        }
    }

    private void jump() {
        if(isFinishing())
            return;
        startActivity(new Intent(this.getApplicationContext(),MainActivity.class));
    }
}
