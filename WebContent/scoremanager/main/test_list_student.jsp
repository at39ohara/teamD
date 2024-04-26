<%-- 科目一覧JSP --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/common/base.jsp">

	<c:param name="title">

		得点管理システム

</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">

		<section class="me-4">

			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績一覧（科目）</h2>

			<div class="my-2 text-end px-4"></div>

			<form method="get">

				<div class="row border mx-3 mb-3 py-2 align-items-center rounded"

					id="filter">

					科目情報

					<div class="col-2">

						<label class="form-label" for="student-f1-select">入学年度 </label> <select

							class="form-select" id="student-f1-select" name="f1">

							<option value="0">--------</option>

							<c:forEach var="year" items="${ent_year_set}">

								<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>

								<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>

							</c:forEach>

						</select>

					</div>

					<div class="col-2">

						<label class="form-label" for="student-f2-select">クラス</label> <select

							class="form-select " id="student-f2-select" name="f2">

							<option value="0">--------</option>

							<c:forEach var="num" items="${class_num_set}">

								<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>

								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>

							</c:forEach>

						</select>

					</div>

					<div class="col-4">

						<label class="form-label" for="student-f2-select">科目</label> <select

							class="form-select " id="student-f2-select" name="f2">

							<option value="0">--------</option>

							<c:forEach var="num" items="${class_num_set}">

								<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>

								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>

							</c:forEach>

						</select>

					</div>

					<div class="col-2 text-center">

						<button class="btn btn-secondary" id="filter-button">検索</button>

					</div>

					<hr class="horizontal-line">

					<div class="mt-2 text-warning">${errors.get("f1")}</div>

					学生情報

					<div class="col-4">

						<label class="form-label" for="student-f1-select">学生番号 </label> <input

							type="text" class="form-control" id="student_num"

							name="student_num" placeholder="学生番号を入力してください" required>

						<c:forEach var="year" items="${ent_year_set}">

							<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>

						</c:forEach>

					</div>

					<div class="col-2 text-center">

						<button class="btn btn-secondary" id="filter-button">検索</button>

					</div>

				</div>

				<style>

					.mt-2 {

						margin-right: 10px;

					}

					.col-4 {

						margin-left: 20px;

					}

					.col-2 {

						margin-left: 20px;

					}

					.horizontal-line {

						border-top: 1px solid black;

						width: 90%;

						margin: 10px auto;

					}

					.highlighted-text {

						color: lightblue;

					}

				</style>

				<p>

					<label><span class="highlighted-text">科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</span></label>

				</p>

			</form>

			<c:choose>

				<c:when test="${students.size()>0}">

					<div>検索結果：${students.size()}件</div>

					<table class="table table-hover">

						<tr>

							<th>入学年度</th>

							<th>学生番号</th>

							<th>氏名</th>

							<th>クラス</th>

							<th class="text-center">在学中</th>

							<th></th>

							<th></th>

						</tr>

						<c:forEach var="student" items="${students}">

							<tr>

								<td>${student.entYear}</td>

								<td>${student.no}</td>

								<td>${student.name}</td>

								<td>${student.classNum}</td>

								<td class="text-center">

									<%-- 在学フラグがたっている場合「○」それ以外は「×」を表示 --%> <c:choose>

										<c:when test="${student.isAttend()}">

											○

</c:when>

										<c:otherwise>

											×

</c:otherwise>

									</c:choose>

								</td>

								<td><a href="StudentUpdate.action?no=${student.no}">変更</a></td>

							</tr>

						</c:forEach>

					</table>

				</c:when>

				<c:otherwise>

				</c:otherwise>

			</c:choose>

		</section>

	</c:param>

</c:import>