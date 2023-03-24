package drawing;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PnlDrawing extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public ArrayList<Shape> shapes;
		
	public PnlDrawing() 
	{
		shapes = new ArrayList<Shape>();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		for(Shape shape : shapes)
		{
			shape.draw(g);
		}
		repaint();				
	}
		
}
