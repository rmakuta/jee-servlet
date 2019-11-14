package pl.makuta.day_04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet412")
public class Servlet412 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("language", req.getParameter("language"));
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
        getServletContext().getRequestDispatcher("/index411.jsp").forward(req, resp);
    }
}
