package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet31")
public class Servlet31 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double amount = Double.parseDouble(req.getParameter("amount"));
        String option = req.getParameter("converter");

        switch (option){
            case "EUR-USD": resp.getWriter().printf(amount + " EUR = %.2f USD", (amount * 1.1201));break;
            case "USD-EUR": resp.getWriter().printf(amount + " USD = %.2f EUR", (amount * 0.89275));break;
            case "EUR-PLN": resp.getWriter().printf(amount + " EUR = %.2f PLN", (amount * 4.42663));break;
            case "PLN-EUR": resp.getWriter().printf(amount + " PLN = %.2f EUR", (amount * 0.234403));break;
            case "USD-PLN": resp.getWriter().printf(amount + " USD = %.2f PLN", (amount * 3.8065));break;
            case "PLN-USD": resp.getWriter().printf(amount + " PLN = %.2f USD", (amount * 0.262671));
        }
    }
}
