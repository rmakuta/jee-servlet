package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet34")
public class Servlet34 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        Boolean isCoockie = false;

        Cookie[] cookies = req.getCookies();
        for(Cookie c: cookies){
            if(c.getName().equalsIgnoreCase("visits")){
                isCoockie = true;
            }
        }

        if(isCoockie){
            for(Cookie c: cookies){
                if(c.getName().equalsIgnoreCase("visits")){
                    out.println("Witaj, odwiedziłeś nas już " + c.getValue() + " razy");
                    Integer n = Integer.parseInt(c.getValue());
                    c.setValue(Integer.toString(++n));
                    resp.addCookie(c);
                }
            }
        }else {
            out.println("Witaj pierwszy raz na naszej stronie.");
            Cookie cookie = new Cookie("visits", "1");
            cookie.setMaxAge(60*60*24*366);
            resp.addCookie(cookie);
        }
    }
}
