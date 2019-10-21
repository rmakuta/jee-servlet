package pl.makuta.day_02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@WebServlet("/servlet23")
public class Servlet23 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:\\Dysk Google\\GoogleCloud\\dev\\CodersLab\\Java Developer Web_bootcamp\\workspace\\_03_arch_zrobione\\03_04_Jee-servlet\\src\\main\\java\\pl\\makuta\\day_02\\oop.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()){
                resp.getWriter().println(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            e.getMessage();
        }
    }
}
