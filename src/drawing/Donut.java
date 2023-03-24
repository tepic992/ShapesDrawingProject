package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle{

	private int innerRadius;
	
	public Donut()
	{
		
	}
	
	public Donut(Point centerPoint, int radius, int innerRadius)
	{
		super(centerPoint, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point centerPoint, int radius, int innerRadius, Color lineColor, Color fillColor,
			boolean selected)
	{
		super(centerPoint, radius, lineColor, fillColor, selected);
		this.innerRadius = innerRadius;
	}
	
	public void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Area donut = createDonut();
		g2.setColor(getFillColor());		
		g2.fill(donut);
		g2.setColor(getLineColor());
		g2.draw(donut);
		
		if(isSelected())
		{
			selected(g);
		}
		
		
	}
	
	private Area createDonut()
	{
		int centerX = super.getCenterPoint().getX();
		int centerY = super.getCenterPoint().getY();
		int outerRadius = super.getRadius();
		
		Ellipse2D outer = new Ellipse2D.Double(centerX - outerRadius, centerY - outerRadius,
				2 * outerRadius, 2 * outerRadius);
		Ellipse2D inner = new Ellipse2D.Double(centerX - this.innerRadius, centerY - this.innerRadius,
				2 * this.innerRadius, 2 * this.innerRadius);
		
		Area outerCircleArea = new Area(outer);
		outerCircleArea.subtract(new Area(inner));
		
		return outerCircleArea;
	}
	
	public void selected(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(this.getCenterPoint().getX() - this.getRadius() - 3,
				this.getCenterPoint().getY() - 3, 6, 6);
		g.drawRect(this.getCenterPoint().getX() + this.getRadius() - 3,
				this.getCenterPoint().getY() - 3, 6, 6);
		g.drawRect(this.getCenterPoint().getX() - 3, 
				this.getCenterPoint().getY() - this.getRadius() - 3, 6, 6);
		g.drawRect(this.getCenterPoint().getX() - 3,
				this.getCenterPoint().getY() + this.getRadius() -3, 6, 6);
	}
	
	public boolean contains(int x, int y)
	{
		if(super.contains(x, y) && this.getCenterPoint().distance(new Point(x, y)) >= this.innerRadius)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean equals(Object object)
	{
		if(object instanceof Donut)
		{
			Donut donut = (Donut) object;
			if(this.getCenterPoint().equals(donut.getCenterPoint()) &&
					this.getRadius() == donut.getRadius() &&
					this.innerRadius == donut.getInnerRadius())
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
	
	public String toString()
	{
		
		return "Donut: centerPoint.x=" + super.getCenterPoint().getX() +
				", centerPoint.y=" + super.getCenterPoint().getY() + 
				", radius=" + super.getRadius() + ", innerRadius=" + this.innerRadius +
				", lineColor=" + super.getLineColor().getRGB() +
				", filCollor=" + super.getFillColor().getRGB(); 
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}
