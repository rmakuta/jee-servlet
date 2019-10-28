package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/sess07")
public class Sess07 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Random random = new Random();

        HttpSession session = req.getSession();
        session.setAttribute("x", random.nextInt(981)+20);
        session.setAttribute("y", random.nextInt(981)+20);

        PrintWriter out = resp.getWriter();

        out.println("<form action='/sess07' method='post'>");
        out.println("<p>" + session.getAttribute("x") + " + " + session.getAttribute("y") +
                " = <input type='number' name='sum'></p>");
        out.println("<p>" + session.getAttribute("x") + " - " + session.getAttribute("y") +
                " = <input type='number' name='sub'></p>");
        out.println("<p>" + session.getAttribute("x") + " * " + session.getAttribute("y") +
                " = <input type='number' name='ratio'></p>");
        out.println("<input type='submit' value='wyślij'>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession();
        int x = (int) session.getAttribute("x");
        int y = (int) session.getAttribute("y");

        PrintWriter out = resp.getWriter();

        out.print("<p>" + x + " + " + y + " = " + req.getParameter("sum"));
        if(Integer.parseInt(req.getParameter("sum")) == (x+y)) {
            out.println(" Correct</p>");
        }else {
            out.println(" Wrong</p>");
        }
        out.print("<p>" + x + " - " + y + " = " + req.getParameter("sub"));
        if(Integer.parseInt(req.getParameter("sub")) == x-y) {
            out.println(" Correct</p>");
        }else {
            out.println(" Wrong</p>");
        }
        out.print("<p>" + x + " * " + y + " = " + req.getParameter("ratio"));
        if(Integer.parseInt(req.getParameter("ratio")) == x*y) {
            out.println(" Correct</p>");
        }else {
            out.println(" Wrong</p>");
        }
    }
}
