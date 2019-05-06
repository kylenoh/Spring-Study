<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="write" method="POST">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<thead>
				<tr>
					<th>이름</th>
					<th>제목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="bName" size="50"></td>
					<td><input type="text" name="bTitle" size="50"></td>
					<td><textarea rows="10" cols="" name="bContent"></textarea> </td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;</td>
				</tr>			
			</tfoot>
		</table>
	</form>
</body>
</html>