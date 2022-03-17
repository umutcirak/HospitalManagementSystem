import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        // email password kontrol edildi. patient çıktı
        // hastanın id(TC) sine ,adına ve soyadına ulaşıldı.
        String id = "35974057910";
        String name ="Umut";
        String surname ="Cirak";
        HttpSession session = request.getSession();
        session.setAttribute("id",id);
        session.setAttribute("name",name);
        session.setAttribute("surname",surname);
        response.sendRedirect("patient.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
