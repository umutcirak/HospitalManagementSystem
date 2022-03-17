<%@ page import="static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.S" %><%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/21/2019
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String patientID = session.getAttribute("id").toString();
    session.setAttribute("patientID",patientID);

%>
Hosgeldiniz <%= session.getAttribute("name") + " " + session.getAttribute("surname") %>
<br/>
<hr>
Lütfen yapmak istediğiniz islemi seciniz:
<br/><br/>

<a href="makeAppointment.jsp">RANDEVU AL</a>
<br/>
-------------------------------------------
<br/>
<a href="isInpatient">YATAN/AYAKTAN HASTA DURUMUNU SORGULA</a>
<br/>
-------------------------------------------
<br/>
GELECEK RANDEVULARI GORUNTULE
<br/><br/>
<form action="seeAppointment" method="post">
    Departman Seciniz :
    <select name="department" >
        <option>Neurology</option>
        <option>Cardiology</option>
        <option>Orthopedics</option>
        <option>Dermatology</option>
    </select>
    <br/><br/>
    Kac gun icindeki randevuları goruntelemek istediginizi seciniz :
    <select name="nextDay" >
        <option>01</option>
        <option>02</option>
        <option>03</option>
        <option>04</option>
        <option>05</option>
        <option>06</option>
        <option>07</option>
        <option>08</option>
        <option>09</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
        <option>22</option>
        <option>23</option>
        <option>24</option>
        <option>25</option>
        <option>26</option>
        <option>27</option>
        <option>28</option>
        <option>29</option>
        <option>30</option>
    </select>
    <br/><br/>
    <input type="submit" value="Onayla" >
</form>
-------------------------------------------
<br/>
GECMIS RANDEVULARI GORUNTULE :
<br/><br/>
<form action="seeAppointment2" method="post">
    Departman Seciniz :
    <select name="department" >
        <option>Neurology</option>
        <option>Cardiology</option>
        <option>Orthopedics</option>
        <option>Dermatology</option>
    </select>
    <br/><br/>
    Kac gun onceki randevuya kadar aratmak istedginizi secin :
    <select name="nextDay" >
        <option>01</option>
        <option>02</option>
        <option>03</option>
        <option>04</option>
        <option>05</option>
        <option>06</option>
        <option>07</option>
        <option>08</option>
        <option>09</option>
        <option>10</option>
        <option>11</option>
        <option>12</option>
        <option>13</option>
        <option>14</option>
        <option>15</option>
        <option>16</option>
        <option>17</option>
        <option>18</option>
        <option>19</option>
        <option>20</option>
        <option>21</option>
        <option>22</option>
        <option>23</option>
        <option>24</option>
        <option>25</option>
        <option>26</option>
        <option>27</option>
        <option>28</option>
        <option>29</option>
        <option>30</option>
    </select>
    <br/><br/>
    <input type="submit" value="Onayla" >
</form>
-------------------------------------------
<br/>

<a href="deleteAppointment">RANDEVU SIL</a>
<br/>
-------------------------------------------
<br/>

<a href="personalInfo">View Personal Information</a>
<br/>
-------------------------------------------
<br/>
<a href="operations">Show Operations</a>
<br/>
-------------------------------------------






</body>
</html>
