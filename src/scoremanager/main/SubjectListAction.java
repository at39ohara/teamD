package scoremanager.main;

import java.time.LocalDate;
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

public class SubjectListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		String entYearStr = "";
		String classNum = "";
		String count = "";
		int entYear = 0;
		boolean isAttend = false;
		List<Subject> subjects = null;
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		SubjectDAO sDao = new SubjectDAO();
		ClassNumDAO cNumDao = new ClassNumDAO();
		Map<String, String> errors = new HashMap<>();

		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		count = req.getParameter("f3");

		List<String> list = cNumDao.filter(teacher.getSchool());

		if (entYearStr != null) {
			entYear = Integer.parseInt(entYearStr);
		}

		if (entYear != 0 && !classNum.equals("0")) {
			subjects = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
		} else if (entYear != 0 && classNum.equals("0")) {
			subjects = sDao.filter(teacher.getSchool(), entYear, isAttend);
		} else if (entYear == 0 && classNum == null || entYear == 0 && classNum.equals("0")) {
			subjects = sDao.filter(teacher.getSchool(), isAttend);
		} else {
			errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
			req.setAttribute("errors", errors);
			subjects = sDao.filter(teacher.getSchool(), isAttend);
		}

		if (entYearStr != null) {
			entYear = Integer.parseInt(entYearStr);
		}
		List<Integer> entYearSet = new ArrayList<>();
		for (int i = year - 10; i < year + 1; i++) {
			entYearSet.add(i);
		}

		req.setAttribute("f1", entYear);
		req.setAttribute("f2", classNum);
		if (count != null) {
			isAttend = true;
			req.setAttribute("f3", count);
		}
		req.setAttribute("subjects", subjects);
		req.setAttribute("class_num_set", list);
		req.setAttribute("ent_year_set", entYearSet);

		req.getRequestDispatcher("subject_list.jsp").forward(req, res);
	}
}
