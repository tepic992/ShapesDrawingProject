package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	private Point startPoint;
	private Point endPoint;
	
	public Line()
	{
		
	}
	
	public Line(Point startPoint, Point endPoint) 
	{
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, Color lineColor, boolean selected)
	{
		super(lineColor, selected);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public double length()
	{
		return startPoint.distance(endPoint);
	}
			
	@Override
	public int compareTo(Object o) 
	{
		
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		
		Point point = new Point(x, y);
		if(length() + 3 > startPoint.distance(point) + endPoint.distance(point))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Point middlePoint()
	{
		return new Point((startPoint.getX() + endPoint.getX()) / 2,
				(startPoint.getY() + endPoint.getY()) / 2);
	}
	
	@Override
	public void draw(Graphics g)
	{
		g.setColor(getLineColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(),
				this.endPoint.getX(), this.endPoint.getY());
		
		if(isSelected())
		{
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g) 
	{
		g.setColor(Color.BLUE);
		startPoint.selected(g);
		endPoint.selected(g);
		middlePoint().selected(g);
	}

	@Override
	public boolean equals(Object object)
	{
		if(object instanceof Line)
		{
			Line line = (Line) object;
			if(startPoint.equals(line.getStartPoint()) && endPoint.equals(line.getEndPoint()))
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
		int endX = startPoint.getX() - endPoint.getX();
		int endY = startPoint.getX() - endPoint.getY();
		
		startPoint.setX(newX);
		startPoint.setY(newY);
		endPoint.setX(newX + endX);
		endPoint.setY(newY + endY);
		
	}
	
	public String toString()
	{
		return "Line: startPoint x=" + this.startPoint.getX() + ", startPoint y=" + 
				this.startPoint.getY() + ", endPoint x=" + this.endPoint.getX() + 
				", endPoint y=" + this.endPoint.getY() + ", lineColor=" + this.getLineColor().getRGB();
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
