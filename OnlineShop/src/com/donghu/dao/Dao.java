package com.donghu.dao;

import com.donghu.myhelper.MyHelper;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 9:57
 */
public class Dao {

    //检查当前注册的email是否出现在数据库中
    private static boolean checkEmail(String email){
        String sql = "select * from user where email = ?";
        ArrayList<HashMap<String,Object>> list = MyHelper.executeQuery(sql,new Object[]{email});
        //存在的话就不能插入，返回false
        if(list.size() == 1){ return false; }
        //数据库中没有的话就返回true
        else{ return true; } }

    /**
     * 用户添加
     */
    private static int insertUser(String email,String name,String password){
        String sql = "insert into user values(null,?,?,?)";
        return MyHelper.executeUpdate(sql,new Object[]{name,email,password});
    }



     //用户注册模块
    public static int signUp(String email,String name,String password){
        //首先检查email是否存在
        boolean flg = checkEmail(email);
        //表示不存在，将数据添加到数据库中
        if(flg){ return insertUser(email, name, password);}
        //表示存在，直接返回false
        else{ return 0; } }

    //用户登录
    public static int login(String email, String password){
        String sql = "select * from user where email = ?";    //先通过email查找
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql, new Object[]{email});
        if(list.size() == 0){ return -1; }//然后匹对password
        if(list.get(0).get("password").equals(password)){ return 1;}
        else{ return 0; } }

    //商品列表查询
    public static ArrayList<HashMap<String, Object>> goodsList(){
        String sql = "select * from goods";
        return MyHelper.executeQuery(sql,null);
    }

    /**
     * 商品购买
     */
    public static int buy(int goodsId, int goodsNum, String email) {
        //先通过goodsId拿到对应商品的信息
        String sql = "select * from goods where id = ?";
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql,new Object[]{goodsId});
        float price = (float)(list.get(0).get("price"));
        //计算当前商品的总价格
        price *= goodsNum;
        //进行下四舍五入
        float scale = price;
        DecimalFormat fnum = new DecimalFormat("##0.00");
        String priceStr = fnum.format(scale);

        //将这个订单插入到数据库中
        String sql2 = "insert into order_info values(null,?,?,?,?,?,?,?,?)";
        Object imgUrl = list.get(0).get("imgUrl");
        Object name = list.get(0).get("name");
        Object buy_time = new Date();
        Object pay_time = new Date();
        Object status = 0;     //状态：0 未付款  1 已支付
        //将数据插入数据库
        return MyHelper.executeUpdate(sql2, new Object[]{imgUrl, name, goodsNum, priceStr, buy_time, pay_time, status, email});
    }

    /**
     * 获取订单表单
     */
    public static ArrayList<HashMap<String, Object>> orderList() {
        String sql = "select * from order_info";
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql, null);
        //处理其中时间 秒后面还有数字的情况
        for (int i = 0; i < list.size(); i++) {
            handle(list.get(i));
        }
        return list;
    }

    /**
     * 付款操作
     */
    public static int pay(int id) {
        String sql = "update order_info set status = ?,payTime = ? where id = ?";
        return MyHelper.executeUpdate(sql,new Object[]{1,new Date(),id});
    }

    /**
     * 通过id查找对应订单的详细信息
     */
    public static HashMap<String, Object> getById(int orderId, String email) {
        String sql = "select * from order_info where id = ?";
        ArrayList<HashMap<String, Object>> list = MyHelper.executeQuery(sql, new Object[]{orderId});
        handle(list.get(0));
        return list.get(0);
    }


    /**
     * 对时间进行处理，去掉秒后面的值
     */
    private static SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void handle(HashMap<String,Object> map){
        //先将Object对象拿到的时间变成字符串
        String buyTime = map.get("buyTime")+"";
        String payTime = map.get("payTime")+"";
        try {
            //将字符串转换为Date类型的时间
            Date parse1 = spf.parse(buyTime);
            Date parse2 = spf.parse(payTime);
            //再将Date类型的时间按 yyyy-MM-dd HH:mm:ss 的格式转换为字符串覆盖掉原先的值
            map.put("buyTime",spf.format(parse1));
            map.put("payTime",spf.format(parse2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
