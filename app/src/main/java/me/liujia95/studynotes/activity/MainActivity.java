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
import me.liujia95.studynotes._2016_3_03.SlideBarActivity;
import me.liujia95.studynotes._2016_3_04.TestPointActivity;

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
        mItems.add("2016.3.03 首字母分类索引");
        mItems.add("2016.3.04 未读消息小红点");
        mItems.add("2016.3.06 自定义组合控件");
        mItems.add("2016.3.07 仿微信Tab bar");
        mItems.add("2016.3.07pm 仿微信图片选择器");
        mItems.add("2016.3.08 图片的聊天气泡");
        mItems.add("2016.3.08pm 仿QQ聊天界面");
        mItems.add("2016.3.10 用GifImageView加载Gif图片");
        mItems.add("2016.3.17 使用EventBus");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItems);
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
                Intent intent1 = new Intent(this, me.liujia95.studynotes._2016_3_02.utils.MainActivity.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(this, SlideBarActivity.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(this, TestPointActivity.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(this, me.liujia95.studynotes._2016_3_06.activity.MainActivity.class);
                startActivity(intent4);
                break;
            case 5:
                Intent intent5 = new Intent(this, me.liujia95.studynotes._2016_3_07.MainActivity.class);
                startActivity(intent5);
                break;
            case 6:
                Intent intent6 = new Intent(this, me.liujia95.studynotes._2016_3_07pm.imageloader.MainActivity.class);
                startActivity(intent6);
                break;
            case 7:
                Intent intent7 = new Intent(this, me.liujia95.studynotes._2016_3_08.MainActivity.class);
                startActivity(intent7);
                break;
            case 8:
                Intent intent8 = new Intent(this, me.liujia95.studynotes._2016_3_08pm.MainActivity.class);
                startActivity(intent8);
                break;
            case 9:
                Intent intent9 = new Intent(this, me.liujia95.studynotes._2016_3_10.MainActivity.class);
                startActivity(intent9);
                break;
            case 10:
                Intent intent10= new Intent(this, me.liujia95.studynotes._2016_3_17.MainActivity.class);
                startActivity(intent10);
                break;
        }
    }
}
