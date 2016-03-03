package me.liujia95.studynotes._2016_3_03;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.liujia95.studynotes.R;
import me.liujia95.studynotes._2016_3_03.bean.DataBean;
import me.liujia95.studynotes._2016_3_03.utils.ListUtil;
import me.liujia95.studynotes._2016_3_03.view.SlideBar;

/**
 * Created by Administrator on 2016/3/3 10:57.
 */
public class SlideBarActivity extends Activity implements AdapterView.OnItemClickListener, SlideBar.OnTouchAssortListener {
    private SlideBar       mSlideBar;
    private ListView       mListView;
    private List<DataBean> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidebar);
        mSlideBar = (SlideBar) findViewById(R.id.slidebar);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemClickListener(this);
        mSlideBar.setOnTouchAssortListener(this);
        setData();
    }
    private void setData(){
        mList = new ArrayList<DataBean>();
        String[] names = getResources().getStringArray(R.array.array_name);
        String[] phones = getResources().getStringArray(R.array.array_phone);
        for(int i=0;i<names.length;i++){
            DataBean data = new DataBean(names[i],phones[i],DataBean.TYPE_DATA);
            mList.add(data);
        }
        ListUtil.sortList(mList);
        mListView.setAdapter(new MyAdapter(this, mList));
    }
    @Override
    public void onTouchAssortListener(String s){
        int select = getSelectIndex(s);
        if(select!=-1){
            mListView.setSelection(select);
        }
    }

    private int getSelectIndex(String s){
        for(int i=0;i<mList.size();i++){
            String name = mList.get(i).getName();
            if(name.equals(s)){
                return i;
            }
        }
        return -1;
    }

    private class MyAdapter extends BaseAdapter {

        private Context        mContext;
        private List<DataBean> mData;

        public MyAdapter(Context context,List<DataBean> list){
            mContext = context;
            mData = list;
        }

        @Override
        public int getCount(){
            return mData.size();
        }

        @Override
        public Object getItem(int position){
            return mData.get(position);
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            int type = mData.get(position).getItem_type();
            String name = mData.get(position).getName();
            if(type== DataBean.TYPE_CHARACTER){
                convertView = View.inflate(mContext, R.layout.item_list_character, null);
                TextView tv_character = (TextView) convertView.findViewById(R.id.tv_item_character);
                tv_character.setText(name);
            }else{
                convertView = View.inflate(mContext, R.layout.item_list_people, null);
                TextView tv_name = (TextView) convertView.findViewById(R.id.tv_item_people_name);
                tv_name.setText(name);
            }
            return convertView;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DataBean bean = (DataBean)parent.getItemAtPosition(position);
        int type = bean.getItem_type();
        if(type==DataBean.TYPE_DATA){
            Toast.makeText(this, bean.getPhone(), Toast.LENGTH_SHORT).show();
        }
    }
}
