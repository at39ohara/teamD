package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
//科目情報が必要なためsubjectのbeanが必要
import bean.Subject;
//セッションでユーザー情報を取得する必要があるためteacherのbeanが必要
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//	セッションでユーザー情報を取得する
		//	ユーザーの状態を保持するために必要だからこのコードが必要
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");

		// セッションから取得したユーザー情報から学校情報を取得
		School school = teacher.getSchool();

		//	科目の一覧からその科目の削除を選択するから他の情報はいらない。
		String cd = request.getParameter("subject_cd");

		System.out.println("delete action 結果");
		System.out.println(cd);

		//	リクエストスコープが何で必要なんか?
		//	リクエストスコープはそもそもその処理が終わるまで一時的に情報を保持しておくためのもの
		//	ここの処理の場合だと、削除して大丈夫？っていうsubject_delete.jspに画面が移動して
		//	確定ボタンが押されるまでの間、削除するかどうかの判断ができないから保持しておく。
		SubjectDAO subjectDAO = new SubjectDAO();
		Subject subject = subjectDAO.get(cd, school);

		System.out.println("subjectdaoからget(cd, school)ができているか");
		System.out.println(subject);

		request.setAttribute("subject", subject);

		if (subject != null) {
			// リクエストスコープにセットする処理
			System.out.println("Subjectオブジェクトはnullではありません。");
		} else {
			// null の場合の処理
			System.out.println("Subjectオブジェクトはnullです。");
		}

		//	全部の処理が完了したら科目を削除するよ大丈夫かい？ってページにフォワードする
		//	この上までの処理は科目一覧のところで削除ボタンを押されたことによって行われる処理
		//	ここから下が処理が終わって削除を実行するかどうかの処理になる
		request.getRequestDispatcher("subject_delete.jsp").forward(request, response);

		try {
		    // ここにエラーが発生しうるコードを記述する
		} catch (Exception e) {
		    // エラーが発生した場合の処理
		    response.sendRedirect("error.jsp");
		}

	}
}