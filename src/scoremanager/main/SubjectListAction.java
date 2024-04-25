package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDAO;
import dao.SubjectDAO;
import tool.Action;

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		String subjectCd = "";
		String subjectName = "";
		List<Subject> subjects = null;
		SubjectDAO subjectDAO = new SubjectDAO();
		ClassNumDAO classNumDAO = new ClassNumDAO();
		Map<String, String> errors = new HashMap<>();

		subjectCd = req.getParameter("f1");
		subjectName = req.getParameter("f2");

		subjects = subjectDAO.filter(teacher.getSchool(), subjectCd, subjectName);

		List<String> classNumList = classNumDAO.filter(teacher.getSchool());

		req.setAttribute("f1", subjectCd);
		req.setAttribute("f2", subjectName);
		req.setAttribute("subjects", subjects);
		req.setAttribute("class_num_set", classNumList);

		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
	}
}
