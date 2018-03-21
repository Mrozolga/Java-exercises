package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import com.company.DrawPanel;

public class Tree{
    public int levels;
    public int x;
    public int y;
    List<Branch> branches = new ArrayList<>();

    public Tree() {
    }

    public Tree(int a, int x, int y)
    {
        levels=a;
        this.x=x;
        this.y=y;
    }

    List<XmasShape> Create()
    {
        List<XmasShape> shapes = new ArrayList<>();
        int scale =1;
        int tmp=80;
        Color green=new Color(30,30,0);
        Color greener = new Color (30,40,0);

        Branch b[] = new Branch[4];
        for (int i=0; i<levels; i++)
        {
            b[i] = new Branch(x,y+(i*i*10),scale,(i+1)*tmp);
            b[i].BranchsetColor(green, greener);
            shapes.add(b[i]);
            branches.add(b[i]);
        }
        return shapes;
    }
}
