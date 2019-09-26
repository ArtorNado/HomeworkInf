import classForServlets.Profile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
@WebServlet("/servlet2")*/
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Profile profile = new Profile();
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("auth", login);
        String[] value = request.getParameterValues("name");
        if (value != null) {
            if (value[0].equals("on")) {
                profile.createCookies(request,response,login,password);
                /*Cookie cookieLogin = new Cookie("login", login);
                cookieLogin.setMaxAge(24 * 60 * 60 * 30);
                Cookie cookiePassword = new Cookie("password", password);
                cookiePassword.setMaxAge(24 * 60 * 60 * 30);
                response.addCookie(cookieLogin);
                response.addCookie(cookiePassword);*/
            }
        }
        if (login.equals("admin")) {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    " <meta charset=\"UTF-8\">\n" +
                    " <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> Profile:\n" + session.getAttribute("auth") +
                    "<form method=\"post\" action=\"/servlet3\">\n" +
                    "          <input type=\"submit\" value=\"Log out\">\n" +
                    "    </form>\n" +
                    "</body>\n" +
                    "</html>");
        } else {
            String path = "http://localhost:8082/servlet";
            response.sendRedirect(path);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

