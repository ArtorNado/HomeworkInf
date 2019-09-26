import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet("/servlet3")*/
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        out.print("Good Bye");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Cookie cookieLogin = new Cookie("login", login);
        cookieLogin.setMaxAge(0);
        cookieLogin.setPath("/");
        response.addCookie(cookieLogin);
        Cookie cookiePassword = new Cookie("password", password);
        cookiePassword.setMaxAge(0);
        cookieLogin.setPath("/");
        response.addCookie(cookiePassword);
        session.invalidate();
        response.setContentType("text/html;charset=utf-8");
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"get\" action=\"/servlet\">\n" +
                "          <input type=\"submit\" value=\"Return to regist page\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
