package com.example.dell.lotteryplan.home.message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/6/23.
 */

public class LotteryMessage {

    private String  lottery_id;
    private String  lottery_title;  //彩种标题
    private String  lottery_issue;  //已开奖时间
    private String  now_time;       //当前时间
    private List<String> ballls = new ArrayList<>();
    private String  next_time;      //下期开奖时间
    private String  hour;           //小时
    private String  minute;         //分钟
    private String  second;         //秒
    private boolean[] speball = new boolean[8];
    private String  item_type;
    private boolean isOpen = false;

    public LotteryMessage(String lottery_id, String lottery_title, String lottery_issue, String now_time, String next_time, String hour, String minute, String second){
        this.lottery_id     =   lottery_id;
        this.lottery_title  =   lottery_title;
        this.lottery_issue  =   lottery_issue;
        this.now_time       =   now_time;
        this.next_time      =   next_time;
        this.hour           =   hour;
        this.minute         =   minute;
        this.second         =   second;
    }

    public void setBall(String ball){
        this.ballls.add(ball);
    }

    public String getBall(int i){
        return this.ballls.get(i);
    }

    public void clearball(){
        this.ballls.clear();
    }

    public List<String> getBallls() {
        return ballls;
    }

    public void setBallls(List<String> ballls) {
        this.ballls = ballls;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public void setSpecil(boolean specil,int i){
        this.speball[i] = specil;
    }

    public boolean getSpecil(int i){
        return this.speball[i];
    }

    public boolean[] getSpeball() {
        return speball;
    }

    public void setSpeball(boolean[] speball) {
        this.speball = speball;
    }

    public String getLottery_id() {
        return lottery_id;
    }

    public void setLottery_id(String lottery_id) {
        this.lottery_id = lottery_id;
    }

    public String getLottery_title() {
        return lottery_title;
    }

    public void setLottery_title(String lottery_title) {
        this.lottery_title = lottery_title;
    }

    public String getLottery_issue() {
        return lottery_issue;
    }

    public void setLottery_issue(String lottery_issue) {
        this.lottery_issue = lottery_issue;
    }

    public String getNow_time() {
        return now_time;
    }

    public void setNow_time(String now_time) {
        this.now_time = now_time;
    }

    public String getNext_time() {
        return next_time;
    }

    public void setNext_time(String next_time) {
        this.next_time = next_time;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
