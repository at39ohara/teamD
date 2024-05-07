package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectUpdateAction extends Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッションからログインユーザー（教師）を取得します
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");

		// ログインユーザーの所属学校を取得
		School school = teacher.getSchool();

		// リクエストから科目コードを取得
		String school_cd = request.getParameter("school_cd");

		// SubjectDAOを使用して、指定された科目コードと所属学校に対応する科目情報を取得
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject = subjectDAO.get(school_cd, school);

		// 取得した科目情報をリクエスト属性に設定
		request.setAttribute("subject", subject);

		// 科目コードをリクエスト属性に設定
		request.setAttribute("school_cd", school_cd);

		// 科目更新画面にフォワード
		request.getRequestDispatcher("subject_update.jsp").forward(request, response);
	}
}