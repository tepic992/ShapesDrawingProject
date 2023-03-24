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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyDonutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXcoordinate;
	private JTextField textYcoordinate;
	private JTextField textRadius;
	private JTextField textInnerRadius;
	private int xCenterPointDonut;
	private int yCenterPointDonut;
	private int radius;
	private int innerRadius;
	private Color lineColor;
	private Color fillColor;
	private boolean modified = false;

	public ModifyDonutDialog(Donut donut) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for modify donut");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		xCenterPointDonut = donut.getCenterPoint().getX();
		yCenterPointDonut = donut.getCenterPoint().getY();
		radius = donut.getRadius();
		innerRadius = donut.getInnerRadius();
		lineColor = donut.getLineColor();
		fillColor = donut.getFillColor();
		
		JLabel lblXcoordinate = new JLabel("X Center Point:");
		JLabel lblYcoordinate = new JLabel("Y Center Point:");
		JLabel lblRadius = new JLabel("Radius:");
		JLabel lblInnerRadius = new JLabel("Inner Radius:");
		
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
		
		textXcoordinate = new JTextField();
		textXcoordinate.setColumns(10);
		textXcoordinate.setText("" + xCenterPointDonut);
		
		textYcoordinate = new JTextField();
		textYcoordinate.setColumns(10);
		textYcoordinate.setText("" + yCenterPointDonut);
		
		
		textRadius = new JTextField();
		textRadius.setColumns(10);
		textRadius.setText("" + radius);
		
		
		textInnerRadius = new JTextField();
		textInnerRadius.setColumns(10);
		textInnerRadius.setText("" + innerRadius);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnLineColor)
							.addGap(56))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXcoordinate)
								.addComponent(lblYcoordinate)
								.addComponent(lblRadius)
								.addComponent(lblInnerRadius))
							.addGap(38)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFillColor)
						.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinate)
						.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLineColor)
						.addComponent(btnFillColor))
					.addGap(20))
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
						
						try 
						{
							if(textXcoordinate.getText().isEmpty() || textYcoordinate.getText().isEmpty() ||
									textRadius.getText().isEmpty() || textInnerRadius.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textRadius.setText("");
								textInnerRadius.setText("");
							}else if(Integer.parseInt(textXcoordinate.getText()) <= 0 ||
									Integer.parseInt(textYcoordinate.getText()) <= 0 ||
									Integer.parseInt(textRadius.getText()) <= 0 ||
									Integer.parseInt(textInnerRadius.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textRadius.setText("");
								textInnerRadius.setText("");
								
							}else if(Integer.parseInt(textRadius.getText()) - 10 < Integer.parseInt(textInnerRadius.getText()))
							{
								JOptionPane.showMessageDialog(null, "Radius value must be greater than inner radius value by a minimum of 10");
										
							}else 
							{
								xCenterPointDonut = Integer.parseInt(textXcoordinate.getText());
								yCenterPointDonut = Integer.parseInt(textYcoordinate.getText());
								radius = Integer.parseInt(textRadius.getText());
								innerRadius = Integer.parseInt(textInnerRadius.getText());
								modified = true;
								dispose();
							}							
						}catch(Exception exception)						
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							textXcoordinate.setText("");
							textYcoordinate.setText("");
							textRadius.setText("");
							textInnerRadius.setText("");
							
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

	public int getxCenterPointDonut() {
		return xCenterPointDonut;
	}

	public void setxCenterPointDonut(int xCenterPointDonut) {
		this.xCenterPointDonut = xCenterPointDonut;
	}

	public int getyCenterPointDonut() {
		return yCenterPointDonut;
	}

	public void setyCenterPointDonut(int yCenterPointDonut) {
		this.yCenterPointDonut = yCenterPointDonut;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
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
