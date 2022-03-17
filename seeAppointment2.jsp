<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/25/2019
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> appIdler = (ArrayList<String>) request.getAttribute("appIdler");
    ArrayList<String> doctNameler = (ArrayList<String>) request.getAttribute("doctNameler");
    ArrayList<String> doctSurnameler = (ArrayList<String>) request.getAttribute("doctSurnameler");
    ArrayList<String> appDateler = (ArrayList<String>) request.getAttribute("appDateler");
    ArrayList<String> appHourlar = (ArrayList<String>) request.getAttribute("appHourlar");
    String nextDay = request.getAttribute("nextDay").toString();
   %>
Gecen <%= nextDay %> gun icindeki randevulariniz :
<br/><br/>
<table cellspacing="15" >
    <tr>
        <th>Appointment ID</th>
        <th>Doctor Name</th>
        <th>Date</th>
    </tr>

    <% for(int i = 0 ; i<appIdler.size(); i++){ %>
    <tr>
        <td> <%= appIdler.get(i)%></td>
        <td> <%= doctNameler.get(i) + " " +doctSurnameler.get(i) %></td>
        <td> <%= appDateler.get(i) +" at " +appHourlar.get(i) %></td>
    </tr>
    <%}%>

</table>
<br/><hr><br/>
<a href="patient.jsp">ANA SAYFA</a>


</body>
</html>
