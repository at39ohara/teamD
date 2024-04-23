<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ログイン</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body>
	<!-- ヘッダー -->
	<header
		class="d-flex flex-wrap justify-content-center py-3 px-5 mb-4 border-bottom border-2 bg-primary bg-opacity-10 bg-gradient">
		<!-- ヘッダーの内容 -->
		<h1>学生管理システム</h1>
	</header>

	<div class="container">
		<h2>ログイン</h2>
		<form action="LoginExecute.action" method="post">
			<div class="mb-3">
				<label for="username" class="form-label">ID</label> <input
					type="text" class="form-control" id="username" name="teacher_id"
					required>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">パスワード</label> <input
					type="password" class="form-control" id="password" name="password"
					required>
			</div>
			<div class="mb-3">
				<input type="checkbox" id="chk_d_ps" onclick="togglePassword()">
				<label for="chk_d_ps">パスワードを表示</label>
			</div>
			<button type="submit" class="btn btn-primary">ログイン</button>
		</form>
	</div>

	<!-- フッター -->
	<footer
		class="py-2 my-4 bg-dark bg-opacity-10 border-top border-3 align-bottom">
		<!-- フッターの内容 -->


		<p class="text-center text-muted mb-0">&copy; 2023 TIC</p>
		<p class="text-center text-muted mb-0">大原学園</p>
	</footer>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<!-- パスワード表示切り替え -->
	<script>
		function togglePassword() {
			var passwordField = document.getElementById("password");
			if (passwordField.type === "password") {
				passwordField.type = "text";
			} else {
				passwordField.type = "password";
			}
		}
	</script>
</body>
</html>