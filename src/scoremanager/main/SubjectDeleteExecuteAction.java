package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//		SubjectDeleteActionのsetAttribute()のところでリクエストスコープに科目コードを格納している
		//		その科目コードを取得してここで科目を削除する処理を行う
		//		まずは科目コードを取得
		String cd = request.getParameter("subject_cd");

		System.out.println("executeでrequest.getParameterが正常に動いているか");
		System.out.println(cd);

		//		ここで科目情報を削除する機能を実行させる（executeが実行という意味）
		SubjectDAO subjectDao = new SubjectDAO();
		Subject subject = new Subject();

		System.out.println("4 null");
		System.out.println(cd);

		subject.setCd(cd);
		subjectDao.delete(subject);

		//		削除を実行したのち削除が完了しましたよーのページにリダイレクト
		response.sendRedirect("subject_delete_done.jsp");
	}
}