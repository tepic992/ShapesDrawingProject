package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class RectangleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textHeight;
	private JTextField textWidth;
	private int rectangleHeight = 0;
	private int rectangleWidth = 0;
	
	public static void main(String[] args) {
		try {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public RectangleDialog() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for adding rectangle");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblHeight = new JLabel("Height:");
		
		textHeight = new JTextField();
		textHeight.setColumns(10);
		
		JLabel lblWidth = new JLabel("Width:");
		
		textWidth = new JTextField();
		textWidth.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(157, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHeight)
						.addComponent(lblWidth))
					.addGap(65)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(85))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						try {
							if(textHeight.getText().isEmpty() || textWidth.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textHeight.setText("");
								textWidth.setText("");
							}
							else if(Integer.parseInt(textHeight.getText()) <= 0 || Integer.parseInt(textWidth.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textHeight.setText("");
								textWidth.setText("");
							}
							else
							{
								rectangleHeight = Integer.parseInt(textHeight.getText());
								rectangleWidth = Integer.parseInt(textWidth.getText());								
								dispose();
							}
							
						} catch(Exception exception)	
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							textHeight.setText("");
							textWidth.setText("");
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
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	public int getRectangleHeight() {
		return rectangleHeight;
	}

	public void setRectangleHeight(int rectangleHeight) {
		this.rectangleHeight = rectangleHeight;
	}

	public int getRectangleWidth() {
		return rectangleWidth;
	}

	public void setRectangleWidth(int rectangleWidth) {
		this.rectangleWidth = rectangleWidth;
	}


	
}
