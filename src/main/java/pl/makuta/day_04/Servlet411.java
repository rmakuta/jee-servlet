package pl.makuta.day_04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/servlet411")
public class Servlet411 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        Map<String, String> languages = new HashMap<>();
        languages.put("en", "Hello!");
        languages.put("pl", "Cześć!");
        languages.put("de", "Ehre!");
        languages.put("es", "Hola!");
        languages.put("fr", "Bienvenue!");

        req.setAttribute("languages", languages);
        getServletContext().getRequestDispatcher("/index411.jsp").forward(req, resp);
    }
}
