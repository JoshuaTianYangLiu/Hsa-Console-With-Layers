// The "LayerConsole" class.
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import hsa.Console;

public class LayerConsoleUtil
{
    BufferedImage b;
    Graphics2D g;   //Temp
    Color c=new Color(0,0,0,0);
    LayerConsoleUtil(){
	b = new BufferedImage(640, 500, BufferedImage.TYPE_INT_ARGB);
	c=new Color(0,0,0);
    }
    LayerConsoleUtil(int length,int width){
	b = new BufferedImage(length, width, BufferedImage.TYPE_INT_ARGB);
	c=new Color(0,0,0);
    }
    BufferedImage getImage(){
	return b;
    }
    Graphics2D getGraphics(){
	return b.createGraphics();
    }
    void setImage(BufferedImage b){
	this.b=b;
    }
    Color getColor(){
	return c;
    }
    void setColor(Color c){
	this.c=c;
    }
    public void draw(){
	BufferedImage buffer = new BufferedImage(640, 500, BufferedImage.TYPE_INT_ARGB);
	g = buffer.createGraphics();
	g.setColor(new Color(0,0,0,0));
	g.fillRect(0, 0, 640, 500);
	g.setColor(Color.red);
	g.fillRect(100,100,300,300);
	g.finalize();
	g = buffer.createGraphics();
	g.setColor(Color.blue);
	g.fillRect(200,300,400,500);
	g.finalize();
    }
} // LayerConsole class
