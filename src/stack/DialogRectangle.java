package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Point;
import drawing.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogRectangle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXcoordinate;
	private JTextField textYcoordinate;
	private JTextField textHeight;
	private JTextField textWidth;
	private int xCoordinateRectangle;
	private int yCoordinateRectangle;
	private int heightRectangle;
	private int widthRectangle;
	private Color lineColor;
	private Color fillColor;
	private Rectangle rectangle = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRectangle() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for adding rectangle on stack");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lineColor = Color.BLACK;
		fillColor = Color.WHITE;
		
		JLabel lblXcoordinate = new JLabel("X coordinate:");
		
		JLabel lblYcoordinate = new JLabel("Y coordinate:");
		
		JLabel lblHeight = new JLabel("Height:");
		
		JLabel lblWidth = new JLabel("Width:");
		
		textXcoordinate = new JTextField();
		textXcoordinate.setColumns(10);
		
		textYcoordinate = new JTextField();
		textYcoordinate.setColumns(10);
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		
		textWidth = new JTextField();
		textWidth.setColumns(10);
		
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(129, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYcoordinate)
								.addComponent(lblXcoordinate)
								.addComponent(lblHeight)
								.addComponent(lblWidth))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(24))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(105)
							.addComponent(btnLineColor)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnFillColor)))
					.addContainerGap(74, Short.MAX_VALUE))
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
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLineColor)
						.addComponent(btnFillColor))
					.addGap(21))
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
							if(textXcoordinate.getText().isEmpty() || textXcoordinate.getText().isEmpty() ||
									textHeight.getText().isEmpty() || textWidth.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textHeight.setText("");
								textWidth.setText("");
							}else if(Integer.parseInt(textXcoordinate.getText()) <= 0 ||
									Integer.parseInt(textYcoordinate.getText()) <= 0 ||
									Integer.parseInt(textHeight.getText()) <= 0 ||
									Integer.parseInt(textWidth.getText()) <= 0) 
				
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textXcoordinate.setText("");
								textYcoordinate.setText("");
								textHeight.setText("");
								textWidth.setText("");
							}else
							{
								xCoordinateRectangle = Integer.parseInt(textXcoordinate.getText());
								yCoordinateRectangle = Integer.parseInt(textYcoordinate.getText());
								heightRectangle = Integer.parseInt(textHeight.getText());
								widthRectangle = Integer.parseInt(textWidth.getText());
								rectangle = new Rectangle(new Point(xCoordinateRectangle, yCoordinateRectangle),
										widthRectangle, heightRectangle, lineColor, fillColor, false);
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

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
}
