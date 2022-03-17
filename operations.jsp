<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/26/2019
  Time: 2:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> oppIDler = (ArrayList<String>) request.getAttribute("oppIDler");
    ArrayList<String> oppNameler = (ArrayList<String>) request.getAttribute("oppNameler");
    ArrayList<String> oppDoctNameler = (ArrayList<String>) request.getAttribute("oppDoctNameler");
    ArrayList<String> oppDoctSurnameler = (ArrayList<String>) request.getAttribute("oppDoctSurnameler");
    ArrayList<String> oppNurseNameler = (ArrayList<String>) request.getAttribute("oppNurseNameler");
    ArrayList<String> oppNurseSurnameler = (ArrayList<String>) request.getAttribute("oppNurseSurnameler");
    ArrayList<String> oppRoomTypeler = (ArrayList<String>) request.getAttribute("oppRoomTypeler");
    ArrayList<String> oppDateler = (ArrayList<String>) request.getAttribute("oppDateler");
    ArrayList<String> oppTimeler = (ArrayList<String>) request.getAttribute("oppTimeler");
    ArrayList<String> doctRankingler = (ArrayList<String>) request.getAttribute("doctRankingler");

%>
<table cellspacing="15" >
    <tr>
        <th>Operation ID</th>
        <th>Operation Name</th>
        <th>Doctor</th>
        <th>Nurse </th>
        <th>Room</th>
        <th>Date</th>

    </tr>

    <% for(int i = 0 ; i<oppIDler.size(); i++){ %>
    <tr>
        <td> <%= oppIDler.get(i)%></td>
        <td> <%=oppNameler.get(i)%></td>
        <td> <%= oppDoctNameler.get(i) +" " +oppDoctSurnameler.get(i)+" (" +doctRankingler.get(i)+")" %></td>
        <td> <%= oppNurseNameler.get(i) +" " +oppNurseSurnameler.get(i) %></td>
        <td> <%= oppRoomTypeler.get(i) %></td>
        <td> <%= oppDateler.get(i) +" at " +oppTimeler.get(i) %></td>
    </tr>
    <%}%>

</table>
<br/><hr><br/>
<a href="patient.jsp">ANA SAYFA</a>




</body>
</html>
