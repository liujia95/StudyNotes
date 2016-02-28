package me.liujia95.studynotes._2016_2_27.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 封装了右侧的索引条及其相关的动作
 * Created by Administrator on 2016/2/27 20:41.
 */
public class IndexableListView extends ListView {

    private boolean         mIsFastScrollEnable = false;
    //负责绘制索引条
    private IndexScroller   mScroller           = null;
    private GestureDetector mGestureDetector    = null;//手势检测器

    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isFastScrollEnabled() {
        return mIsFastScrollEnable;
    }

    @Override
    public void setFastScrollEnabled(boolean enabled) {
        mIsFastScrollEnable = enabled;
        //如果允许FastScroll
        if (mIsFastScrollEnable) {
            if (mScroller == null) {
                mScroller = new IndexScroller(getContext(), this);
            }
        } else {
            if (mScroller != null) {
                //如果页数不多，就不显示快速滑动的索引条
                mScroller.hide();
                mScroller = null;
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas); //绘制listview原本的item
        if (mScroller != null) {
            //绘制右侧的索引条
            mScroller.draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //如果mScroller自己来处理触摸事件，该方法返回true。
        //如果用户手指点到了右侧索引条，就由它自己来处理
        if (mScroller != null && mScroller.onTouchEvent(ev)) {
            return true;
        }
        if (mGestureDetector == null) {
            //使用手势处理触摸事件
            mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    //直接显示右侧的索引条
                    mScroller.show();
                    return super.onFling(e1, e2, velocityX, velocityY);
                }
            });
        }
        mGestureDetector.onTouchEvent(ev);
        return super.onTouchEvent(ev);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (mScroller != null) {
            mScroller.setAdapter(adapter);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mScroller != null) {
            //当屏幕方向发生改变，索引条也要相应改变
            mScroller.onSizeChanged(w, h, oldw, oldh);
        }
    }
}
