package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyCircleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtXcenterPoint;
	private JTextField txtYcenterPoint;
	private JTextField textRadius;
	private int xCenterPoint;
	private int yCenterPoint;
	private int radius;
	private Color lineColor;
	private Color fillColor;
	private boolean modified = false;

	public ModifyCircleDialog(Circle circle) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for modify circle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		xCenterPoint = circle.getCenterPoint().getX();
		yCenterPoint = circle.getCenterPoint().getY();
		radius = circle.getRadius();
		lineColor = circle.getLineColor();
		fillColor = circle.getFillColor();
		
		JLabel lblYcenterPoint = new JLabel("Y Center Point:");
		
		JLabel lblRadius = new JLabel("Radius:");
		
		JButton btnLineColor = new JButton("Line Color");
		btnLineColor.setBackground(lineColor);
		btnLineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color currentColor = lineColor;
				lineColor = JColorChooser.showDialog(null, "Choose your line color", lineColor);
				if(lineColor == null)
				{
					lineColor = currentColor;
				}
				btnLineColor.setBackground(lineColor);
				
			}
		});
		
		JButton btnFillColor = new JButton("Fill Color");
		btnFillColor.setBackground(fillColor);
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color currentColor = fillColor;
				fillColor = JColorChooser.showDialog(null, "Choose your fill color", fillColor);
				if(fillColor == null)
				{
					fillColor = currentColor;
				}
				btnFillColor.setBackground(fillColor);
			}
		});
		
		JLabel lblXcenterPoint = new JLabel("X Center Point:");
		
		txtXcenterPoint = new JTextField();
		txtXcenterPoint.setColumns(10);
		txtXcenterPoint.setText("" + xCenterPoint);
		
		txtYcenterPoint = new JTextField();
		txtYcenterPoint.setColumns(10);
		txtYcenterPoint.setText("" + yCenterPoint);
		
		textRadius = new JTextField();
		textRadius.setColumns(10);
		textRadius.setText("" + radius);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(81)
							.addComponent(btnLineColor)
							.addGap(68))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYcenterPoint)
								.addComponent(lblXcenterPoint)
								.addComponent(lblRadius))
							.addGap(27)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtXcenterPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFillColor)
						.addComponent(txtYcenterPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtXcenterPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXcenterPoint))
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcenterPoint)
						.addComponent(txtYcenterPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLineColor)
						.addComponent(btnFillColor))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							
							if(txtXcenterPoint.getText().isEmpty() || txtYcenterPoint.getText().isEmpty() ||
									textRadius.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								txtXcenterPoint.setText("");
								txtYcenterPoint.setText("");
								textRadius.setText("");
							} else if(Integer.parseInt(txtXcenterPoint.getText()) <=0 ||
										Integer.parseInt(txtYcenterPoint.getText()) <=0 ||
										Integer.parseInt(textRadius.getText()) <=0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								txtXcenterPoint.setText("");
								txtYcenterPoint.setText("");
								textRadius.setText("");
							}else
							{
								xCenterPoint = Integer.parseInt(txtXcenterPoint.getText());
								yCenterPoint = Integer.parseInt(txtYcenterPoint.getText());
								radius = Integer.parseInt(textRadius.getText());
								modified = true;
								dispose();
							}
							
						}catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							txtXcenterPoint.setText("");
							txtYcenterPoint.setText("");
							textRadius.setText("");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int getxCenterPoint() {
		return xCenterPoint;
	}

	public void setxCenterPoint(int xCenterPoint) {
		this.xCenterPoint = xCenterPoint;
	}

	public int getyCenterPoint() {
		return yCenterPoint;
	}

	public void setyCenterPoint(int yCenterPoint) {
		this.yCenterPoint = yCenterPoint;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}
	
}
