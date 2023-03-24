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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ModifyPointDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXCoordinate;
	private JTextField textYCoordinate;
	private int xCoordinate;
	private int yCoordinate;
	private Color lineColor;
	private boolean modified = false;

	/**
	 * Create the dialog.
	 */
	public ModifyPointDialog(Point point) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for modify point");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		xCoordinate = point.getX();
		yCoordinate = point.getY();
		lineColor = point.getLineColor();
		
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		
		JButton btnLineColor = new JButton("LineColor");
		btnLineColor.setBackground(point.getLineColor());
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
		
		textXCoordinate = new JTextField();
		textXCoordinate.setColumns(10);
		textXCoordinate.setText("" + point.getX());
				
		textYCoordinate = new JTextField();
		textYCoordinate.setColumns(10);
		textYCoordinate.setText("" + point.getY());
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(160)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblYCoordinate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXCoordinate)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(104, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(btnLineColor)
					.addGap(141))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(textXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(textYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnLineColor)
					.addContainerGap(75, Short.MAX_VALUE))
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
							if(textXCoordinate.getText().isEmpty() || textYCoordinate.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textXCoordinate.setText("");
								textYCoordinate.setText("");
							} else if(Integer.parseInt(textXCoordinate.getText()) <= 0 || 
									Integer.parseInt(textYCoordinate.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textXCoordinate.setText("");
								textYCoordinate.setText("");
							}else
							{
								xCoordinate = Integer.parseInt(textXCoordinate.getText());
								yCoordinate = Integer.parseInt(textYCoordinate.getText());
								modified = true;
								dispose();
							}
							
						}catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							textXCoordinate.setText("");
							textYCoordinate.setText("");
							
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

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public boolean isModified() {
		return modified;
	}

	public void setModified(boolean modified) {
		this.modified = modified;
	}
	
}
