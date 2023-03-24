package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	
	private Point centerPoint;
	private int radius;
	
	public Circle()
	{
		
	}
	
	public Circle(Point centerPoint, int radius)
	{
		this.centerPoint = centerPoint;
		this.radius = radius;				
	}
	
	public Circle(Point centerPoint, int radius, Color lineColor, Color fillColor, boolean selected)
	{
		super(lineColor, fillColor, selected);
		this.centerPoint = centerPoint;
		this.radius = radius;
	}
	
	
	@Override
	public int compareTo(Object o)
	{		
		return 0;
	}

	@Override
	public boolean contains(int x, int y)
	{
		if(centerPoint.distance(new Point(x, y)) <= this.radius)
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
		g.fillOval(this.centerPoint.getX() - this.radius,
					this.centerPoint.getY() - this.radius, this.radius * 2, this.radius * 2);
		g.setColor(getLineColor());
		g.drawOval(this.centerPoint.getX() - this.radius, this.centerPoint.getY() - this.radius,
					this.radius * 2, this.radius * 2);
		
		if(isSelected())
		{
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(this.centerPoint.getX() - 3, this.centerPoint.getY() - 3, 6, 6); 
		g.drawRect(this.centerPoint.getX() - 3, this.centerPoint.getY() - this.radius - 3, 6, 6);
		g.drawRect(this.centerPoint.getX() - 3, this.centerPoint.getY() + this.radius - 3, 6, 6);
		g.drawRect(this.centerPoint.getX() - this.radius - 3, this.centerPoint.getY() - 3, 6, 6);
		g.drawRect(this.centerPoint.getX() + this.radius - 3, this.centerPoint.getY() - 3, 6, 6);	
	}

	@Override
	public boolean equals(Object object)
	{
		if(object instanceof Circle)
		{
			Circle circle = (Circle) object;
			if(this.centerPoint.equals(circle.getCenterPoint()) && this.radius == circle.getRadius())
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
		this.centerPoint.moveShape(newX, newY);
		
	}
	
	public String toString()
	{
		return "Circle: centerPoint.x=" + this.centerPoint.getX() + ", centerPoint.y=" +
				this.centerPoint.getY() + ", radius=" + this.radius + ", lineColor="
				+ this.getLineColor().getRGB() + ", fillColor=" + this.getFillColor().getRGB();
	}
	
	public Point getCenterPoint() {
		return centerPoint;
	}

	public void setCenterPoint(Point centerPoint) {
		this.centerPoint = centerPoint;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
