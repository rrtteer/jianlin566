<html>
	<head>
		<title>客户关系管理系统</title>
		<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../css/global.css">
	</head>
	
	<body>
		<#list users as user >
			${user.id?c} | ${user.userName?if_exists} | ${user.trueName?if_exists} 
			| ${user.email?if_exists} | <#if user.createDate?exists >${user.createDate?string('yyyy-MM-dd HH:mm:ss')}</#if> <br>
		</#list>
	</body>
</html>