import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "appointmentOKServlet")
public class appointmentOKServlet extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null ;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String all = request.getParameter("selectedDoctor");
        String patientID = session.getAttribute("patientID").toString();
        String doctor_id = all.substring(0,11);
        String date = all.substring(12,22);
        String hour = all.substring(23,31);
        String app_id ="12345678";


        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Create a statement
            String sql = "insert into appointments (appointment_id,doctor_id,patient_id,appointment_date,appointment_time) values (?,?,?,?,?) ";
            myprepst = myconn.prepareStatement(sql);
            myprepst.setString(1, app_id);
            myprepst.setString(2, doctor_id);
            myprepst.setString(3, patientID);
            myprepst.setDate(4, Date.valueOf(date));
            myprepst.setTime(5, Time.valueOf(hour));
            // Execute a SQL query

            myprepst.executeUpdate();

        }catch (Exception exc) {
            exc.printStackTrace();
        }


        out.println("<html>");
        out.println("<head><title> OKKKITOKI </title></head>");
        out.println("<body>");
        out.println("RANDEVUNUZ ALINMISTIR :");
        out.println("<hr><br/>");
        out.println("Randevu tarihi : "+date);
        out.println("<br/><br/>");
        out.println("Randevu saati : "+ hour);
        out.println("<br/><br/>");
        out.println("<hr>");
        out.println("<br/>");
        out.println("Ana Sayfa :");
        out.println("<a href=\"patient.jsp\">Login</a>");
        out.println("<br/>");


        out.println("</body>");
        out.println("</html>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
