package com.example.dell.lotteryplan.home.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
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
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderTwo;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */

public class HomepageAdpater extends BaseAdapter {

    public static final int         TYPE_COUNT = 6;
    public static final int         TYPE_ITEM1 = 1;
    public static final int         TYPE_ITEM2 = 2;
    public static final int         TYPE_ITEM3 = 3;
    public static final int         TYPE_ITEM4 = 4;
    public static final int         TYPE_ITEM5 = 5;
    private Context                 context;
    private List<LotteryMessage>    list;
    private LotteryViewHolderOne    lotteryViewHolderOne,LotteryViewHolderOne5;
    private LotteryViewHolderTwo    lotteryViewHolderTwo;
    private LotteryViewHolderFifth  lotteryViewHolderFifth1,lotteryViewHolderFifth3;
    private LayoutInflater          mInflater;
    private int                     currentType;
    private View                    itemview1,itemview2,itemview3,itemview4,itemview5;
    private int[]                   farm={R.drawable.type3_ball_1,R.drawable.type3_ball_2,R.drawable.type3_ball_3,R.drawable.type3_ball_4,R.drawable.type3_ball_5,
                                    R.drawable.type3_ball_6,R.drawable.type3_ball_7,R.drawable.type3_ball_8,R.drawable.type3_ball_9,R.drawable.type3_ball_10,R.drawable.type3_ball_11,R.drawable.type3_ball_12,
                                    R.drawable.type3_ball_13,R.drawable.type3_ball_14,R.drawable.type3_ball_15,R.drawable.type3_ball_16,R.drawable.type3_ball_17,R.drawable.type3_ball_18,R.drawable.type3_ball_19,R.drawable.type3_ball_20};
    private int[]                   nums={R.drawable.type2_ball_1,R.drawable.type2_ball_2,R.drawable.type2_ball_3,R.drawable.type2_ball_4,
                                    R.drawable.type2_ball_5,R.drawable.type2_ball_6, R.drawable.type2_ball_7,R.drawable.type2_ball_8,R.drawable.type2_ball_9,R.drawable.type2_ball_10};
    private boolean                 mBusy = false;
    private String[]                strings={"1","2","3","4","5","6","7","8","9"};
    private AnimationDrawable       frameAnim1,frameAnim2,frameAnim3,frameAnim4,frameAnim5,frameAnim6,frameAnim7,frameAnim8,frameAnim9,frameAnim10;
    private AnimationDrawable       farmAnim1,farmAnim2,farmAnim3,farmAnim4,farmAnim5,farmAnim6,farmAnim7,farmAnim8;

