package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SubjectCreateAction extends Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// JSP ページにフォワード
		request.getRequestDispatcher("subject_create.jsp").forward(request, response);

		try {
		    // ここにエラーが発生しうるコードを記述する
		} catch (Exception e) {
		    // エラーが発生した場合の処理
		    response.sendRedirect("error.jsp");
		}
	}
}