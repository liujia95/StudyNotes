package me.liujia95.studynotes._2016_3_06.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.liujia95.studynotes.R;

/**
 * Created by Administrator on 2016/3/6 14:04.
 */
public class MainActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.group_view_btn_youku)
    Button mBtnYouku;
    @InjectView(R.id.group_view_btn_spinner)
    Button mBtnSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_group_view);

        ButterKnife.inject(this);

        initListener();
    }

    private void initListener() {
        mBtnSpinner.setOnClickListener(this);
        mBtnYouku.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnYouku) {
            Intent intent = new Intent(this, YoukuMenuActivity.class);
            startActivity(intent);
        } else if (v == mBtnSpinner) {
            Intent intent = new Intent(this, SpinnerActivity.class);
            startActivity(intent);
        }
    }
}
