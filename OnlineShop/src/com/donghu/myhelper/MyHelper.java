package com.donghu.myhelper;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 10:03
 */
public class MyHelper {
    private static DataSource dataSource = null;
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;

    static {
        //设置数据源
        dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/shop?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");
    }

    /**
     * 释放掉资源
     */
    private static void closeAll() throws SQLException {
        if(resultSet != null){
            resultSet.close();
        }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }

    /**
     * 查
     * @param sql    传入的sql语句
     * @param param  需要动态注入的sql数据
     * @return       返回所查询的结果
     */
    public static ArrayList<HashMap<String,Object>> executeQuery(String sql, Object[] param){
        ArrayList<HashMap<String,Object>> list = new ArrayList<>();
        try{
            //与数据库进行连接
            connection = dataSource.getConnection();
            //创建sql语句对象
            statement = connection.prepareStatement(sql);
            //处理指定id查询时的情况
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    statement.setObject(i+1,param[i]);
                }
            }
            //执行sql语句,拿到一个结果集
            resultSet = statement.executeQuery();

            //拿到列的数量
            ResultSetMetaData metaData = resultSet.getMetaData();
            int countCol = metaData.getColumnCount();

            //将结果集的内容存放到list中
            while(resultSet.next()){
                //每一行的数据就可以使用HashMap<String,Object>来存放
                HashMap<String,Object> map = new HashMap<>();
                //遍历每一列
                for(int i = 0; i < countCol; i++){
                    //获取列名
                    String columnName = metaData.getColumnName(i + 1);
//                    metaData.getColumnLabel(i+1);     //拿别名
                    //获取当前列在当前行对应的值
                    Object object = resultSet.getObject(i + 1);
                    //放到map中
                    map.put(columnName,object);
                }
                //将存放每一行数据的 map 存放到 ArrayList 中
                list.add(map);
            }

            //释放掉资源
            closeAll();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 增删改
     * @param sql     SQL语句
     * @param param   替换占位符的数据
     * @return        被影响的行数
     */
    public static int executeUpdate(String sql,Object[] param){
        int result = 0;
        try{
            //连接数据库
            connection = dataSource.getConnection();
            //创建SQL语句对象
            statement = connection.prepareStatement(sql);
            //处理需要动态注入sql语句时的情况
            if(param != null){
                for(int i = 0; i < param.length; i++){
                    statement.setObject(i+1,param[i]);
                }
            }
            //打印一下填充后的SQL语句，方便查错
            System.out.println(statement);

            //执行SQL
            result = statement.executeUpdate();
            //释放资源
            closeAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        //返回被影响的行数
        return result;
    }
}
