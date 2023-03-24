package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeftPoint;
	private int width;
	private int height;
	
	
	public Rectangle() 
	{
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height)
	{
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color lineColor, 
			Color fillColor, boolean selected)
	{
		super(lineColor, fillColor, selected);
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		
	}

	@Override
	public int compareTo(Object o)
	{
		
		return 0;
	}

	@Override
	public boolean contains(int x, int y)
	{
		
		if(this.upperLeftPoint.getX() <= x && x <= this.upperLeftPoint.getX() + width &&
				this.upperLeftPoint.getY() <= y && y <= this.upperLeftPoint.getY() + height)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(getFillColor());
		g.fillRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), width, height);
		g.setColor(getLineColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), width, height);
		
		if(isSelected())
		{
			selected(g);
		}
		
	}

	@Override
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(this.upperLeftPoint.getX() - 3, this.upperLeftPoint.getY() - 3, 6, 6);
		g.drawRect(this.upperLeftPoint.getX() + width - 3, this.upperLeftPoint.getY() - 3, 6, 6);
		g.drawRect(this.upperLeftPoint.getX() - 3, this.upperLeftPoint.getY() + height -3, 6, 6);
		g.drawRect(this.upperLeftPoint.getX() + width - 3, this.upperLeftPoint.getY() + height - 3,
				6, 6);
	}

	@Override
	public boolean equals(Object object)
	{		
		if(object instanceof Rectangle)
		{
			Rectangle rectangle = (Rectangle) object;
			if(this.upperLeftPoint.equals(rectangle.getUpperLeftPoint()) && 
					this.width == rectangle.getWidth() && this.height == rectangle.getHeight())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	@Override
	public void moveShape(int newX, int newY) 
	{
		this.upperLeftPoint.moveShape(newX, newY);
		
	}
	
	public int area()
	{
		return this.width * this.height;
	}
	
	public String toString()
	{
		return "Rectangle: upperLeftPoint x=" + this.upperLeftPoint.getX() +
				", upperLeftPoint y=" + this.upperLeftPoint.getY() + 
				", width=" + this.width + ", height=" + this.height + 
				", lineColor=" + this.getLineColor().getRGB() +
				", fillColor=" + this.getFillColor().getRGB();
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
