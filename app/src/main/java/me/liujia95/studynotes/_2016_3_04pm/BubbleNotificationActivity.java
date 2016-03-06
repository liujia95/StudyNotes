package me.liujia95.studynotes._2016_3_04pm;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.liujia95.studynotes.R;

/**
 * Created by Administrator on 2016/3/4 14:12.
 */
public class BubbleNotificationActivity extends Activity {

    @InjectView(R.id.bubble_notification_recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_notification);
        ButterKnife.inject(this);
    }


}
