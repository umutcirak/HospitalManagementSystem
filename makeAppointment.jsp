<%--
  Created by IntelliJ IDEA.
  User: Umut
  Date: 12/21/2019
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = session.getAttribute("id").toString();
    session.setAttribute("patientID",id);
%>
RANDEVU BILGILERINIZI DOLDURUNUZ
<br/><br/>

<form action="appointment" method="post">
    Klinik seciniz :
    <br/><br/>
    <select name="department" >
        <option>Neurology</option>
        <option>Cardiology</option>
        <option>Orthopedics</option>
        <option>Dermatology</option>
    </select>
    <br/><br/>
    Randevu aratmak istediginiz ayı seçiniz:
    <select name="month" >
        <option>January</option>
        <option>February</option>
        <option>March</option>
        <option>April</option>
        <option>May</option>
        <option>June</option>
        <option>July</option>
        <option>August</option>
        <option>September</option>
        <option>October</option>
        <option>November</option>
        <option>December</option>
    </select>
    <br/><br/>
    Randevu almak istediginiz gun araligini seciniz :
    <select name="day1" >
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
        <option>31</option>
    </select>
        <select name="day2" >
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
            <option>31</option>
        </select>
    <br/><br/>
    Randevu almak icin saat araligi seciniz :
    <select name="hour1" >
        <option>09.00</option>
        <option>10.00</option>
        <option>11.00</option>
        <option>12.00</option>
        <option>13.00</option>
        <option>14.00</option>
        <option>15.00</option>
        <option>16.00</option>
        <option>17.00</option>
    </select>
    <select name="hour2" >
        <option>09.00</option>
        <option>10.00</option>
        <option>11.00</option>
        <option>12.00</option>
        <option>13.00</option>
        <option>14.00</option>
        <option>15.00</option>
        <option>16.00</option>
        <option>17.00</option>
    </select>
    <br/><br/>
    <input type="submit" value="Onayla" >
</form>




</body>
</html>
