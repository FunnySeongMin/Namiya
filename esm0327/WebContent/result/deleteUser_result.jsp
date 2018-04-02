<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- bootstrap-theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- bootstrap-dialog -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/css/bootstrap-dialog.min.css">
<!-- bootstrap-select -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.0-beta/css/bootstrap-select.min.css">
<!-- favicon -->
<link rel="shortcut icon" type="image/x-icon" href="favicon-brown.ico" />

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- fontawesom -->
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
<!-- bootstrap -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- bootstrap-dialog -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap3-dialog/1.34.9/js/bootstrap-dialog.min.js"></script>
<!-- bootstrap-select -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.0-beta/js/bootstrap-select.min.js"></script>
<!-- fontawesome -->
<script defer src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
<title>updateUser_result</title>
</head>
<body>
</body>
<script>
$(document).ready(function() {
	BootstrapDialog.show({
			type : "type-danger",
			title : "<i class='fas fa-exclamation-circle'></i> 알림",
			message : "회원탈퇴 되었습니다.",
			closable : false,
			onhidden : function(dialogRef) {
				location.href = "${pageContext.request.contextPath}/index.jsp";
			},
			buttons : [ {
				label : "확인",
				hotkey : 13,
				action : function(cancel) {
					cancel.close();
				}
			} ]
		});
	});
</script>
</html>