// The "LayerConsole" class.
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.AlphaComposite;
import java.lang.*;
import java.awt.image.BufferedImage;

import hsa.Console;

public class LayerConsole {

    public static void main(String[] args) {
	LayerConsole l = new LayerConsole(4); //The 3 states there will be 3 layers starting at 0. 0,1,2; The default is 100.

	l.setColor(Color.red, 0);
	l.fillRect(100, 100, 300, 300, 0);
	l.setColor(Color.blue, 2);
	l.fillRect(200, 300, 500, 500, 2);
	l.clearRect(300, 325, 50, 50, 2);
	l.setColor(Color.green, 1);
	l.setColor(Color.green, 3);
	l.strokeWeight(2,3);
	l.drawBezier(100, 100, 0, 200, 100, 300, 400, 400, 500, 3);
	for (int i = 100; i < 640; i++) {
	    l.clear(1);
	    l.fillRect(i, 250, 100, 100, 1);
	    l.draw();
	}
    }

    Console c; // The output console
    Graphics2D g; //This deals with changing images
    int length = 640; //Defaults
    int width = 500;
    int arraySize = 100;
    LayerConsoleUtil layerArr[];
    BufferedImage buf = new BufferedImage(640, 500, BufferedImage.TYPE_INT_ARGB); //Buffer
    Graphics finalImage;
    LayerConsole() {
	c = new Console();
	layerArr = new LayerConsoleUtil[100];
	init();
    }


    LayerConsole(int size) {
	c = new Console();
	layerArr = new LayerConsoleUtil[size];
	arraySize = size;
	init();
    }


    LayerConsole(int size, String title) {
	c = new Console(title);
	layerArr = new LayerConsoleUtil[size];
	arraySize = size;
	init();
    }


    LayerConsole(int size, String title, int length, int width) {
	c = new Console(length, width, title);
	this.length = length;
	this.width = width;
	layerArr = new LayerConsoleUtil[size];
	arraySize = size;
	init();
    }


    void clear(int layer) {
	g = layerArr[layer].getGraphics();
	g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
	g.fillRect(0, 0, length, width);
	g.finalize();
    }


    void clearRect(int x, int y, int length, int width, int layer) //THIS DOES NOT WORK
    {
	g = layerArr[layer].getGraphics();
	g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
	g.fillRect(x, y, length, width);
	g.finalize();
    }


    void setColor(Color c, int layer) {
	layerArr[layer].setColor(c);
    }


    void fillRect(int x, int y, int length, int width, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.fillRect(x, y, length, width);
	g.finalize();
    }


    void drawRect(int x, int y, int length, int width, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawRect(x, y, length, width);
	g.finalize();
    }


    void fillOval(int x, int y, int length, int width, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.fillOval(x, y, length, width);
	g.finalize();
    }


    void drawOval(int x, int y, int length, int width, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawOval(x, y, length, width);
	g.finalize();
    }


    void drawLine(int x1, int y1, int x2, int y2, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawLine(x1, y1, x2, y2);
	g.finalize();
    }


    void drawPolygon(int x[], int y[], int n, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawPolygon(x, y, n);
	g.finalize();
    }


    void fillPolygon(int x[], int y[], int n, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.fillPolygon(x, y, n);
	g.finalize();
    }


    void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawArc(x, y, width, height, startAngle, arcAngle);
	g.finalize();
    }


    void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.fillArc(x, y, width, height, startAngle, arcAngle);
	g.finalize();
    }


    void drawRoundRect(int x, int y, int width, int height, int xRadius, int yRadius, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawRoundRect(x, y, width, height, xRadius, yRadius);
	g.finalize();
    }


    void fillRoundRect(int x, int y, int width, int height, int xRadius, int yRadius, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.fillRoundRect(x, y, width, height, xRadius, yRadius);
	g.finalize();
    }


    void drawString(String str, int x, int y, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	g.drawString(str, x, y);
	g.finalize();
    }
    void drawBezier(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	for (int i = 0; i < 500; i++) {
	    double t = i / 500.0;
	    int x = (int)(Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2 + 3 * Math.pow(t, 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);
	    int y = (int)(Math.pow(1 - t, 3) * y1 + 3 * t * Math.pow(1 - t, 2) * y2 + 3 * Math.pow(t, 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);
	    g.drawLine(x, y, x, y);
	}
	g.finalize();
    }
    void drawBezier(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int numOfDots, int layer) {
	g = layerArr[layer].getGraphics();
	g.setStroke(layerArr[layer].getStroke());
	g.setColor(layerArr[layer].getColor());
	for (int i = 0; i < numOfDots; i++) {
	    double t = i * 1.0 / numOfDots;
	    int x = (int)(Math.pow(1 - t, 3) * x1 + 3 * t * Math.pow(1 - t, 2) * x2 + 3 * Math.pow(t, 2) * (1 - t) * x3 + Math.pow(t, 3) * x4);
	    int y = (int)(Math.pow(1 - t, 3) * y1 + 3 * t * Math.pow(1 - t, 2) * y2 + 3 * Math.pow(t, 2) * (1 - t) * y3 + Math.pow(t, 3) * y4);
	    g.drawLine(x, y, x, y);
	}
    }
    void strokeWeight(int n, int layer) {
	layerArr[layer].setWeight(n);
    }
    void init() {
	for (int i = 0; i < arraySize; i++) {
	    layerArr[i] = new LayerConsoleUtil(length, width);
	    g = layerArr[i].getGraphics();
	    g.setColor(new Color(0, 0, 0, 0));
	    g.fillRect(0, 0, length, width);
	    g.finalize();
	}
    }

    void draw() {
	//All images are init as black
	//Use setColor for color for text
	//both clear methods do not work
	//Some weird bug where console stops work a while
	//Just close RTP entirely and open again
	g = buf.createGraphics();
	//g.setComposite (AlphaComposite.getInstance (AlphaComposite.CLEAR, 0.0f));
	g.setColor(new Color(255, 255, 255));
	g.fillRect(0, 0, length, width);
	g.finalize();
	finalImage = buf.createGraphics(); //If someone wants to get this to work with Graphics2D, be my guest
	for (int i = 0; i < arraySize; i++) {
	    finalImage.drawImage(layerArr[i].getImage(), 0, 0, null);
	}
	finalImage.finalize();
	c.drawImage(buf, 0, 0, null);
    }
} // LayerConsole class
