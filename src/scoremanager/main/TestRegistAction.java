package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Point;
import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.PointDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import tool.Action;

public class TestRegistAction extends Action {

    @SuppressWarnings("static-access")
	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        // セッションから教師情報を取得
        Teacher teacher = (Teacher) session.getAttribute("user");
        String schoolCd = teacher.getSchoolCdAsString();
        School school = new School();
        school.setCd(schoolCd);
        // リクエストパラメータから入力された情報を取得
        String entYearStr = request.getParameter("f1");
        String classNum = request.getParameter("f2");
        String subjectStr = request.getParameter("f3");
        String numStr = request.getParameter("f4");
        String take = null;
        int entYear = 0;
        int num = 0;
        String subjectName = null;
        Subject subject = new Subject();
        // 入力された年度があれば、取得
        if (entYearStr != null && !entYearStr.isEmpty()) {
            entYear = Integer.parseInt(entYearStr);
            take = "taking";
        }
        // 入力された回数があれば、取得
        if (numStr != null) {
            num = Integer.parseInt(numStr);
        }
        // 入力された科目があれば、取得
        if (subjectStr != null) {
            subject.setCd(subjectStr);
            subjectName = new SubjectDAO().get(subject.getCd(), school).getName();
        }
        // DAOの準備
        SubjectDAO subjectDao = new SubjectDAO();
        PointDAO pointDao = new PointDAO();
        ClassNumDAO cNumDao = new ClassNumDAO();
        StudentDAO studentDao = new StudentDAO();
        boolean isAttend = true;
        List<Student> students;
        List<Point> tests = null;
        // 学生リストのフィルタリング
        students = studentDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
        // クラス番号と科目のリストを取得
        List<String> classNumSet = cNumDao.filter(teacher.getSchool());
        List<Subject> subjectSet = subjectDao.filter(teacher.getSchool());
        // 科目コードと科目名のリストを取得
        List<String> subject_cdSet = getSubjectCdList(subjectSet);
        List<String> subject_nameSet = getSubjectNameList(subjectSet);
        // テストのリストを取得
        if (entYear != 0 && !classNum.equals("0")) {
            tests = pointDao.filter(entYear, classNum, subject, num, teacher.getSchool());
        }
        // 入学年度のリストを作成
        List<Integer> entYearSet = new ArrayList<>();
        int year = LocalDate.now().getYear();
        for (int i = year - 10; i <= year; i++) {
            entYearSet.add(i);
        }
        // リクエスト属性を設定
        request.setAttribute("f1", entYear);
        request.setAttribute("f2", classNum);
        request.setAttribute("f3", subjectStr);
        request.setAttribute("f4", num);
        request.setAttribute("students", students);
        request.setAttribute("tests", tests);
        request.setAttribute("class_num_set", classNumSet);
        request.setAttribute("ent_year_set", entYearSet);
        request.setAttribute("subject_cdset", subject_cdSet);
        request.setAttribute("subject_nameset", subject_nameSet);
        request.setAttribute("subject_name2", subjectName);
        request.setAttribute("take", take);
        // JSPにフォワード
        request.getRequestDispatcher("test_regist.jsp").forward(request, response);
    }
    // 科目コードのリストを取得するメソッド
    public List<String> getSubjectCdList(List<Subject> subjectList) {
        List<String> subjectCdList = new ArrayList<>();
        for (Subject subject : subjectList) {
            subjectCdList.add(subject.getCd());
        }
        return subjectCdList;
    }
    // 科目名のリストを取得するメソッド
    public List<String> getSubjectNameList(List<Subject> subjectList) {
		List<String> subjectNameList = new ArrayList<>();
		for (Subject subject : subjectList) {
			subjectNameList.add(subject.getName());
		}
		return subjectNameList;
	}
}