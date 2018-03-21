package com.company;

import java.awt.*;

public class Star implements XmasShape{

    int x;
    int y;
    Color fillColor = new Color(255, 255, 255);

    public Star ()
    {
        x=0;
        y=0;

    }
    public Star (int x, int y)
    {
        this.x=x;
        this.y=y;
    }


    public void StarsetColor()
    {
        fillColor=new Color((int)(Math.random() * 0x1000000));
    }
    @Override
    public void render(Graphics2D g2d) {

        int midX = x/4-100;
        int midY = y/5-40;
        int radius[] = {11,4,9,4};
        int nPoints = 10;
        int[] X = new int[nPoints];
        int[] Y = new int[nPoints];
        int max=10;

        for (double current=0.0; current<nPoints; current++)
        {
            int i = (int) current;
            double x = Math.cos(current*((2*Math.PI)/max))*radius[i % 4];
            double y = Math.sin(current*((2*Math.PI)/max))*radius[i % 4];

            X[i] = (int) x+midX;
            Y[i] = (int) y+midY;
        }

        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(X, Y, nPoints);

    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
    }
}
