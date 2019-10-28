package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet36")
public class Servlet36 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        String[] num = req.getParameterValues("num");
        int[] numInt = new int[num.length];

        for(int i =0; i<num.length; i++){
            numInt[i] = Integer.parseInt(num[i]);
        }

        int sum = 0;
        int ratio = 1;

        out.println("Liczby:");
        for(int i = 0; i < numInt.length; i++){
            sum += numInt[i];
            ratio *= numInt[i];
            out.println("  - " + numInt[i]);
        }

        out.println("Średnia:");
        out.println("  - " + (sum/numInt.length));
        out.println("Suma:");
        out.println("  - " + sum);
        out.println("Iloczyn:");
        out.println("  - " + ratio);
    }
}
