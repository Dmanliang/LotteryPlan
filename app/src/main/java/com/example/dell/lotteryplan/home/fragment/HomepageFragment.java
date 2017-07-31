package com.example.dell.lotteryplan.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.home.activity.BannerLinkActivity;
import com.example.dell.lotteryplan.home.adapter.AdvAdapter;
import com.example.dell.lotteryplan.home.adapter.HomepageAdpater;
import com.example.dell.lotteryplan.home.adapter.LotteryAdpater;
import com.example.dell.lotteryplan.home.logic.AdFragment;
import com.example.dell.lotteryplan.home.logic.TipView;
import com.example.dell.lotteryplan.home.logic.listview.ListView;
import com.example.dell.lotteryplan.home.logic.listview.PullToRefreshLayout;
import com.example.dell.lotteryplan.home.message.Alter;
import com.example.dell.lotteryplan.home.message.Banner;
import com.example.dell.lotteryplan.home.message.LotteryMessage;
import com.example.dell.lotteryplan.base.Constants;
import com.example.dell.lotteryplan.getJson.HttpTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dell on 2017/6/26.
 */

public class HomepageFragment extends Fragment implements View.OnClickListener{
    private View                    rootView;
    private ListView                hompageListView;
    private View                    advertise;
    private HomepageAdpater         homepageAdpater;
    private List<LotteryMessage>    homepageList  = new ArrayList<>();
    private HttpTask                Httptask1,Httptask2;
    //开奖信息
    //请求时间数据
    public SimpleDateFormat         format          = new SimpleDateFormat("yyyyMMddHHmmss");
    public SimpleDateFormat         format_now      = new SimpleDateFormat("yyyy-MM-dd");
    private long[]                  hours           = new long[9];
    private long[]                  min             = new long[9];
    private long[]                  secd            = new long[9];
    private String[]                iss             = new String[9];
    private String[]                tempIss         = new String[9];
    //上期开奖数据
    private String                  server_time;
    private String                  issue           = null;
    private String                  num             = null;
    private String                  expect_time     = null;
    private String[]                lastTime        = new String[9];
    private String[]                templastTime    = new String[9];
    //本期开奖数据
    private String                  issueNow        = null;
    private String                  expect_timeNow  = null;
    private boolean[]               isNextOpen      = new boolean[9];
    private boolean[]               isFistTime      = new boolean[9];
    private boolean[]               isLastTime      = new boolean[9];
    private boolean[]               isChanger       = new boolean[9];
    //广告轮播
    private ViewPager               adViewpager;
    private ImageView[]             imageViews   = null;
    private ImageView               imageView    = null;
    private ImageView               colse_notice;
    private RelativeLayout          noticelayout;
    private ViewGroup               group;
    private AtomicInteger           what         = new AtomicInteger(0);
    private static final int        DE           = 2000;
    private boolean                 isContinue   = true;
    private AdvAdapter              mAdvApter;
    private ArrayList<AdFragment>   mAdFragments = new ArrayList<>();
    private ArrayList<Banner>       mBanners     = new ArrayList<>();
    //公告信息
    private TipView                 tipView;
    private List<String>            tipList      =  new ArrayList<>();
    private List<Alter>             alterList    =  new ArrayList<>();
    private ArrayList<String>       homeTitles   =  new ArrayList<>();
    private ArrayList<String>       lotteryids   =  new ArrayList<>();
    private String                  lotteryid    = "";
    private Boolean                 isRun        = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.homepage_fragment, container, false);
            initView();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setUserVisibleHint(true);
    }

    //初始化控件
    public void initView(){
        for(int i=0;i<isFistTime.length;i++){
            isFistTime[i]   =   true;
            isNextOpen[i]   =   true;
            isLastTime[i]   =   true;
            isChanger[i]    =   false;
        }
        requestLotteryType();
        requestBanner();
        requestNotice();
        setListView(rootView);
    }

    //初始化数据
    public void setData(){
        LotteryMessage lotteryMessage;
        for(int i=0;i<homeTitles.size();i++){
            lotteryMessage = new LotteryMessage(lotteryids.get(i),homeTitles.get(i), "第 20170101001 期已开","","","00","00","00");
            homepageList.add(lotteryMessage);
            if(lotteryids.get(i).equals("27")){
                homepageList.get(i).setItem_type("1");
            }else if(lotteryids.get(i).equals("12")){
                homepageList.get(i).setItem_type("2");
            }else if(lotteryids.get(i).equals("21")){
                homepageList.get(i).setItem_type("3");
            }else if(lotteryids.get(i).equals("1") || lotteryids.get(i).equals("3") || lotteryids.get(i).equals("7") || lotteryids.get(i).equals("134") || lotteryids.get(i).equals("102")){
                homepageList.get(i).setItem_type("4");
            }else{
                homepageList.get(i).setItem_type("5");
            }
        }
    }

    //设置列表
    public void setListView(View view){
        advertise       = LayoutInflater.from(this.getActivity()).inflate(R.layout.advertise,null,false);
        adViewpager     = (ViewPager)advertise.findViewById(R.id.ad_viewpager);
        group           = (ViewGroup)advertise.findViewById(R.id.viewGroup);
        tipView         = (TipView)advertise.findViewById(R.id.notice);
        colse_notice    = (ImageView)advertise.findViewById(R.id.colse_notice);
        noticelayout    = (RelativeLayout)advertise.findViewById(R.id.noticelayout);
        tipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNoice((tipView.getCurTipIndex()-1+tipView.getTipList().size())%tipView.getTipList().size());
            }
        });
        colse_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticelayout.setVisibility(View.GONE);
            }
        });
        adViewpager.setAdapter(mAdvApter = new AdvAdapter(this.getFragmentManager(), mAdFragments));
        adViewpager.addOnPageChangeListener(new GuidePageChangeListener());
        adViewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                        isContinue = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isContinue = true;
                        break;
                    default:
                        isContinue = true;
                        break;
                }
                adViewpager.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        addIndicator(group);//广告轮播图添加指示器
        //广告自动切换线程
        viewHandler.postDelayed(viewRunnable, DE);
        hompageListView = (ListView)view.findViewById(R.id.homepageListView);
        hompageListView.getListView().addHeaderView(advertise);
        hompageListView.getListView().setDividerHeight(0);
        homepageAdpater =  new HomepageAdpater(this.getContext(),homepageList);
        hompageListView.getListView().setAdapter(homepageAdpater);
        homepageAdpater.notifyDataSetChanged();
        hompageListView.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        hompageListView.setLoadDataListener(new PullToRefreshLayout.LoadDataListener() {
            @Override
            //下拉刷新调用
            public void onRefresh() {
                requestData();
            }

            @Override
            //下拉加载更多调用
            public void onLoadMore() {
            }
        });
        hompageListView.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        homepageAdpater.setmBusy(true);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        homepageAdpater.setmBusy(false);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        homepageAdpater.setmBusy(false);
                        break;
                    default:
                        break;
                }
                homepageAdpater.notifyDataSetChanged();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    //请求单独数据
    public void requestLotteryData(int pos) {
        requestTime();
        requestLotteryMessage(lotteryids.get(pos),pos);
    }

    //请求单个开奖数据
    public void requestLotteryMessage(final String lotteryid,final int pos) {
        //获取当前开奖数据
        Httptask1 = new HttpTask();
        Httptask1.execute(Constants.API + Constants.CURRENT_ISSUE+lotteryid);
        Httptask1.setTaskHandler(new HttpTask.HttpTaskHandler() {
            public void taskSuccessful(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONObject id = data.getJSONObject(lotteryids.get(pos));
                    issueNow = id.optString("issue");
                    expect_timeNow = id.optString("expect_time");
                    setNowMessage(issueNow, expect_timeNow, pos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void taskFailed() {
            }
        });

        //获取已开奖结果数据
        Httptask2 = new HttpTask();
        Httptask2.execute(Constants.API + Constants.LAST_RESULT+lotteryid+"&count=1");
        Httptask2.setTaskHandler(new HttpTask.HttpTaskHandler() {
            public void taskSuccessful(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    JSONArray ls = data.getJSONArray(lotteryids.get(pos));
                    JSONObject lottery = ls.getJSONObject(0);
                    issue = lottery.optString("issue");
                    num = lottery.optString("nums");
                    expect_time = lottery.optString("expect_time");
                    String[] numList = num.split(",");
                    setMessage(numList, issue, pos);
                    hompageListView.onLoadComplete(true, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void taskFailed() {
            }
        });
    }

    //请求数据
    public void requestData() {
        requestTime();
        requestMessage(lotteryid);
    }

    //请求彩种类型
    public void requestLotteryType(){
        HttpTask httpTask = new HttpTask();
        httpTask.execute(Constants.LOTTERY_TYPE+"index");
        httpTask.setTaskHandler(new HttpTask.HttpTaskHandler() {
            @Override
            public void taskSuccessful(String json) {
                try{
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray  data       = jsonObject.getJSONArray("data");
                    for(int i=0;i<data.length();i++){
                        JSONObject id = data.getJSONObject(i);
                        homeTitles.add(id.optString("name"));
                        lotteryids.add(id.optString("lottery_id"));
                        if(i == data.length()-1){
                            lotteryid += id.optString("lottery_id");
                        }else{
                            lotteryid += id.optString("lottery_id")+",";
                        }
                    }
                    Message msg = new Message();
                    msg.what = 2;
                    recomdHandler.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void taskFailed() {

            }
        });
    }

    //请求开奖数据
    public void requestMessage(final String lotteryid) {
        //获取当前开奖数据
        Httptask1 = new HttpTask();
        Httptask1.execute(Constants.API + Constants.CURRENT_ISSUE+lotteryid);
        Httptask1.setTaskHandler(new HttpTask.HttpTaskHandler() {
            public void taskSuccessful(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    for(int i=0;i<lotteryids.size();i++){
                        JSONObject id = data.getJSONObject(lotteryids.get(i));
                        issueNow = id.optString("issue");
                        expect_timeNow = id.optString("expect_time");
                        setNowMessage(issueNow, expect_timeNow, i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void taskFailed() {
            }
        });

        //获取已开奖结果数据
        Httptask2 = new HttpTask();
        Httptask2.execute(Constants.API + Constants.LAST_RESULT+lotteryid+"&count=1");
        Httptask2.setTaskHandler(new HttpTask.HttpTaskHandler() {
            public void taskSuccessful(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    for(int i=0;i<lotteryids.size();i++){
                        JSONArray ls = data.getJSONArray(lotteryids.get(i));
                        JSONObject lottery = ls.getJSONObject(0);
                        issue = lottery.optString("issue");
                        num = lottery.optString("nums");
                        expect_time = lottery.optString("expect_time");
                        String[] numList = num.split(",");
                        setMessage(numList, issue, i);
                    }
                    hompageListView.onLoadComplete(true, false);
                    if(!isRun){
                        isRun = true;
                        Message msg = new Message();
                        msg.what = 3;
                        recomdHandler.sendMessage(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void taskFailed() {
            }
        });
    }

    //设置现在开奖信息
    public void setNowMessage(String home_date, String expect_time, int pos) {
        try {
            iss[pos] = home_date;
            if(isFistTime[pos]){
                tempIss[pos]        = home_date;
                isFistTime[pos]     = false;
            }else{
                if(!tempIss[pos].equals(iss[pos])&& !isChanger[pos]){
                    isChanger[pos]   = true;
                }else if(!tempIss[pos].equals(iss[pos])&& isChanger[pos] && isNextOpen[pos]){
                    tempIss[pos]     = iss[pos];
                    isChanger[pos]   = false;
                }
            }
            String nowTime    = getNowTime();
            long hour       = (format.parse(expect_time).getTime() - format.parse(server_time).getTime()) / 3600000;
            long minutes    = (format.parse(expect_time).getTime() - format.parse(server_time).getTime()) / 60000- hour * 60;
            long seconds    = (format.parse(expect_time).getTime() - format.parse(server_time).getTime()) / 1000 - minutes * 60 - hour * 3600;
            hours[pos]      = hour;
            min[pos]        = minutes;
            secd[pos]       = seconds;
            homepageList.get(pos).setNow_time(nowTime);
            homepageList.get(pos).setNext_time(home_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置已开奖信息
    public void setMessage(String[] num, String issue, int pos)  {
        lastTime[pos] = issue;
        if(isLastTime[pos]){
            templastTime[pos] = issue;
            isLastTime[pos]   = false;
        }else{
            if(templastTime[pos].equals(lastTime[pos])&& isChanger[pos]){
                isNextOpen[pos]     = false;
                lastTime[pos]       = tempIss[pos];
            }else if(!templastTime[pos].equals(lastTime[pos])&& !isNextOpen[pos]) {
                isNextOpen[pos]     = true;
                templastTime[pos]   = lastTime[pos];
            }
        }
        if(pos == 4){
            for(int i=0;i<num.length;i++){
                if(num[i].equals("19") || num[i].equals("20")){
                    homepageList.get(pos).setSpecil(true,i);
                }else{
                    homepageList.get(pos).setSpecil(false,i);
                }
            }
        }
        setBall(num,pos);
        if(!isNextOpen[pos]){
            homepageList.get(pos).setLottery_issue("第 " + lastTime[pos] + " 期开奖中");
        }else{
            homepageList.get(pos).setOpen(false);
            homepageList.get(pos).setLottery_issue("第 " + lastTime[pos] + " 期已开");
        }
    }

    //设置球码
    public void setBall(String[] num,int pos){
        homepageList.get(pos).clearball();
        for(int i=0;i<num.length;i++){
            homepageList.get(pos).setBall(num[i]);
        }
    }

    //倒计时操作
    public void reBackTime(int pos) {
        if(hours[pos] == 0){
            homepageList.get(pos).setHour("00");
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                homepageList.get(pos).setMinute("00");
                homepageList.get(pos).setSecond("00");
                homepageList.get(pos).setOpen(true);
                requestLotteryData(pos);
            }
        }else if(hours[pos]>0 && hours[pos] <10){
            homepageList.get(pos).setHour("0"+hours[pos]);
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                homepageList.get(pos).setMinute("00");
                homepageList.get(pos).setSecond("00");
            }
        }else{
            homepageList.get(pos).setHour(hours[pos]+"");
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    homepageList.get(pos).setMinute(min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                } else {
                    homepageList.get(pos).setMinute("0" +min[pos]+"");
                    homepageList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                homepageList.get(pos).setMinute("00");
                homepageList.get(pos).setSecond("00");
            }
        }
    }

    //请求服务器时间
    public void requestTime(){
        HttpTask httpTask = new HttpTask();
        httpTask.execute(Constants.API+Constants.SERVER_TIME);
        httpTask.setTaskHandler(new HttpTask.HttpTaskHandler() {
            @Override
            public void taskSuccessful(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject data = jsonObject.getJSONObject("data");
                    server_time     = data.getString("server_time");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void taskFailed() {

            }
        });
    }

    //时间截转化
    public String getNowTime(){
        Date date = new Date();
        date = Calendar.getInstance().getTime();
        String   nowtime = format_now.format(date);
        return nowtime;
    }

    /**
     * 每15秒请求一次数据
     */
    public DataHandler dataHandler = new DataHandler(this);
    public Runnable dataRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Message msg = new Message();
                dataHandler.sendMessage(msg);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };

    private static class DataHandler extends Handler {
        WeakReference<HomepageFragment> reference;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HomepageFragment lottery = reference.get();
            if (lottery != null) {
                lottery.requestData();
                lottery.homepageAdpater.notifyDataSetChanged();
                lottery.dataHandler.postDelayed(lottery.dataRunnable, 15000);
            }
        }

        DataHandler(HomepageFragment lottery) {
            reference = new WeakReference<>(lottery);
        }
    }

    /**
     * 开奖时间线程
     * 每秒向服务器校对一次 分针和秒针
     */
    public TimeHandler timeHandler = new TimeHandler(this);
    Runnable timeRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                Message msg = new Message();
                timeHandler.sendMessage(msg);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };

    private static class TimeHandler extends Handler {
        WeakReference<HomepageFragment> reference;

        public TimeHandler(HomepageFragment lottery) {
            reference = new WeakReference<>(lottery);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HomepageFragment lottery = reference.get();
            if (lottery != null) {
                if(lottery.homepageList.size()!=0){
                    for (int i = 0; i < lottery.homepageList.size(); i++) {
                        lottery.reBackTime(i);
                    }
                }
                lottery.homepageAdpater.notifyDataSetChanged();
                lottery.timeHandler.postDelayed(lottery.timeRunnable, 1000);
            }
        }
    }

    //重新初始化一些数据
    public void resetData(){
        for(int i=0;i<9;i++){
            iss[i]          ="";
            tempIss[i]      ="";
            lastTime[i]     ="";
            templastTime[i] ="";
            isNextOpen[i]   = true;
            isFistTime[i]   = true;
            isLastTime[i]   = true;
            isChanger[i]    = false;
        }
    }

    //请求公告信息
    public void requestNotice(){
        HttpTask httpTask = new HttpTask();
        httpTask.execute(Constants.API1+Constants.ALERT);
        httpTask.setTaskHandler(new HttpTask.HttpTaskHandler() {
            @Override
            public void taskSuccessful(String json) {
                try{
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray  data       = jsonObject.getJSONArray("data");
                    Alter      alter;
                    for(int i=0;i<data.length();i++){
                        jsonObject      = data.getJSONObject(i);
                        String url      = jsonObject.getString("url");
                        String content  = jsonObject.getString("content");
                        String id       = jsonObject.getString("id");
                        alter           = new Alter(id,content,url);
                        alterList.add(alter);
                        tipList.add(content);
                    }
                    Message msg = new Message();
                    msg.what = 1;
                    recomdHandler.sendMessage(msg);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void taskFailed() {

            }
        });
    }

    //请求开奖轮播图
    public void requestBanner(){
        mBanners.clear();
        HttpTask httptask = new HttpTask();
        httptask.execute(Constants.API1+Constants.BANNER);
        httptask.setTaskHandler(new HttpTask.HttpTaskHandler() {
            @Override
            public void taskSuccessful(String json) {
                try{
                    JSONObject jsonObject = new JSONObject(json);
                    JSONArray  data = jsonObject.getJSONArray("data");
                    Banner banner;
                    for(int i=0;i<data.length();i++){
                        jsonObject = data.getJSONObject(i);
                        String      imageurl    = jsonObject.getString("image");
                        String      link        = jsonObject.getString("url");
                        String      title       = jsonObject.getString("title");
                        banner                  = new Banner(imageurl,link,title);
                        mBanners.add(banner);
                    }
                    if (mAdvApter != null) {
                        FragmentManager fragmentManager     =   getFragmentManager();
                        FragmentTransaction transaction     = fragmentManager.beginTransaction();
                        List<Fragment>      fragments       = fragmentManager.getFragments();
                        if (fragments != null && fragments.size() > 0) {
                            for (int i = 0; i < fragments.size(); i++) {
                                fragments.remove(i);
                            }
                        }
                        transaction.commit();
                    }
                    mAdFragments.clear();
                    for (int i = 0; i < mBanners.size(); i++) {
                        mAdFragments.add(AdFragment.newInstance(mBanners.get(i).getImgUrl(), mBanners.get(i).getLink(), mBanners.get(i).getTitle()));
                    }
                    //添加轮播图
                    mAdvApter.notifyDataSetChanged();
                    addIndicator(group);//添加indicator
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void taskFailed() {

            }
        });
    }

    //广告轮播小图标
    public void addIndicator(ViewGroup group) {
        if (group.getChildCount() > 0) {
            group.removeViews(0, group.getChildCount());
        }
        //小图标
        imageViews = new ImageView[mBanners.size()];
        for (int i = 0; i < mBanners.size(); i++) {
            imageView = new ImageView(this.getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(26, 26));
            imageViews[i] = imageView;
            if (i == 0) {
                imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(15,
                    15));
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            group.addView(imageViews[i], layoutParams);
        }
    }

    //设置公告跳转
    public void setNoice(int position){
        Intent intent = new Intent(getActivity(), BannerLinkActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url",alterList.get(position).getUrl());
        bundle.putString("title",alterList.get(position).getId());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    //设置推荐信息
    public void setTipView() {
        tipView.setTipList(tipList);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    //切换广告监听
    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int position) {
            position = position % mAdFragments.size();
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[position].setBackgroundResource(R.drawable.page_indicator_focused);
                if (position != i) {
                    imageViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
                }
                what.set(position);
            }
        }
    }

    private Runnable viewRunnable = new Runnable() {
        @Override
        public void run() {
            if (isContinue) {
                viewHandler.sendEmptyMessage(what.get());
                whatOption();
                viewHandler.postDelayed(viewRunnable, DE);
            }
        }
    };

    private void whatOption() {
        what.incrementAndGet();
        if (what.get() > imageViews.length - 1) {
            what.getAndAdd(-imageViews.length);
        }
    }

    private static class ViewHandler extends Handler {
        WeakReference<HomepageFragment> mhomepage;

        ViewHandler(HomepageFragment mainActivity) {
            mhomepage = new WeakReference<>(mainActivity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            HomepageFragment homepage = mhomepage.get();
            if (homepage != null) {
                homepage.adViewpager.setCurrentItem(msg.what);
            }
        }

    }


    //启动广告
    private final ViewHandler viewHandler = new ViewHandler(this);

    //更新UI线程信息
    public Handler recomdHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    //显示推荐彩种信息
                    setTipView();
                    break;
                case 2:
                    setData();
                    requestData();
                    break;
                case 3:
                    //开奖倒计时
                    timeHandler.post(timeRunnable);
                    //每15秒钟请求一次数据
                    dataHandler.postDelayed(dataRunnable, 15000);
                    break;
            }
        }
    };

    @Override
    public void onResume() {
        resetData();
        requestData();
        super.onResume();
    }

    @Override
    public void onPause() {
        timeHandler.removeCallbacks(timeRunnable);
        dataHandler.removeCallbacks(dataRunnable);
        isRun=false;
        super.onPause();
    }

}