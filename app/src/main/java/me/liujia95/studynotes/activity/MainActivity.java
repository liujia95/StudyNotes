package me.liujia95.studynotes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.liujia95.studynotes.R;
import me.liujia95.studynotes._2016_2_27.IndexableListViewActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.main_listview)
    ListView mListview;

    private List<String> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        ButterKnife.inject(this);
    }

    private void initData() {
        mItems = new ArrayList<>();
        mItems.add("2016.2.27 索引");
        mItems.add("2016.3.02 键盘面板冲突");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mItems);
        mListview.setAdapter(adapter);
    }

    private void initListener() {
        mListview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                Intent intent0 = new Intent(this, IndexableListViewActivity.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(this,me.liujia95.studynotes._2016_3_02.utils.MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
