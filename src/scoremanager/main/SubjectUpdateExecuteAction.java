//package scoremanager.main;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import bean.Subject;
//import bean.Teacher;
//import dao.SubjectDAO;
//import tool.Action;
//
//public class SubjectUpdateExecuteAction extends Action {
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();// セッション
//		Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザー
//
//		// フォームから送信されたデータを取得
//		String cd = request.getParameter("school_cd");
//		String name = request.getParameter("subject_name");
//
//		Subject subject = new Subject();
//		subject.setCd(school_cd);
//		subject.setName(subject_name);
//		subject.setSchool(teacher.getSchool());
//
//		// SubjectDaoを使ってデータベースに挿入
//		SubjectDAO subjectDAO = new SubjectDAO();
//
//
//		// 科目を取得して存在を確認
//        Subject existingSubject = subjectDAO.get(cd, teacher.getSchool());
//
//
//		if (existingSubject == null) {
//			// 登録成功時の処理
//			response.sendRedirect("subject_update_done.jsp");
//			; // 登録後の画面にリダイレクト
//		} else {
//			// 登録失敗時の処理
//			response.sendRedirect("subject_update.jsp?error=failed"); // 失敗した場合は元のページに戻す
//		}
//	}
//}