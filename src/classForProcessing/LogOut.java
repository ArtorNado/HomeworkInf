package classForProcessing;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LogOut {

    public void deleteSessionCookies(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response){
        HttpSession session = request.getSession();
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
    }

}
