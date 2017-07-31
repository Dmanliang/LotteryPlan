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
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderTwo;

import java.util.List;

/**
 * Created by dell on 2017/6/27.
 */

public class HappyAdpater extends BaseAdapter {

    private Context context;
    private List<LotteryMessage> list;
    private LotteryViewHolderTwo lotteryViewHolderTwo;
    private LayoutInflater mInflater;
    private boolean                 mBusy = false;
    private String[]                strings={"1","2","3","4","5","6","7","8","9"};

    public HappyAdpater(Context context,List<LotteryMessage> list){
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
        lotteryViewHolderTwo = null;
        if(convertView == null){
            lotteryViewHolderTwo    =   new LotteryViewHolderTwo();
            convertView             =   mInflater.inflate(R.layout.item_lottery_item5,parent,false);
            setView(convertView);
            convertView.setTag(lotteryViewHolderTwo);
        }else{
            lotteryViewHolderTwo 	= 	(LotteryViewHolderTwo) convertView.getTag();
            if(list.get(position).isOpen()){
                lotteryViewHolderTwo.type_balls1.startAutoScroll();
                lotteryViewHolderTwo.type_balls2.startAutoScroll();
                lotteryViewHolderTwo.type_balls3.startAutoScroll();
                lotteryViewHolderTwo.type_balls4.startAutoScroll();
                lotteryViewHolderTwo.type_balls5.startAutoScroll();
                lotteryViewHolderTwo.type_balls6.startAutoScroll();
                lotteryViewHolderTwo.type_balls7.startAutoScroll();
                lotteryViewHolderTwo.type_balls8.startAutoScroll();
            }else{
                lotteryViewHolderTwo.type_balls1.stopAutoScroll();
                lotteryViewHolderTwo.type_balls2.stopAutoScroll();
                lotteryViewHolderTwo.type_balls3.stopAutoScroll();
                lotteryViewHolderTwo.type_balls4.stopAutoScroll();
                lotteryViewHolderTwo.type_balls5.stopAutoScroll();
                lotteryViewHolderTwo.type_balls6.stopAutoScroll();
                lotteryViewHolderTwo.type_balls7.stopAutoScroll();
                lotteryViewHolderTwo.type_balls8.stopAutoScroll();
                if(list.get(position).getLottery_id().equals("102")){
                    if(list.get(position).getBallls().size()!=0) {
                        lotteryViewHolderTwo.type_balls6.setVisibility(View.GONE);
                        lotteryViewHolderTwo.type_balls7.setVisibility(View.GONE);
                        lotteryViewHolderTwo.type_balls8.setVisibility(View.GONE);
                        lotteryViewHolderTwo.type_balls1.setText(list.get(position).getBall(0));
                        lotteryViewHolderTwo.type_balls2.setText(list.get(position).getBall(1));
                        lotteryViewHolderTwo.type_balls3.setText(list.get(position).getBall(2));
                        lotteryViewHolderTwo.type_balls4.setText(list.get(position).getBall(3));
                        lotteryViewHolderTwo.type_balls5.setText(list.get(position).getBall(4));
                    }
                }else{
                    if(list.get(position).getBallls().size()!=0){
                        lotteryViewHolderTwo.type_balls6.setVisibility(View.VISIBLE);
                        lotteryViewHolderTwo.type_balls7.setVisibility(View.VISIBLE);
                        lotteryViewHolderTwo.type_balls8.setVisibility(View.VISIBLE);
                        lotteryViewHolderTwo.type_balls1.setText(list.get(position).getBall(0));
                        lotteryViewHolderTwo.type_balls2.setText(list.get(position).getBall(1));
                        lotteryViewHolderTwo.type_balls3.setText(list.get(position).getBall(2));
                        lotteryViewHolderTwo.type_balls4.setText(list.get(position).getBall(3));
                        lotteryViewHolderTwo.type_balls5.setText(list.get(position).getBall(4));
                        lotteryViewHolderTwo.type_balls6.setText(list.get(position).getBall(5));
                        lotteryViewHolderTwo.type_balls7.setText(list.get(position).getBall(6));
                        lotteryViewHolderTwo.type_balls8.setText(list.get(position).getBall(7));
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
        lotteryViewHolderTwo.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderTwo.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderTwo.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderTwo.type_balls1        = (UpDownTextView) view.findViewById(R.id.type5_ball1);
        lotteryViewHolderTwo.type_balls2        = (UpDownTextView) view.findViewById(R.id.type5_ball2);
        lotteryViewHolderTwo.type_balls3        = (UpDownTextView) view.findViewById(R.id.type5_ball3);
        lotteryViewHolderTwo.type_balls4        = (UpDownTextView) view.findViewById(R.id.type5_ball4);
        lotteryViewHolderTwo.type_balls5        = (UpDownTextView) view.findViewById(R.id.type5_ball5);
        lotteryViewHolderTwo.type_balls6        = (UpDownTextView) view.findViewById(R.id.type5_ball6);
        lotteryViewHolderTwo.type_balls7        = (UpDownTextView) view.findViewById(R.id.type5_ball7);
        lotteryViewHolderTwo.type_balls8        = (UpDownTextView) view.findViewById(R.id.type5_ball8);
        lotteryViewHolderTwo.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderTwo.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderTwo.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderTwo.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderTwo.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderTwo.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderTwo.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderTwo.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderTwo.type_balls1.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls2.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls3.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls4.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls5.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls6.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls7.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls8.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo.type_balls8.setGravity(Gravity.CENTER);
    }

    public void setData(int i){
        lotteryViewHolderTwo.lottery_history.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.lottery_current.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.lottery_rules.setTag(lotteryViewHolderTwo);
        lotteryViewHolderTwo.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        setSpecilBall(i);
        lotteryViewHolderTwo.type_balls1.setTextList(strings);
        lotteryViewHolderTwo.type_balls2.setTextList(strings);
        lotteryViewHolderTwo.type_balls3.setTextList(strings);
        lotteryViewHolderTwo.type_balls4.setTextList(strings);
        lotteryViewHolderTwo.type_balls5.setTextList(strings);
        lotteryViewHolderTwo.type_balls6.setTextList(strings);
        lotteryViewHolderTwo.type_balls7.setTextList(strings);
        lotteryViewHolderTwo.type_balls8.setTextList(strings);
        lotteryViewHolderTwo.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderTwo.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderTwo.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderTwo.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderTwo.hour.setText(list.get(i).getHour());
        lotteryViewHolderTwo.min.setText(list.get(i).getMinute());
        lotteryViewHolderTwo.secd.setText(list.get(i).getSecond());
    }

    public void setSpecilBall(int i){
        if(list.get(i).getSpecil(0)){
            lotteryViewHolderTwo.type_balls1.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(1)){
            lotteryViewHolderTwo.type_balls2.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(2)){
            lotteryViewHolderTwo.type_balls3.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(3)){
            lotteryViewHolderTwo.type_balls4.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(4)){
            lotteryViewHolderTwo.type_balls5.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls5.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(5)){
            lotteryViewHolderTwo.type_balls6.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls6.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(6)){
            lotteryViewHolderTwo.type_balls7.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls7.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(7)){
            lotteryViewHolderTwo.type_balls8.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderTwo.type_balls8.setBackgroundResource(R.drawable.type1_ball_1);
        }
    }
}
