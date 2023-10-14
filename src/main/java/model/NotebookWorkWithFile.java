package model;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class NotebookWorkWithFile {
    private Notebook notebook;
    private final File dataBase;

    public NotebookWorkWithFile(File file) throws IOException {
        this.notebook = new Notebook();
        this.dataBase = file;
    }

    public Notebook loadFromTextFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(dataBase));
        String numbers, name;
        String[] line;
        PhoneNumbers pn;
        while (reader.ready()) {
            line = reader.readLine()
                    .trim()
                    .split(" / ", 2);
            name = line[0];
            numbers = line[1];
            line = numbers.split(", ");

            notebook.addNote(name, null);
            pn = notebook.getPhoneNumbers(name);
            for(String s : line) {
                if(pn.getNumbers().get(0) == null)
                    pn.getNumbers().set(0, s);
                else
                    pn.addNumber(s);
            }
        }
        reader.close();
        return notebook;
    }

    public void saveToTextFile(Notebook notebook) throws IOException{
        this.notebook = notebook;
        FileWriter writer = new FileWriter(dataBase);
        for(Map.Entry<String, PhoneNumbers> entry : notebook.getNotebook().entrySet()) {
            String note = entry.getKey() + " / " + entry.getValue().toString() + "\n";
            writer.write(note);
        }
        writer.close();
    }
}
