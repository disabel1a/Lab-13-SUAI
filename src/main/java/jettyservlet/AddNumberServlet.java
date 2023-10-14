package jettyservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add-number")
public class AddNumberServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter pageView = resp.getWriter();
        String name = req.getParameter("name");
        pageView.append("<html>\n<body>\n")
                .append("<h1>Add a note</h1>")
                .append("<br>")
                .append("<label>" + name + " numbers</label>")
                .append("<br>")
                .append("<form method=\"post\" action=\"/my-app/my-servlet\">")
                .append("<label>")
                .append("<input name=\"additNumber\">\n" +
                        "        - New Phone number\n" +
                        "        <br>\n" +
                        "        <button name=\"name\" value=\"" + name + "\" type=\"submit\">Send</button>")
                .append("</label>")
                .append("</form>\n</body>\n</html>");*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pageView = resp.getWriter();
        String name = req.getParameter("name");
        pageView.append("<html>\n<body>\n")
                .append("<h1>Add a note</h1>")
                .append("<br>")
                .append("<label>" + name + "</label>")
                .append("<br>")
                .append("<form method=\"post\" action=\"/my-app/my-servlet\">")
                .append("<label>")
                .append("<input name=\"additNumber\">\n" +
                        "        - New Phone number\n" +
                        "        <br>\n" +
                        "        <button name=\"name\" value=\"" + name + "\" type=\"submit\">Send</button>")
                .append("</label>")
                .append("</form>\n</body>\n</html>");
    }
}
