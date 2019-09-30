import classForProcessing.LogIn;

import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet("/servlet1")*/
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        LogIn logIn = new LogIn();
        /*HttpSession session = request.getSession(true);
        Cookie[] cookies = request.getCookies();*/
        String login = "";
        String password = "";
        Boolean haveCookey;
        haveCookey = logIn.checkCookies(request,response,login,password);
        if (haveCookey) {
            login = (String) request.getAttribute("login");
            password = (String) request.getAttribute("password");
        }
        /*if (cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login"))
                    login = cookie.getValue();
                if (cookie.getName().equals("password"))
                    password = cookie.getValue();
            }
            request.setAttribute("login", login);
            request.setAttribute("password", password);
        }*/

        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method=\"post\" action=\"/servlet2\">\n" +
                "          Login<input type=\"text\" name=\"login\" value=\"" + login + "\">\n" +
                "          Password<input name=\"password\" type=\"text\" value=\""+password+"\" >\n" +
                "          Remember me<input type=\"checkbox\" name=\"name\">\n" +
                "          <input type=\"submit\" value=\"Log in\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}

