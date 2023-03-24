package sort;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogRectangleSort extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXcoordinate;
	private JTextField textYcoordinate;
	private JTextField textWidth;
	private JTextField textHeight;
	private int coordinateX;
	private int coordinateY;
	private int widthRectangle;
	private int heightRectangle;
	private Color lineColor;
	private Color fillColor;
	private Rectangle rectangle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangleSort dialog = new DialogRectangleSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRectangleSort() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for adding rectangle for sort");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lineColor = Color.BLACK;
		fillColor = Color.WHITE;
		
		JLabel lblXcoordinate = new JLabel("X coordinate:");
		JLabel lblYcoordinate = new JLabel("Y coordinate:");
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblHeight = new JLabel("Height:");
		
		textXcoordinate = new JTextField();
		textXcoordinate.setColumns(10);
		
		textYcoordinate = new JTextField();
		textYcoordinate.setColumns(10);
		
		textWidth = new JTextField();
		textWidth.setColumns(10);
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		
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
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLineColor)
							.addGap(42)
							.addComponent(btnFillColor))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(138)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblXcoordinate)
									.addGap(18)
									.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYcoordinate)
										.addComponent(lblWidth)
										.addComponent(lblHeight))
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinate)
						.addComponent(textXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLineColor)
						.addComponent(btnFillColor))
					.addGap(19))
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
							}else
							{
								coordinateX = Integer.parseInt(textXcoordinate.getText());
								coordinateY = Integer.parseInt(textYcoordinate.getText());
								widthRectangle = Integer.parseInt(textWidth.getText());
								heightRectangle = Integer.parseInt(textHeight.getText());
								rectangle = new Rectangle(new Point(coordinateX, coordinateY),
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
