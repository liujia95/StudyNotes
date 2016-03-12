package me.liujia95.studynotes._2016_3_10;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;

import me.liujia95.studynotes.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Administrator on 2016/3/10 13:08.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gif);
        GifImageView iv = (GifImageView) findViewById(R.id.gif_iv);
        try {
            GifDrawable drawable = new GifDrawable(getAssets(), "face/gif/f001.gif");
            iv.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
