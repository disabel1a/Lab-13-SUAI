package jettyservlet;

import model.Notebook;
import model.NotebookWorkWithFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class MainServlet extends HttpServlet {
    private Notebook notebook;
    private File dataBase;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dataBase = new File("src/main/java/data/data_base");
        try {
            notebook = new NotebookWorkWithFile(dataBase).loadFromTextFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pageView = resp.getWriter();
        pageView.println("<html>\n<body>\n");
        pageView.println(mainPageView());
        pageView.println("</body>\n</html>\n");
        //resp.getWriter().write("Method doGet\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number, name, additNumber = null;
        name = req.getParameter("name");
        number = req.getParameter("number");
        additNumber = req.getParameter("additNumber");

        if(name != null && number != null && additNumber == null) {
            notebook.addNote(name, number);
            new NotebookWorkWithFile(dataBase).saveToTextFile(notebook);
        } else if(name != null && additNumber != null){
            notebook.addNumber(name, additNumber);
            new NotebookWorkWithFile(dataBase).saveToTextFile(notebook);
        }

        PrintWriter pageView = resp.getWriter();
        pageView.println("<html>\n<body>\n");
        pageView.println(mainPageView());
        pageView.println("</body>\n</html>\n");

    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private String mainPageView() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Your Notebook</h1>")
                .append("<br>")
                .append("<form method=\"post\" action=\"/my-app/static/form.html\">" +
                        "<button type=\"send\">Add a new note</button>" +
                        "</form>")
                .append("<br>")
                .append("<br>");
        sb.append(notebook.toHTMLString());
        return sb.toString();
    }
}
