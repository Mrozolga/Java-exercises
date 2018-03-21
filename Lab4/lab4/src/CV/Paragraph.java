package CV;


import javax.xml.bind.annotation.XmlValue;
import java.io.PrintStream;

//@XmlSeeAlso({ParagraphWithList.class})
public class Paragraph{
    @XmlValue
    String content;
    Paragraph (String content_)
    {
        this.content=content_;
    }

    public Paragraph() {
    }

    Paragraph setContent(String text)
    {
        this.content=text;
        return this;
    }

    public void writeHTML(PrintStream out){
        out.printf("<p>%s</p>\n",content);
    }
}
