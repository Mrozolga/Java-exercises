package CV;


import javax.xml.bind.annotation.XmlElement;
import java.io.PrintStream;

public class ParagraphWithList extends Paragraph{
    @XmlElement
    UnorderedList list = new UnorderedList();

    public void ParagraphWithList(){}

    public ParagraphWithList setContent(String s){
        content=s;
        return this;
    }

    public ParagraphWithList addListItem(String t)
    {
        list.addItem(t);
        return this;
    }

    public void writeHTML(PrintStream out){
        out.printf("<p><ol>%s", content);
        for(int i=0;i<list.list_of_item.size();i++) {
            (list.list_of_item.get(i)).writeHTML(out);
            out.printf("\n");
        }
        out.printf("</ol></p>");
    }

}
