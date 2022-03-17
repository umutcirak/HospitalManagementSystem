<%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/26/2019
  Time: 4:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String a = request.getAttribute("arrival_date").toString();
    String b = request.getAttribute("discharge_date").toString();
    String c = request.getAttribute("disease").toString();
    String d = request.getAttribute("room_type").toString();

%>

OPERATION :
<br/>
<%
    if ( a != null && b != null){ %>
        <div>
                  INPATION : yes <br/><br/>
                   DISEASE : <%= b %>
              ARRIVAL DATE : <%= a %>
            ROOM TYPE      : <%= d %>
            DISCHARGE DATE : <%= c %>


        </div>



       <% } else{  %>
           <div>
           <br/><br/>
               **YATAN HASTA KATEGORISINDE GORUNMEMEKTSINIZ**
           </div>

      <% %>


</body>
</html>
