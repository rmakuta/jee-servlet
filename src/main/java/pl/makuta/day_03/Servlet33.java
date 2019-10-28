package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet33")
public class Servlet33 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        resp.getWriter().print("<form action='/servlet33' method='post'>");
        for(int i = 1; i <= 5; i++){
            if(session.getAttribute("text"+i) != null) {
                out.println("<input type='text' name='text" + i + "' value='" +
                        session.getAttribute("text"+i) + "'></br>");
            }else{
                out.println("<input type='text' name='text" + i + "'></br>");
            }
        }
        out.println("<input type='submit' value='wyślij'>");
        out.print("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();

        for(int i = 1; i <= 5; i++){
            session.setAttribute("text"+i, req.getParameter("text"+i));
        }
    }
}
