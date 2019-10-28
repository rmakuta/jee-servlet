package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/servlet351")
public class Servlet351 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<form action='/servlet351' method='post'>");
        out.println("<p>Nazwa:<input type='text' name='name'>Ilość:<input type='number' name='quantity'>" +
                "Cena:<input type='number' name='price'><input type='submit' value='zamów'></p>");
        out.println("</form>");
        out.println("<a href='/servlet352'>koszyk</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        Product product = new Product(req.getParameter("name"), Integer.parseInt(req.getParameter("quantity")),
                Float.parseFloat(req.getParameter("price")));

        HttpSession session = req.getSession();

        if(session.getAttribute("basket") == null){
            session.setAttribute("basket", new ArrayList<Product>());
        }

        List<Product> basket = (List<Product>) session.getAttribute("basket");
        basket.add(product);
        session.setAttribute("basket", basket);

        out.println("<form action='/servlet351' method='post'>");
        out.println("<h3>Produkt dodano.</h3>");
        out.println("<p>Nazwa:<input type='text' name='name'>Ilość:<input type='number' name='quantity'>" +
                "Cena:<input type='number' name='price'><input type='submit' value='zamów'></p>");
        out.println("</form>");
        out.println("<a href='/servlet352'>koszyk</a>");

    }
}
