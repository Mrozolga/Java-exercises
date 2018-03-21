package com.company;

import CV.Document;
import CV.ParagraphWithList;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{
        PrintStream out = new PrintStream("cv2.html");
        Document cv = new Document("Jana Kowalski - CV");
        cv.addPhoto("...");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności2")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addListItem("C")
                                .addListItem("C++")
                                .addListItem("Java")
                );
            cv.writeHTML(System.out);
        cv.write("cv.xml");
        Document cv2 = Document.read("cv.xml");
        cv2.writeHTML(out);

    }
}
