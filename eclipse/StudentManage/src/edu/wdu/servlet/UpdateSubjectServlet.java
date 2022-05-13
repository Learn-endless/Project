package edu.wdu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import edu.wdu.dao.SubjectDao;
import edu.wdu.pojo.Result;

/**
 * Servlet implementation class UpdateSubjectServlet
 */
@WebServlet("/updateSubject")
public class UpdateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ����
		String idStr = request.getParameter("id");
		String name = request.getParameter("name");
		String creditStr = request.getParameter("credit");
		int id = Integer.parseInt(idStr);
		int credit = Integer.parseInt(creditStr);
		//2.�޸Ŀγ�
		int updateResult = SubjectDao.updateSubject(id, name, credit);
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