    public HomepageAdpater(Context context,List<LotteryMessage> list){
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
        }
        else if("3".equals(list.get(position).getItem_type())){
            return TYPE_ITEM3;
        }
        else if("4".equals(list.get(position).getItem_type())){
            return TYPE_ITEM4;
        }
        else if("5".equals(list.get(position).getItem_type())){
            return TYPE_ITEM5;
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
                lotteryViewHolderFifth1 = null;
                if(convertView == null){
                    lotteryViewHolderFifth1    =    new LotteryViewHolderFifth();
                    itemview1               =   mInflater.inflate(R.layout.item_lottery_item2,parent,false);
                    setView1(itemview1);
                    itemview1.setTag(lotteryViewHolderFifth1);
                    convertView = itemview1;
                }else {
                    lotteryViewHolderFifth1 	= 	(LotteryViewHolderFifth) convertView.getTag();
                    if(list.get(position).isOpen()) {
                        frameAnim1=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim);
                        frameAnim2=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim1);
                        frameAnim3=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim2);
                        frameAnim4=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim3);
                        frameAnim5=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim4);
                        frameAnim6=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim);
                        frameAnim7=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim1);
                        frameAnim8=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim2);
                        frameAnim9=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim3);
                        frameAnim10=(AnimationDrawable) context.getResources().getDrawable(R.drawable.nums_anim4);
                        lotteryViewHolderFifth1.mtype_balls1.setBackgroundDrawable(frameAnim1);
                        lotteryViewHolderFifth1.mtype_balls2.setBackgroundDrawable(frameAnim2);
                        lotteryViewHolderFifth1.mtype_balls3.setBackgroundDrawable(frameAnim3);
                        lotteryViewHolderFifth1.mtype_balls4.setBackgroundDrawable(frameAnim4);
                        lotteryViewHolderFifth1.mtype_balls5.setBackgroundDrawable(frameAnim5);
                        lotteryViewHolderFifth1.mtype_balls6.setBackgroundDrawable(frameAnim6);
                        lotteryViewHolderFifth1.mtype_balls7.setBackgroundDrawable(frameAnim7);
                        lotteryViewHolderFifth1.mtype_balls8.setBackgroundDrawable(frameAnim8);
                        lotteryViewHolderFifth1.mtype_balls9.setBackgroundDrawable(frameAnim9);
                        lotteryViewHolderFifth1.mtype_balls10.setBackgroundDrawable(frameAnim10);
                        if (frameAnim1 != null && !frameAnim1.isRunning()) {
                            frameAnim1.start();
                        }
                        if (frameAnim2 != null && !frameAnim2.isRunning()) {
                            frameAnim2.start();
                        }
                        if (frameAnim3 != null && !frameAnim3.isRunning()) {
                            frameAnim3.start();
                        }
                        if (frameAnim4 != null && !frameAnim4.isRunning()) {
                            frameAnim4.start();
                        }
                        if (frameAnim5 != null && !frameAnim5.isRunning()) {
                            frameAnim5.start();
                        }
                        if (frameAnim6 != null && !frameAnim6.isRunning()) {
                            frameAnim6.start();
                        }
                        if (frameAnim7 != null && !frameAnim7.isRunning()) {
                            frameAnim7.start();
                        }
                        if (frameAnim8 != null && !frameAnim8.isRunning()) {
                            frameAnim8.start();
                        }
                        if (frameAnim9 != null && !frameAnim9.isRunning()) {
                            frameAnim9.start();
                        }
                        if (frameAnim10 != null && !frameAnim10.isRunning()) {
                            frameAnim10.start();
                        }
                    }else{
                        if (frameAnim1 != null && frameAnim1.isRunning()) {
                            frameAnim1.stop();
                        }
                        if (frameAnim2 != null && frameAnim2.isRunning()) {
                            frameAnim2.stop();
                        }
                        if (frameAnim3 != null && frameAnim3.isRunning()) {
                            frameAnim3.stop();
                        }
                        if (frameAnim4 != null && frameAnim4.isRunning()) {
                            frameAnim4.stop();
                        }
                        if (frameAnim5 != null && frameAnim5.isRunning()) {
                            frameAnim5.stop();
                        }
                        if (frameAnim6 != null && frameAnim6.isRunning()) {
                            frameAnim6.stop();
                        }
                        if (frameAnim7 != null && frameAnim7.isRunning()) {
                            frameAnim7.stop();
                        }
                        if (frameAnim8 != null && frameAnim8.isRunning()) {
                            frameAnim8.stop();
                        }
                        if (frameAnim9 != null && frameAnim9.isRunning()) {
                            frameAnim9.stop();
                        }
                        if (frameAnim10 != null && frameAnim10.isRunning()) {
                            frameAnim10.stop();
                        }
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderFifth1.mtype_balls1 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(0)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls2 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(1)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls3 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(2)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls4 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(3)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls5 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(4)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls6 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(5)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls7 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(6)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls8 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(7)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls9 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(8)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls10.setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(9)) - 1]));
                        }
                    }
                }
                if(!mBusy){
                    setData1(position);
                }
                break;
            case TYPE_ITEM2:
                lotteryViewHolderTwo = null;
                if(convertView == null){
                    lotteryViewHolderTwo    =    new LotteryViewHolderTwo();
                    itemview2               =    mInflater.inflate(R.layout.item_lottery_item5,parent,false);
                    setView2(itemview2);
                    itemview2.setTag(lotteryViewHolderTwo);
                    convertView = itemview2;
                }else {
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
                        if(list.get(position).getBallls().size()!=0){
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
                if(!mBusy) {
                    setData2(position);
                }
                break;
            case TYPE_ITEM3:
                lotteryViewHolderFifth3 =null;
                if(convertView == null){
                    lotteryViewHolderFifth3     =    new LotteryViewHolderFifth();
                    itemview3                   =   mInflater.inflate(R.layout.item_lottery_item6,parent,false);
                    setView3(itemview3);
                    itemview3.setTag(lotteryViewHolderFifth3);
                    convertView = itemview3;
                }else{
                    lotteryViewHolderFifth3 	= 	(LotteryViewHolderFifth) convertView.getTag();
                    if(list.get(position).isOpen()) {
                        farmAnim1=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim1);
                        farmAnim2=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim2);
                        farmAnim3=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim3);
                        farmAnim4=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim4);
                        farmAnim5=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim1);
                        farmAnim6=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim2);
                        farmAnim7=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim3);
                        farmAnim8=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim4);
                        lotteryViewHolderFifth3.mtype_balls1.setBackgroundDrawable(farmAnim1);
                        lotteryViewHolderFifth3.mtype_balls2.setBackgroundDrawable(farmAnim2);
                        lotteryViewHolderFifth3.mtype_balls3.setBackgroundDrawable(farmAnim3);
                        lotteryViewHolderFifth3.mtype_balls4.setBackgroundDrawable(farmAnim4);
                        lotteryViewHolderFifth3.mtype_balls5.setBackgroundDrawable(farmAnim5);
                        lotteryViewHolderFifth3.mtype_balls6.setBackgroundDrawable(farmAnim6);
                        lotteryViewHolderFifth3.mtype_balls7.setBackgroundDrawable(farmAnim7);
                        lotteryViewHolderFifth3.mtype_balls8.setBackgroundDrawable(farmAnim8);
                        if (farmAnim1 != null && !farmAnim1.isRunning()) {
                            farmAnim1.start();
                        }
                        if (farmAnim2 != null && !farmAnim2.isRunning()) {
                            farmAnim2.start();
                        }
                        if (farmAnim3 != null && !farmAnim3.isRunning()) {
                            farmAnim3.start();
                        }
                        if (farmAnim4 != null && !farmAnim4.isRunning()) {
                            farmAnim4.start();
                        }
                        if (farmAnim5 != null && !farmAnim5.isRunning()) {
                            farmAnim5.start();
                        }
                        if (farmAnim6 != null && !farmAnim6.isRunning()) {
                            farmAnim6.start();
                        }
                        if (farmAnim7 != null && !farmAnim7.isRunning()) {
                            farmAnim7.start();
                        }
                        if (farmAnim8 != null && !farmAnim8.isRunning()) {
                            farmAnim8.start();
                        }
                    }else{
                        if (farmAnim1 != null && farmAnim1.isRunning()) {
                            farmAnim1.stop();
                        }
                        if (farmAnim2 != null && farmAnim2.isRunning()) {
                            farmAnim2.stop();
                        }
                        if (farmAnim3 != null && farmAnim3.isRunning()) {
                            farmAnim3.stop();
                        }
                        if (farmAnim4 != null && farmAnim4.isRunning()) {
                            farmAnim4.stop();
                        }
                        if (farmAnim5 != null && farmAnim5.isRunning()) {
                            farmAnim5.stop();
                        }
                        if (farmAnim6 != null && farmAnim6.isRunning()) {
                            farmAnim6.stop();
                        }
                        if (farmAnim7 != null && farmAnim7.isRunning()) {
                            farmAnim7.stop();
                        }
                        if (farmAnim8 != null && farmAnim8.isRunning()) {
                            farmAnim8.stop();
                        }
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderFifth3.mtype_balls1.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(0)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls2.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(1)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls3.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(2)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls4.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(3)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls5.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(4)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls6.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(5)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls7.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(6)) - 1]));
                            lotteryViewHolderFifth3.mtype_balls8.setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(7)) - 1]));
                        }
                    }
                }
                if(!mBusy) {
                    setData3(position);
                }
                break;
            case TYPE_ITEM4:
                lotteryViewHolderOne = null;
                if(convertView == null){
                    lotteryViewHolderOne    =    new LotteryViewHolderOne();
                    itemview4               =    mInflater.inflate(R.layout.item_lottery_item1,parent,false);
                    setView4(itemview4);
                    itemview4.setTag(lotteryViewHolderOne);
                    convertView = itemview4;
                }else {
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
                            if((list.get(position).getLottery_id().equals("102"))){
                                setSpecilBall2(position);
                                lotteryViewHolderOne.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderOne.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderOne.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderOne.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderOne.type_balls5.setText(list.get(position).getBall(4));
                            }else{
                                lotteryViewHolderOne.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderOne.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderOne.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderOne.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderOne.type_balls5.setText(list.get(position).getBall(4));
                            }
                        }
                    }
                }
                if(!mBusy) {
                    setData4(position);
                }
                break;
            case TYPE_ITEM5:
                LotteryViewHolderOne5 = null;
                if(convertView == null){
                    LotteryViewHolderOne5    =    new LotteryViewHolderOne();
                    itemview5               =   mInflater.inflate(R.layout.item_lottery_item10,parent,false);
                    setView5(itemview5);
                    itemview5.setTag(LotteryViewHolderOne5);
                    convertView = itemview5;
                }else {
                    LotteryViewHolderOne5 	= 	(LotteryViewHolderOne)convertView.getTag();
                    if(list.get(position).isOpen()){
                        LotteryViewHolderOne5.type_balls1.startAutoScroll();
                        LotteryViewHolderOne5.type_balls2.startAutoScroll();
                        LotteryViewHolderOne5.type_balls3.startAutoScroll();
                        LotteryViewHolderOne5.type_balls4.startAutoScroll();
                    }else{
                        LotteryViewHolderOne5.type_balls1.stopAutoScroll();
                        LotteryViewHolderOne5.type_balls2.stopAutoScroll();
                        LotteryViewHolderOne5.type_balls3.stopAutoScroll();
                        LotteryViewHolderOne5.type_balls4.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            LotteryViewHolderOne5.type_balls1.setText(list.get(position).getBall(0));
                            LotteryViewHolderOne5.type_balls2.setText(list.get(position).getBall(1));
                            LotteryViewHolderOne5.type_balls3.setText(list.get(position).getBall(2));
                            LotteryViewHolderOne5.type_balls4.setText(list.get(position).getBall(3));
                        }
                    }
                }
                if(!mBusy) {
                    setData5(position);
                }
                break;
        }
        return convertView;
    }

    public void setView1(View view){
        lotteryViewHolderFifth1.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth1.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth1.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth1.mtype_balls1        = (ImageView)view.findViewById(R.id.type2_ball1);
        lotteryViewHolderFifth1.mtype_balls2        = (ImageView)view.findViewById(R.id.type2_ball2);
        lotteryViewHolderFifth1.mtype_balls3        = (ImageView)view.findViewById(R.id.type2_ball3);
        lotteryViewHolderFifth1.mtype_balls4        = (ImageView)view.findViewById(R.id.type2_ball4);
        lotteryViewHolderFifth1.mtype_balls5        = (ImageView)view.findViewById(R.id.type2_ball5);
        lotteryViewHolderFifth1.mtype_balls6        = (ImageView)view.findViewById(R.id.type2_ball6);
        lotteryViewHolderFifth1.mtype_balls7        = (ImageView)view.findViewById(R.id.type2_ball7);
        lotteryViewHolderFifth1.mtype_balls8        = (ImageView)view.findViewById(R.id.type2_ball8);
        lotteryViewHolderFifth1.mtype_balls9        = (ImageView)view.findViewById(R.id.type2_ball9);
        lotteryViewHolderFifth1.mtype_balls10       = (ImageView)view.findViewById(R.id.type2_ball10);
        lotteryViewHolderFifth1.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFifth1.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFifth1.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFifth1.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFifth1.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFifth1.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFifth1.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFifth1.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFifth1.mtype_balls1.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls2.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls3.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls4.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls5.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls6.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls7.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls8.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls9.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.mtype_balls10.setTag(lotteryViewHolderFifth1);
    }
    public void setView2(View view){
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
    public void setView3(View view) {
        lotteryViewHolderFifth3.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth3.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth3.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth3.mtype_balls1       = (ImageView)view.findViewById(R.id.type6_ball1);
        lotteryViewHolderFifth3.mtype_balls2       = (ImageView)view.findViewById(R.id.type6_ball2);
        lotteryViewHolderFifth3.mtype_balls3       = (ImageView)view.findViewById(R.id.type6_ball3);
        lotteryViewHolderFifth3.mtype_balls4       = (ImageView)view.findViewById(R.id.type6_ball4);
        lotteryViewHolderFifth3.mtype_balls5       = (ImageView)view.findViewById(R.id.type6_ball5);
        lotteryViewHolderFifth3.mtype_balls6       = (ImageView)view.findViewById(R.id.type6_ball6);
        lotteryViewHolderFifth3.mtype_balls7       = (ImageView)view.findViewById(R.id.type6_ball7);
        lotteryViewHolderFifth3.mtype_balls8       = (ImageView)view.findViewById(R.id.type6_ball8);
        lotteryViewHolderFifth3.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFifth3.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFifth3.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFifth3.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFifth3.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFifth3.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFifth3.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFifth3.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFifth3.mtype_balls1.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls2.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls3.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls4.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls5.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls6.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls7.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.mtype_balls8.setTag(lotteryViewHolderFifth3);
    }
    public void setView4(View view){
        lotteryViewHolderOne.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderOne.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderOne.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderOne.type_balls1        = (UpDownTextView) view.findViewById(R.id.type1_ball1);
        lotteryViewHolderOne.type_balls2        = (UpDownTextView) view.findViewById(R.id.type1_ball2);
        lotteryViewHolderOne.type_balls3        = (UpDownTextView) view.findViewById(R.id.type1_ball3);
        lotteryViewHolderOne.type_balls4        = (UpDownTextView) view.findViewById(R.id.type1_ball4);
        lotteryViewHolderOne.type_balls5        = (UpDownTextView) view.findViewById(R.id.type1_ball5);
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
    public void setView5(View view){
        LotteryViewHolderOne5.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        LotteryViewHolderOne5.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        LotteryViewHolderOne5.now_time           = (TextView)view.findViewById(R.id.now_time);
        LotteryViewHolderOne5.type_balls1        = (UpDownTextView) view.findViewById(R.id.type10_ball1);
        LotteryViewHolderOne5.type_balls2        = (UpDownTextView) view.findViewById(R.id.type10_ball2);
        LotteryViewHolderOne5.type_balls3        = (UpDownTextView) view.findViewById(R.id.type10_ball3);
        LotteryViewHolderOne5.type_balls4        = (UpDownTextView) view.findViewById(R.id.type10_ball4);
        LotteryViewHolderOne5.home_time          = (TextView)view.findViewById(R.id.home_time);
        LotteryViewHolderOne5.hour               = (TextView)view.findViewById(R.id.hour);
        LotteryViewHolderOne5.min                = (TextView)view.findViewById(R.id.min);
        LotteryViewHolderOne5.secd               = (TextView)view.findViewById(R.id.sec);
        LotteryViewHolderOne5.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        LotteryViewHolderOne5.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        LotteryViewHolderOne5.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        LotteryViewHolderOne5.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        LotteryViewHolderOne5.type_balls1.setTag(lotteryViewHolderTwo);
        LotteryViewHolderOne5.type_balls2.setTag(lotteryViewHolderTwo);
        LotteryViewHolderOne5.type_balls3.setTag(lotteryViewHolderTwo);
        LotteryViewHolderOne5.type_balls4.setTag(lotteryViewHolderTwo);
        LotteryViewHolderOne5.type_balls1.setGravity(Gravity.CENTER);
        LotteryViewHolderOne5.type_balls2.setGravity(Gravity.CENTER);
        LotteryViewHolderOne5.type_balls3.setGravity(Gravity.CENTER);
        LotteryViewHolderOne5.type_balls4.setGravity(Gravity.CENTER);
    }

    public void setData1(int i){
        lotteryViewHolderFifth1.lottery_history.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.lottery_current.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.lottery_rules.setTag(lotteryViewHolderFifth1);
        lotteryViewHolderFifth1.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth1.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth1.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });

        lotteryViewHolderFifth1.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderFifth1.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderFifth1.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderFifth1.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFifth1.hour.setText(list.get(i).getHour());
        lotteryViewHolderFifth1.min.setText(list.get(i).getMinute());
        lotteryViewHolderFifth1.secd.setText(list.get(i).getSecond());
    }
    public void setData2(int i){
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
    public void setData3(int i){
        lotteryViewHolderFifth3.lottery_history.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.lottery_current.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.lottery_rules.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth3.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth3.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth3.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderFifth3.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderFifth3.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderFifth3.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFifth3.hour.setText(list.get(i).getHour());
        lotteryViewHolderFifth3.min.setText(list.get(i).getMinute());
        lotteryViewHolderFifth3.secd.setText(list.get(i).getSecond());
    }
    public void setData4(int i){
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
    public void setData5(int i){
        LotteryViewHolderOne5.lottery_history.setTag(LotteryViewHolderOne5);
        LotteryViewHolderOne5.lottery_current.setTag(LotteryViewHolderOne5);
        LotteryViewHolderOne5.lottery_rules.setTag(LotteryViewHolderOne5);
        LotteryViewHolderOne5.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });
        LotteryViewHolderOne5.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });
        LotteryViewHolderOne5.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderOne holder = (LotteryViewHolderOne) v.getTag();
            }
        });
        LotteryViewHolderOne5.type_balls1.setTextList(strings);
        LotteryViewHolderOne5.type_balls2.setTextList(strings);
        LotteryViewHolderOne5.type_balls3.setTextList(strings);
        LotteryViewHolderOne5.type_balls4.setTextList(strings);
        LotteryViewHolderOne5.lottery_title.setText(list.get(i).getLottery_title());
        LotteryViewHolderOne5.lottery_issue.setText(list.get(i).getLottery_issue());
        LotteryViewHolderOne5.now_time.setText(list.get(i).getNow_time());
        LotteryViewHolderOne5.home_time.setText(list.get(i).getNext_time());
        LotteryViewHolderOne5.hour.setText(list.get(i).getHour());
        LotteryViewHolderOne5.min.setText(list.get(i).getMinute());
        LotteryViewHolderOne5.secd.setText(list.get(i).getSecond());
    }

    //设置广东快乐十分19,20码红球
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

    //设置广西快乐十分19,20码红球
    public void setSpecilBall2(int i){
        if(list.get(i).getSpecil(0)){
            lotteryViewHolderOne.type_balls1.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderOne.type_balls1.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(1)){
            lotteryViewHolderOne.type_balls2.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderOne.type_balls2.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(2)){
            lotteryViewHolderOne.type_balls3.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderOne.type_balls3.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(3)){
            lotteryViewHolderOne.type_balls4.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderOne.type_balls4.setBackgroundResource(R.drawable.type1_ball_1);
        }
        if(list.get(i).getSpecil(4)){
            lotteryViewHolderOne.type_balls5.setBackgroundResource(R.drawable.type1_ball_3);
        }else {
            lotteryViewHolderOne.type_balls5.setBackgroundResource(R.drawable.type1_ball_1);
        }
    }
}
