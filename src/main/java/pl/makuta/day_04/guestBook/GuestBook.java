package pl.makuta.day_04.guestBook;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebServlet("/guest-book")
public class GuestBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PostDao postDao = new PostDao();
        List<Post> posts = Arrays.asList(postDao.findAll(getServletContext().getInitParameter("user"),
                getServletContext().getInitParameter("password")));
        Collections.reverse(posts);
        req.setAttribute("posts", posts);
        getServletContext().getRequestDispatcher("/guest_book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        PostDao postDao = new PostDao();
        Post post = new Post(req.getParameter("title"), req.getParameter("description"));
        postDao.create(post, getServletContext().getInitParameter("user"), getServletContext().getInitParameter("password"));
        List<Post> posts = Arrays.asList(postDao.findAll(getServletContext().getInitParameter("user"),
                getServletContext().getInitParameter("password")));
        Collections.reverse(posts);
        req.setAttribute("posts", posts);
        getServletContext().getRequestDispatcher("/guest_book.jsp").forward(req, resp);
    }
}
