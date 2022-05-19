package com.donghu.servlet; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 18:29
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.Dao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收request参数
        String email = request.getParameter("email");
        String orderIdStr = request.getParameter("orderId");

        //转换类型
        int orderId = Integer.parseInt(orderIdStr);

        //调用dao中的方法查询对应订单的详细信息
        HashMap<String,Object> order = Dao.getById(orderId,email);

        Result result = new Result("success",order);
        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
