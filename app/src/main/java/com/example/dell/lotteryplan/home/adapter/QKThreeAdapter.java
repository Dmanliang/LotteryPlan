package com.example.dell.lotteryplan.home.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.lotteryplan.R;
import com.example.dell.lotteryplan.home.message.LotteryMessage;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderFour;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderOne;

import java.util.List;

/**
 * Created by dell on 2017/6/26.
 */

public class QKThreeAdapter extends BaseAdapter {

    private Context context;
    private List<LotteryMessage> list;
    private LotteryViewHolderFour lotteryViewHolderFour;
    private LayoutInflater mInflater;
    private int[] qk3bg         = {
            R.drawable.type4_ball_1,
            R.drawable.type4_ball_2,
            R.drawable.type4_ball_3,
            R.drawable.type4_ball_4,
            R.drawable.type4_ball_5,
            R.drawable.type4_ball_6
    };
    private boolean                 mBusy = false;
    private AnimationDrawable       q3Anim1,q3Anim2,q3Anim3;

    public QKThreeAdapter(Context context,List<LotteryMessage> list){
        this.context    =   context;
        this.list       =   list;
        mInflater    = LayoutInflater.from(context);
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
        lotteryViewHolderFour = null;
        if(convertView == null){
            lotteryViewHolderFour    =   new LotteryViewHolderFour();
            convertView             =   mInflater.inflate(R.layout.item_lottery_item7,parent,false);
            setView(convertView);
            convertView.setTag(lotteryViewHolderFour);
        }else{
            lotteryViewHolderFour 	= 	(LotteryViewHolderFour) convertView.getTag();
            if(list.get(position).isOpen()) {
                q3Anim1=(AnimationDrawable) context.getResources().getDrawable(R.drawable.q3_anim1);
                q3Anim2=(AnimationDrawable) context.getResources().getDrawable(R.drawable.q3_anim2);
                q3Anim3=(AnimationDrawable) context.getResources().getDrawable(R.drawable.q3_anim3);
                lotteryViewHolderFour.mtype7_balls1.setBackgroundDrawable(q3Anim1);
                lotteryViewHolderFour.mtype7_balls2.setBackgroundDrawable(q3Anim2);
                lotteryViewHolderFour.mtype7_balls3.setBackgroundDrawable(q3Anim3);
                if (q3Anim1 != null && !q3Anim1.isRunning()) {
                    q3Anim1.start();
                }
                if (q3Anim2 != null && !q3Anim2.isRunning()) {
                    q3Anim2.start();
                }
                if (q3Anim3 != null && !q3Anim3.isRunning()) {
                    q3Anim3.start();
                }
            }else{
                if (q3Anim1 != null && q3Anim1.isRunning()) {
                    q3Anim1.stop();
                }
                if (q3Anim2 != null && q3Anim2.isRunning()) {
                    q3Anim2.stop();
                }
                if (q3Anim3 != null && q3Anim3.isRunning()) {
                    q3Anim3.stop();
                }
                if(list.get(position).getBallls().size()!=0){
                    lotteryViewHolderFour.mtype7_balls1.setBackground(ContextCompat.getDrawable(context, qk3bg[Integer.parseInt(list.get(position).getBall(0)) - 1]));
                    lotteryViewHolderFour.mtype7_balls2.setBackground(ContextCompat.getDrawable(context, qk3bg[Integer.parseInt(list.get(position).getBall(1)) - 1]));
                    lotteryViewHolderFour.mtype7_balls3.setBackground(ContextCompat.getDrawable(context, qk3bg[Integer.parseInt(list.get(position).getBall(2)) - 1]));
                }
            }
        }
        if(!mBusy){
            setData(position);
        }
        return convertView;
    }

    public void setView(View view){
        lotteryViewHolderFour.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFour.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFour.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFour.mtype7_balls1      = (ImageView)view.findViewById(R.id.type7_ball1);
        lotteryViewHolderFour.mtype7_balls2      = (ImageView)view.findViewById(R.id.type7_ball2);
        lotteryViewHolderFour.mtype7_balls3      = (ImageView)view.findViewById(R.id.type7_ball3);
        lotteryViewHolderFour.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFour.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFour.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFour.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFour.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFour.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFour.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFour.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFour.mtype7_balls1.setTag(lotteryViewHolderFour);
        lotteryViewHolderFour.mtype7_balls2.setTag(lotteryViewHolderFour);
        lotteryViewHolderFour.mtype7_balls3.setTag(lotteryViewHolderFour);
    }

    public void setData(int i){
        lotteryViewHolderFour.lottery_history.setTag(lotteryViewHolderFour);
        lotteryViewHolderFour.lottery_current.setTag(lotteryViewHolderFour);
        lotteryViewHolderFour.lottery_rules.setTag(lotteryViewHolderFour);
        lotteryViewHolderFour.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFour holder = (LotteryViewHolderFour) v.getTag();
            }
        });
        lotteryViewHolderFour.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFour holder = (LotteryViewHolderFour) v.getTag();
            }
        });
        lotteryViewHolderFour.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFour holder = (LotteryViewHolderFour) v.getTag();
            }
        });
        lotteryViewHolderFour.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderFour.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderFour.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderFour.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFour.hour.setText(list.get(i).getHour());
        lotteryViewHolderFour.min.setText(list.get(i).getMinute());
        lotteryViewHolderFour.secd.setText(list.get(i).getSecond());
    }
}
