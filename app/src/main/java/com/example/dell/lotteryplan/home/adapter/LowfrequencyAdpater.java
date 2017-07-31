package com.example.dell.lotteryplan.home.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderFifth;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderOne;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderThree;
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderTwo;

import java.util.List;

/**
 * Created by dell on 2017/6/29.
 */

public class LowfrequencyAdpater extends BaseAdapter {

    public static final int         TYPE_COUNT = 5;
    public static final int         TYPE_ITEM1 = 1;
    public static final int         TYPE_ITEM2 = 2;
    public static final int         TYPE_ITEM3 = 3;
    public static final int         TYPE_ITEM4 = 4;
    private boolean                 mBusy = false;
    private Context                 context;
    private List<LotteryMessage>    list;
    private LotteryViewHolderTwo    lotteryViewHolderTwo1,lotteryViewHolderTwo2,lotteryViewHolderTwo3,lotteryViewHolderTwo4;
    private LayoutInflater          mInflater;
    private int                     currentType;
    private View                    itemview1,itemview2,itemview3,itemview4,itemview5;
    private String[]                strings={"1","2","3","4","5","6","7","8","9"};

    public LowfrequencyAdpater(Context context,List<LotteryMessage> list){
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
    public int getItemViewType(int position) {
        if("1".equals(list.get(position).getItem_type())){
            return TYPE_ITEM1;
        }else if("2".equals(list.get(position).getItem_type())){
            return TYPE_ITEM2;
        } else if("3".equals(list.get(position).getItem_type())){
            return TYPE_ITEM3;
        } else if("4".equals(list.get(position).getItem_type())){
            return TYPE_ITEM4;
        }else{
            return 100;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        currentType = getItemViewType(position);
        switch (currentType){
            case TYPE_ITEM1:
                lotteryViewHolderTwo1 = null;
                if(convertView == null){
                    lotteryViewHolderTwo1  =   new LotteryViewHolderTwo();
                    itemview1               =   mInflater.inflate(R.layout.item_lottery_item1,parent,false);
                    setView1(itemview1);
                    itemview1.setTag(lotteryViewHolderTwo1);
                    convertView = itemview1;
                }else{
                    lotteryViewHolderTwo1 	= 	(LotteryViewHolderTwo) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderTwo1.type_balls1.startAutoScroll();
                        lotteryViewHolderTwo1.type_balls2.startAutoScroll();
                        lotteryViewHolderTwo1.type_balls3.startAutoScroll();
                        lotteryViewHolderTwo1.type_balls4.startAutoScroll();
                        lotteryViewHolderTwo1.type_balls5.startAutoScroll();
                    }else{
                        lotteryViewHolderTwo1.type_balls1.stopAutoScroll();
                        lotteryViewHolderTwo1.type_balls2.stopAutoScroll();
                        lotteryViewHolderTwo1.type_balls3.stopAutoScroll();
                        lotteryViewHolderTwo1.type_balls4.stopAutoScroll();
                        lotteryViewHolderTwo1.type_balls5.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            if(list.get(position).getLottery_id().equals("151")){
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls1 .setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo1.type_balls2 .setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo1.type_balls3 .setText(list.get(position).getBall(2));
                                lotteryViewHolderTwo1.type_balls4 .setText(list.get(position).getBall(3));
                            }else if(list.get(position).getLottery_id().equals("154")){
                                lotteryViewHolderTwo1.type_balls3.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls4.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls1 .setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo1.type_balls2 .setText(list.get(position).getBall(1));
                            }else if(list.get(position).getLottery_id().equals("155")){
                                lotteryViewHolderTwo1.type_balls4.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.GONE);
                                lotteryViewHolderTwo1.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls1 .setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo1.type_balls2 .setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo1.type_balls3 .setText(list.get(position).getBall(2));
                            }else if(list.get(position).getLottery_id().equals("164")){
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls5.setBackgroundResource(R.drawable.type1_ball_3);
                                lotteryViewHolderTwo1.type_balls1.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls2.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls3.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls4.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls1 .setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo1.type_balls2 .setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo1.type_balls3 .setText(list.get(position).getBall(2));
                                lotteryViewHolderTwo1.type_balls4 .setText(list.get(position).getBall(3));
                                lotteryViewHolderTwo1.type_balls5 .setText(list.get(position).getBall(4));
                            }else{
                                lotteryViewHolderTwo1.type_balls1.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls2.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls3.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls4.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls5.setVisibility(View.VISIBLE);
                                lotteryViewHolderTwo1.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls5.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo1.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo1.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo1.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderTwo1.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderTwo1.type_balls5.setText(list.get(position).getBall(4));
                            }
                        }
                    }
                }
                if(!mBusy) {
                    setData1(position);
                }
                break;
            case TYPE_ITEM2:
                lotteryViewHolderTwo2 = null;
                if(convertView == null){
                    lotteryViewHolderTwo2  =   new LotteryViewHolderTwo();
                    itemview2               =   mInflater.inflate(R.layout.item_lottery_item5,parent,false);
                    setView2(itemview2);
                    itemview2.setTag(lotteryViewHolderTwo2);
                    convertView = itemview2;
                }else{
                    lotteryViewHolderTwo2 	= 	(LotteryViewHolderTwo) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderTwo2.type_balls1.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls2.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls3.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls4.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls5.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls6.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls7.startAutoScroll();
                        lotteryViewHolderTwo2.type_balls8.startAutoScroll();
                    }else{
                        lotteryViewHolderTwo2.type_balls1.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls2.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls3.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls4.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls5.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls6.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls7.stopAutoScroll();
                        lotteryViewHolderTwo2.type_balls8.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            if(list.get(position).getLottery_id().equals("161")){
                                lotteryViewHolderTwo2.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo2.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo2.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderTwo2.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderTwo2.type_balls5.setText(list.get(position).getBall(4));
                                lotteryViewHolderTwo2.type_balls6.setText(list.get(position).getBall(5));
                                lotteryViewHolderTwo2.type_balls7.setText(list.get(position).getBall(6));
                                lotteryViewHolderTwo2.type_balls8.setText(list.get(position).getBall(7));
                            }else{
                                lotteryViewHolderTwo2.type_balls8.setVisibility(View.GONE);
                                lotteryViewHolderTwo2.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderTwo2.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderTwo2.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderTwo2.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderTwo2.type_balls5.setText(list.get(position).getBall(4));
                                lotteryViewHolderTwo2.type_balls6.setText(list.get(position).getBall(5));
                                lotteryViewHolderTwo2.type_balls7.setText(list.get(position).getBall(6));
                            }
                        }
                    }
                }
                if(!mBusy) {
                    setData2(position);
                }
               break;
            case TYPE_ITEM3:
                lotteryViewHolderTwo3 = null;
                if(convertView == null){
                    lotteryViewHolderTwo3  =   new LotteryViewHolderTwo();
                    itemview3               =   mInflater.inflate(R.layout.item_lottery_item8,parent,false);
                    setView3(itemview3);
                    itemview3.setTag(lotteryViewHolderTwo3);
                    convertView = itemview3;
                }else{
                    lotteryViewHolderTwo3 	= 	(LotteryViewHolderTwo) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderTwo3.type_balls1.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls2.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls3.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls4.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls5.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls6.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls7.startAutoScroll();
                        lotteryViewHolderTwo3.type_balls8.startAutoScroll();
                    }else{
                        lotteryViewHolderTwo3.type_balls1.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls2.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls3.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls4.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls5.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls6.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls7.stopAutoScroll();
                        lotteryViewHolderTwo3.type_balls8.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderTwo3.type_balls1.setText(list.get(position).getBall(0));
                            lotteryViewHolderTwo3.type_balls2.setText(list.get(position).getBall(1));
                            lotteryViewHolderTwo3.type_balls3.setText(list.get(position).getBall(2));
                            lotteryViewHolderTwo3.type_balls4.setText(list.get(position).getBall(3));
                            lotteryViewHolderTwo3.type_balls5.setText(list.get(position).getBall(4));
                            lotteryViewHolderTwo3.type_balls6.setText(list.get(position).getBall(5));
                            lotteryViewHolderTwo3.type_balls7.setText(list.get(position).getBall(6));
                            lotteryViewHolderTwo3.type_balls8.setText(list.get(position).getBall(7));
                        }
                    }
                }
                if(!mBusy) {
                    setData3(position);
                }
                break;
            case TYPE_ITEM4:
                lotteryViewHolderTwo4 = null;
                if(convertView == null){
                    lotteryViewHolderTwo4  =   new LotteryViewHolderTwo();
                    itemview4               =   mInflater.inflate(R.layout.item_lottery_item9,parent,false);
                    setView4(itemview4);
                    itemview4.setTag(lotteryViewHolderTwo4);
                    convertView = itemview4;
                }else{
                    lotteryViewHolderTwo4 	= 	(LotteryViewHolderTwo) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderTwo4.type_balls1.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls2.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls3.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls4.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls5.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls6.startAutoScroll();
                        lotteryViewHolderTwo4.type_balls7.startAutoScroll();
                    }else{
                        lotteryViewHolderTwo4.type_balls1.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls2.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls3.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls4.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls5.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls6.stopAutoScroll();
                        lotteryViewHolderTwo4.type_balls7.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            if(list.get(position).getLottery_id().equals("141")){
                                lotteryViewHolderTwo4.type_balls6.setBackgroundResource(R.drawable.type1_ball_3);
                            }else if(list.get(position).getLottery_id().equals("142")){
                                lotteryViewHolderTwo4.type_balls5.setBackgroundResource(R.drawable.type1_ball_3);
                                lotteryViewHolderTwo4.type_balls6.setBackgroundResource(R.drawable.type1_ball_3);
                            }else{
                                lotteryViewHolderTwo4.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls5.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls6.setBackgroundResource(R.drawable.type1_ball_1);
                                lotteryViewHolderTwo4.type_balls7.setBackgroundResource(R.drawable.type1_ball_3);
                            }
                            lotteryViewHolderTwo4.type_balls1.setText(list.get(position).getBall(0));
                            lotteryViewHolderTwo4.type_balls2.setText(list.get(position).getBall(1));
                            lotteryViewHolderTwo4.type_balls3.setText(list.get(position).getBall(2));
                            lotteryViewHolderTwo4.type_balls4.setText(list.get(position).getBall(3));
                            lotteryViewHolderTwo4.type_balls5.setText(list.get(position).getBall(4));
                            lotteryViewHolderTwo4.type_balls6.setText(list.get(position).getBall(5));
                            lotteryViewHolderTwo4.type_balls7.setText(list.get(position).getBall(6));
                        }
                    }
                }
                if(!mBusy) {
                    setData4(position);
                }
                break;
        }
        return convertView;
    }

    public void setView1(View view){
        lotteryViewHolderTwo1.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderTwo1.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderTwo1.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderTwo1.type_balls1        = (UpDownTextView) view.findViewById(R.id.type1_ball1);
        lotteryViewHolderTwo1.type_balls2        = (UpDownTextView) view.findViewById(R.id.type1_ball2);
        lotteryViewHolderTwo1.type_balls3        = (UpDownTextView) view.findViewById(R.id.type1_ball3);
        lotteryViewHolderTwo1.type_balls4        = (UpDownTextView) view.findViewById(R.id.type1_ball4);
        lotteryViewHolderTwo1.type_balls5        = (UpDownTextView) view.findViewById(R.id.type1_ball5);
        lotteryViewHolderTwo1.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderTwo1.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderTwo1.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderTwo1.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderTwo1.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderTwo1.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderTwo1.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderTwo1.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderTwo1.type_balls1.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.type_balls2.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.type_balls3.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.type_balls4.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.type_balls5.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo1.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo1.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo1.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo1.type_balls5.setGravity(Gravity.CENTER);
    }
    public void setData1(int i){
        lotteryViewHolderTwo1.lottery_history.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.lottery_current.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.lottery_rules.setTag(lotteryViewHolderTwo1);
        lotteryViewHolderTwo1.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo1.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo1.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo1.type_balls1.setTextList(strings);
        lotteryViewHolderTwo1.type_balls2.setTextList(strings);
        lotteryViewHolderTwo1.type_balls3.setTextList(strings);
        lotteryViewHolderTwo1.type_balls4.setTextList(strings);
        lotteryViewHolderTwo1.type_balls5.setTextList(strings);
        lotteryViewHolderTwo1.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderTwo1.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderTwo1.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderTwo1.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderTwo1.hour.setText(list.get(i).getHour());
        lotteryViewHolderTwo1.min.setText(list.get(i).getMinute());
        lotteryViewHolderTwo1.secd.setText(list.get(i).getSecond());
    }

    public void setView2(View view){
        lotteryViewHolderTwo2.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderTwo2.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderTwo2.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderTwo2.type_balls1        = (UpDownTextView) view.findViewById(R.id.type5_ball1);
        lotteryViewHolderTwo2.type_balls2        = (UpDownTextView) view.findViewById(R.id.type5_ball2);
        lotteryViewHolderTwo2.type_balls3        = (UpDownTextView) view.findViewById(R.id.type5_ball3);
        lotteryViewHolderTwo2.type_balls4        = (UpDownTextView) view.findViewById(R.id.type5_ball4);
        lotteryViewHolderTwo2.type_balls5        = (UpDownTextView) view.findViewById(R.id.type5_ball5);
        lotteryViewHolderTwo2.type_balls6        = (UpDownTextView) view.findViewById(R.id.type5_ball6);
        lotteryViewHolderTwo2.type_balls7        = (UpDownTextView) view.findViewById(R.id.type5_ball7);
        lotteryViewHolderTwo2.type_balls8        = (UpDownTextView) view.findViewById(R.id.type5_ball8);
        lotteryViewHolderTwo2.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderTwo2.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderTwo2.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderTwo2.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderTwo2.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderTwo2.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderTwo2.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderTwo2.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderTwo2.type_balls1.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls2.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls3.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls4.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls5.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls6.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls7.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls8.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo2.type_balls8.setGravity(Gravity.CENTER);
    }
    public void setData2(int i){
        lotteryViewHolderTwo2.lottery_history.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.lottery_current.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.lottery_rules.setTag(lotteryViewHolderTwo2);
        lotteryViewHolderTwo2.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo2.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo2.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo2.type_balls1.setTextList(strings);
        lotteryViewHolderTwo2.type_balls2.setTextList(strings);
        lotteryViewHolderTwo2.type_balls3.setTextList(strings);
        lotteryViewHolderTwo2.type_balls4.setTextList(strings);
        lotteryViewHolderTwo2.type_balls5.setTextList(strings);
        lotteryViewHolderTwo2.type_balls6.setTextList(strings);
        lotteryViewHolderTwo2.type_balls7.setTextList(strings);
        lotteryViewHolderTwo2.type_balls8.setTextList(strings);
        lotteryViewHolderTwo2.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderTwo2.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderTwo2.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderTwo2.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderTwo2.hour.setText(list.get(i).getHour());
        lotteryViewHolderTwo2.min.setText(list.get(i).getMinute());
        lotteryViewHolderTwo2.secd.setText(list.get(i).getSecond());
    }

    public void setView3(View view){
        lotteryViewHolderTwo3.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderTwo3.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderTwo3.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderTwo3.type_balls1        = (UpDownTextView) view.findViewById(R.id.type8_ball1);
        lotteryViewHolderTwo3.type_balls2        = (UpDownTextView) view.findViewById(R.id.type8_ball2);
        lotteryViewHolderTwo3.type_balls3        = (UpDownTextView) view.findViewById(R.id.type8_ball3);
        lotteryViewHolderTwo3.type_balls4        = (UpDownTextView) view.findViewById(R.id.type8_ball4);
        lotteryViewHolderTwo3.type_balls5        = (UpDownTextView) view.findViewById(R.id.type8_ball5);
        lotteryViewHolderTwo3.type_balls6        = (UpDownTextView) view.findViewById(R.id.type8_ball6);
        lotteryViewHolderTwo3.type_balls7        = (UpDownTextView) view.findViewById(R.id.type8_ball7);
        lotteryViewHolderTwo3.type_balls8        = (UpDownTextView) view.findViewById(R.id.type8_ball8);
        lotteryViewHolderTwo3.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderTwo3.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderTwo3.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderTwo3.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderTwo3.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderTwo3.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderTwo3.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderTwo3.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderTwo3.type_balls1.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls2.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls3.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls4.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls5.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls6.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls7.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls8.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo3.type_balls8.setGravity(Gravity.CENTER);
    }
    public void setData3(int i){
        lotteryViewHolderTwo3.lottery_history.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.lottery_current.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.lottery_rules.setTag(lotteryViewHolderTwo3);
        lotteryViewHolderTwo3.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo3.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo3.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo3.type_balls1.setTextList(strings);
        lotteryViewHolderTwo3.type_balls2.setTextList(strings);
        lotteryViewHolderTwo3.type_balls3.setTextList(strings);
        lotteryViewHolderTwo3.type_balls4.setTextList(strings);
        lotteryViewHolderTwo3.type_balls5.setTextList(strings);
        lotteryViewHolderTwo3.type_balls6.setTextList(strings);
        lotteryViewHolderTwo3.type_balls7.setTextList(strings);
        lotteryViewHolderTwo3.type_balls8.setTextList(strings);
        lotteryViewHolderTwo3.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderTwo3.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderTwo3.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderTwo3.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderTwo3.hour.setText(list.get(i).getHour());
        lotteryViewHolderTwo3.min.setText(list.get(i).getMinute());
        lotteryViewHolderTwo3.secd.setText(list.get(i).getSecond());
    }

    public void setView4(View view){
        lotteryViewHolderTwo4.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderTwo4.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderTwo4.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderTwo4.type_balls1        = (UpDownTextView) view.findViewById(R.id.type9_ball1);
        lotteryViewHolderTwo4.type_balls2        = (UpDownTextView) view.findViewById(R.id.type9_ball2);
        lotteryViewHolderTwo4.type_balls3        = (UpDownTextView) view.findViewById(R.id.type9_ball3);
        lotteryViewHolderTwo4.type_balls4        = (UpDownTextView) view.findViewById(R.id.type9_ball4);
        lotteryViewHolderTwo4.type_balls5        = (UpDownTextView) view.findViewById(R.id.type9_ball5);
        lotteryViewHolderTwo4.type_balls6        = (UpDownTextView) view.findViewById(R.id.type9_ball6);
        lotteryViewHolderTwo4.type_balls7        = (UpDownTextView) view.findViewById(R.id.type9_ball7);
        lotteryViewHolderTwo4.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderTwo4.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderTwo4.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderTwo4.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderTwo4.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderTwo4.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderTwo4.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderTwo4.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderTwo4.type_balls1.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls2.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls3.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls4.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls5.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls6.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls7.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderTwo4.type_balls7.setGravity(Gravity.CENTER);
    }
    public void setData4(int i){
        lotteryViewHolderTwo4.lottery_history.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.lottery_current.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.lottery_rules.setTag(lotteryViewHolderTwo4);
        lotteryViewHolderTwo4.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo4.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo4.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderTwo holder = (LotteryViewHolderTwo) v.getTag();
            }
        });
        lotteryViewHolderTwo4.type_balls1.setTextList(strings);
        lotteryViewHolderTwo4.type_balls2.setTextList(strings);
        lotteryViewHolderTwo4.type_balls3.setTextList(strings);
        lotteryViewHolderTwo4.type_balls4.setTextList(strings);
        lotteryViewHolderTwo4.type_balls5.setTextList(strings);
        lotteryViewHolderTwo4.type_balls6.setTextList(strings);
        lotteryViewHolderTwo4.type_balls7.setTextList(strings);
        lotteryViewHolderTwo4.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderTwo4.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderTwo4.now_time.setText(list.get(i).getNow_time());

        lotteryViewHolderTwo4.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderTwo4.hour.setText(list.get(i).getHour());
        lotteryViewHolderTwo4.min.setText(list.get(i).getMinute());
        lotteryViewHolderTwo4.secd.setText(list.get(i).getSecond());
    }
}
