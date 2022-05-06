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
 * Data: 2022-05-05
 * Time: 14:48
 */
public class MyHelper {

    private static DataSource dataSource = null;
    private static Connection connection = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    static{
        //设置数据源
        dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/student_manage?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1234");
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
            //填充占位符
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

    /**
     * 查
     * @param sql    SQL语句
     * @param param  替换占位符的数据
     * @return       结果集
     */
    public static ArrayList<HashMap<String,Object>> executeQuery(String sql, Object[] param){
        ArrayList<HashMap<String,Object>> list = null;
        try {
            //与数据库建立连接
            connection = dataSource.getConnection();
            //创建语句对象
            statement = connection.prepareStatement(sql);
            //先处理sql语句中是否有占位符？的情况
            if(param != null){
                for(int i = 0; i < param.length; i++){
                    statement.setObject(i+1,param[i]);
                }
            }

            //打印一下处理完毕的sql语句，方便查错。
            System.out.println(statement);

            //执行sql语句,得到结果集
            resultSet = statement.executeQuery();

            //拿到列的数量
            ResultSetMetaData metaData = resultSet.getMetaData();
            int countCol = metaData.getColumnCount();

            //遍历结果集，使用顺序表来存放
            list = new ArrayList<>();
            while(resultSet.next()){       //遍历每一行
                //每一行的数据就可以使用HashMap<String,Object>来存放
                HashMap<String,Object> map = new HashMap<>();
                //遍历每一列
                for(int i = 0; i < countCol; i++){
                    //获取列名
                    String columnName = metaData.getColumnName(i + 1);
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 释放掉资源
     * @throws SQLException
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
}
