package pl.makuta.day_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@WebServlet("/servlet25")
public class Servlet25 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i=0; i<numbers.length; i++){
            numbers[i] = random.nextInt(101);
        }

        for (int n: numbers){
            resp.getWriter().print("[" + n + "] ");
        }

        Arrays.sort(numbers);

        resp.getWriter().println("\n");

        for (int n: numbers){
            resp.getWriter().print("[" + n + "] ");
        }
    }
}
