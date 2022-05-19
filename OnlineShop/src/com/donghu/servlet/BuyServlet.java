package com.donghu.servlet; /**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Data: 2022-05-19
 * Time: 14:01
 */

import com.alibaba.fastjson.JSON;
import com.donghu.dao.Dao;
import com.donghu.pojo.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //接收request传输的数据
        String goodsIdStr = request.getParameter("goodsId");
        String goodsNumStr = request.getParameter("goodsNum");
        String email = request.getParameter("email");

        //转换一下类型
        int goodsId = Integer.parseInt(goodsIdStr);
        int goodsNum = Integer.parseInt(goodsNumStr);

        //调用dao中的方法
        int res = Dao.buy(goodsId,goodsNum,email);

        Result result = new Result();
        if(res > 0){
            result.setFlag("success");
        }else{
            result.setFlag("fail");
        }
        response.getWriter().append(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
