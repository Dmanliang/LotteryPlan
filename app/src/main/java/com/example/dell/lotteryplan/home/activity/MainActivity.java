package com.example.dell.lotteryplan.home.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.home.adapter.MyFragmentPagerAdapter;
import com.example.dell.lotteryplan.home.fragment.CountryFragment;
import com.example.dell.lotteryplan.home.fragment.FizeFragment;
import com.example.dell.lotteryplan.home.fragment.HappytimeFagment;
import com.example.dell.lotteryplan.home.fragment.HightfrequencyFragment;
import com.example.dell.lotteryplan.home.fragment.HomepageFragment;
import com.example.dell.lotteryplan.home.fragment.LotteryFragment;
import com.example.dell.lotteryplan.home.fragment.LowfrequencyFragment;
import com.example.dell.lotteryplan.home.fragment.OutsideFragment;
import com.example.dell.lotteryplan.home.fragment.QkthreeFragment;
import com.example.dell.lotteryplan.base.BaseActivity;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private RelativeLayout          title_layout;
    private RelativeLayout          main_toolbar;
    private TextView                toolbar_title;
    private ImageView               btn_personal,mark_btn;
    private RadioGroup              radioGroup;
    private RadioButton             homepage,lottery,qkthree,fize,happytime,hightfrequency,country,outside,lowfrequency;
    private ImageView               title_close,lottery_ssc,lottery_ks,lottery_11x5,lottery_kesf,lottery_gpc,lottery_dpc,lottery_jwc,lottery_qgc;
    private ViewPager               mPager;
    private ArrayList<Fragment>     fragmentList = new ArrayList<>();
    private PopupWindow             lotteryWindow;
    private MyFragmentPagerAdapter  fragmentPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setView(R.layout.activity_main);
        initView();
        //初始化ViewPager
        initViewPager();
    }

    //初始化控件
    public void initView(){
        title_layout    =   (RelativeLayout)findViewById(R.id.title_layout);
        main_toolbar    =   (RelativeLayout)findViewById(R.id.main_toolbar);
        toolbar_title   =   (TextView)findViewById(R.id.toolbar_title);
        btn_personal    =   (ImageView)findViewById(R.id.btn_personal);
        mark_btn        =   (ImageView)findViewById(R.id.mark_btn);
        radioGroup      =   (RadioGroup)findViewById(R.id.radioGroup_main);
        homepage        =   (RadioButton)findViewById(R.id.homepage);
        lottery         =   (RadioButton)findViewById(R.id.lottery);
        qkthree         =   (RadioButton)findViewById(R.id.qkthree);
        fize            =   (RadioButton)findViewById(R.id.fize);
        happytime       =   (RadioButton)findViewById(R.id.happytime);
        hightfrequency  =   (RadioButton)findViewById(R.id.hightfrequency);
        country         =   (RadioButton)findViewById(R.id.country);
        outside         =   (RadioButton)findViewById(R.id.outside);
        lowfrequency    =   (RadioButton)findViewById(R.id.lowfrequency);
        mPager          =   (ViewPager)findViewById(R.id.main_viewPager);
        btn_personal.setVisibility(View.VISIBLE);
        btn_personal.setOnClickListener(this);
        mark_btn.setOnClickListener(this);
        homepage.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.homepage:
                        mPager.setCurrentItem(0);
                        break;
                    case R.id.lottery:
                        mPager.setCurrentItem(1);
                        break;
                    case R.id.qkthree:
                        mPager.setCurrentItem(2);
                        break;
                    case R.id.fize:
                        mPager.setCurrentItem(3);
                        break;
                    case R.id.happytime:
                        mPager.setCurrentItem(4);
                        break;
                    case R.id.hightfrequency:
                        mPager.setCurrentItem(5);
                        break;
                    case R.id.country:
                        mPager.setCurrentItem(6);
                        break;
                    case R.id.outside:
                        mPager.setCurrentItem(7);
                        break;
                    case R.id.lowfrequency:
                        mPager.setCurrentItem(8);
                        break;
                }
            }
        });
    }

    //添加切换界面
    private void initViewPager(){
        HomepageFragment        homepageFragment    =   new HomepageFragment();
        LotteryFragment         lotteryFragment     =   new LotteryFragment();
        QkthreeFragment         qkthreeFragment     =   new QkthreeFragment();
        FizeFragment            fizeFragment        =   new FizeFragment();
        HappytimeFagment        happytimeFagment    =   new HappytimeFagment();
        HightfrequencyFragment  hightFragment       =   new HightfrequencyFragment();
        CountryFragment         countryFragment     =   new CountryFragment();
        OutsideFragment         outsideFragment     =   new OutsideFragment();
        LowfrequencyFragment    lowFragment         =   new LowfrequencyFragment();
        fragmentList.add(homepageFragment);
        fragmentList.add(lotteryFragment );
        fragmentList.add(qkthreeFragment );
        fragmentList.add(fizeFragment    );
        fragmentList.add(happytimeFagment);
        fragmentList.add(hightFragment   );
        fragmentList.add(countryFragment );
        fragmentList.add(outsideFragment );
        fragmentList.add(lowFragment     );
        fragmentPagerAdapter = new MyFragmentPagerAdapter(this.getSupportFragmentManager(), fragmentList);
        mPager.setOffscreenPageLimit(2);
        //ViewPager设置适配器
        mPager.setAdapter(fragmentPagerAdapter);
        //ViewPager显示第一个Fragment
        mPager.setCurrentItem(0);
        //ViewPager页面切换监听
        mPager.setOnPageChangeListener(new myOnPageChangeListener());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mark_btn:
                showLotterySelect(v);
                break;
            case R.id.btn_personal:
                startActivity(new Intent(MainActivity.this,PersonalActivity.class));
                break;
            case R.id.title_close:
                lotteryWindow.dismiss();
                break;
            case R.id.lottery_ssc:
                mPager.setCurrentItem(1);
                break;
            case R.id.lottery_ks:
                mPager.setCurrentItem(2);
                break;
            case R.id.lottery_11x5:
                mPager.setCurrentItem(3);
                break;
            case R.id.lottery_kesf:
                mPager.setCurrentItem(4);
                break;
            case R.id.lottery_gpc:
                mPager.setCurrentItem(5);
                break;
            case R.id.lottery_dpc:
                mPager.setCurrentItem(8);
                break;
            case R.id.lottery_jwc:
                mPager.setCurrentItem(7);
                break;
            case R.id.lottery_qgc:
                mPager.setCurrentItem(6);
                break;
        }
    }

    /**
     *ViewPager切换Fragment,RadioGroup做相应变化
     */
    private class myOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    radioGroup.check(R.id.homepage);
                    break;
                case 1:
                    radioGroup.check(R.id.lottery);
                    break;
                case 2:
                    radioGroup.check(R.id.qkthree);
                    break;
                case 3:
                    radioGroup.check(R.id.fize);
                    break;
                case 4:
                    radioGroup.check(R.id.happytime);
                    break;
                case 5:
                    radioGroup.check(R.id.hightfrequency);
                    break;
                case 6:
                    radioGroup.check(R.id.country);
                    break;
                case 7:
                    radioGroup.check(R.id.outside);
                    break;
                case 8:
                    radioGroup.check(R.id.lowfrequency);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    //显示彩种选择
    public void showLotterySelect(View view){
        view = MainActivity.this.getLayoutInflater().inflate(R.layout.lottery_choice, null);
        lotteryWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        lotteryWindow.setTouchable(true);
        lotteryWindow.setOutsideTouchable(true);
        view.setBackgroundColor(Color.parseColor("#80000000"));
        if (lotteryWindow.isShowing()) {
            lotteryWindow.dismiss();
        } else {
            lotteryWindow.setFocusable(true);
        }
        setLotteryView(view);
        int xOffset = main_toolbar.getWidth() / 2 - view.getMeasuredWidth() / 2;
        lotteryWindow.showAsDropDown(main_toolbar, xOffset, 0);
    }

    public void setLotteryView(View view){
        title_close     = (ImageView)view.findViewById(R.id.title_close);
        lottery_ssc     = (ImageView)view.findViewById(R.id.lottery_ssc);
        lottery_ks      = (ImageView)view.findViewById(R.id.lottery_ks);
        lottery_11x5    = (ImageView)view.findViewById(R.id.lottery_11x5);
        lottery_kesf    = (ImageView)view.findViewById(R.id.lottery_kesf);
        lottery_gpc     = (ImageView)view.findViewById(R.id.lottery_gpc);
        lottery_dpc     = (ImageView)view.findViewById(R.id.lottery_dpc);
        lottery_jwc     = (ImageView)view.findViewById(R.id.lottery_jwc);
        lottery_qgc     = (ImageView)view.findViewById(R.id.lottery_qgc);
        title_close.setOnClickListener(this);
        lottery_ssc.setOnClickListener(this);
        lottery_ks.setOnClickListener(this);
        lottery_11x5.setOnClickListener(this);
        lottery_kesf.setOnClickListener(this);
        lottery_gpc.setOnClickListener(this);
        lottery_dpc.setOnClickListener(this);
        lottery_jwc.setOnClickListener(this);
        lottery_qgc.setOnClickListener(this);
    }

}
