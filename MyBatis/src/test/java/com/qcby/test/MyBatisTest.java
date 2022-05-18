package com.qcby.test;

import com.qcby.dao.UserDao;
import com.qcby.enty.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-18
 * Time: 10:28
 */
public class MyBatisTest {
    private InputStream in = null;
    private SqlSession session = null;
    private UserDao mapper = null;
    //使用日期格式
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before  //前置通知, 在方法执行之前执行
    public void init() throws IOException {
        //加载主配置文件，目的是为了构建SqlSessionFactory对象
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //通过SqlSessionFactory工厂对象创建SqlSesssion对象
        session = factory.openSession();
        //通过Session创建UserDao接口代理对象
        mapper = session.getMapper(UserDao.class);
    }

    @After  //@After: 后置通知, 在方法执行之后执行 。
    public void destory() throws IOException {
        //这里需要进行提交事务，不然就会回滚回去
        session.commit();
        //释放资源
        session.close();
        in.close();
    }

    /**
     * 测试通过id查询数据
     */
    @Test
    public void find(){
        //通过id查询用户信息
        User user = mapper.find(1);
        System.out.println(user);
    }

    /**
     * 测试查询全部数据
     */
    @Test
    public void findAll(){
        //获取下数据库的所有内容
        List<User> users = mapper.findAll();
        for(User user:users){
            System.out.println(user.toString());
        }
    }

    /**
     * 测试插入新的数据
     */
    @Test
    public void add() throws ParseException {
        User user = new User(3,"王五",sdf.parse("1350-06-05 22:56:55"),"男","武汉东湖学院");
        mapper.add(user);
        //重新获取下数据库的内容，查看是否添加成功
        List<User> result = mapper.findAll();
        for (User n:result) {
            System.out.println(n);
        }
    }

    /**
     * 测试通过id删除数据
     */
    @Test
    public void del(){
        //删除id为2的数据
        mapper.del(3);
        //重新获取下数据库的内容，查看是否删除成功
        List<User> result = mapper.findAll();
        for (User n:result) {
            System.out.println(n);
        }
    }

    /**
     * 测试通过id修改数据
     */
    @Test
    public void update() throws ParseException {
        //需要修改数据的id
        Integer id = 1;
        //修改后的信息
        String username = "成吉思汗";
        Date birthday = sdf.parse("2015-11-20 12:30:12");
        String sex = "男";
        String address = "武汉市";
        //将整个封装成一个User对象
        User user = new User(id,username,birthday,sex,address);
        //进行修改
        mapper.update(user);
        //重新获取下数据库的内容，查看是否删除成功
        List<User> result = mapper.findAll();
        for (User n:result) {
            System.out.println(n);
        }
    }
}
