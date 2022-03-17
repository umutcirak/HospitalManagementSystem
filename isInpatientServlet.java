import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "isInpatientServlet")
public class isInpatientServlet extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null ;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String patientID = session.getAttribute("patientID").toString();

        PrintWriter out = response.getWriter();

        String arrival_date = "dafasgd";
        String discharge_date = "saf" ;
        String disease  = "sddsad";
        String room_type = "bsadafsaf";
        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select * from inpatient,test,room where inpatient.id= '"+patientID+"' and " +
                    "inpatient.test_no = test.test_no and inpatient.room_id = room.room_id";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                arrival_date = String.valueOf(rs.getDate("arrival_date"));
                discharge_date = String.valueOf(rs.getDate("discharge_date"));
                disease = rs.getString("disease");
                room_type = rs.getString("room_type");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        request.setAttribute("arrival_date",arrival_date);
        request.setAttribute("discharge_date",discharge_date);
        request.setAttribute("disease",disease);
        request.setAttribute("room_type",room_type);

        request.getRequestDispatcher("isInpatient.jsp").forward(request, response);








    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
