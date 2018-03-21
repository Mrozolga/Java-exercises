package com.company;

import java.awt.*;

public class Bubble implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor = new Color(11,11,11);
    Color fillColor = new Color(255, 255, 255);

    public Bubble ()
    {
        x=0;
        y=0;
        scale=1;
    }
    public Bubble (int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public Bubble (int x, int y, int scale)
    {
        this.x=x;
        this.y=y;
        this.scale=scale;

    }
    public void BubblesetColor(int r1, int g1, int b1, int r2, int g2, int b2)
    {
        lineColor=new Color(r1, g1, b1);
        fillColor=new Color(r2, g2,b2);
    }
    public void BubblesetColor()
    {
        fillColor=new Color((int)(Math.random() * 0x1000000));
    }
    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(fillColor);
        g2d.fillOval(0,0,25,25);
        g2d.setColor(fillColor);
        g2d.drawOval(0,0,25,25);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
