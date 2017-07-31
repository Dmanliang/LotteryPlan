package com.example.dell.lotteryplan.base;

/**
 * Created by dell on 2017/5/24.
 */

public class Constants {
    public static final String  API  = "http://120.77.242.46:9550"; 	                        //服务器地址
    public static final String  API1 = "http://www.168cpt.com/";                                //服务器地址
    public static final String  UPADTE="update_version?os=1";                                   //版本更新
    public static final String  BANNER="get_mobile_banner?number=2";                            //轮播图
    public static final String  ALERT ="get_alert";                                             //公告
    public static final String  HELP  ="get_lottery_help?lottery_id=";                          //获取帮助中心规则
    public static final String  LAST_RESULT="/lottery/get_lottery_last_result?lottery_ids=";    //获取彩种开奖结果
    public static final String  CURRENT_ISSUE="/lottery/get_lottery_current_issue?lottery_ids=";//获取彩种当前信息
    public static final String  SERVER_TIME="/lottery/get_server_time";                         //获取服务器时间
    public static final String  LOTTERY_TYPE="http://www.168cpt.com/mobile_classify?type=";     //彩种类型

}
