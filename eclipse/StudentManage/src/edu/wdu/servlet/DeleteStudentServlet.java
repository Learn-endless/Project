package edu.wdu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import edu.wdu.dao.StudentDao;
import edu.wdu.pojo.Result;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取参数
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		//2.删除学生数据
		int deleteResult = StudentDao.deleteStudent(id);
		Result result = new Result();
		if(deleteResult > 0) {
			result.setFlag("success");
		}else {
			result.setFlag("fail");
		}
		response.getWriter().append(JSON.toJSONString(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
