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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyRectangleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXcoordinate;
	private JTextField textYcoordinate;
	private JTextField textWidth;
	private JTextField textHeight;
	private int xCoordinate;
	private int yCoordinate;
	private int widthRectangle;
	private int heightRectangle;
	private Color lineColor;
	private Color fillColor;
	private boolean modified = false;

	public ModifyRectangleDialog(Rectangle rectangle) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for modify rectangle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		xCoordinate = rectangle.getUpperLeftPoint().getX();
		yCoordinate = rectangle.getUpperLeftPoint().getY();
		widthRectangle = rectangle.getWidth();
		heightRectangle = rectangle.getHeight();
		lineColor = rectangle.getLineColor();
		fillColor = rectangle.getFillColor();
		
		JLabel lblXcoordinate = new JLabel("X coordinate:");
		JLabel lblYcoordinate = new JLabel("Y coordinate:");
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblHeight = new JLabel("Height:");
		
		textXcoordinate = new JTextField();
		textXcoordinate.setColumns(10);
		textXcoordinate.setText("" + xCoordinate);
		
		textYcoordinate = new JTextField();
		textYcoordinate.setColumns(10);
		textYcoordinate.setText("" + yCoordinate);
		
		textWidth = new JTextField();
		textWidth.setColumns(10);
		textWidth.setText("" + widthRectangle);
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		textHeight.setText("" + heightRectangle);
		
		JButton btnLineColor = new JButton("Line Color");
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
		btnLineColor.setBackground(lineColor);
		
		JButton btnFillColor = new JButton("Fill Color");
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
		btnFillColor.setBackground(fillColor);
				
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(176)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblHeight)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXcoordinate)
							.addGap(18)
							.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblWidth)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblYcoordinate)
							.addGap(18)
							.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(119)
					.addComponent(btnLineColor)
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addComponent(btnFillColor)
					.addGap(42))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinate)
						.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLineColor)
						.addComponent(btnFillColor))
					.addContainerGap())
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
							if(textXcoordinate.getText().isEmpty() || textYcoordinate.getText().isEmpty() ||
									textWidth.getText().isEmpty() || textHeight.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textWidth.setText("");
								textHeight.setText("");
								
							}else if(Integer.parseInt(textXcoordinate.getText()) <= 0 ||
									Integer.parseInt(textYcoordinate.getText()) <= 0 ||
									Integer.parseInt(textWidth.getText()) <= 0 ||
									Integer.parseInt(textHeight.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textWidth.setText("");
								textHeight.setText("");
							} else
							{
								xCoordinate = Integer.parseInt(textXcoordinate.getText());
								yCoordinate = Integer.parseInt(textYcoordinate.getText());
								widthRectangle = Integer.parseInt(textWidth.getText());
								heightRectangle = Integer.parseInt(textHeight.getText());
								modified = true;
								dispose();
							}
						}catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							textXcoordinate.setText("");
							textYcoordinate.setText("");
							textWidth.setText("");
							textHeight.setText("");
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

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getWidthRectangle() {
		return widthRectangle;
	}

	public void setWidthRectangle(int widthRectangle) {
		this.widthRectangle = widthRectangle;
	}

	public int getHeightRectangle() {
		return heightRectangle;
	}

	public void setHeightRectangle(int heightRectangle) {
		this.heightRectangle = heightRectangle;
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
