package CV;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Document {
    @XmlElement
    String title;
    @XmlElement
    Photo photo;
    @XmlElement
    List<Section> sections = new ArrayList<>();

    Document(){}
    public Document(String s) {
        title=s;
    }

    public Document setTitle(String title){
        this.title = title;
        return this;
    }

    public Document addPhoto(String photoUrl){
        photo = new Photo(photoUrl);
        return this;
    }

    public Section addSection(String sectionTitle){
        Section a = new Section (sectionTitle);
        sections.add(a);
        return a;
    }
    public Document addSection(Section s){
        sections.add(s);
        return this;
    }
    public void writeHTML(PrintStream out) {
        out.printf("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<head>\n" +
                "<title>"+title+"</title>\n" +
                "</head>\n" +
                "<body>");
        addPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/SNice.svg/1200px-SNice.svg.png");
        photo.writeHTML(out);
        out.printf("\n");
        for(Section x : sections)

        {
            x.writeHTML(out);
            out.printf("\n");
            for(Paragraph y : x.paragraphs)
            {
                y.writeHTML(out);
                out.printf("\n");
            }
            out.printf("\n");
        }
        out.printf("</body>\n</html>");
    }
    public void write(String fileName){
        try {
            JAXBContext jc = JAXBContext.newInstance(Document.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            FileWriter writer= new FileWriter(fileName);;
            m.marshal(this, writer);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static Document read(String fileName){
        try {
            JAXBContext jc = JAXBContext.newInstance(Document.class);
            Unmarshaller m = jc.createUnmarshaller();
            FileReader reader = new FileReader(fileName);
            return (Document) m.unmarshal(reader);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }



}
