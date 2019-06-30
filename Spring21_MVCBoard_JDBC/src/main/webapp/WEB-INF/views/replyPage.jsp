<%@ page language="java" 
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>





	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="reply" method="post">
			<input type="hidden" name="bId" value="${replyPageFromCommand.bId}">
			<input type="hidden" name="bGroup" value="${replyPageFromCommand.bGroup}">
			<input type="hidden" name="bStep" value="${replyPageFromCommand.bStep}">
			<input type="hidden" name="bIndent" value="${replyPageFromCommand.bIndent}">
			<tr>
				<td> 번호 </td>
				<td> ${replyPageFromCommand.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${replyPageFromCommand.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input type="text" name="bName" value="${replyPageFromCommand.bName}"></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="bTitle" value="${replyPageFromCommand.bTitle}"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea rows="10"  name="bContent">${replyPageFromCommand.bContent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="답변"> 
				<a href="list" >목록</a></td>
			</tr>
		</form>
	</table>
	
	
	
	
	
</body>
</html>