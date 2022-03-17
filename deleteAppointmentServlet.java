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

@WebServlet(name = "deleteAppointmentServlet")
public class deleteAppointmentServlet extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String patientID = session.getAttribute("patientID").toString();
        ArrayList<String> appIdler = new ArrayList<String>();
        ArrayList<String> doctNameler = new ArrayList<String>();
        ArrayList<String> doctSurnameler = new ArrayList<String>();
        ArrayList<String> appDateler = new ArrayList<String>();
        ArrayList<String> appHourlar = new ArrayList<String>();


        Calendar now = Calendar.getInstance();
        int day = now.get(Calendar.DAY_OF_MONTH);
        int month = now.get(Calendar.MONTH) + 1 ;
        int year = now.get(Calendar.YEAR);
        String sqlDateNOW = year+"-"+month+"-"+day;

        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select * from appointments,doctor,user where appointments.doctor_id = doctor.id" +
                    " and user.id = doctor.id and appointments.appointment_date > '"+sqlDateNOW+"' and " +
                    "appointments.patient_id = '"+patientID+"'";
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

        request.setAttribute("appIdler",appIdler);
        request.setAttribute("doctNameler",doctNameler);
        request.setAttribute("doctSurnameler",doctSurnameler);
        request.setAttribute("appDateler",appDateler);
        request.setAttribute("appHourlar",appHourlar);

        request.getRequestDispatcher("deleteAppointment.jsp").forward(request, response);

    }

    }
