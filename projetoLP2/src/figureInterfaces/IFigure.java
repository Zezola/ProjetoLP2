package figureInterfaces;

import java.awt.*;

public interface IFigure {
    public boolean clicked(int x, int y);
    public void paint(Graphics g);
    public void select(Graphics g);
}
