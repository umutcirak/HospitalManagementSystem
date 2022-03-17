<%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/22/2019
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<%
    String a = session.getAttribute("patientID").toString();
    String b = session.getAttribute("name").toString();
    String c = session.getAttribute("surname").toString();
    String d = session.getAttribute("address").toString();
    String e = session.getAttribute("phone_number").toString();
    String f = session.getAttribute("email").toString();
    String g = session.getAttribute("age").toString();
    String h = session.getAttribute("gender").toString();
    session.setAttribute("patientID",a);
%>
<body>
PERSONAL INFORMATION
<br/><hr>
<br/>
ID : <%= a %>
<br/><br/>
First Name : <%= b %>
<br/><br/>
Last Name: <%= c %>
<br/><br/>
Address : <%= d %>
<br/><br/>
Phone : <%= e %>
<br/><br/>
Email : <%= f %>
<br/><br/>
Age : <%= g %>
<br/><br/>
Gender : <%= h %>
<br/><hr><br/>

<a href="patient.jsp">Ana Sayfa</a>




</body>
</html>
