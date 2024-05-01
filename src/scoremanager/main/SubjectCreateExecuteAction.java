package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ユーザー情報を取得
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");

		//科目情報を取得
		String cd = request.getParameter("subject_cd");
		String name = request.getParameter("subject_name");
		System.out.println("request Parameter");
		System.out.println(cd);
		System.out.println(name);

		if (cd == null || cd.length() != 3) {
			request.setAttribute("errorMessage", "科目コードは3文字で入力してください");
			request.setAttribute("subject_cd", cd);
			request.setAttribute("subject_name", name);
			return;
		}

		SubjectDAO subjectDao = new SubjectDAO();

		// 科目情報を作成してデータベースに保存
		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());

		subjectDao.save(subject);
		System.out.println("sava done?");
		System.out.println(subject);
		System.out.println(subjectDao);

		// 科目登録完了ページにリダイレクト
		response.sendRedirect("subject_create_done.jsp");
	}
}