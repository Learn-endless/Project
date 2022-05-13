package edu.wdu.servlet;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import edu.wdu.dao.SubjectDao;
import edu.wdu.pojo.Result;

@WebServlet("/getSubjectInfo")
public class GetSubjectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSubjectInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		HashMap<String, Object> student = SubjectDao.getById(id);
		Result result = new Result("success",student);
		response.getWriter().append(JSON.toJSONString(result));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
