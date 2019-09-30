import classForProcessing.Shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Servlet4")
public class Servlet4 extends HttpServlet {
    ArrayList<String> items = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Shopping shopping = new Shopping();
        if(request.getParameter("addItem") != null){
            shopping.addItem(request.getParameter("addItem"), session);
            /*System.out.println(request.getParameter("addItem"));
            items = shopping.addItem(request.getParameter("addItem"), items);
            System.out.println("sise "+ items);*/
        }
        out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    " <meta charset=\"UTF-8\">\n" +
                    " <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</form>\n" +
                    "<form method=\"post\" action=\"/servlet4\">\n" +
                    "<input type=\"text\" name=\"addItem\">\n" +
                    "          <input type=\"submit\" value=\"add Item\">" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");
        shopping.createTable(request,response,out, session);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
