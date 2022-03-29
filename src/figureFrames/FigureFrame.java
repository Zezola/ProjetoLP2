package figureFrames;

import figureModels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import figureModels.*;

public class FigureFrame extends JFrame {
    List<Figure> figureList = new ArrayList<>();
    public FigureFrame() {
        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
        this.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        Point currentMouseLocation = MouseInfo.getPointerInfo().getLocation();
                        super.keyPressed(e);

                        switch (e.getKeyChar()){
                            case ('w'):
                                figureList.get(figureList.size()-1).drag(0, -3);
                                break;
                            case ('s'):
                                figureList.get(figureList.size()-1).drag(0, 3);
                                break;
                            case ('a'):
                                figureList.get(figureList.size()-1).drag(-3, 0);
                                break;
                            case ('d'):
                                figureList.get(figureList.size()-1).drag(3, 0);
                                break;
                            case ('q'):
                                figureList.add(new Square((int)currentMouseLocation.getX(),
                                        (int)currentMouseLocation.getY(), 100, 100));
                                break;
                            case('e'):
                                figureList.add(new Ellipse((int)currentMouseLocation.getX(),
                                        (int)currentMouseLocation.getY(), 100, 70));
                                break;
                            case ('c'):
                                figureList.add(new Circle((int)currentMouseLocation.getX(),
                                        (int)currentMouseLocation.getY(), 100));
                                break;
                            case ('+'):
                                figureList.get(figureList.size()-1).resize(5,5);
                                break;
                            case ('-'):
                                figureList.get(figureList.size()-1).resize(-5, -5);


                        }
                        repaint();
                    }
                }

        );
        this.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        // Store the points X and Y of the clicked location
                        int xClicked = e.getX();
                        int yClicked = e.getY();

                        // Loop through the list of figures and verify if
                        // if a figure was clicked
                        for (int i = 0; i < figureList.size(); i++) {
                            if (figureList.get(i).clicked(xClicked, yClicked)) {
                                Figure figCopy = figureList.get(i);
                                figureList.remove(figureList.get(i));
                                figureList.add(figCopy);
                            }
                        }
                        repaint();
                    }


                }
        );
        this.setSize(500, 500);
        this.setTitle("Projeto LP2");

    }

    public void paint(Graphics g) {
        super.paint(g);
        for (Figure figure: figureList) {
            figure.paint(g);

        }

    }


}
