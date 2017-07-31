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
import com.example.dell.lotteryplan.home.viewholder.LotteryViewHolderThree;

import java.util.List;

/**
 * Created by dell on 2017/6/28.
 */

public class HightfrequencyAdpater extends BaseAdapter {

    public static final int         TYPE_COUNT = 6;
    public static final int         TYPE_ITEM1 = 1;
    public static final int         TYPE_ITEM2 = 2;
    public static final int         TYPE_ITEM3 = 3;
    public static final int         TYPE_ITEM4 = 4;
    public static final int         TYPE_ITEM5 = 5;
    private Context                 context;
    private List<LotteryMessage>    list;
    private LotteryViewHolderThree  lotteryViewHolderThree;
    private LotteryViewHolderFifth  lotteryViewHolderFifth1,lotteryViewHolderFifth2,lotteryViewHolderFifth3,lotteryViewHolderFifth4;
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

    public HightfrequencyAdpater(Context context,List<LotteryMessage> list){
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
                lotteryViewHolderThree = null;
                if(convertView == null){
                    lotteryViewHolderThree  =   new LotteryViewHolderThree();
                    itemview1               =   mInflater.inflate(R.layout.item_lottery_item3,parent,false);
                    setView1(itemview1);
                    itemview1.setTag(lotteryViewHolderThree);
                    convertView = itemview1;
                }else{
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
                        lotteryViewHolderThree.type_balls21.startAutoScroll();
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
                        lotteryViewHolderThree.type_balls21.stopAutoScroll();
                        if (list.get(position).getBallls().size() != 0) {
                            lotteryViewHolderThree.type_balls1.setText(list.get(position).getBall(0));
                            lotteryViewHolderThree.type_balls2.setText(list.get(position).getBall(1));
                            lotteryViewHolderThree.type_balls3.setText(list.get(position).getBall(2));
                            lotteryViewHolderThree.type_balls4.setText(list.get(position).getBall(3));
                            lotteryViewHolderThree.type_balls5.setText(list.get(position).getBall(4));
                            lotteryViewHolderThree.type_balls6.setText(list.get(position).getBall(5));
                            lotteryViewHolderThree.type_balls7.setText(list.get(position).getBall(6));
                            lotteryViewHolderThree.type_balls8.setText(list.get(position).getBall(7));
                            lotteryViewHolderThree.type_balls9.setText(list.get(position).getBall(8));
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
                            lotteryViewHolderThree.type_balls21.setText(list.get(position).getBall(20));
                        }
                    }
                }
                if(!mBusy) {
                    setData1(position);
                }
                break;
            case TYPE_ITEM2:
                lotteryViewHolderFifth1 =null;
                if(convertView == null){
                    lotteryViewHolderFifth1     =    new LotteryViewHolderFifth();
                    itemview2                   =   mInflater.inflate(R.layout.item_lottery_item6,parent,false);
                    setView2(itemview2);
                    itemview2.setTag(lotteryViewHolderFifth1);
                    convertView = itemview2;
                }else{
                    lotteryViewHolderFifth1 	= 	(LotteryViewHolderFifth) convertView.getTag();
                    if(list.get(position).isOpen()) {
                        farmAnim1=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim1);
                        farmAnim2=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim2);
                        farmAnim3=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim3);
                        farmAnim4=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim4);
                        farmAnim5=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim1);
                        farmAnim6=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim2);
                        farmAnim7=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim3);
                        farmAnim8=(AnimationDrawable) context.getResources().getDrawable(R.drawable.farm_anim4);
                        lotteryViewHolderFifth1.mtype_balls1.setBackgroundDrawable(farmAnim1);
                        lotteryViewHolderFifth1.mtype_balls2.setBackgroundDrawable(farmAnim2);
                        lotteryViewHolderFifth1.mtype_balls3.setBackgroundDrawable(farmAnim3);
                        lotteryViewHolderFifth1.mtype_balls4.setBackgroundDrawable(farmAnim4);
                        lotteryViewHolderFifth1.mtype_balls5.setBackgroundDrawable(farmAnim5);
                        lotteryViewHolderFifth1.mtype_balls6.setBackgroundDrawable(farmAnim6);
                        lotteryViewHolderFifth1.mtype_balls7.setBackgroundDrawable(farmAnim7);
                        lotteryViewHolderFifth1.mtype_balls8.setBackgroundDrawable(farmAnim8);
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
                            lotteryViewHolderFifth1.mtype_balls1 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(0)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls2 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(1)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls3 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(2)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls4 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(3)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls5 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(4)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls6 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(5)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls7 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(6)) - 1]));
                            lotteryViewHolderFifth1.mtype_balls8 .setBackground(ContextCompat.getDrawable(context, farm[Integer.parseInt(list.get(position).getBall(7)) - 1]));
                        }
                    }
                }
                if(!mBusy) {
                    setData2(position);
                }
                break;
            case TYPE_ITEM3:
                lotteryViewHolderFifth2 = null;
                if(convertView == null){
                    lotteryViewHolderFifth2     =   new LotteryViewHolderFifth();
                    itemview3                   =   mInflater.inflate(R.layout.item_lottery_item2,parent,false);
                    setView3(itemview3);
                    itemview3.setTag(lotteryViewHolderFifth2);
                    convertView = itemview3;
                }else {
                    lotteryViewHolderFifth2 	= 	(LotteryViewHolderFifth) convertView.getTag();
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
                        lotteryViewHolderFifth2.mtype_balls1.setBackgroundDrawable(frameAnim1);
                        lotteryViewHolderFifth2.mtype_balls2.setBackgroundDrawable(frameAnim2);
                        lotteryViewHolderFifth2.mtype_balls3.setBackgroundDrawable(frameAnim3);
                        lotteryViewHolderFifth2.mtype_balls4.setBackgroundDrawable(frameAnim4);
                        lotteryViewHolderFifth2.mtype_balls5.setBackgroundDrawable(frameAnim5);
                        lotteryViewHolderFifth2.mtype_balls6.setBackgroundDrawable(frameAnim6);
                        lotteryViewHolderFifth2.mtype_balls7.setBackgroundDrawable(frameAnim7);
                        lotteryViewHolderFifth2.mtype_balls8.setBackgroundDrawable(frameAnim8);
                        lotteryViewHolderFifth2.mtype_balls9.setBackgroundDrawable(frameAnim9);
                        lotteryViewHolderFifth2.mtype_balls10.setBackgroundDrawable(frameAnim10);
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
                            lotteryViewHolderFifth2.mtype_balls1 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(0)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls2 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(1)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls3 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(2)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls4 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(3)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls5 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(4)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls6 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(5)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls7 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(6)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls8 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(7)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls9 .setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(8)) - 1]));
                            lotteryViewHolderFifth2.mtype_balls10.setBackground(ContextCompat.getDrawable(context, nums[Integer.parseInt(list.get(position).getBall(9)) - 1]));
                        }
                    }
                }
                if(!mBusy) {
                    setData3(position);
                }
                break;
            case TYPE_ITEM4:
                lotteryViewHolderFifth3 = null;
                if(convertView == null){
                    lotteryViewHolderFifth3    =    new LotteryViewHolderFifth();
                    itemview4               =   mInflater.inflate(R.layout.item_lottery_item5,parent,false);
                    setView4(itemview4);
                    itemview4.setTag(lotteryViewHolderFifth3);
                    convertView = itemview4;
                }else {
                    lotteryViewHolderFifth3 	= 	(LotteryViewHolderFifth) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderFifth3.type_balls1.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls2.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls3.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls4.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls5.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls6.startAutoScroll();
                        lotteryViewHolderFifth3.type_balls7.startAutoScroll();
                    }else{
                        lotteryViewHolderFifth3.type_balls1.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls2.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls3.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls4.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls5.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls6.stopAutoScroll();
                        lotteryViewHolderFifth3.type_balls7.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0){
                            lotteryViewHolderFifth3.type_balls1.setText(list.get(position).getBall(0));
                            lotteryViewHolderFifth3.type_balls2.setText(list.get(position).getBall(1));
                            lotteryViewHolderFifth3.type_balls3.setText(list.get(position).getBall(2));
                            lotteryViewHolderFifth3.type_balls4.setText(list.get(position).getBall(3));
                            lotteryViewHolderFifth3.type_balls5.setText(list.get(position).getBall(4));
                            lotteryViewHolderFifth3.type_balls6.setText(list.get(position).getBall(5));
                            lotteryViewHolderFifth3.type_balls7.setText(list.get(position).getBall(6));
                        }
                    }
                }
                if(!mBusy) {
                    setData4(position);
                }
                break;
            case TYPE_ITEM5:
                lotteryViewHolderFifth4 = null;
                if(convertView == null){
                    lotteryViewHolderFifth4    =    new LotteryViewHolderFifth();
                    itemview5                  =   mInflater.inflate(R.layout.item_lottery_item1,parent,false);
                    setView5(itemview5);
                    itemview5.setTag(lotteryViewHolderFifth4);
                    convertView = itemview5;
                }else {
                    lotteryViewHolderFifth4 	= 	(LotteryViewHolderFifth) convertView.getTag();
                    if(list.get(position).isOpen()){
                        lotteryViewHolderFifth4.type_balls1.startAutoScroll();
                        lotteryViewHolderFifth4.type_balls2.startAutoScroll();
                        lotteryViewHolderFifth4.type_balls3.startAutoScroll();
                        lotteryViewHolderFifth4.type_balls4.startAutoScroll();
                        lotteryViewHolderFifth4.type_balls5.startAutoScroll();
                    }else{
                        lotteryViewHolderFifth4.type_balls1.stopAutoScroll();
                        lotteryViewHolderFifth4.type_balls2.stopAutoScroll();
                        lotteryViewHolderFifth4.type_balls3.stopAutoScroll();
                        lotteryViewHolderFifth4.type_balls4.stopAutoScroll();
                        lotteryViewHolderFifth4.type_balls5.stopAutoScroll();
                        if(list.get(position).getBallls().size()!=0) {
                            if (list.get(position).getLottery_id().equals("14") || list.get(position).getLottery_id().equals("117") || list.get(position).getLottery_id().equals("133")) {
                                lotteryViewHolderFifth4.type_balls4.setVisibility(View.GONE);
                                lotteryViewHolderFifth4.type_balls5.setVisibility(View.GONE);
                                lotteryViewHolderFifth4.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderFifth4.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderFifth4.type_balls3.setText(list.get(position).getBall(2));
                            } else if (list.get(position).getLottery_id().equals("118")) {
                                lotteryViewHolderFifth4.type_balls5.setVisibility(View.GONE);
                                lotteryViewHolderFifth4.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderFifth4.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderFifth4.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderFifth4.type_balls4.setText(list.get(position).getBall(3));
                            } else if (list.get(position).getLottery_id().equals("108") || list.get(position).getLottery_id().equals("109") || list.get(position).getLottery_id().equals("110")) {
                                lotteryViewHolderFifth4.type_balls4.setVisibility(View.VISIBLE);
                                lotteryViewHolderFifth4.type_balls5.setVisibility(View.VISIBLE);
                                lotteryViewHolderFifth4.type_balls1.setText(list.get(position).getBall(0));
                                lotteryViewHolderFifth4.type_balls2.setText(list.get(position).getBall(1));
                                lotteryViewHolderFifth4.type_balls3.setText(list.get(position).getBall(2));
                                lotteryViewHolderFifth4.type_balls4.setText(list.get(position).getBall(3));
                                lotteryViewHolderFifth4.type_balls5.setText(list.get(position).getBall(4));
                            }
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
        lotteryViewHolderThree.type_balls21.setVisibility(View.VISIBLE);
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
    }
    public void setView2(View view){
        lotteryViewHolderFifth1.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth1.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth1.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth1.mtype_balls1       = (ImageView)view.findViewById(R.id.type6_ball1);
        lotteryViewHolderFifth1.mtype_balls2       = (ImageView)view.findViewById(R.id.type6_ball2);
        lotteryViewHolderFifth1.mtype_balls3       = (ImageView)view.findViewById(R.id.type6_ball3);
        lotteryViewHolderFifth1.mtype_balls4       = (ImageView)view.findViewById(R.id.type6_ball4);
        lotteryViewHolderFifth1.mtype_balls5       = (ImageView)view.findViewById(R.id.type6_ball5);
        lotteryViewHolderFifth1.mtype_balls6       = (ImageView)view.findViewById(R.id.type6_ball6);
        lotteryViewHolderFifth1.mtype_balls7       = (ImageView)view.findViewById(R.id.type6_ball7);
        lotteryViewHolderFifth1.mtype_balls8       = (ImageView)view.findViewById(R.id.type6_ball8);
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
    }
    public void setView3(View view){
        lotteryViewHolderFifth2.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth2.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth2.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth2.mtype_balls1       = (ImageView)view.findViewById(R.id.type2_ball1);
        lotteryViewHolderFifth2.mtype_balls2       = (ImageView)view.findViewById(R.id.type2_ball2);
        lotteryViewHolderFifth2.mtype_balls3       = (ImageView)view.findViewById(R.id.type2_ball3);
        lotteryViewHolderFifth2.mtype_balls4       = (ImageView)view.findViewById(R.id.type2_ball4);
        lotteryViewHolderFifth2.mtype_balls5       = (ImageView)view.findViewById(R.id.type2_ball5);
        lotteryViewHolderFifth2.mtype_balls6       = (ImageView)view.findViewById(R.id.type2_ball6);
        lotteryViewHolderFifth2.mtype_balls7       = (ImageView)view.findViewById(R.id.type2_ball7);
        lotteryViewHolderFifth2.mtype_balls8       = (ImageView)view.findViewById(R.id.type2_ball8);
        lotteryViewHolderFifth2.mtype_balls9       = (ImageView)view.findViewById(R.id.type2_ball9);
        lotteryViewHolderFifth2.mtype_balls10      = (ImageView)view.findViewById(R.id.type2_ball10);
        lotteryViewHolderFifth2.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFifth2.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFifth2.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFifth2.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFifth2.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFifth2.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFifth2.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFifth2.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFifth2.mtype_balls1.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls2.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls3.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls4.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls5.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls6.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls7.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls8.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls9.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.mtype_balls10.setTag(lotteryViewHolderFifth2);

    }
    public void setView4(View view){
        lotteryViewHolderFifth3.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth3.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth3.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth3.type_balls1        = (UpDownTextView) view.findViewById(R.id.type5_ball1);
        lotteryViewHolderFifth3.type_balls2        = (UpDownTextView) view.findViewById(R.id.type5_ball2);
        lotteryViewHolderFifth3.type_balls3        = (UpDownTextView) view.findViewById(R.id.type5_ball3);
        lotteryViewHolderFifth3.type_balls4        = (UpDownTextView) view.findViewById(R.id.type5_ball4);
        lotteryViewHolderFifth3.type_balls5        = (UpDownTextView) view.findViewById(R.id.type5_ball5);
        lotteryViewHolderFifth3.type_balls6        = (UpDownTextView) view.findViewById(R.id.type5_ball6);
        lotteryViewHolderFifth3.type_balls7        = (UpDownTextView) view.findViewById(R.id.type5_ball7);
        lotteryViewHolderFifth3.type_balls8        = (UpDownTextView) view.findViewById(R.id.type5_ball8);
        lotteryViewHolderFifth3.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFifth3.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFifth3.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFifth3.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFifth3.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFifth3.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFifth3.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFifth3.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFifth3.type_balls8.setVisibility(View.GONE);
        lotteryViewHolderFifth3.type_balls1.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls2.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls3.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls4.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls5.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls6.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls7.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls8.setTag(lotteryViewHolderFifth3);
        lotteryViewHolderFifth3.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls6.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls7.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth3.type_balls8.setGravity(Gravity.CENTER);
    }
    public void setView5(View view){
        lotteryViewHolderFifth4.lottery_title      = (TextView)view.findViewById(R.id.lottery_title);
        lotteryViewHolderFifth4.lottery_issue      = (TextView)view.findViewById(R.id.lottery_issue);
        lotteryViewHolderFifth4.now_time           = (TextView)view.findViewById(R.id.now_time);
        lotteryViewHolderFifth4.type_balls1        = (UpDownTextView)view.findViewById(R.id.type1_ball1);
        lotteryViewHolderFifth4.type_balls2        = (UpDownTextView)view.findViewById(R.id.type1_ball2);
        lotteryViewHolderFifth4.type_balls3        = (UpDownTextView)view.findViewById(R.id.type1_ball3);
        lotteryViewHolderFifth4.type_balls4        = (UpDownTextView)view.findViewById(R.id.type1_ball4);
        lotteryViewHolderFifth4.type_balls5        = (UpDownTextView)view.findViewById(R.id.type1_ball5);
        lotteryViewHolderFifth4.home_time          = (TextView)view.findViewById(R.id.home_time);
        lotteryViewHolderFifth4.hour               = (TextView)view.findViewById(R.id.hour);
        lotteryViewHolderFifth4.min                = (TextView)view.findViewById(R.id.min);
        lotteryViewHolderFifth4.secd               = (TextView)view.findViewById(R.id.sec);
        lotteryViewHolderFifth4.lottery_history    = (TextView)view.findViewById(R.id.lottery_history);
        lotteryViewHolderFifth4.lottery_current    = (TextView)view.findViewById(R.id.lottery_current);
        lotteryViewHolderFifth4.lottery_rules      = (TextView)view.findViewById(R.id.lottery_rules);
        lotteryViewHolderFifth4.icon_lottery       = (ImageView)view.findViewById(R.id.icon_lottery);
        lotteryViewHolderFifth4.type_balls1.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.type_balls2.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.type_balls3.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.type_balls4.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.type_balls5.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.type_balls1.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth4.type_balls2.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth4.type_balls3.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth4.type_balls4.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth4.type_balls5.setGravity(Gravity.CENTER);
        lotteryViewHolderFifth4.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lotteryViewHolderFifth4.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lotteryViewHolderFifth4.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
    public void setData3(int i){
        lotteryViewHolderFifth2.lottery_history.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.lottery_current.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.lottery_rules.setTag(lotteryViewHolderFifth2);
        lotteryViewHolderFifth2.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth2.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth2.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth2.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderFifth2.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderFifth2.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderFifth2.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFifth2.hour.setText(list.get(i).getHour());
        lotteryViewHolderFifth2.min.setText(list.get(i).getMinute());
        lotteryViewHolderFifth2.secd.setText(list.get(i).getSecond());
    }
    public void setData4(int i){
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
        lotteryViewHolderFifth3.type_balls1.setTextList(strings);
        lotteryViewHolderFifth3.type_balls2.setTextList(strings);
        lotteryViewHolderFifth3.type_balls3.setTextList(strings);
        lotteryViewHolderFifth3.type_balls4.setTextList(strings);
        lotteryViewHolderFifth3.type_balls5.setTextList(strings);
        lotteryViewHolderFifth3.type_balls6.setTextList(strings);
        lotteryViewHolderFifth3.type_balls7.setTextList(strings);
        lotteryViewHolderFifth3.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFifth3.hour.setText(list.get(i).getHour());
        lotteryViewHolderFifth3.min.setText(list.get(i).getMinute());
        lotteryViewHolderFifth3.secd.setText(list.get(i).getSecond());
    }
    public void setData5(int i){
        lotteryViewHolderFifth4.lottery_history.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.lottery_current.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.lottery_rules.setTag(lotteryViewHolderFifth4);
        lotteryViewHolderFifth4.lottery_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth4.lottery_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth4.lottery_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryViewHolderFifth holder = (LotteryViewHolderFifth) v.getTag();
            }
        });
        lotteryViewHolderFifth4.type_balls1.setTextList(strings);
        lotteryViewHolderFifth4.type_balls2.setTextList(strings);
        lotteryViewHolderFifth4.type_balls3.setTextList(strings);
        lotteryViewHolderFifth4.type_balls4.setTextList(strings);
        lotteryViewHolderFifth4.type_balls5.setTextList(strings);
        lotteryViewHolderFifth4.lottery_title.setText(list.get(i).getLottery_title());
        lotteryViewHolderFifth4.lottery_issue.setText(list.get(i).getLottery_issue());
        lotteryViewHolderFifth4.now_time.setText(list.get(i).getNow_time());
        lotteryViewHolderFifth4.home_time.setText(list.get(i).getNext_time());
        lotteryViewHolderFifth4.hour.setText(list.get(i).getHour());
        lotteryViewHolderFifth4.min.setText(list.get(i).getMinute());
        lotteryViewHolderFifth4.secd.setText(list.get(i).getSecond());
    }


}
