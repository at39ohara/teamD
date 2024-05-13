package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;


public class StudentUpdateAction extends Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentNo = request.getParameter("no");
		HttpSession session = request.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー

		// 学生情報を取得する処理
		StudentDAO studentDao = new StudentDAO();
		ClassNumDAO cNumDao = new ClassNumDAO();// クラス番号Daoを初期化
		List<String> list = cNumDao.filter(teacher.getSchool());
		Student student = studentDao.get(studentNo);
		request.setAttribute("student", student);
		request.setAttribute("class_num_set", list);
		request.getRequestDispatcher("student_update.jsp").forward(request, response);

		try {
		    // ここにエラーが発生しうるコードを記述する
		} catch (Exception e) {
		    // エラーが発生した場合の処理
		    response.sendRedirect("error.jsp");
		}
	}
}