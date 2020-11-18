<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Hello World!</h2>
<form action="save" method="post">
 id：<input id="id" name="studentNumber" type="text"><br/>
   姓名：<input id="password" name="name" type="text"><br/>
班级：<input id="className" name="className" type="text"><br/>
    <input type="submit">
</form>

<br/>
<form action="delete" method="post">
id：<input id="id" name="studentNumber" type="text"><br/>
<input type="hidden" name="_method" value="delete" />
<input type="submit" value="删除">
</form>

<br/>
<form action="get" method="get">
id：<input id="id" name="studentNumber" type="text"><br/>
<input type="submit" value="查询">
</form>

<br/>
<form action="update" method="post">
 id：<input id="id" name="studentNumber" type="text"><br/>
   姓名：<input id="name" name="name" type="text"><br/>
   <input type="hidden" name="_method" value="put" />
    <input type="submit" value="更新">
</form>

</body>
</html> 

