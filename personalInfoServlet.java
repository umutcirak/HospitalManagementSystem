import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "personalInfoServlet")
public class personalInfoServlet extends HttpServlet {

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
        String name ="";
        String surname = "";
        String address = "";
        String phone_number ="";
        String email = "";
        String age = "";
        String gender = "";
        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select * from user,patient where patient.id = '" + patientID + "' and user.id = patient.id";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString("name");
                surname = rs.getString("surname");
                address = rs.getString("address");
                phone_number = rs.getString("phone_number");
                email = rs.getString("email");
                age = rs.getString("age");
                gender = rs.getString("gender");
            }


        } catch (Exception exc) {
            exc.printStackTrace();
        }

        // SQL den bilgi çekmediği için bol bilgi attım

        session.setAttribute("patientID",patientID);
        session.setAttribute("name",name);
        session.setAttribute("surname",surname);
        session.setAttribute("address",address);
        session.setAttribute("phone_number",phone_number);
        session.setAttribute("email",email);
        session.setAttribute("age",age);
        session.setAttribute("gender",gender);

        response.sendRedirect("personalInfo.jsp");


    }


}
