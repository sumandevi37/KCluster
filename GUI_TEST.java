import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.color.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GUI_TEST  extends JFrame
{

	public GUI_TEST()
	{
		setTitle("TEST");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawLine(0, 300, 600, 300);
		g.drawLine(300,0,300,600);
	}
	
	public static void main(String[] args)
	{
		GUI_TEST t = new GUI_TEST();
	}
}

class circle extends JPanel
{
	int radius;
	int x;
	int y;
	
	public circle(int in_x, int in_y, int  in_radius)
	{
		x = in_x;
		y = in_y;
		radius = in_radius;
	}
	
	public void paintCircle(Graphics comp)
	{
		Graphics2D comp2D = (Graphics2D)comp;
		Ellipse2D.Float _circle = new Ellipse2D.Float(x,y,radius,radius);
	}
}
