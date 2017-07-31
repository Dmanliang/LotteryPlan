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
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderThree;

import java.util.List;

/**
 * Created by dell on 2017/6/27.
 */

public class OutsideAdpater extends BaseAdapter {

    public static final int         TYPE_COUNT = 5;
    public static final int         TYPE_ITEM1 = 1;
    public static final int         TYPE_ITEM2 = 2;
    public static final int         TYPE_ITEM3 = 3;
    private Context                 context;
    private List<LotteryMessage>    list;
    private LotteryViewHolderOne    lotteryViewHolderOne;
    private LotteryViewHolderThree  lotteryViewHolderThree,lotteryViewHolderThree1;
    private LayoutInflater          mInflater;
    private int                     currentType;//当前item类型
    private boolean                 mBusy = false;
    private String[]                strings={"1","2","3","4","5","6","7","8","9"};

    public OutsideAdpater(Context context,List<LotteryMessage> list){
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
        }else if("3".equals(list.get(position).getItem_type())){
            return TYPE_ITEM3;
        }else {
            return 100;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemview1=null;
        View itemview2=null;
        View itemview3=null;
        currentType = getItemViewType(position);
        switch (currentType){
            case TYPE_ITEM1:
                lotteryViewHolderThree = null;
                if(convertView == null){
                    lotteryViewHolderThree  =   new LotteryViewHolderThree();
                    itemview1               =   mInflater.inflate(R.layout.item_lottery_item3,parent,false);
                    setView1(itemview1);
                    itemview1.setTag(lotteryViewHolderThree);
                    convertView = itemview1;
                }
                else{
                    lotteryViewHolderThree 	= 	(LotteryViewHolderThree) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderThree.type_balls1.startAutoScroll();
                        lotteryViewHolderThree.type_balls2.startAutoScroll();
                        lotteryViewHolderThree.type_balls3.startAutoScroll();
                        lotteryViewHolderThree.type_balls4.startAutoScroll();
                        lotteryViewHolderThree.type_balls5.startAutoScroll();
                        lotteryViewHolderThree.type_balls6.startAutoScroll();
                        lotteryViewHolderThree.type_balls7.startAutoScroll();
                        lotteryViewHolderThree.type_balls8.startAutoScroll();
                        lotteryViewHolderThree.type_balls9.startAutoScroll();
                        lotteryViewHolderThree.type_balls10.startAutoScroll();
                        lotteryViewHolderThree.type_balls11.startAutoScroll();
                        lotteryViewHolderThree.type_balls12.startAutoScroll();
                        lotteryViewHolderThree.type_balls13.startAutoScroll();
                        lotteryViewHolderThree.type_balls14.startAutoScroll();
                        lotteryViewHolderThree.type_balls15.startAutoScroll();
                        lotteryViewHolderThree.type_balls16.startAutoScroll();
                        lotteryViewHolderThree.type_balls17.startAutoScroll();
                        lotteryViewHolderThree.type_balls18.startAutoScroll();
                        lotteryViewHolderThree.type_balls19.startAutoScroll();
                        lotteryViewHolderThree.type_balls20.startAutoScroll();
                    }else {
                        lotteryViewHolderThree.type_balls1.stopAutoScroll();
                        lotteryViewHolderThree.type_balls2.stopAutoScroll();
                        lotteryViewHolderThree.type_balls3.stopAutoScroll();
                        lotteryViewHolderThree.type_balls4.stopAutoScroll();
                        lotteryViewHolderThree.type_balls5.stopAutoScroll();
                        lotteryViewHolderThree.type_balls6.stopAutoScroll();
                        lotteryViewHolderThree.type_balls7.stopAutoScroll();
                        lotteryViewHolderThree.type_balls8.stopAutoScroll();
                        lotteryViewHolderThree.type_balls9.stopAutoScroll();
                        lotteryViewHolderThree.type_balls10.stopAutoScroll();
                        lotteryViewHolderThree.type_balls11.stopAutoScroll();
                        lotteryViewHolderThree.type_balls12.stopAutoScroll();
                        lotteryViewHolderThree.type_balls13.stopAutoScroll();
                        lotteryViewHolderThree.type_balls14.stopAutoScroll();
                        lotteryViewHolderThree.type_balls15.stopAutoScroll();
                        lotteryViewHolderThree.type_balls16.stopAutoScroll();
                        lotteryViewHolderThree.type_balls17.stopAutoScroll();
                        lotteryViewHolderThree.type_balls18.stopAutoScroll();
                        lotteryViewHolderThree.type_balls19.stopAutoScroll();
                        lotteryViewHolderThree.type_balls20.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderThree.type_balls1 .setText(list.get(position).getBall(0));
                            lotteryViewHolderThree.type_balls2 .setText(list.get(position).getBall(1));
                            lotteryViewHolderThree.type_balls3 .setText(list.get(position).getBall(2));
                            lotteryViewHolderThree.type_balls4 .setText(list.get(position).getBall(3));
                            lotteryViewHolderThree.type_balls5 .setText(list.get(position).getBall(4));
                            lotteryViewHolderThree.type_balls6 .setText(list.get(position).getBall(5));
                            lotteryViewHolderThree.type_balls7 .setText(list.get(position).getBall(6));
                            lotteryViewHolderThree.type_balls8 .setText(list.get(position).getBall(7));
                            lotteryViewHolderThree.type_balls9 .setText(list.get(position).getBall(8));
                            lotteryViewHolderThree.type_balls10.setText(list.get(position).getBall(9));
                            lotteryViewHolderThree.type_balls11.setText(list.get(position).getBall(10));
                            lotteryViewHolderThree.type_balls12.setText(list.get(position).getBall(11));
                            lotteryViewHolderThree.type_balls13.setText(list.get(position).getBall(12));
                            lotteryViewHolderThree.type_balls14.setText(list.get(position).getBall(13));
                            lotteryViewHolderThree.type_balls15.setText(list.get(position).getBall(14));
                            lotteryViewHolderThree.type_balls16.setText(list.get(position).getBall(15));
                            lotteryViewHolderThree.type_balls17.setText(list.get(position).getBall(16));
                            lotteryViewHolderThree.type_balls18.setText(list.get(position).getBall(17));
                            lotteryViewHolderThree.type_balls19.setText(list.get(position).getBall(18));
                            lotteryViewHolderThree.type_balls20.setText(list.get(position).getBall(19));
                        }
                    }
                }
                if(!mBusy){
                    setData1(position);
                }
                break;
            case TYPE_ITEM2:
                lotteryViewHolderOne = null;
                if(convertView == null){
                    lotteryViewHolderOne    =   new LotteryViewHolderOne();
                    itemview2               =   mInflater.inflate(R.layout.item_lottery_item1,parent,false);
                    setView2(itemview2);
                    itemview2.setTag(lotteryViewHolderOne);
                    convertView = itemview2;
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
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderOne.type_balls1.setText(list.get(position).getBall(0));
                            lotteryViewHolderOne.type_balls2.setText(list.get(position).getBall(1));
                            lotteryViewHolderOne.type_balls3.setText(list.get(position).getBall(2));
                            lotteryViewHolderOne.type_balls4.setText(list.get(position).getBall(3));
                            lotteryViewHolderOne.type_balls5.setText(list.get(position).getBall(4));
                        }
                    }
                }
                if(!mBusy) {
                    setData2(position);
                }
                break;
            case TYPE_ITEM3:
                lotteryViewHolderThree1 = null;
                if(convertView == null){
                    lotteryViewHolderThree1  =   new LotteryViewHolderThree();
                    itemview3               =   mInflater.inflate(R.layout.item_lottery_item3,parent,false);
                    setView3(itemview3);
                    itemview3.setTag(lotteryViewHolderThree1);
                    convertView = itemview3;
                }
                else{
                    lotteryViewHolderThree1 	= 	(LotteryViewHolderThree) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderThree1.type_balls1.startAutoScroll();
                        lotteryViewHolderThree1.type_balls2.startAutoScroll();
                        lotteryViewHolderThree1.type_balls3.startAutoScroll();
                        lotteryViewHolderThree1.type_balls4.startAutoScroll();
                        lotteryViewHolderThree1.type_balls5.startAutoScroll();
                        lotteryViewHolderThree1.type_balls6.startAutoScroll();
                        lotteryViewHolderThree1.type_balls7.startAutoScroll();
                        lotteryViewHolderThree1.type_balls8.startAutoScroll();
                        lotteryViewHolderThree1.type_balls9.startAutoScroll();
                        lotteryViewHolderThree1.type_balls10.startAutoScroll();
                        lotteryViewHolderThree1.type_balls11.startAutoScroll();
                        lotteryViewHolderThree1.type_balls12.startAutoScroll();
                        lotteryViewHolderThree1.type_balls13.startAutoScroll();
                        lotteryViewHolderThree1.type_balls14.startAutoScroll();
                        lotteryViewHolderThree1.type_balls15.startAutoScroll();
                        lotteryViewHolderThree1.type_balls16.startAutoScroll();
                        lotteryViewHolderThree1.type_balls17.startAutoScroll();
                        lotteryViewHolderThree1.type_balls18.startAutoScroll();
                        lotteryViewHolderThree1.type_balls19.startAutoScroll();
                        lotteryViewHolderThree1.type_balls20.startAutoScroll();
                        lotteryViewHolderThree1.type_balls21.startAutoScroll();
                    }else {
                        lotteryViewHolderThree1.type_balls1.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls2.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls3.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls4.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls5.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls6.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls7.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls8.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls9.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls10.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls11.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls12.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls13.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls14.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls15.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls16.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls17.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls18.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls19.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls20.stopAutoScroll();
                        lotteryViewHolderThree1.type_balls21.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderThree1.type_balls1 .setText(list.get(position).getBall(0));
                            lotteryViewHolderThree1.type_balls2 .setText(list.get(position).getBall(1));
                            lotteryViewHolderThree1.type_balls3 .setText(list.get(position).getBall(2));
                            lotteryViewHolderThree1.type_balls4 .setText(list.get(position).getBall(3));
                            lotteryViewHolderThree1.type_balls5 .setText(list.get(position).getBall(4));
                            lotteryViewHolderThree1.type_balls6 .setText(list.get(position).getBall(5));
                            lotteryViewHolderThree1.type_balls7 .setText(list.get(position).getBall(6));
                            lotteryViewHolderThree1.type_balls8 .setText(list.get(position).getBall(7));
                            lotteryViewHolderThree1.type_balls9 .setText(list.get(position).getBall(8));
                            lotteryViewHolderThree1.type_balls10.setText(list.get(position).getBall(9));
                            lotteryViewHolderThree1.type_balls11.setText(list.get(position).getBall(10));
                            lotteryViewHolderThree1.type_balls12.setText(list.get(position).getBall(11));
                            lotteryViewHolderThree1.type_balls13.setText(list.get(position).getBall(12));
                            lotteryViewHolderThree1.type_balls14.setText(list.get(position).getBall(13));
                            lotteryViewHolderThree1.type_balls15.setText(list.get(position).getBall(14));
                            lotteryViewHolderThree1.type_balls16.setText(list.get(position).getBall(15));
                            lotteryViewHolderThree1.type_balls17.setText(list.get(position).getBall(16));
                            lotteryViewHolderThree1.type_balls18.setText(list.get(position).getBall(17));
                            lotteryViewHolderThree1.type_balls19.setText(list.get(position).getBall(18));
                            lotteryViewHolderThree1.type_balls20.setText(list.get(position).getBall(19));
                            lotteryViewHolderThree1.type_balls21.setText(list.get(position).getBall(20));
                        }
                    }
                }
                if(!mBusy) {
                    setData3(position);
                }
                break;
        }
        return convertView;
    }

    public void setView1(View view){
        lotteryViewHolderThree.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderThree.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderThree.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderThree.type_balls1        = (UpDownTextView) view.findViewById(R.id.type3_ball1);
        lotteryViewHolderThree.type_balls2        = (UpDownTextView) view.findViewById(R.id.type3_ball2);
        lotteryViewHolderThree.type_balls3        = (UpDownTextView) view.findViewById(R.id.type3_ball3);
        lotteryViewHolderThree.type_balls4        = (UpDownTextView) view.findViewById(R.id.type3_ball4);
        lotteryViewHolderThree.type_balls5        = (UpDownTextView) view.findViewById(R.id.type3_ball5);
        lotteryViewHolderThree.type_balls6        = (UpDownTextView) view.findViewById(R.id.type3_ball6);
        lotteryViewHolderThree.type_balls7        = (UpDownTextView) view.findViewById(R.id.type3_ball7);
        lotteryViewHolderThree.type_balls8        = (UpDownTextView) view.findViewById(R.id.type3_ball8);
        lotteryViewHolderThree.type_balls9        = (UpDownTextView) view.findViewById(R.id.type3_ball9);
        lotteryViewHolderThree.type_balls10       = (UpDownTextView) view.findViewById(R.id.type3_ball10);
        lotteryViewHolderThree.type_balls11       = (UpDownTextView) view.findViewById(R.id.type3_ball11);
        lotteryViewHolderThree.type_balls12       = (UpDownTextView) view.findViewById(R.id.type3_ball12);
        lotteryViewHolderThree.type_balls13       = (UpDownTextView) view.findViewById(R.id.type3_ball13);
        lotteryViewHolderThree.type_balls14       = (UpDownTextView) view.findViewById(R.id.type3_ball14);
        lotteryViewHolderThree.type_balls15       = (UpDownTextView) view.findViewById(R.id.type3_ball15);
        lotteryViewHolderThree.type_balls16       = (UpDownTextView) view.findViewById(R.id.type3_ball16);
        lotteryViewHolderThree.type_balls17       = (UpDownTextView) view.findViewById(R.id.type3_ball17);
        lotteryViewHolderThree.type_balls18       = (UpDownTextView) view.findViewById(R.id.type3_ball18);
        lotteryViewHolderThree.type_balls19       = (UpDownTextView) view.findViewById(R.id.type3_ball19);
        lotteryViewHolderThree.type_balls20       = (UpDownTextView) view.findViewById(R.id.type3_ball20);
        lotteryViewHolderThree.type_balls21       = (UpDownTextView) view.findViewById(R.id.type3_ball21);
        lotteryViewHolderThree.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderThree.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderThree.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderThree.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderThree.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderThree.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderThree.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderThree.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderThree.type_balls1.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls2.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls3.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls4.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls5.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls6.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls7.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls8.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls9.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls10.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls11.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls12.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls13.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls14.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls15.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls16.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls17.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls18.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls19.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls20.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls21.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls8.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls9.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls10.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls11.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls12.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls13.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls14.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls15.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls16.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls17.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls18.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls19.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls20.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls21.setGravity(Gravity.CENTER);
        lotteryViewHolderThree.type_balls21.setVisibility(View.GONE);
    }

    public void setView2(View view){
        lotteryViewHolderOne.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderOne.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderOne.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderOne.type_balls1        = (UpDownTextView)view.findViewById(R.id.type1_ball1);
        lotteryViewHolderOne.type_balls2        = (UpDownTextView)view.findViewById(R.id.type1_ball2);
        lotteryViewHolderOne.type_balls3        = (UpDownTextView)view.findViewById(R.id.type1_ball3);
        lotteryViewHolderOne.type_balls4        = (UpDownTextView)view.findViewById(R.id.type1_ball4);
        lotteryViewHolderOne.type_balls5        = (UpDownTextView)view.findViewById(R.id.type1_ball5);
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

    public void setView3(View view){
        lotteryViewHolderThree1.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderThree1.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderThree1.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderThree1.type_balls1        = (UpDownTextView) view.findViewById(R.id.type3_ball1);
        lotteryViewHolderThree1.type_balls2        = (UpDownTextView) view.findViewById(R.id.type3_ball2);
        lotteryViewHolderThree1.type_balls3        = (UpDownTextView) view.findViewById(R.id.type3_ball3);
        lotteryViewHolderThree1.type_balls4        = (UpDownTextView) view.findViewById(R.id.type3_ball4);
        lotteryViewHolderThree1.type_balls5        = (UpDownTextView) view.findViewById(R.id.type3_ball5);
        lotteryViewHolderThree1.type_balls6        = (UpDownTextView) view.findViewById(R.id.type3_ball6);
        lotteryViewHolderThree1.type_balls7        = (UpDownTextView) view.findViewById(R.id.type3_ball7);
        lotteryViewHolderThree1.type_balls8        = (UpDownTextView) view.findViewById(R.id.type3_ball8);
        lotteryViewHolderThree1.type_balls9        = (UpDownTextView) view.findViewById(R.id.type3_ball9);
        lotteryViewHolderThree1.type_balls10       = (UpDownTextView) view.findViewById(R.id.type3_ball10);
        lotteryViewHolderThree1.type_balls11       = (UpDownTextView) view.findViewById(R.id.type3_ball11);
        lotteryViewHolderThree1.type_balls12       = (UpDownTextView) view.findViewById(R.id.type3_ball12);
        lotteryViewHolderThree1.type_balls13       = (UpDownTextView) view.findViewById(R.id.type3_ball13);
        lotteryViewHolderThree1.type_balls14       = (UpDownTextView) view.findViewById(R.id.type3_ball14);
        lotteryViewHolderThree1.type_balls15       = (UpDownTextView) view.findViewById(R.id.type3_ball15);
        lotteryViewHolderThree1.type_balls16       = (UpDownTextView) view.findViewById(R.id.type3_ball16);
        lotteryViewHolderThree1.type_balls17       = (UpDownTextView) view.findViewById(R.id.type3_ball17);
        lotteryViewHolderThree1.type_balls18       = (UpDownTextView) view.findViewById(R.id.type3_ball18);
        lotteryViewHolderThree1.type_balls19       = (UpDownTextView) view.findViewById(R.id.type3_ball19);
        lotteryViewHolderThree1.type_balls20       = (UpDownTextView) view.findViewById(R.id.type3_ball20);
        lotteryViewHolderThree1.type_balls21       = (UpDownTextView) view.findViewById(R.id.type3_ball21);
        lotteryViewHolderThree1.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderThree1.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderThree1.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderThree1.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderThree1.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderThree1.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderThree1.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderThree1.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderThree1.type_balls1.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls2.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls3.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls4.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls5.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls6.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls7.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls8.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls9.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls10.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls11.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls12.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls13.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls14.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls15.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls16.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls17.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls18.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls19.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls20.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls21.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls8.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls9.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls10.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls11.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls12.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls13.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls14.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls15.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls16.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls17.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls18.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls19.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls20.setGravity(Gravity.CENTER);
        lotteryViewHolderThree1.type_balls21.setGravity(Gravity.CENTER);
    }

    public void setData1(int i){
        lotteryViewHolderThree.lottery_history.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.lottery_current.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.lottery_rules.setTag(lotteryViewHolderThree);
        lotteryViewHolderThree.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree.type_balls1.setTextList(strings);
        lotteryViewHolderThree.type_balls2.setTextList(strings);
        lotteryViewHolderThree.type_balls3.setTextList(strings);
        lotteryViewHolderThree.type_balls4.setTextList(strings);
        lotteryViewHolderThree.type_balls5.setTextList(strings);
        lotteryViewHolderThree.type_balls6.setTextList(strings);
        lotteryViewHolderThree.type_balls7.setTextList(strings);
        lotteryViewHolderThree.type_balls8.setTextList(strings);
        lotteryViewHolderThree.type_balls9.setTextList(strings);
        lotteryViewHolderThree.type_balls10.setTextList(strings);
        lotteryViewHolderThree.type_balls11.setTextList(strings);
        lotteryViewHolderThree.type_balls12.setTextList(strings);
        lotteryViewHolderThree.type_balls13.setTextList(strings);
        lotteryViewHolderThree.type_balls14.setTextList(strings);
        lotteryViewHolderThree.type_balls15.setTextList(strings);
        lotteryViewHolderThree.type_balls16.setTextList(strings);
        lotteryViewHolderThree.type_balls17.setTextList(strings);
        lotteryViewHolderThree.type_balls18.setTextList(strings);
        lotteryViewHolderThree.type_balls19.setTextList(strings);
        lotteryViewHolderThree.type_balls20.setTextList(strings);
        lotteryViewHolderThree.type_balls21.setTextList(strings);
        lotteryViewHolderThree.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderThree.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderThree.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderThree.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderThree.hour.setText(list.get(i).getHour());
        lotteryViewHolderThree.min.setText(list.get(i).getMinute());
        lotteryViewHolderThree.secd.setText(list.get(i).getSecond());
    }

    public void setData2(int i){
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
        lotteryViewHolderOne.type_balls1.setTextList(strings);
        lotteryViewHolderOne.type_balls2.setTextList(strings);
        lotteryViewHolderOne.type_balls3.setTextList(strings);
        lotteryViewHolderOne.type_balls4.setTextList(strings);
        lotteryViewHolderOne.type_balls5.setTextList(strings);
        lotteryViewHolderOne.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderOne.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderOne.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderOne.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderOne.hour.setText(list.get(i).getHour());
        lotteryViewHolderOne.min.setText(list.get(i).getMinute());
        lotteryViewHolderOne.secd.setText(list.get(i).getSecond());
    }

    public void setData3(int i){
        lotteryViewHolderThree1.lottery_history.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.lottery_current.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.lottery_rules.setTag(lotteryViewHolderThree1);
        lotteryViewHolderThree1.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree1.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree1.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderThree holder = (LotteryViewHolderThree) v.getTag();
            }
        });
        lotteryViewHolderThree1.type_balls1.setTextList(strings);
        lotteryViewHolderThree1.type_balls2.setTextList(strings);
        lotteryViewHolderThree1.type_balls3.setTextList(strings);
        lotteryViewHolderThree1.type_balls4.setTextList(strings);
        lotteryViewHolderThree1.type_balls5.setTextList(strings);
        lotteryViewHolderThree1.type_balls6.setTextList(strings);
        lotteryViewHolderThree1.type_balls7.setTextList(strings);
        lotteryViewHolderThree1.type_balls8.setTextList(strings);
        lotteryViewHolderThree1.type_balls9.setTextList(strings);
        lotteryViewHolderThree1.type_balls10.setTextList(strings);
        lotteryViewHolderThree1.type_balls11.setTextList(strings);
        lotteryViewHolderThree1.type_balls12.setTextList(strings);
        lotteryViewHolderThree1.type_balls13.setTextList(strings);
        lotteryViewHolderThree1.type_balls14.setTextList(strings);
        lotteryViewHolderThree1.type_balls15.setTextList(strings);
        lotteryViewHolderThree1.type_balls16.setTextList(strings);
        lotteryViewHolderThree1.type_balls17.setTextList(strings);
        lotteryViewHolderThree1.type_balls18.setTextList(strings);
        lotteryViewHolderThree1.type_balls19.setTextList(strings);
        lotteryViewHolderThree1.type_balls20.setTextList(strings);
        lotteryViewHolderThree1.type_balls21.setTextList(strings);
        lotteryViewHolderThree1.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderThree1.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderThree1.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderThree1.type_balls21.setVisibility(View.VISIBLE);
        lotteryViewHolderThree1.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderThree1.hour.setText(list.get(i).getHour());
        lotteryViewHolderThree1.min.setText(list.get(i).getMinute());
        lotteryViewHolderThree1.secd.setText(list.get(i).getSecond());
    }

}
