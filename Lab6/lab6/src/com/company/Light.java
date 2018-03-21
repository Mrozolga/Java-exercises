package com.company;

import java.awt.*;

public class Light  implements XmasShape {
        int x;
        int y;
        double scale;
        Color lineColor = new Color(9, 84, 42);
        Color fillColor = new Color(238, 255, 0);

        public Light ()
        {
            x=0;
            y=0;
            scale=1;
        }
        public Light (int x, int y)
        {
            this.x=x;
            this.y=y;
            scale=1;
        }
        public Light (int x, int y, int scale)
        {
            this.x=x;
            this.y=y;
            this.scale=scale;

        }
        public void LightsetColor()
        {
            fillColor=new Color((int)(Math.random() * 0x1000000));
        }

        @Override
        public void render(Graphics2D g2d) {
            g2d.setColor(fillColor);
            g2d.fillOval(0,0,10,10);
            g2d.setColor(fillColor);
            g2d.drawOval(0,0,10,10);
        }

        @Override
        public void transform(Graphics2D g2d) {
            g2d.translate(x,y);
            g2d.scale(scale,scale);
        }
    }

