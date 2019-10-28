package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/rememberMe")
public class Cookie6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;cahrset=UTF-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        String name = "";
        boolean isCookie = false;
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("name")){
                isCookie = true;
                name = cookie.getValue();
            }
        }

        if(isCookie){
            out.println("Cześć " + name + "! Twoje dane zostały wczytane z ciasteczka.");
        }else {
            out.println("<form action='/rememberMe' method='post'>");
            out.println("Imię: <input type='text' name='name'>");
            out.println("<input type='checkbox' name='check' value='yes'>Zapamiętaj mnie.");
            out.println("<input type='submit' value='wyślij'>");
            out.println("</form>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;cahrset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("Cześć " + req.getParameter("name") + "!");
        if(req.getParameter("check").equals("yes")){
            Cookie cookie = new Cookie("name", req.getParameter("name"));
            cookie.setMaxAge(5);
            resp.addCookie(cookie);
        }
    }
}
