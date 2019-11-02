package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet("/sess08")
public class Sess08 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();
        if (session.getAttribute("quiz") == null) {
            Map<String, String> quiz = new HashMap<>();
            quiz.put("Niemcy", "Berlin");
            quiz.put("Czechy", "Praga");
            quiz.put("Słowacja", "Bratysława");
            quiz.put("Ukraina", "Kijów");
            session.setAttribute("quiz", quiz);
        }

        Map<String, String> quiz = (Map<String, String>) session.getAttribute("quiz");
        List<String> k = new ArrayList<>(quiz.keySet());
        if(session.getAttribute("correctAnswer") == null){
            session.setAttribute("correctAnswer", 0);
        }
        if(session.getAttribute("count") == null){
            session.setAttribute("count", 0);
        }

        resp.getWriter().println("<form action='' method='post'>");
        resp.getWriter().println("Podaj stolicę państwa dla: " + k.get((int) session.getAttribute("count")));
        resp.getWriter().println("<input type='hidden' name='country' value=entry.getKey()>");
        resp.getWriter().println("<input type='hidden' name='correctCapital' value=capital>");
        resp.getWriter().println("<input type='text' name='capital'>");
        resp.getWriter().println("<input type='submit' value='wyślij'>");
        resp.getWriter().println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        Map<String, String> quiz = (Map<String, String>) session.getAttribute("quiz");
        List<String> v = new ArrayList<>(quiz.values());
        List<String> k = new ArrayList<>(quiz.keySet());
        int x = (int) session.getAttribute("count");

        resp.getWriter().println("<form action='' method='get'>");
//        resp.getWriter().println(req.getParameter("capital") + " = " + v.get(x));
        if(req.getParameter("capital").equals(v.get(x))){
            resp.getWriter().println("Dobrze! " + req.getParameter("capital") + " jest stolicą państwa " + k.get(x) + ".");
            int correctAnswer = (int) session.getAttribute("correctAnswer");
            session.setAttribute("correctAnswer", ++correctAnswer);
        }else {
            resp.getWriter().println();
            resp.getWriter().println("Błąd! " + req.getParameter("capital") + " nie jest stolicą państwa " + k.get(x) + ".");
        }
        resp.getWriter().println("<input type='submit' value='oK!'>");
        resp.getWriter().println("</form>");

        session.setAttribute("count", ++x);

        if((int) session.getAttribute("count") == quiz.size()){
            resp.getWriter().println("Poprawnych odpowiedzi: " + session.getAttribute("correctAnswer"));
            session.setAttribute("count", 0);
            session.setAttribute("correctAnswer", 0);
        }
    }
}
