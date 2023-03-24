package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

public class FrameDrawing extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private PnlDrawing pnlDrawing;
	private Point startPoint = null;
	private Shape selectedShape = null;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDrawing frame = new FrameDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrameDrawing() {
		setTitle("Shapes Drawing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		leftPanel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		leftPanel.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		leftPanel.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		leftPanel.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		leftPanel.add(tglbtnDonut);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		leftPanel.add(tglbtnSelect);
		
		JButton btnLineColor = new JButton("LineColor");
		btnLineColor.setForeground(new Color(255, 255, 255));
		btnLineColor.setBackground(new Color(0, 0, 0));
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Color currentColor = lineColor;
				lineColor = JColorChooser.showDialog(null, "Choose your line color", lineColor);
				if(lineColor == null)
				{
					lineColor = currentColor;
				}
				btnLineColor.setBackground(lineColor);
				
				if(btnLineColor.getBackground().equals(Color.WHITE))
				{
					btnLineColor.setForeground(new Color(0, 0, 0));
				}
				else
				{
					btnLineColor.setForeground(new Color(255, 255, 255));
				}
			}
		});
				
		leftPanel.add(btnLineColor);
		
		JButton btnFillColor = new JButton("FillColor");
		btnFillColor.setForeground(new Color(0, 0, 0));
		btnFillColor.setBackground(new Color(255, 255, 255));
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Color currentColor = fillColor;
				fillColor = JColorChooser.showDialog(null, "Choose your fillColor", fillColor);
				if(fillColor == null)
				{
					fillColor = currentColor;
				}
				btnFillColor.setBackground(fillColor);
				
				if(btnFillColor.getBackground().equals(Color.BLACK))
				{
					btnFillColor.setForeground(new Color(255, 255, 255));
				}
				else
				{
					btnFillColor.setForeground(new Color(0, 0, 0));
				}
			}
		});
		
		leftPanel.add(btnFillColor);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(selectedShape instanceof Point)
				{
					Point point = (Point)selectedShape;
					ModifyPointDialog modifyDialog = new ModifyPointDialog(point);
					modifyDialog.setVisible(true);
					
					if(modifyDialog.isModified())
					{
						point.setX(modifyDialog.getxCoordinate());
						point.setY(modifyDialog.getyCoordinate());
						point.setLineColor(modifyDialog.getLineColor());
					}
				}else if(selectedShape instanceof Line)
				{
					Line line = (Line)selectedShape;
					ModifyLineDialog modifyLineDialog = new ModifyLineDialog(line);
					modifyLineDialog.setVisible(true);
					
					if(modifyLineDialog.isModified())
					{
						line.getStartPoint().setX(modifyLineDialog.getxStartPoint());
						line.getStartPoint().setY(modifyLineDialog.getyStartPoint());
						line.getEndPoint().setX(modifyLineDialog.getxEndPoint());
						line.getEndPoint().setY(modifyLineDialog.getyEndPoint());
						line.setLineColor(modifyLineDialog.getLineColor());
					}
				}else if(selectedShape instanceof Rectangle)
				{
					Rectangle rectangle = (Rectangle)selectedShape;
					ModifyRectangleDialog dialog = new ModifyRectangleDialog(rectangle);
					dialog.setVisible(true);
					
					if(dialog.isModified())
					{
						rectangle.getUpperLeftPoint().setX(dialog.getxCoordinate());
						rectangle.getUpperLeftPoint().setY(dialog.getyCoordinate());
						rectangle.setWidth(dialog.getWidthRectangle());
						rectangle.setHeight(dialog.getHeightRectangle());
						rectangle.setLineColor(dialog.getLineColor());
						rectangle.setFillColor(dialog.getFillColor());
					}
				}else if(selectedShape instanceof Donut)
				{					
					Donut donut = (Donut)selectedShape;
					ModifyDonutDialog donutDialog = new ModifyDonutDialog(donut);
					donutDialog.setVisible(true);
					
					if(donutDialog.isModified())
					{
						donut.getCenterPoint().setX(donutDialog.getxCenterPointDonut());
						donut.getCenterPoint().setY(donutDialog.getyCenterPointDonut());
						donut.setRadius(donutDialog.getRadius());
						donut.setInnerRadius(donutDialog.getInnerRadius());
						donut.setLineColor(donutDialog.getLineColor());
						donut.setFillColor(donutDialog.getFillColor());
					}
				}else if(selectedShape instanceof Circle)
				{					
					Circle circle = (Circle)selectedShape;
					ModifyCircleDialog circleDialog = new ModifyCircleDialog(circle);
					circleDialog.setVisible(true);
					
					if(circleDialog.isModified())
					{
						circle.getCenterPoint().setX(circleDialog.getxCenterPoint());
						circle.getCenterPoint().setY(circleDialog.getyCenterPoint());
						circle.setRadius(circleDialog.getRadius());
						circle.setLineColor(circleDialog.getLineColor());
						circle.setFillColor(circleDialog.getFillColor());
					}
				}
			}
		});
		btnModify.setEnabled(false);
		btnModify.setForeground(new Color(255, 255, 255));
		btnModify.setBackground(new Color(128, 128, 255));
		leftPanel.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteShapeDialog dialog = new DeleteShapeDialog();
				dialog.setVisible(true);
				
				if(dialog.getAnswer() == 1)
				{
					pnlDrawing.shapes.remove(selectedShape);
					selectedShape = null;
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(128, 128, 255));
		leftPanel.add(btnDelete);
		
		buttonGroup.add(tglbtnPoint);
		buttonGroup.add(tglbtnLine);
		buttonGroup.add(tglbtnRectangle);
		buttonGroup.add(tglbtnCircle);
		buttonGroup.add(tglbtnDonut);
		buttonGroup.add(tglbtnSelect);
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.setForeground(new Color(255, 255, 255));
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{				
				if(tglbtnPoint.isSelected())
				{
					Point point = new Point(e.getX(), e.getY(), lineColor, false);
					pnlDrawing.shapes.add(point);
					startPoint = null;
				}
				else if(tglbtnLine.isSelected())
				{
					if(startPoint == null)
					{
						startPoint = new Point(e.getX(), e.getY());
					}
					else
					{
						Point endPoint = new Point(e.getX(), e.getY());
						Line line = new Line(startPoint, endPoint, lineColor, false);
						pnlDrawing.shapes.add(line);
						startPoint = null;						
					}
				}
				else if(tglbtnRectangle.isSelected())
				{
					RectangleDialog dialog = new RectangleDialog();
					dialog.setVisible(true);
					if(dialog.getRectangleHeight() != 0 && dialog.getRectangleWidth() != 0) 
					{
						Point upperLeftPoint = new Point(e.getX(), e.getY());
						Rectangle rectangle = new Rectangle(upperLeftPoint, dialog.getRectangleWidth(),
								dialog.getRectangleHeight(), lineColor, fillColor, false);
						pnlDrawing.shapes.add(rectangle);
					}
				}
				else if(tglbtnCircle.isSelected())
				{
					CircleDialog dialog = new CircleDialog();
					dialog.setVisible(true);
					if(dialog.getRadiusCircle() != 0)
					{
						Point centerPoint = new Point(e.getX(), e.getY());
						Circle circle = new Circle(centerPoint, dialog.getRadiusCircle(), 
								lineColor, fillColor, false);
						pnlDrawing.shapes.add(circle);
					}
				}
				else if(tglbtnDonut.isSelected())
				{
					DonutDialog dialog = new DonutDialog();
					dialog.setVisible(true);
					if(dialog.getRadiusDonat() != 0 && dialog.getInnerRadiusDonat() != 0)
					{
						Point centerPoint = new Point(e.getX(), e.getY());
						Donut donut = new Donut(centerPoint, dialog.getRadiusDonat(),
								dialog.getInnerRadiusDonat(), lineColor, fillColor, false);
						pnlDrawing.shapes.add(donut);
					}
				}
				else if(tglbtnSelect.isSelected())
				{
					if(selectedShape != null)
					{
						selectedShape.setSelected(false);
						selectedShape = null;
					}
					Collections.reverse(pnlDrawing.shapes);
			
					for(Shape shape : pnlDrawing.shapes)
					{
						if(shape.contains(e.getX(), e.getY()))
						{
							selectedShape = shape;
							selectedShape.setSelected(true);
							break;
						}
					}
					Collections.reverse(pnlDrawing.shapes);
					
					if(selectedShape != null)
					{
						btnModify.setEnabled(true);
						btnDelete.setEnabled(true);
					}
					else
					{
						btnModify.setEnabled(false);
						btnDelete.setEnabled(false);
					}
				}
			}
		});
		pnlDrawing.setBackground(new Color(255, 255, 255));
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
	}

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

}
