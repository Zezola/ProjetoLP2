package figureModels;

import figureInterfaces.IFigure;

import java.awt.*;

public abstract class Figure implements IFigure {
    int x;
    int y;
    int w;
    int h;
    int radius;
    public Figure(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    };
    public Figure(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public abstract void print();
    public abstract void drag(int dx, int dy);
    public abstract void resize(int rw, int rh);

}
