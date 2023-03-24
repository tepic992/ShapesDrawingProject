package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
		
	public Point()
	{
		
	}
	
	public Point(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, Color lineColor, boolean selected)
	{
		super(lineColor, selected);
		this.x = x;
		this.y = y;
		
	}
	
	public double distance(Point point) 
	{
		int dx = this.x - point.getX(); 						
		int dy = this.y - point.getY();						
		double d = Math.sqrt(dx * dx + dy * dy );	
		return d;	
	}
	
	
	@Override
	public int compareTo(Object o) 
	{
		return 0;
	}

	@Override
	public boolean contains(int x, int y) 
	{
		
		int dx = this.x - x;
		int dy = this.y - y;
		
		if(Math.abs(dx) <3 && Math.abs(dy) <3) 
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
		g.setColor(getLineColor());
		g.drawLine(this.x - 3, this.y, this.x + 3, this.y);
		g.drawLine(this.x, this.y - 3, this.x, this.y + 3);
		
		if(isSelected())
		{
			selected(g);
		}
	}

	@Override
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(this.x - 3, this.y - 3, 6, 6);
	}

	@Override
	public boolean equals(Object object) {
		if(object instanceof Point) 
		{
			Point point = (Point) object;
			if(this.x == point.getX() && this.y == point.getY()) 
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
		this.x = newX;
		this.y = newY;		
	}
	
	public String toString() 
	{
		return "Point: x=" + this.x + ", y=" + this.y + ", linecolor=" + this.getLineColor().getRGB(); 
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}



	
}
