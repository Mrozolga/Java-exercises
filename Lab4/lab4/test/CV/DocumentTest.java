package CV;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DocumentTest {
    @org.junit.Test
    public void setTitle() throws Exception {
        String exp_title = "Anna Kowalska";
        Document dokument = new Document();
        dokument.setTitle("Anna Kowalska");
        assertEquals(dokument.title, exp_title);
    }

    @org.junit.Test
    public void addPhoto() throws Exception {
        String exp_photo = "http://image.com";
        Document dokument = new Document();
        dokument.addPhoto("http://image.com");
        assertEquals(dokument.photo.url, exp_photo);
    }

    @org.junit.Test
    public void addSection() throws Exception {
        String exp_section = "section";
        Document dokument = new Document();
        dokument.addSection("section");
        assertEquals(dokument.sections.get(0).title, exp_section);
    }

    @org.junit.Test
    public void addSection1() throws Exception {
        String exp_section = "section";
        Document dokument = new Document();
        Section section = new Section("section");
        dokument.addSection(section);
        assertEquals(dokument.sections.get(0).title, exp_section);
    }

    @org.junit.Test
    public void writeHTML() throws Exception {
        Document cv = new Document("Olga Mrozowicz - CV");
        Section sekcja = new Section ("Umiejętności");
        sekcja.addParagraph("siatkówka");
        cv.addSection(sekcja);
        String exp="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                               "<head>\n" +
                               "<title>"+cv.title+"</title>\n"+
                               "</head>\n" +
                               "<body>"+"<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/SNice.svg/1200px-SNice.svg.png\" alt=\"Smiley face\" "+
                "height=\"42\" width=\"42\"/>\n\n"+
                "<h1>"+sekcja.title+"</h1>\n"+"\n<p>"+sekcja.paragraphs.get(0).content+"</p>\n\n\n</body>\n</html>";

        PrintStream out = new PrintStream("exp.html");
        PrintStream out2 = new PrintStream("exp1.html");
        cv.writeHTML(out);
        out2.printf(exp);
        FileReader fileReader = new FileReader("exp.html");
        FileReader fileReader2 = new FileReader("exp1.html");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        String textLine, textLine2;
        do {
            textLine = bufferedReader.readLine();
            textLine2=bufferedReader2.readLine();
            assertEquals(textLine, textLine2);
        } while(textLine != null && textLine2 !=null);
        bufferedReader.close();
        bufferedReader2.close();
    }


}