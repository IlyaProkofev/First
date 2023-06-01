import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
public class MyPanel extends JPanel {
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(1560,700));
    }
    public Dimension getPrefferedSize() {
        return new Dimension(1560,700);
    }
    private int x = 100;
    private int y = 100;
    private int width = 50;
    private int height = 100;
    private int step = 30;
    private int delta = 3;

    private ArrayList<Rectangle> outlist = new ArrayList<Rectangle>();

    public void setSymbols(String parm){
        String[] arr = parm.replace(",", "").split(" ");
        outlist.clear();
        for (String cifra: arr){
            switch (cifra){
                case "N":
                    segment(2);
                    segment(4);
                    segment(6);
                    segment(7);
                    segment(8);
                    break;
                case "n":
                    segment(3);
                    segment(4);
                    segment(6);
                    break;
                case "M":
                    segment(9);
                    segment(10);
                    segment(11);
                    segment(12);
                    break;
                case "m":
                    segment(3);
                    segment(4);
                    segment(6);
                    segment(13);
                    break;
                case "O":
                    segment(1);
                    segment(2);
                    segment(4);
                    segment(5);
                    segment(6);
                    segment(7);
                    break;
                case "o":
                    segment(3);
                    segment(4);
                    segment(5);
                    segment(6);
                    break;
                case "P":
                    segment(1);
                    segment(2);
                    segment(3);
                    segment(6);
                    segment(7);
                    break;
                case "p":
                    segment(6);
                    segment(14);
                    segment(15);
                    segment(16);
                    break;
                case "Q":
                    segment(1);
                    segment(2);
                    segment(4);
                    segment(5);
                    segment(6);
                    segment(7);
                    segment(19);
                    break;
                case "q":
                    segment(4);
                    segment(15);
                    segment(17);
                    segment(18);
                    break;
            }
            x = x + step + width;
        }
    }
    public void segment(int number){
        switch (number) {
            case 1: outlist.add(new Rectangle(x + delta, y, x+ width - delta, y));
                break;
            case 3: outlist.add(new Rectangle(x + delta, y + height / 2, x + width - delta, y + height / 2));
                break;
            case 5: outlist.add(new Rectangle(x + delta, y + height, x + width - delta, y + height));
                break;
            case 2: outlist.add(new Rectangle(x + width, y + delta, x + width, y + (height / 2) - delta));
                break;
            case 4: outlist.add(new Rectangle(x + width, y + (height / 2) + delta, x + width, y + height - delta));
                break;
            case 6: outlist.add(new Rectangle(x, y + (height / 2) + delta, x, y + height - delta));
                break;
            case 7: outlist.add(new Rectangle(x, y + delta, x, y + (height / 2) - delta));
                break;

            case 8:
                outlist.add(new Rectangle(x + delta + 2, y + 2, x + width - delta - 2, y + height - 2));
                break;
            case 9:
                outlist.add(new Rectangle(x, y + height, x + (width / 2) - (width / 4), y));
                break;
            case 10:
                outlist.add(new Rectangle(x + (width / 2) - (width / 4), y, x + (width / 2), y + (height / 2)));
                break;
            case 11:
                outlist.add(new Rectangle(x + (width / 2), y + (height / 2), x + (width / 2) + (width / 4), y));
                break;
            case 12:
                outlist.add(new Rectangle(x + (width / 2) + (width / 4), y, x + width, y + height));
                break;
            case 13:
                outlist.add(new Rectangle(x + (width / 2) + delta - 3, y + (height / 2), x + (width / 2) + delta - 3, y + height - delta));
                break;
            case 14:
                outlist.add(new Rectangle(x + (width / 2) - 2, y + (height / 2), x + delta, y + (height / 2)));
                break;
            case 15:
                outlist.add(new Rectangle(x + (width / 2), y + (height / 2), x + (width / 2), y + (height / 2) + (height / 4)));
                break;
            case 16:
                outlist.add(new Rectangle(x, y + (height / 2) + (height / 4) ,x + (width / 2), y + (height / 2) + (height / 4)));
                break;
            case 17:
                outlist.add(new Rectangle(x + (width / 2), y + (height / 2), x + width, y + (height / 2)));
                break;
            case 18:
                outlist.add(new Rectangle(x + width, y + (height / 2) + (height / 4) ,x + (width / 2), y + (height / 2) + (height / 4)));
                break;
            case 19:
                outlist.add(new Rectangle(x + width - (width / 4), y + (height / 2) + (height / 4) ,x + width + (width / 4), y + height + (height / 4)));
                break;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Rectangle rect: outlist) {
            g.drawLine(rect.x, rect.y, rect.width, rect.height);
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStep(int step) {
        this.step = step;
    }
}