import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "deleteAppointmentServlet2")
public class deleteAppointmentServlet2 extends HttpServlet {
    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null ;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String appID = request.getParameter("selectedAppointment");
        PrintWriter out = response.getWriter();

        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Create a statement
            String sql = "DELETE FROM `appointments` WHERE `appointment_id` = ?";
            myprepst = myconn.prepareStatement(sql);
            myprepst.setString(1, appID);
            // Execute a SQL query
            myprepst.executeUpdate();

        }catch (Exception exc) {
            exc.printStackTrace();
        }

        out.println("<html>");
        out.println("<head><title> OLDUU </title></head>");
        out.println("<body>");
        out.println("  **RANDEVUNUZ SILINMISTIR**  ");
        out.println("<hr><br/>");
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
