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
                            case ('s'):
                                figureList.add(new Square((int)currentMouseLocation.getX(),
                                        (int)currentMouseLocation.getY(), 100, 100));
                                break;
                            case ('c'):
                                figureList.add(new Circle((int)currentMouseLocation.getX(),
                                        (int)currentMouseLocation.getY(), 100));
                                break;
                            case ('+'):
                                Figure lastFigure = figureList.get(figureList.size()-1);
                                lastFigure.resize(10,10);
                                break;
                            default:
                                System.exit(0);
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

                    @Override
                    public void mousePressed(MouseEvent e) {
                        super.mousePressed(e);
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
