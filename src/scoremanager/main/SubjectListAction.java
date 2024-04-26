package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDAO;
import tool.Action;

public class SubjectListAction  extends Action {

// オーバーライド
@Override
    public void execute (HttpServletRequest request, HttpServletResponse response) throws Exception{
     HttpSession session = request.getSession();
     Teacher teacher = (Teacher)session.getAttribute("user");

     // 科目リスト
     List<Subject> subjects = null;

     // 科目Dao
     SubjectDAO sDao = new SubjectDAO();

     // 全件取得
  subjects = sDao.filter( teacher.getSchool() );

     // レスポンス値をセット
     request.setAttribute( "subjects", subjects );

     // JSPへフォワード
     request.getRequestDispatcher("subject_list.jsp").forward(request, response);

    }
}