package CV;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.PrintStream;

public class ListItem {
    @XmlValue
    String content;
    public ListItem(){}
    ListItem(String i)
    {

        content = i;
    }
    public void writeHTML(PrintStream out){
        out.printf("<li>%s</li>",content);
    }
}
