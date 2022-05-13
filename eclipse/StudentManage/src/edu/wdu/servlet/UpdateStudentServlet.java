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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取参数
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String subjectIdStr = request.getParameter("subjectId");
		int id = Integer.parseInt(idStr);
		int subjectId = Integer.parseInt(subjectIdStr);
		//2.修改学生
		int updateResult = StudentDao.updateStudent(id, name, gender, subjectId);
		Result result = new Result();
		if(updateResult > 0) {
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
