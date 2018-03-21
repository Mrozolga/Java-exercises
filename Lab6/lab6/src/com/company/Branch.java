package com.company;

import java.awt.*;

public class Branch implements XmasShape {
    int x;
    int y,tmp;
    double scale;
    Color lineColor = new Color(11,11,11);
    Color fillColor = new Color(12,12,12);

    public Branch ()
    {
        x=0;
        y=0;
        scale=1;
        tmp =80;
    }
    public Branch (int x, int y)
    {
        this.x=x;
        this.y=y;
        tmp=80;
        scale=1;
    }
    public Branch (int x, int y, int scale)
    {
        this.x=x;
        this.y=y;
        this.scale=scale;
        tmp=80;

    }
    public Branch(int x, int y, int scale, int tmp)
    {
        this.x=x;
        this.y=y;
        this.scale=scale;
        this.tmp=tmp;

    }
    public void BranchsetColor(Color color_fill, Color color_line)
    {
        lineColor=color_line;
        fillColor=color_fill;
    }
    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(fillColor);
        int x_p[]= {x,x-tmp,x+tmp,x};
        int y_p[]= {y,y+tmp,y+tmp,y};
        System.out.print("x "+x+" x+tmp: "+(x+tmp)+" x-tmp: "+(x-tmp)+"y: "+y+" y+tmp: "+(y+tmp)+" y+tmp: "+(y+tmp)+" tmp "+tmp+"\n");
        g2d.setColor(lineColor);
        g2d.drawPolygon(x_p, y_p,4);
        g2d.fillPolygon(new Polygon(x_p,y_p,4));
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }

    public boolean Contains (int x1, int y1)
    {
        if (x1<=x+tmp && x1>=x-tmp && y1<=y+tmp && y1>=y-tmp)
        {
            System.out.print("x+tmp: "+(x+tmp)+" x-tmp: "+(y-tmp)+"y+tmp: "+(y+tmp)+" y-tmp: "+(y-tmp)+"\n");
            return true;
        }
        else return false;
    }

}
