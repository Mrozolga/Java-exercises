package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;

public class DrawPanel extends JPanel {
     List<XmasShape> shapes = new ArrayList<>();

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
        }
    }

    DrawPanel() {
        int x=250, y=20;
        setBackground(new Color(79, 79, 79));
        Tree t = new Tree(4,x,y);
        add(t.Create());
        LightBubble l =new LightBubble(x,y,80);
        add(l.Create());
        add(l.CreateBubbles());
        }



   public void add(XmasShape b)
   {
       shapes.add(b);
   }
    public void add(List<XmasShape> b)
    {
        shapes.addAll(b);
    }
}
