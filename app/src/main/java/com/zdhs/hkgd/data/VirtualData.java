package com.zdhs.hkgd.data;


import com.zdhs.hkgd.R;

public class VirtualData {
    //首页-今日工单
    public static int[] sheet_icon = new int[]{
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher};
    public static String[] sheet_title = new String[]{"待接单","待预约","待维修"};
    public static int [] sheet_num = new int[]{3,2,3};

    //首页-今日工单
    public static String[] news_title = new String[]{"通知","通知","通知"};
    public static String[] news_time = new String[]{"5分钟前","11分钟前","1小时前"};
    public static String[] news_summary = new String[]{"您有新的工单待处理","您有一个订单编号为1234的订单已经完成审核，请注意查收。您有一个订单编号为1234的订单已经完成审核，请注意查收。","您有一个名叫“胡歌”的男朋友已经到了，请注意查收。"};

    //工单-工单
    public static String[] sheet_detail_id = new String[]{"123456789","987654321","147258369"};
    public static String[] sheet_detail_State = new String[]{"待接单","待预约","待维修"};
    public static String[] sheet_detail_shopName = new String[]{"测试一号店","测试二号店","测试三号店"};
    public static String[] sheet_detail_equipmentName = new String[]{"空调1","空调2","空调3"};
    public static int[] priority = new int[]{1,2,3};
    public static String[] sheet_detail_workerName = new String[]{"王江涛","王波涛","王洪涛"};
    public static String[] sheet_detail_workerTel = new String[]{"15093249729","15093249729","15093249729"};
    public static String[] sheet_detail_date = new String[]{"2019/4/27 09:12","2019/4/28 14:23","2019/4/29 11:12"};
}
