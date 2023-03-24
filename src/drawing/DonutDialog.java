package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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

public class DonutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textRadius;
	private JTextField textInnerRadius;
	private int radiusDonat = 0;
	private int innerRadiusDonat = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DonutDialog() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for adding donut");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblRadius = new JLabel("Radius:");
		JLabel lblInnerRadius = new JLabel("InnerRadius:");
		textRadius = new JTextField();
		textRadius.setColumns(10);
		textInnerRadius = new JTextField();
		textInnerRadius.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(155)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRadius)
						.addComponent(lblInnerRadius))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(textInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(78, Short.MAX_VALUE))
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
						
						try{
							if(textRadius.getText().isEmpty() || textInnerRadius.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textRadius.setText("");
								textInnerRadius.setText("");
							}
							else if(Integer.parseInt(textRadius.getText()) <= 0 && 
									Integer.parseInt(textInnerRadius.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textRadius.setText("");
								textInnerRadius.setText("");							
							}
							else if(Integer.parseInt(textRadius.getText()) - 10 < Integer.parseInt(textInnerRadius.getText()))
							{
								JOptionPane.showMessageDialog(null, "Radius value must be greater than inner radius value by a minimum of 10");
								textRadius.setText("");
								textInnerRadius.setText("");
							}
							else 
							{
								radiusDonat = Integer.parseInt(textRadius.getText());
								innerRadiusDonat = Integer.parseInt(textInnerRadius.getText());
								dispose();
							}
						
						}catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
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

	public int getRadiusDonat() {
		return radiusDonat;
	}

	public void setRadiusDonat(int radiusDonat) {
		this.radiusDonat = radiusDonat;
	}

	public int getInnerRadiusDonat() {
		return innerRadiusDonat;
	}

	public void setInnerRadiusDonat(int innerRadiusDonat) {
		this.innerRadiusDonat = innerRadiusDonat;
	}

}
