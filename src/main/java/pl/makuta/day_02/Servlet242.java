package pl.makuta.day_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet242")
public class Servlet242 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String products[] = {
                "Asus Transformr;2999.99",
                "iPhone 6';3499.18",
                "Converse Sneakers;125.00",
                "LG OLED55B6P OLED TV;6493.91",
                "Samsung HT-J4100;800.99",
                "Alpine Swiss Dress Belt;99.08",
                "60 Watt LED;1.50",
                "Arduino Nano;3.26",
        };

        int id = Integer.parseInt(req.getParameter("id"));
        if(id < 0 || id >= products.length){
            resp.getWriter().println("Product not found");
        }else {
            for(int i=0; i<products.length; i++){
                if(i == id){
                    resp.getWriter().println(products[i]);
                }
            }
        }
    }
}
