package figureModels;

import java.awt.*;

public class Square extends Figure{
    int x,y;
    int w,h;

    public Square(int x, int y, int w, int h) {
        super(x,y,w,h);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public boolean clicked(int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g2d.setColor(Color.blue);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }

    @Override
    public void select(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawRect(this.x, this.y, this.w, this.h);
        g2d.setColor(Color.green);
        g2d.fillRect(this.x, this.y, this.w, this.h);
    }

    public void print() {
        System.out.printf("Square with x,y,w,h = %d, %d, %d, %d \n",
                this.x, this.y, this.w, this.h);
    }

    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void resize(int resizedW, int resizedH) {
        this.w += resizedW;
        this.h += resizedH;
    }


}
