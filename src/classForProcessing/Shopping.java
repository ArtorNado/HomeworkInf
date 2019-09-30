package classForProcessing;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shopping {

    HttpServletRequest request;
    HttpServletResponse response;
    PrintWriter out;

    public void createTable(HttpServletRequest request, HttpServletResponse response, PrintWriter out, HttpSession session) {
        this.request = request;
        this.response = response;
        this.out = out;
        if(session.getAttribute("ids") != null) {
            for (Integer i = 0; i <= (Integer) session.getAttribute("ids"); i++) {
                out.print("<table style=\"border-width: 10; width: 280; border-style: ridge double groove solid\">\n" +
                        "<tbody>" +
                        "<style>\n"+
                        "table {\n"+
                        "  width: 500px;\n" +
                        "height: 10px;\n" +
                        "}\n"+
                        "</style>\n"+
                        "<tr>\n"+
                            "<td>"+ session.getAttribute(i.toString()) +"</td>\n"+
                        "</tr>\n"+
                        "</tbody>\n"+
                        "</table>");
            }
        }
    }
    public void addItem(String name, HttpSession session){
        if(session.getAttribute("ids") == null) {
            session.setAttribute("ids", 0);
        }
        int id = (Integer) session.getAttribute("ids") + 1;
        session.setAttribute("ids",id);
        session.setAttribute(session.getAttribute("ids").toString(), name);
    }
}
