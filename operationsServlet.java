import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "operationsServlet")
public class operationsServlet extends HttpServlet {

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

        ArrayList<String> oppIDler = new ArrayList<String>();
        ArrayList<String> oppNameler = new ArrayList<String>();
        ArrayList<String> oppDoctNameler = new ArrayList<String>();
        ArrayList<String> oppDoctSurnameler = new ArrayList<String>();
        ArrayList<String> oppNurseNameler = new ArrayList<String>();
        ArrayList<String> oppNurseSurnameler = new ArrayList<String>();
        ArrayList<String> oppRoomTypeler = new ArrayList<String>();
        ArrayList<String> oppDateler = new ArrayList<String>();
        ArrayList<String> oppTimeler = new ArrayList<String>();
        ArrayList<String> doctRankingler = new ArrayList<String>();

        /*

        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select operation_id,operation.name as op_name , user.name as doc_name," +
                    "user.surname as doc_surname,ranking,operation_date,operation_time from operation,doctor," +
                    "user where operation.patient_id = '"+patientID+"' and " +
                    "operation.doctor_id = user.id and doctor.id = user.id";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                oppIDler.add(rs.getString("operation_id"));
                oppNameler.add(rs.getString("op_name"));
                oppDoctNameler.add(rs.getString("doc_name"));
                oppDoctSurnameler.add(rs.getString("doc_surname"));
                doctRankingler.add(rs.getString("ranking"));
                oppDateler.add(String.valueOf(rs.getDate("operation_date")));
                oppTimeler.add(String.valueOf(rs.getTime("operation_time")));
            }
            ResultSet rs2 ;
            String sql2 = "select user.name as nurse_name , user.surname as nurse_surname " +
                    "from user,nurses,appointments " +
                    "where appointments.patient_id = '"+patientID+"' and user.id = nurses.id";

            rs2 = stmt.executeQuery(sql2);
            while (rs2.next()) {
                oppNurseNameler.add(rs.getString("nurse_name"));
                oppNurseSurnameler.add(rs.getString("nurse_surname"));
            }
            ResultSet rs3 ;
            String sql3 = "select room_type from operation,room " +
                    "where operation.patient_id = '"+patientID+"' and room.room_id = operation.operation_room_id";
            rs3 = stmt.executeQuery(sql3);
            while (rs3.next()) {
                oppRoomTypeler.add(rs.getString("room_type"));
            }


        } catch (Exception exc) {
            exc.printStackTrace();
        }

         */


        oppIDler.add("sasfsaf");
        oppNameler.add("dasdsad");

        request.setAttribute("oppIDler",oppIDler);
        request.setAttribute("oppNameler",oppNameler);
        request.setAttribute("oppDoctNameler",oppDoctNameler);
        request.setAttribute("oppDoctSurnameler",oppDoctSurnameler);
        request.setAttribute("oppNurseNameler",oppNurseNameler);
        request.setAttribute("oppNurseSurnameler",oppNurseSurnameler);
        request.setAttribute("oppRoomTypeler",oppRoomTypeler);
        request.setAttribute("oppDateler",oppDateler);
        request.setAttribute("oppTimeler",oppTimeler);
        request.setAttribute("doctRankingler",doctRankingler);

        request.getRequestDispatcher("operations.jsp").forward(request, response);








    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
