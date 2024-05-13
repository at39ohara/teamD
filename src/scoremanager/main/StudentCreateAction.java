package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.StudentDAO;
import tool.Action;

public class StudentCreateAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	    HttpSession session = req.getSession();
	    Teacher teacher = (Teacher) session.getAttribute("user");
	    String entYearStr = req.getParameter("f1");
	    String classNum = req.getParameter("f2");
	    String isAttendStr = req.getParameter("f3");
	    int entYear = 0;
	    boolean isAttend = false;
	    List<Student> students = null;
	    LocalDate todaysDate = LocalDate.now();
	    int year = todaysDate.getYear();
	    StudentDAO sDao = new StudentDAO();
	    ClassNumDAO cNumDao = new ClassNumDAO();
	    Map<String, String> errors = new HashMap<>();

	    List<String> classNumList = cNumDao.filter(teacher.getSchool());
	    List<Integer> entYearSet = new ArrayList<>();
	    for (int i = year - 10; i <= year + 1; i++) {
	        entYearSet.add(i);
	    }

	    // 入学年度が送信されていた場合
	    if (entYearStr != null && !entYearStr.isEmpty()) {
	        entYear = Integer.parseInt(entYearStr);
	    } else {
	        errors.put("f1", "入学年度を選択してください");
	    }

	    // クラス番号が送信されていた場合
	    if (classNum != null && !classNum.isEmpty()) {
	        if (classNum.equals("0")) {
	            errors.put("f2", "クラスを選択してください");
	        } else {
	            // クラス番号が選択された場合のみ、そのクラスの学生を取得
	            students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
	        }
	    } else {
	        errors.put("f2", "クラスを選択してください");
	    }

	    // 在学フラグが送信されていた場合
	    if (isAttendStr != null && !isAttendStr.isEmpty()) {
	        isAttend = Boolean.parseBoolean(isAttendStr);
	    }

	    // エラーチェック
	    if (!errors.isEmpty()) {
	        req.setAttribute("errors", errors);
	        req.setAttribute("f1", entYear);
	        req.setAttribute("f2", classNum);
	        req.setAttribute("f3", isAttendStr);
	        req.setAttribute("class_num_set", classNumList);
	        req.setAttribute("ent_year_set", entYearSet);
	        req.getRequestDispatcher("student_create.jsp").forward(req, res);
	        return;
	    }

	    // 入学年度とクラスが選択されていない場合、エラーメッセージを設定してフォワード
	    if (entYear == 0 || classNum == null || classNum.equals("0")) {
	        errors.put("general", "入学年度とクラスを選択してください");
	        req.setAttribute("errors", errors);
	        req.setAttribute("f1", entYear);
	        req.setAttribute("f2", classNum);
	        req.setAttribute("f3", isAttendStr);
	        req.setAttribute("class_num_set", classNumList);
	        req.setAttribute("ent_year_set", entYearSet);
	        req.getRequestDispatcher("student_create.jsp").forward(req, res);
	        return;
	    }

	    // 登録処理を行う
	    // 例: sDao.registerStudents(students);

	    // 登録後、成功メッセージなどを設定してリダイレクトするなどの処理を行う
	    // 例: req.setAttribute("successMessage", "登録が完了しました");
	    //     req.getRequestDispatcher("success.jsp").forward(req, res);
	}
}