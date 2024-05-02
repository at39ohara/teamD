package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ユーザー情報を取得
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");

		// 科目情報を取得
		String cd = request.getParameter("subject_cd");
		String name = request.getParameter("subject_name");
		System.out.println("リクエストパラメータ");
		System.out.println(cd);
		System.out.println(name);

		// データベースに保存
		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());

		SubjectDAO subjectDao = new SubjectDAO();

		// 科目情報を更新
		subjectDao.save(subject, teacher.getSchool());

		// 更新完了ページにリダイレクト
		response.sendRedirect("subject_update_done.jsp");
	}
}