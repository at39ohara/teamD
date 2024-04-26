package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;


public class SubjectUpdateAction extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentNo = request.getParameter("no");
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー

		ClassNumDAO cNumDao = new ClassNumDAO();// クラス番号Daoを初期化
		List<String> list = cNumDao.filter(teacher.getSchool());
		SubjectDAO subjectDao = null;
		@SuppressWarnings("null")
		Subject student = subjectDao.get(studentNo);
		request.setAttribute("student", student);
		request.setAttribute("class_num_set", list);
		request.getRequestDispatcher("subject_update.jsp").forward(request, response);


	}
}