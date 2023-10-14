package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Notebook {
    private Map<String, PhoneNumbers> notebook;

    public Notebook() {
        this.notebook = new HashMap<>();
    }

    public Map<String, PhoneNumbers> getNotebook() {
        return notebook;
    }

    public void setNotebook(Map<String, PhoneNumbers> notebook) {
        this.notebook = notebook;
    }

    public PhoneNumbers getPhoneNumbers(String name) {
        return notebook.get(name);
    }

    public void addNote(String name, String number) {
        PhoneNumbers pn = new PhoneNumbers();
        pn.addNumber(number);
        notebook.put(name, pn);
    }

    public void addNumber(String name, String number) {
        notebook.get(name).addNumber(number);
    }

    public String toHTMLString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, PhoneNumbers> entry : notebook.entrySet()) {
            sb.append("<p>Name: ")
                    .append(entry.getKey())
                    .append("</p>\n<p>")
                    .append("Phone number/s: ")
                    .append(entry.getValue().toString())
                    .append("<form method=\"post\" action=\"/my-app/add-number\">\n" +
                            "        <button name=\"name\" value=\"" + entry.getKey() + "\" type=\"submit\">Add number</button>\n" +
                            "</form>")
                    .append("</p>\n");
        }
        return sb.toString();
    }
}
