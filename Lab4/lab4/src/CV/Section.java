package CV;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section{
    @XmlAttribute
    String title;
    @XmlElements(value= {
            @XmlElement(name = "paragraph", type = Paragraph.class),
            @XmlElement(name = "paragraph-with-list", type = ParagraphWithList.class)
    })
    List<Paragraph> paragraphs = new ArrayList<>() ;

    Section (){}

    public Section(String title_)
    {
        this.title=title_;
    }
    public Section setTitle(String title){
        this.title=title;
        return this;
    }
    public Section addParagraph(String paragraphText){
        Paragraph a= new Paragraph(paragraphText);
        paragraphs.add(a);
        return this;
    }
    public Section addParagraph(Paragraph p){
        paragraphs.add(p);
        return this;
    }
    public void writeHTML(PrintStream out){
        out.printf("<h1>%s</h1>\n",title);
    }
}
