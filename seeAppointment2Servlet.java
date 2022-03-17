import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

@WebServlet(name = "seeAppointment2Servlet")
public class seeAppointment2Servlet extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int nextDay = Integer.parseInt(request.getParameter("nextDay"));
        String department = request.getParameter("department");
        String patientID = session.getAttribute("patientID").toString();

        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH) + 1 ;
        int year = now.get(Calendar.YEAR);
        String sqlDateNOW = year+"-"+month+"-"+day;

        String dayExtractedDate = dayExtractedDate(sqlDateNOW,nextDay);

        ArrayList<String> appIdler = new ArrayList<String>();
        ArrayList<String> doctNameler = new ArrayList<String>();
        ArrayList<String> doctSurnameler = new ArrayList<String>();
        ArrayList<String> appDateler = new ArrayList<String>();
        ArrayList<String> appHourlar = new ArrayList<String>();

        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select * from appointments,doctor,user where appointments.doctor_id = doctor.id" +
                    " and user.id = doctor.id and appointment.appointment_date between '"+dayExtractedDate+"' and '"+sqlDateNOW+"'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                appIdler.add(rs.getString("appointment_id"));
                doctNameler.add(rs.getString("name"));
                doctSurnameler.add(rs.getString("surname"));
                appDateler.add(String.valueOf(rs.getDate("appointment_date")));
                appHourlar.add(String.valueOf(rs.getTime("appointment_time")));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        // sql calismiyor AQ

        appIdler.add("23546754");
        doctNameler.add("Murat");
        doctSurnameler.add("Dalkilic");
        appDateler.add("2017-03-15");
        appHourlar.add("12:40:00");

        request.setAttribute("appIdler",appIdler);
        request.setAttribute("doctNameler",doctNameler);
        request.setAttribute("doctSurnameler",doctSurnameler);
        request.setAttribute("appDateler",appDateler);
        request.setAttribute("appHourlar",appHourlar);
        request.setAttribute("nextDay",nextDay);
        request.getRequestDispatcher("seeAppointment2.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static String dayExtractedDate(String date,int gun){
        int day = Integer.parseInt(date.substring(8,10));
        int month = Integer.parseInt(date.substring(5,7));
        int year = Integer.parseInt(date.substring(0,4));
        day -= gun;
        if(day<0){
            day+= 30 ;
            month -=1 ;
        }if(month < 12){
            month +=12 ;
            year -=1;
        }
        return year+"-"+month+"-"+day;


    }


}
