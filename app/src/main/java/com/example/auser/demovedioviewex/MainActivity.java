package com.example.auser.demovedioviewex;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.videoView);
        if (mc == null) {
            mc = new MediaController(this);
            videoView.setMediaController(mc);


        }
        //Log.d("Here1:", Environment.getExternalStorageDirectory().getAbsolutePath());

            //Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Movies/sawing_a_baby_in_half.mp4");///可以取得SD card跟路徑
        Uri uri = Uri.parse("Removable/MicroSD/Movies/sawing_a_baby_in_half.mp4");
            videoView.setVideoURI(uri);
            videoView.setOnPreparedListener(onPreparedListener);
        //requestPermissions();

    }

    MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {
            if (position == 0)
                videoView.start();

            mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                    mc.setAnchorView(videoView);
                }
            });
        }
    };

    /*
    void requestPermissions() {

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.READ_CONTACTS)) {


            } else {


                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        10);


            }
        } else {
            Log.d("Here:", Environment.getExternalStorageDirectory().getAbsolutePath());
            Uri uri = Uri.parse(Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/Movies/sawing_a_baby_in_half.mp4");///可以取得SD card跟路徑
            videoView.setVideoURI(uri);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 10: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    requestPermissions();

                } else {


                }
                return;
            }


        }
    }
    */
}

