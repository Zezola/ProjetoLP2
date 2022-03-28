package figureModels;

import java.awt.*;

public class Circle extends Figure{
    int x;
    int y;
    int radius;
    public Circle(int x, int y, int radius) {
        super(x,y,radius);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public boolean clicked(int x, int y) {
        return (this.x<=x && x<=this.x+this.radius && this.y<=y && y<=this.y+this.radius);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x, this.y, this.radius, this.radius);
        g2d.setColor(Color.green);
        g2d.fillOval(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void select(Graphics g) {
        System.out.println("CIRCLE");
    }

    @Override
    public void drag(int dx, int dy) {

    }

    @Override
    public void resize(int rw, int rh) {
        this.radius += rw;
    }



    @Override
    public void print() {
        System.out.println("CIRCULO");
    }
}
