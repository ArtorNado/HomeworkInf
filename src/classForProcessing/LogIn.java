package classForProcessing;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class LogIn {

    public boolean checkCookies(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String login, String password){
        HttpSession session = request.getSession(true);
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login"))
                    login = cookie.getValue();
                if (cookie.getName().equals("password"))
                    password = cookie.getValue();
            }
            request.setAttribute("login", login);
            request.setAttribute("password", password);
        }
        return (cookies.length>0);
    }

}
