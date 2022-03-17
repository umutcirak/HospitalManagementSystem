import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "makeAppointmentServlet")
public class makeAppointmentServlet extends HttpServlet {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    static final String USER = "root";
    static final String PASS = "644Uc644.";

    static Statement stmt = null ;
    static Connection myconn = null;
    static PreparedStatement myprepst = null;
    static ResultSet rs = null;


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String patientID = session.getAttribute("patientID").toString();
        String department = request.getParameter("department").toString();
        String month = request.getParameter("month").toString();
        String day1 = request.getParameter("day1").toString();
        String day2 = request.getParameter("day2").toString();
        String hour1 = request.getParameter("hour1").toString();
        String hour2 = request.getParameter("hour2").toString();
        String monthINT ="";

        if(month.equals("January")){
            monthINT = "01";
        }
        else if(month.equals("February")){
            monthINT = "02";
        }
        else if(month.equals("March")){
            monthINT = "03";
        }
        else if(month.equals("April")){
            monthINT = "04";
        }
        else if(month.equals("May")){
            monthINT = "05";
        }
        else if(month.equals("June")){
            monthINT = "06";
        }
        else if(month.equals("July")){
            monthINT = "07";
        }
        else if(month.equals("August")){
            monthINT = "08";
        }
        else if(month.equals("September")){
            monthINT = "09";
        }
        else if(month.equals("October")){
            monthINT = "10";
        }
        else if(month.equals("November")){
            monthINT = "11";
        }
        else if(month.equals("December")){
            monthINT = "12";
        }

        String doctor_id = "doctor_id";
        String doctor_name ="doctor_name";
        String doctor_surname ="doctor_surname";
        String doctor_department = "doctor_department";
        String available_hours = "available_hours";
        String available_dates = "available date";
        String doctor_ranking = "doctor_ranking";

        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        try {

            myconn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = myconn.createStatement();
            String sql = "select * from user,doctor,department where department.dept_name = '" + department+ "'"  +" and "
                    + "department.dept_id = doctor.dept_id "+" and "+ "user.id = doctor.id";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                doctor_id = rs.getString("id");
                doctor_name = rs.getString("name");
                doctor_surname = rs.getString("surname");
                doctor_department = rs.getString("dept_name");
                available_hours = rs.getTime("available_hours").toString();
                available_dates = rs.getDate("available_dates").toString();
                doctor_ranking = rs.getString("ranking");
                Doctor doctor = new Doctor(doctor_id,doctor_name,doctor_surname,doctor_department,available_hours,available_dates,doctor_ranking);
                doctors.add(doctor);
            }

             String monthDoctor;

             String dayDoctor;
             int dayDoctorInt ;

             String hourDoctor ;
             double hourDoctorDouble;

             int day1INT = Integer.parseInt(day1);
             int day2INT = Integer.parseInt(day2);

             double hour1DOUBLE = Double.parseDouble(hour1);
             double hour2DOUBLE = Double.parseDouble(hour2);


            for (int i = 0; i <doctors.size() ; i++) {
                monthDoctor = doctors.get(i).getAvailable_dates().substring(5,7);
                 dayDoctor = doctors.get(i).getAvailable_dates().substring(8,10);
                dayDoctorInt = Integer.parseInt(dayDoctor);
                 String a = doctors.get(i).getAvailable_hours();
                hourDoctor = a.substring(0,2)+"."+a.substring(3,5);
                hourDoctorDouble = Double.parseDouble(hourDoctor);
                if(!(monthINT.equals(monthDoctor) && (day1INT <= dayDoctorInt && dayDoctorInt <= day2INT) &&
                        (hour1DOUBLE <= hourDoctorDouble && hour2DOUBLE >= hourDoctorDouble))){
                                        doctors.remove(i);
                }else {
                }


            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        ArrayList<Doctor> deneme = new ArrayList<Doctor>();
        Doctor denemedoc = new Doctor("76497327104","Umut","Cirak",
                "Neurology","15:30:00","2019-09-28","Prof");
        Doctor denemedoc2 = new Doctor("12345678912","Eray","Erdogan",
                "Cardiology","19:30:00","2019-12-21","Asistant");
        Doctor denemedoc3 = new Doctor("11111111111","Suleyman","Yalcin",
                "Dermatology","02:00:00","2025-10-08","Pro");
        deneme.add(denemedoc) ;
        deneme.add(denemedoc2);
        deneme.add(denemedoc3);
        ArrayList<String> idler = new ArrayList<String>();
        ArrayList<String> nameler = new ArrayList<String>();
        ArrayList<String> surnameler = new ArrayList<String>();
        ArrayList<String> departmentler = new ArrayList<String>();
        ArrayList<String> saatler = new ArrayList<String>();
        ArrayList<String> dateler = new ArrayList<String>();
        ArrayList<String> rankingler = new ArrayList<String>();
        for (Doctor d : deneme ) {
            idler.add(d.getDoctor_id());
            nameler.add(d.getName());
            surnameler.add(d.getSurname());
            departmentler.add(d.getDepartment());
            saatler.add(d.getAvailable_hours());
            dateler.add(d.getAvailable_dates());
            rankingler.add(d.getRanking());
        }
        session.setAttribute("idler",idler);
        session.setAttribute("nameler",nameler);
        session.setAttribute("surnameler",surnameler);
        session.setAttribute("departmentler",departmentler);
        session.setAttribute("saatler",saatler);
        session.setAttribute("dateler",dateler);
        session.setAttribute("rankingler",rankingler);
        response.sendRedirect("makeAppointment2.jsp");

    }


    }
