package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LightBubble {
    List<XmasShape> lightchain = new ArrayList<>();
    List<XmasShape> bubbles = new ArrayList<>();
    int x, y, tmp;

    LightBubble(int x_, int y_, int tmp_) {
        x = x_;
        y = y_;
        tmp = tmp_;
    }

    List<XmasShape> Create() {
        int x_ = x + 280, y_ = y + 60;

        for (int i = 0; i < 6; i++) {
            Light l = new Light(x_, y_, 1);
            lightchain.add(l);
            l.LightsetColor();
            x_ = x_ - 20;
            y_ = y_ + 10;
        }

        x_ = x_ + 200;
        y_ = y_ + 50;
        for (int i = 0; i < 16; i++) {
            Light l = new Light(x_, y_, 1);
            lightchain.add(l);
            l.LightsetColor();
            x_ = x_ - 20;
            y_ = y_ + 8;
        }

        x_ = x_ + 370;
        y_ = y_ + 70;
        for (int i = 0; i < 22; i++) {
            Light l = new Light(x_, y_, 1);
            lightchain.add(l);
            l.LightsetColor();
            x_ = x_ - 20;
            y_ = y_ + 5;

        }

        return lightchain;
    }

    List<XmasShape> CreateBubbles() {
        Random generator = new Random();
        double x_, y_;
        int p1, p2;
        int[] u = new int[]{250+70, 450+20};
        int[] v = new int[]{570+70, 0};
        for (int i = 0; i < 200; i++) {
            x_ = generator.nextFloat();
            y_ = generator.nextFloat();
            if (x_ + y_ < 1) {
                x_ = 1 - x_;
                y_ = 1 - y_;
            }
            p1 = (int) ((u[0] * x_ + v[0] * y_ )-150);
            p2 = (int) ((u[1] * x_ + v[1] * y_)+40);
            if(i%4==0) {
                Bubble a = new Bubble(p1, p2, 1);
                System.out.print(p1+" "+p2+" "+"\n");
                a.BubblesetColor();
                bubbles.add(a);

            }
            else
            {
                Star a = new Star(p1-10,p2);
                a.StarsetColor();
                bubbles.add(a);
            }
        }
        return bubbles;
    }
}
