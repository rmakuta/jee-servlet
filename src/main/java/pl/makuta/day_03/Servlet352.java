package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/servlet352")
public class Servlet352 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        HttpSession session = req.getSession();

        PrintWriter out = resp.getWriter();
        float sum = 0;

        List<Product> basket = (List<Product>) session.getAttribute("basket");
        for(Product p: basket){
            out.println(p.getName() + " - " + p.getQuantity() + " x " + p.getPrice() + "zł = " + p.getQuantity()*p.getPrice() + "zł");
            sum += (p.getQuantity()*p.getPrice());
        }
        out.println("                  SUMA: " + sum + "zł");
    }
}
