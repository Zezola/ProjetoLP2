package figureModels;

import java.awt.*;

public class Ellipse extends Figure {

    int x, y;
    int w, h;

    public Ellipse (int x, int y, int w, int h) {
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

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x, this.y, this.w, this.h);
        g2d.setColor(Color.pink);
        g2d.fillOval(this.x, this.y, this.w, this.h);
    }





    @Override
    public void drag(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void resize(int rw, int rh) {
        this.w += rw;
        this.h += rh;
    }
}
