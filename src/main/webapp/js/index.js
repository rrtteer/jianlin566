$(document).ready(function() {
   $("#btnLogin").click(function () {
	   // 获取用户名 密码以及用户类型
	   var userName = $("#userName").val();
	   if (isEmpty(userName)) {
		   alert("请输入用户名");
		   return;
	   }
	   var password = $("#password").val();
	   if (isEmpty(password)) {
		   alert("请输入密码");
		   return;
	   }
	   var roleName = $("#roleName").val();
	   if (isEmpty(roleName)) {
		   alert("请选择用户类型");
		   return;
	   }
	   
//	   $.ajax();
//	   $.getJSON();
//	   var data = {userName: userName, password: password, 
//			   roleName:roleName};
	   var data = {};
	   data.userName = userName;
	   data.password = password;
	   data.roleName = roleName;
	   $.post("user/login", data, function (data) {
		   var resultCode = data.resultCode;
		   if (resultCode == 1) {
			   var userIdString = data.result.userIdString;
			   var userName = data.result.userName;
			   // 写入cookie
			   $.cookie("userIdString", userIdString);
			   $.cookie("userName", userName);
			   window.location.href = "main";
		   } else {
			   alert(data.result);
			   
		   }
	   });
	   
	   
   });
});
