package drawing;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("rawtypes")
public abstract class Shape implements Comparable {

	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private boolean selected;
	
	public Shape()
	{
				
	}
	
	public Shape(boolean selected)
	{
		super();
		this.selected = selected;
	}
	
	public Shape(Color lineColor, boolean selected) 
	{
		this.lineColor = lineColor;
		this.selected = selected;
	}
	
	public Shape(Color lineColor, Color fillColor, boolean selected)
	{
		this.lineColor = lineColor;
		this.fillColor = fillColor;
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw(Graphics g);
	public abstract void selected(Graphics g);
	public abstract boolean equals(Object object);
	public abstract void moveShape(int newX, int newY);
	

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}