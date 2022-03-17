<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/22/2019
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
 ArrayList<String> idler = (ArrayList<String>) session.getAttribute("idler");
    ArrayList<String> nameler = (ArrayList<String>) session.getAttribute("nameler");
    ArrayList<String> surnameler = (ArrayList<String>) session.getAttribute("surnameler");
    ArrayList<String> departmentler = (ArrayList<String>) session.getAttribute("departmentler");
    ArrayList<String> saatler = (ArrayList<String>) session.getAttribute("saatler");
    ArrayList<String> dateler = (ArrayList<String>) session.getAttribute("dateler");
    ArrayList<String> rankingler = (ArrayList<String>) session.getAttribute("rankingler");

%>
Alabileceginiz randevular bunlardır :
<br/><br/>

<form action="appointmentOK" method = "POST">

<table cellspacing="15" >
    <tr>
        <th>   </th>
        <th>Name</th>
        <th>Surname</th>
        <th>Expertise</th>
        <th>Available Date</th>
        <th>Rank</th>
    </tr>

    <% for(int i = 0 ; i<idler.size(); i++){ %>
        <tr>
            <td> <input type="radio" name="selectedDoctor" value =<%=idler.get(i)+","+dateler.get(i)+","+saatler.get(i)%> ></td>
            <td> <%= nameler.get(i)%></td>
            <td> <%= surnameler.get(i) %></td>
            <td> <%= departmentler.get(i) %></td>
            <td> <%= dateler.get(i) +" at " +saatler.get(i) %></td>
            <td> <%= rankingler.get(i) %></td>
        </tr>
    <%}%>

</table>
<input type="submit"  value="Onayla">
</form>










</body>
</html>
