package pl.makuta.day_04.newsletter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newsletter")
public class Newsletter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/newsletter.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Cookie cookie = new Cookie("user", req.getParameter("email"));
        cookie.setMaxAge(10);
        resp.addCookie(cookie);

        User user = new User(req.getParameter("email"), req.getParameter("name"));
        UserDao userDao = new UserDao();
        userDao.create(user);
        resp.sendRedirect("/newsletter.jsp");
    }
}
