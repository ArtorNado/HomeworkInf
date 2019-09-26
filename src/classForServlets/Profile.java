package classForServlets;

import javax.servlet.http.Cookie;

public class Profile {

    public  void createCookies(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, String login, String password){
        Cookie cookieLogin = new Cookie("login", login);
        cookieLogin.setMaxAge(24 * 60 * 60 * 30);
        Cookie cookiePassword = new Cookie("password", password);
        cookiePassword.setMaxAge(24 * 60 * 60 * 30);
        response.addCookie(cookieLogin);
        response.addCookie(cookiePassword);
    }


}
