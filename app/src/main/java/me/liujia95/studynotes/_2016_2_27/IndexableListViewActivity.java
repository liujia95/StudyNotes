package me.liujia95.studynotes._2016_2_27;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.liujia95.studynotes.R;
import me.liujia95.studynotes._2016_2_27.utils.StringMatcher;
import me.liujia95.studynotes._2016_2_27.view.IndexableListView;

/**
 * Created by Administrator on 2016/2/27 20:23.
 */
public class IndexableListViewActivity extends Activity {

    private ArrayList<String> mItems;

    @InjectView(R.id.indexable_listview)
    IndexableListView mListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexable_listview);
        initView();
        initData();
    }

    private void initView() {
        ButterKnife.inject(this);
    }

    private void initData() {
        /*
         * 1、初始化items
         * 2、根据section获取position
         */
        mItems = new ArrayList<>();
        mItems.add("Diary of a Wimpy Kid 6: Cabin Fever");
        mItems.add("Steve Jobs");
        mItems.add("Inheritance (The Inheritance Cycle)");
        mItems.add("11/22/63: A Novel");
        mItems.add("The Hunger Games");
        mItems.add("The LEGO Ideas Book");
        mItems.add("Explosive Eighteen: A Stephanie Plum Novel");
        mItems.add("Catching Fire (The Second Book of the Hunger Games)");
        mItems.add("Elder Scrolls V: Skyrim: Prima Official Game Guide");
        mItems.add("Death Comes to Pemberley");
        mItems.add("Diary of a Wimpy Kid 6: Cabin Fever");
        mItems.add("Steve Jobs");
        mItems.add("Inheritance (The Inheritance Cycle)");
        mItems.add("11/22/63: A Novel");
        mItems.add("The Hunger Games");
        mItems.add("The LEGO Ideas Book");
        mItems.add("Explosive Eighteen: A Stephanie Plum Novel");
        mItems.add("Catching Fire (The Second Book of the Hunger Games)");
        mItems.add("Elder Scrolls V: Skyrim: Prima Official Game Guide");
        mItems.add("做作");
        mItems.add("Alwangs waiting for you !");
        mItems.add("Be with you !");
        mItems.add("Calls you just to say hi.");
        mItems.add("Dear ,good ninght.");
        mItems.add("Expect the whole of you . ");
        mItems.add("Forever stand by you .");
        mItems.add("Give you what you need");
        mItems.add("Hope you enjoy your life.");
        mItems.add("I love you.");
        mItems.add("You jump ,I jump.");
        mItems.add("Kiss you when you wake.");
        mItems.add("Learn to know you .");
        mItems.add("Make more surprise in your life.");
        mItems.add("Never make you cry .");
        mItems.add("Offer support.");
        mItems.add("Put you in my heart.");
        mItems.add("Quit your fears.");
        mItems.add("Run with you . ");
        mItems.add("Sing a song for you .");
        mItems.add("To be yours.");
        mItems.add("Understand you .");
        mItems.add("Value myself on you . ");
        mItems.add("Wake you up everday.");
        mItems.add("Xl love for you .");
        mItems.add("You are alwangs so addictive");
        mItems.add("Zeal for you . ");

        // 排序
        Collections.sort(mItems);

        ContentAdapter adapter = new ContentAdapter(this, android.R.layout.simple_list_item_1, mItems);
        mListview.setAdapter(adapter);
        //设置快速滑动 这一步骤包含了右侧索引初始化的过程
        mListview.setFastScrollEnabled(true);
    }

    private class ContentAdapter extends ArrayAdapter<String> implements SectionIndexer {

        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ContentAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }

        @Override
        public Object[] getSections() {
            String[] sections = new String[mSections.length()];
            // 将每个section作为单个数组元素放到sections中
            for (int i = 0; i < mSections.length(); i++) {
                sections[i] = String.valueOf(mSections.charAt(i));
            }
            return sections;
        }

        @Override
        public int getPositionForSection(int sectionIndex) {
            //从当前的section往前查，直到遇到第一个有对应的item为止，否则不进行定位
            for (int i = sectionIndex; i >= 0; i--) {
                for (int j = 0; j < getCount(); j++) {
                    if (i == 0) {
                        //查询数字
                        for (int k = 0; k <= 9; k++) {
                            if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(k))) {
                                return j;
                            }
                        }
                    } else {
                        //查询字母
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(mSections.charAt(i)))) {
                            return j;
                        }
                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }
    }
}
