package CV;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList{
    @XmlElement
    List<ListItem> list_of_item = new ArrayList<>();

    UnorderedList addItem(String i){
        ListItem item = new ListItem(i);
        list_of_item.add(item);
        return this;
    }
}
