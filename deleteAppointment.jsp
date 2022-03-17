<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/22/2019
  Time: 5:22 AM
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
    ArrayList<String> appHourlar = (ArrayList<String>) request.getAttribute("appDateler");

%>
<form action="deleteAppointment2" method = "POST">
<table cellspacing="15" >
    <tr>
        <th>    </th>
        <th>Appointment ID</th>
        <th>Doctor Name</th>
        <th>Date</th>
    </tr>

    <% for(int i = 0 ; i<appIdler.size(); i++){ %>
    <tr>
        <td> <input type="radio" name="selectedAppointment" value =<%=appIdler.get(i)%> ></td>
        <td> <%= appIdler.get(i)%></td>
        <td> <%= doctNameler.get(i) + " " +doctSurnameler.get(i) %></td>
        <td> <%= appDateler.get(i) +" at " +appHourlar.get(i) %></td>
    </tr>
    <%}%>

</table>
    <input type="submit"  value="Onayla">
</form>
<br/><hr><br/>
<a href="patient.jsp">ANA SAYFA</a>

</body>
</html>
