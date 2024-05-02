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
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //ユーザー情報を取得
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        if (teacher == null || teacher.getSchool() == null || teacher.getSchool().getCd() == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        School school = teacher.getSchool();

        // リクエストパラメータから更新する科目のコードを取得
        String cd = request.getParameter("subject_cd");
        System.out.println("サブジェクトコードがアップデート");
        System.out.println(cd);

        // 科目情報を取得
        SubjectDAO subjectDao = new SubjectDAO();
        Subject subject = subjectDao.get(cd, school);
        System.out.println("科目取得できとるか");
        System.out.println(cd);
        System.out.println(school);
        System.out.println(subject);

        request.setAttribute("subject", subject);
        System.out.println(request);

        request.getRequestDispatcher("subject_update.jsp").forward(request, response);
      }
  }