package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Point;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import dao.PointDAO;
import tool.Action;

public class TestRegistExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 送信ボタンの値を取得
        String submitButtonValue = req.getParameter("submitButton");

        // セッションからユーザー情報を取得
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");
        String schoolCd = teacher.getSchoolCdAsString();

        // 削除するテストデータと登録するテストデータを抽出
        List<Point> deleteTests = extractDeleteTests(req);
        List<Point> tests = extractTests(req, schoolCd, deleteTests);

        // PointDAOをインスタンス化
        PointDAO pointDAO = new PointDAO();

        // 削除するテストデータを削除
        if (!deleteTests.isEmpty()) {
            pointDAO.delete(deleteTests);
        }

        // 登録するテストデータを保存
        if (!tests.isEmpty()) {
            pointDAO.save(tests);
        }

        // フォーム送信に応じた処理を実行
        handleFormSubmission(submitButtonValue, req, res);
    }

    // 削除するテストデータを抽出するメソッド
    private List<Point> extractDeleteTests(HttpServletRequest req) {
        List<Point> deleteTests = new ArrayList<>();

        String[] deletePointNos = req.getParameterValues("deletePoint");
        String deleteSubjectCd = req.getParameter("subject.cd2");

        if (deletePointNos != null) {
            for (String deletePointNo1 : deletePointNos) {
                Point deleteTest = createPoint(deletePointNo1, deleteSubjectCd);
                deleteTests.add(deleteTest);
            }
        }

        return deleteTests;
    }

    // 登録するテストデータを抽出するメソッド
    private List<Point> extractTests(HttpServletRequest req, String schoolCd, List<Point> deleteTests) {
        List<Point> tests = new ArrayList<>();

        String[] Nos = req.getParameterValues("no");
        String[] classNums = req.getParameterValues("classNum");
        String[] studentNos = req.getParameterValues("student.no");
        String[] subjectCds = req.getParameterValues("subject.cd");
        String[] points = req.getParameterValues("point");

        if (classNums != null) {
            for (int i = 0; i < classNums.length; i++) {
                Point test = createPoint(Nos[i], schoolCd, classNums[i], studentNos[i], subjectCds[i], points[i]);
                // 削除リストに含まれていない場合のみ登録リストに追加
                if (!containsStudent(deleteTests, studentNos[i])) {
                    tests.add(test);
                }
            }
        }

        return tests;
    }

    // Pointオブジェクトを作成するメソッド
    private Point createPoint(String testNo, String subjectCd) {
        Point point = new Point();
        point.setNo(Integer.parseInt(testNo));

        Student student = new Student();
        student.setNo(testNo);
        point.setStudent(student);

        Subject subject = new Subject();
        subject.setCd(subjectCd);
        point.setSubject(subject);

        return point;
    }

    // Pointオブジェクトを作成するメソッド
    private Point createPoint(String testNo, String schoolCd, String classNum, String studentNo, String subjectCd, String point) {
        Point test = createPoint(testNo, subjectCd);
        test.setClassNum(classNum);
        test.setPoint(Integer.parseInt(point));
        test.getStudent().setNo(studentNo);

        return test;
    }

    // 削除リストに指定の学生番号が含まれているかを判定するメソッド
    private boolean containsStudent(List<Point> tests, String studentNo) {
        for (Point test : tests) {
            if (test.getStudent().getNo().equals(studentNo)) {
                return true;
            }
        }
        return false;
    }

    // フォーム送信に応じた処理を実行するメソッド
    private void handleFormSubmission(String submitButtonValue, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (submitButtonValue != null) {
            if (submitButtonValue.equals("登録して終了")) {
                // 登録して終了ボタンがクリックされた場合の処理
                req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
            } else if (submitButtonValue.equals("登録して再度入力")) {
                // 登録して再度入力ボタンがクリックされた場合の処理
                res.sendRedirect("TestRegist.action");
            }
        }
    }
}
