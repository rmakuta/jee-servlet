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
//
//        Map<String, String> quiz = (Map<String, String>) session.getAttribute("quiz");
//        int correctAnswer = 0;
//        for (Map.Entry<String, String> entry : quiz.entrySet()) {
//            resp.getWriter().println("<form action='' method='get'>");
//            resp.getWriter().println("Podaj stolicę państwa dla: " + entry.getKey());
//            resp.getWriter().println("<input type='text' name='country'>");
////            resp.getWriter().println("<input type='submit' value='wyślij'>");
//            resp.getWriter().println("</form>");
//            if(req.getParameter("country").equals(entry.getValue())){
//                resp.getWriter().println("Dobrze!");
//                correctAnswer++;
//            }else {
//                resp.getWriter().println("Błąd!");
//            }
//            resp.getWriter().println("Poprawnych dpowiedzi: " + correctAnswer);
//        }
//
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();
//        if (session.getAttribute("quiz") == null) {
//            Map<String, String> quiz = new HashMap<>();
//            quiz.put("Niemcy", "Berlin");
//            quiz.put("Czechy", "Praga");
//            quiz.put("Słowacja", "Bratysława");
//            quiz.put("Ukraina", "Kijów");
//            session.setAttribute("quiz", quiz);
//        }

        Map<String, String> quiz = (Map<String, String>) session.getAttribute("quiz");
        int correctAnswer = 0;
        for (Map.Entry<String, String> entry : quiz.entrySet()) {
            resp.getWriter().println("<form action='' method='post'>");
            resp.getWriter().println("Podaj stolicę państwa dla: " + entry.getKey());
            resp.getWriter().println("<input type='text' name='country'>");
//            resp.getWriter().println("<input type='submit' value='wyślij'>");
            resp.getWriter().println("</form>");
            if(req.getParameter("country").equals(entry.getValue())){
                resp.getWriter().println("Dobrze!");
                correctAnswer++;
            }else {
                resp.getWriter().println("Błąd!");
            }
            resp.getWriter().println("Poprawnych dpowiedzi: " + correctAnswer);
        }
    }
}
