package com.example.dell.lotteryplan.home.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.home.logic.UpDownTextView;
import com.example.dell.lotteryplan.home.message.LotteryMessage;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderOne;

import java.util.List;

/**
 * Created by dell on 2017/6/27.
 */

public class CountryAdpater extends BaseAdapter {
    private Context                 context;
    private List<LotteryMessage>    list;
    private LotteryViewHolderOne    lotteryViewHolderOne;
    private LayoutInflater          mInflater;
    private boolean                 mBusy = false;
    private String[]                strings={"1","2","3","4","5","6","7","8","9"};

    public CountryAdpater(Context context,List<LotteryMessage> list){
        this.context    =   context;
        this.list       =   list;
        mInflater       =   LayoutInflater.from(context);
    }

    public boolean ismBusy() {
        return mBusy;
    }

    public void setmBusy(boolean mBusy) {
        this.mBusy = mBusy;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        lotteryViewHolderOne = null;
        if(convertView == null){
            lotteryViewHolderOne    =   new LotteryViewHolderOne();
            convertView             =   mInflater.inflate(R.layout.item_lottery_item4,parent,false);
            setView(convertView);
            convertView.setTag(lotteryViewHolderOne);
        }else{
            lotteryViewHolderOne 	= 	(LotteryViewHolderOne) convertView.getTag();
            if(list.get(position).isOpen()){
                lotteryViewHolderOne.type_balls1.startAutoScroll();
                lotteryViewHolderOne.type_balls2.startAutoScroll();
                lotteryViewHolderOne.type_balls3.startAutoScroll();
                lotteryViewHolderOne.type_balls4.startAutoScroll();
                lotteryViewHolderOne.type_balls5.startAutoScroll();
            }else{
                lotteryViewHolderOne.type_balls1.stopAutoScroll();
                lotteryViewHolderOne.type_balls2.stopAutoScroll();
                lotteryViewHolderOne.type_balls3.stopAutoScroll();
                lotteryViewHolderOne.type_balls4.stopAutoScroll();
                lotteryViewHolderOne.type_balls5.stopAutoScroll();
                if(list.get(position).getLottery_id().equals("17")){
                    if(list.get(position).getBallls().size()!=0){
                        lotteryViewHolderOne.type_balls4.setVisibility(View.VISIBLE);
                        lotteryViewHolderOne.type_balls5.setVisibility(View.VISIBLE);
                        lotteryViewHolderOne.type_balls1.setText(list.get(position).getBall(0));
                        lotteryViewHolderOne.type_balls2.setText(list.get(position).getBall(1));
                        lotteryViewHolderOne.type_balls3.setText(list.get(position).getBall(2));
                        lotteryViewHolderOne.type_balls4.setText(list.get(position).getBall(3));
                        lotteryViewHolderOne.type_balls5.setText(list.get(position).getBall(4));
                    }
                }else{
                    if(list.get(position).getBallls().size()!=0){
                        lotteryViewHolderOne.type_balls4.setVisibility(View.GONE);
                        lotteryViewHolderOne.type_balls5.setVisibility(View.GONE);
                        lotteryViewHolderOne.type_balls1.setText(list.get(position).getBall(0));
                        lotteryViewHolderOne.type_balls2.setText(list.get(position).getBall(1));
                        lotteryViewHolderOne.type_balls3.setText(list.get(position).getBall(2));
                    }
                }
            }
        }
        if(!mBusy){
            setData(position);
        }
        return convertView;
    }

    public void setView(View view){
        lotteryViewHolderOne.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderOne.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderOne.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderOne.type_balls1        = (UpDownTextView)view.findViewById(R.id.type4_ball1);
        lotteryViewHolderOne.type_balls2        = (UpDownTextView)view.findViewById(R.id.type4_ball2);
        lotteryViewHolderOne.type_balls3        = (UpDownTextView)view.findViewById(R.id.type4_ball3);
        lotteryViewHolderOne.type_balls4        = (UpDownTextView)view.findViewById(R.id.type4_ball4);
        lotteryViewHolderOne.type_balls5        = (UpDownTextView)view.findViewById(R.id.type4_ball5);
        lotteryViewHolderOne.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderOne.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderOne.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderOne.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderOne.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderOne.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderOne.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderOne.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderOne.type_balls1.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.type_balls2.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.type_balls3.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.type_balls4.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.type_balls5.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderOne.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderOne.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderOne.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderOne.type_balls5.setGravity(Gravity.CENTER);
    }

    public void setData(int i){
        lotteryViewHolderOne.type_balls1.setTextList(strings);
        lotteryViewHolderOne.type_balls2.setTextList(strings);
        lotteryViewHolderOne.type_balls3.setTextList(strings);
        lotteryViewHolderOne.type_balls4.setTextList(strings);
        lotteryViewHolderOne.type_balls5.setTextList(strings);
        lotteryViewHolderOne.lottery_history.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.lottery_current.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.lottery_rules.setTag(lotteryViewHolderOne);
        lotteryViewHolderOne.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });
        lotteryViewHolderOne.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });
        lotteryViewHolderOne.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });

        lotteryViewHolderOne.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderOne.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderOne.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderOne.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderOne.hour.setText(list.get(i).getHour());
        lotteryViewHolderOne.min.setText(list.get(i).getMinute());
        lotteryViewHolderOne.secd.setText(list.get(i).getSecond());
    }
}
