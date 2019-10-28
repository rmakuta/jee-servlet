package pl.makuta.day_03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet32")
public class Servlet32 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain;charset=UTF-8");

        String bin = req.getParameter("bin");
        char[] binCharTab = bin.toCharArray();

        for(char b: binCharTab){
            if(b != '1' && b != '0'){
                for(char c: binCharTab){
                    resp.getWriter().print(c);
                }
                resp.getWriter().println(" nie jest prawidłową wartościa binarną.");
                return;
            }
        }

        int[] binIntTab = new int[binCharTab.length];
        for(int i = 0; i < binCharTab.length; i++){
            binIntTab[i] = Character.getNumericValue(binCharTab[i]);
        }

        int dec = 0;
        for(int i = binIntTab.length-1, j = 0; i >= 0; i--, j++){
            if(binIntTab[i] != 0){
                dec += Math.pow(2,j);
            }
        }

        for(char c: binCharTab){
            resp.getWriter().print(c);
        }
        resp.getWriter().print(" = " + dec);
    }
}
