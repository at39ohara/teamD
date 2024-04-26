package scoremanager.main;

import java.util.ArrayList;
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

public class SubjectCreateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");

		String subjectCd = null;
		String subjectName = "";

		List<String> subjects = null;
		List<String> list = null;

		SubjectDAO sDao = new SubjectDAO();
		ClassNumDAO cNumDao = new ClassNumDAO();

		Map<String, String> errors = new HashMap<>();

		subjectCd = req.getParameter("f1");
		subjectName = req.getParameter("f2");

		if (subjectCd != null) {
			subjects = sDao.filter(teacher.getSchool(), subjectCd);
		}

		if (subjects == null || subjects.isEmpty()) {
			errors.put("f1", "該当する科目が存在しません");
			req.setAttribute("errors", errors);
			subjects = sDao.getAllSubjects(teacher.getSchool());
		}

		list = cNumDao.filter(teacher.getSchool());

		req.setAttribute("f1", subjectCd);
		req.setAttribute("f2", subjectName);
		req.setAttribute("subjects", subjects);
		req.setAttribute("class_num_set", list);

		req.getRequestDispatcher("subject_create.jsp").forward(req, res);
	}
}
