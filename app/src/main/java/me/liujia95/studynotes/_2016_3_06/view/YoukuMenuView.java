package me.liujia95.studynotes._2016_3_06.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewHelper;

import me.liujia95.studynotes.R;


/**
 * Created by Administrator on 2016/3/6 14:26.
 */
public class YoukuMenuView extends RelativeLayout implements View.OnClickListener {

    private boolean isLevel1Display = true;
    private boolean isLevel2Display = true;
    private boolean isLevel3Display = true;

    private int mAnimationCount = 0; //有几个动画正在在播放

    RelativeLayout mLevel3Container;
    RelativeLayout mLevel2Container;
    ImageView      mLevel2Menu;
    RelativeLayout mLevel1Container;
    ImageView      mLevel1Home;

    public YoukuMenuView(Context context) {
        this(context, null);
    }

    public YoukuMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_youkumenu, this);

        //设置获得window中的焦点，可以获得activity中的事件
        setFocusableInTouchMode(true);

        assignViews();
        initListener();
    }

    private void assignViews() {
        mLevel3Container = (RelativeLayout) findViewById(R.id.youkumenu_level3_container);
        mLevel2Container = (RelativeLayout) findViewById(R.id.youkumenu_level2_container);
        mLevel2Menu = (ImageView) findViewById(R.id.youkumenu_level2_menu);
        mLevel1Container = (RelativeLayout) findViewById(R.id.youkumenu_level1_container);
        mLevel1Home = (ImageView) findViewById(R.id.youkumenu_level1_home);
    }

    /**
     * 初始化事件
     */
    private void initListener() {
        mLevel1Home.setOnClickListener(this);
        mLevel2Menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLevel1Home) {
            clickLevel1Home();
        } else if (v == mLevel2Menu) {
            clickLevel2Menu();
        }
    }

    /**
     * 点击了一级菜单的home键
     */
    private void clickLevel1Home() {
        if (mAnimationCount != 0) {
            return;
        }
        if (isLevel1Display && isLevel2Display && isLevel3Display) {
            //如果三个层级都在，点击一级home键，隐藏二，三
            hidenLevelAnimator(mLevel2Container, 100);
            hidenLevelAnimator(mLevel3Container, 0);
            isLevel2Display = false;
            isLevel3Display = false;
        } else if (isLevel1Display && !isLevel2Display && !isLevel3Display) {
            //如果一级在，二，三不在，显示二级
            showLevelAnimator(mLevel2Container, 0);
            isLevel2Display = true;
        } else if (isLevel1Display && isLevel2Display && !isLevel3Display) {
            //如果一，二级在，三不在，隐藏二级
            hidenLevelAnimator(mLevel2Container, 0);
            isLevel2Display = false;
        }
    }

    /**
     * 点击了二级菜单的menu键
     */
    private void clickLevel2Menu() {
        if (mAnimationCount != 0) {
            return;
        }
        if (isLevel1Display && isLevel2Display && isLevel3Display) {
            //如果三个层级都在，点击二级menu键，隐藏三
            hidenLevelAnimator(mLevel3Container, 0);
            isLevel3Display = false;
        } else if (isLevel1Display && isLevel2Display && !isLevel3Display) {
            //如果一，二级在，三不在，显示三级
            showLevelAnimator(mLevel3Container, 0);
            isLevel3Display = true;
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_MENU:
                //点击硬件菜单
                clickHardwareMenu();
                return true;//不将点击事件继续向下传递
        }
        return super.onKeyUp(keyCode, event);
    }

    /**
     * 点击硬件菜单
     */
    private void clickHardwareMenu() {
        if (isLevel2Display && isLevel2Display && isLevel3Display) {
            //如果一二三都在，隐藏一二三
            hidenLevelAnimator(mLevel1Container, 200);
            hidenLevelAnimator(mLevel2Container, 100);
            hidenLevelAnimator(mLevel3Container, 0);
            isLevel1Display = false;
            isLevel2Display = false;
            isLevel3Display = false;
        } else if (!isLevel1Display && !isLevel2Display && !isLevel3Display) {
            //如果一二三不在，显示一二三
            showLevelAnimator(mLevel3Container, 200);
            showLevelAnimator(mLevel2Container, 100);
            showLevelAnimator(mLevel1Container, 0);
            isLevel1Display = true;
            isLevel2Display = true;
            isLevel3Display = true;
        } else if (isLevel1Display && isLevel2Display && !isLevel3Display) {
            //如果一二在，三不在，隐藏一二
            hidenLevelAnimator(mLevel1Container, 100);
            hidenLevelAnimator(mLevel2Container, 0);
            isLevel1Display = false;
            isLevel2Display = false;
        } else if (isLevel1Display && !isLevel2Display && !isLevel3Display) {
            //如果一在，隐藏一
            hidenLevelAnimator(mLevel1Container, 0);
            isLevel1Display = false;
        }
    }

    /**
     * 隐藏层级的动画
     *
     * @param container  容器
     * @param startDelay 动画播放的延迟时长(ms)
     */
    private void hidenLevelAnimator(RelativeLayout container, long startDelay) {
        //给控件设置中轴
        ViewHelper.setPivotX(container, container.getWidth() / 2);
        ViewHelper.setPivotY(container, container.getHeight());

        //属性动画：旋转--> 0 --> -180
        ObjectAnimator animator = ObjectAnimator.ofFloat(container, "rotation", 0, -180);
        animator.setDuration(600);
        animator.setStartDelay(startDelay);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mAnimationCount++;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimationCount--;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }

    /**
     * 显示层级的动画
     *
     * @param container  容器
     * @param startDelay 动画播放的延迟时长(ms)
     */
    private void showLevelAnimator(RelativeLayout container, long startDelay) {
        //给控件设置中轴
        container.setPivotX(container.getWidth() / 2);
        container.setPivotY(container.getHeight());

        //属性动画：旋转--> -180 --> 0
        ObjectAnimator animator = ObjectAnimator.ofFloat(container, "rotation", -180, 0);
        animator.setDuration(600);
        animator.setStartDelay(startDelay);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mAnimationCount++;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mAnimationCount--;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }
}
