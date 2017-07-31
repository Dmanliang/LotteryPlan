package com.example.dell.lotteryplan.home.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.base.Constants;
import com.example.dell.lotteryplan.getJson.HttpTask;
import com.example.dell.lotteryplan.home.adapter.LotteryAdpater;
import com.example.dell.lotteryplan.home.adapter.LowfrequencyAdpater;
import com.example.dell.lotteryplan.home.logic.listview.ListView;
import com.example.dell.lotteryplan.home.logic.listview.PullToRefreshLayout;
import com.example.dell.lotteryplan.home.message.LotteryMessage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/6/26.
 */

public class LowfrequencyFragment extends Fragment {

    private View                    rootView;
    private ListView                LowFreqListView;
    private LowfrequencyAdpater     LowFreqAdpater;
    private List<LotteryMessage>    LowFreList  = new ArrayList<>();
    private HttpTask                Httptask1,Httptask2;
    //开奖信息
    //请求时间数据
    public SimpleDateFormat         format          = new SimpleDateFormat("yyyyMMddHHmmss");
    public SimpleDateFormat         format_now      = new SimpleDateFormat("yyyy-MM-dd");
    private long[]                  hours           = new long[33];
    private long[]                  min             = new long[33];
    private long[]                  secd            = new long[33];
    private String[]                iss             = new String[33];
    private String[]                tempIss         = new String[33];
    //上期开奖数据
    private String                  server_time;
    private String                  issue           = null;
    private String                  num             = null;
    private String                  expect_time     = null;
    private String[]                lastTime        = new String[33];
    private String[]                templastTime    = new String[33];
    //本期开奖数据
    private String                  issueNow        = null;
    private String                  expect_timeNow  = null;
    private boolean[]               isNextOpen      = new boolean[33];
    private boolean[]               isFistTime      = new boolean[33];
    private boolean[]               isLastTime      = new boolean[33];
    private boolean[]               isChanger       = new boolean[33];
    private ArrayList<String>       homeTitles      = new ArrayList<>();
    private ArrayList<String>       lotteryids      = new ArrayList<>();
    private String                  lotteryid       = "";
    private Boolean                 isRun           = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.lowfrequency_fragment, container, false);
            initView(rootView);
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

    //初始化列表
    public void initView(View view){
        requestLotteryType();
        for(int i=0;i<isFistTime.length;i++){
            isFistTime[i]   =   true;
            isNextOpen[i]   =   true;
            isLastTime[i]   =   true;
            isChanger [i]   =   false;
        }
        setListView(view);
    }

    //初始化列表数据
    public void setData(){
        LotteryMessage lotteryMessage;
        for(int i=0;i<homeTitles.size();i++){
            lotteryMessage = new LotteryMessage(lotteryids.get(i),homeTitles.get(i), "第 20170101001 期已开","","","00","00","00 ");
            LowFreList.add(lotteryMessage);
            if(lotteryids.get(i).equals("157") || lotteryids.get(i).equals("161") || lotteryids.get(i).equals("162") || lotteryids.get(i).equals("166") || lotteryids.get(i).equals("167")){
                LowFreList.get(i).setItem_type("2");
            }else if(lotteryids.get(i).equals("140") || lotteryids.get(i).equals("147") || lotteryids.get(i).equals("150") || lotteryids.get(i).equals("152") || lotteryids.get(i).equals("160") || lotteryids.get(i).equals("170")){
                LowFreList.get(i).setItem_type("3");
            }else if(lotteryids.get(i).equals("139") || lotteryids.get(i).equals("141") || lotteryids.get(i).equals("142") || lotteryids.get(i).equals("143") || lotteryids.get(i).equals("145") || lotteryids.get(i).equals("149") || lotteryids.get(i).equals("165") || lotteryids.get(i).equals("168") || lotteryids.get(i).equals("172")){
                LowFreList.get(i).setItem_type("4");
            }else{
                LowFreList.get(i).setItem_type("1");
            }
        }
    }

    //设置列表
    public void setListView(View view){
        LowFreqListView = (ListView)view.findViewById(R.id.lowfrequencyListView);
        LowFreqListView.getListView().setDividerHeight(0);
        LowFreqAdpater  =  new LowfrequencyAdpater(this.getContext(),LowFreList);
        LowFreqListView.getListView().setAdapter(LowFreqAdpater);
        LowFreqAdpater.notifyDataSetChanged();
        LowFreqListView.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        LowFreqListView.setLoadDataListener(new PullToRefreshLayout.LoadDataListener() {
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
        LowFreqListView.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        LowFreqAdpater.setmBusy(true);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        LowFreqAdpater.setmBusy(false);
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        LowFreqAdpater.setmBusy(false);
                        break;
                    default:
                        break;
                }
                LowFreqAdpater.notifyDataSetChanged();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

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
        httpTask.execute(Constants.LOTTERY_TYPE+"8");
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
                    LowFreqListView.onLoadComplete(true, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

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
                    LowFreqListView.onLoadComplete(true, false);
                    if(!isRun){
                        isRun = true;
                        Message msg = new Message();
                        msg.what = 2;
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
            LowFreList.get(pos).setNow_time(nowTime);
            LowFreList.get(pos).setNext_time(home_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //设置已开奖信息
    public void setMessage(String[] num, String issue, int pos) {
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
        setBall(num,pos);
        if(!isNextOpen[pos]){
            LowFreList.get(pos).setLottery_issue("第 " + lastTime[pos] + " 期开奖中");
        }else{
            LowFreList.get(pos).setOpen(false);
            LowFreList.get(pos).setLottery_issue("第 " + lastTime[pos] + " 期已开");
        }
    }

    //设置球码
    public void setBall(String[] num,int pos){
        LowFreList.get(pos).clearball();
        for(int i=0;i<num.length;i++){
            LowFreList.get(pos).setBall(num[i]);
        }
    }

    //倒计时操作
    public void reBackTime(int pos) {
        if(hours[pos] == 0){
            LowFreList.get(pos).setHour("00");
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                LowFreList.get(pos).setMinute("00");
                LowFreList.get(pos).setSecond("00");
                LowFreList.get(pos).setOpen(true);
                requestLotteryData(pos);
            }
        }else if(hours[pos]>0 && hours[pos] <10){
            LowFreList.get(pos).setHour("0"+hours[pos]);
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                LowFreList.get(pos).setMinute("00");
                LowFreList.get(pos).setSecond("00");
            }
        }else{
            LowFreList.get(pos).setHour(hours[pos]+"");
            if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] >= 10) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (secd[pos] <= 60 && secd[pos] > 0 && min[pos] < 10 && min[pos] >= 0) {
                secd[pos]--;
                if (secd[pos] >= 10) {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond("0" +secd[pos]+"");
                }
            } else if (min[pos] > 0 && secd[pos] == 0) {
                min[pos]--;
                secd[pos] = 59;
                if (min[pos] >= 10) {
                    LowFreList.get(pos).setMinute(min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                } else {
                    LowFreList.get(pos).setMinute("0" +min[pos]+"");
                    LowFreList.get(pos).setSecond(secd[pos]+"");
                }
            } else if (secd[pos] == 0 && min[pos] == 0) {
                LowFreList.get(pos).setMinute("00");
                LowFreList.get(pos).setSecond("00");
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
        WeakReference<LowfrequencyFragment> reference;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LowfrequencyFragment lottery = reference.get();
            if (lottery != null) {
                lottery.requestData();
                lottery.LowFreqAdpater.notifyDataSetChanged();
                lottery.dataHandler.postDelayed(lottery.dataRunnable, 15000);
            }
        }

        DataHandler(LowfrequencyFragment lottery) {
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
        WeakReference<LowfrequencyFragment> reference;
        public TimeHandler(LowfrequencyFragment lottery) {
            reference = new WeakReference<>(lottery);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LowfrequencyFragment lottery = reference.get();
            if (lottery != null) {
                if(lottery.LowFreList.size()!=0){
                    for (int i = 0; i < 33; i++) {
                        lottery.reBackTime(i);
                    }
                }
                lottery.LowFreqAdpater.notifyDataSetChanged();
                lottery.timeHandler.postDelayed(lottery.timeRunnable, 1000);
            }
        }
    }

    //更新UI线程信息
    public Handler recomdHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    setData();
                    requestData();
                    break;
                case 2:
                    //开奖倒计时
                    timeHandler.post(timeRunnable);
                    //每15秒钟请求一次数据
                    dataHandler.postDelayed(dataRunnable, 15000);
                    break;
            }
        }
    };

    //重新初始化一些数据
    public void resetData(){
        for(int i=0;i<33;i++){
            iss[i]="";
            tempIss[i]="";
            lastTime[i]="";
            templastTime[i]="";
            isNextOpen[i]   = true;
            isFistTime[i]   = true;
            isLastTime[i]   = true;
            isChanger[i]    = false;
        }
    }

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
