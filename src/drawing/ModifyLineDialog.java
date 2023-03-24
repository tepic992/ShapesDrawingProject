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

public class ModifyLineDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXstartPoint;
	private JTextField textYstartPoint;
	private JTextField textXendPoint;
	private JTextField textYendPoint;
	private int xStartPoint;
	private int yStartPoint;
	private int xEndPoint;
	private int yEndPoint;
	private Color lineColor;
	private boolean modified = false;
	
	/**
	 * Create the dialog.
	 */
	public ModifyLineDialog(Line line) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Dialog for modify line");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		xStartPoint = line.getStartPoint().getX();
		yStartPoint = line.getStartPoint().getY();
		xEndPoint = line.getEndPoint().getX();
		yEndPoint = line.getEndPoint().getY();
		lineColor = line.getLineColor();
		
		JLabel lblXstartPoint = new JLabel("X Start Point:");
		
		JLabel lblYstartPoint = new JLabel("Y Start Point:");
		
		JLabel lblXendPoint = new JLabel("X End Point:");
		
		JLabel lblYendPoint = new JLabel("Y End Point:");
		
		textXstartPoint = new JTextField();
		textXstartPoint.setColumns(10);
		textXstartPoint.setText("" + line.getStartPoint().getX());		
		
		textYstartPoint = new JTextField();
		textYstartPoint.setColumns(10);
		textYstartPoint.setText("" + line.getStartPoint().getY());
		
		textXendPoint = new JTextField();
		textXendPoint.setColumns(10);
		textXendPoint.setText("" + line.getEndPoint().getX());
		
		textYendPoint = new JTextField();
		textYendPoint.setColumns(10);
		textYendPoint.setText("" + line.getEndPoint().getY());
		
		JButton btnLineColor = new JButton("Line Color");
		btnLineColor.setBackground(line.getLineColor());
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
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(160)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYstartPoint)
						.addComponent(lblXendPoint)
						.addComponent(lblYendPoint)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblXstartPoint, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(textXstartPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textYendPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textXendPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textYstartPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(100, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(199, Short.MAX_VALUE)
					.addComponent(btnLineColor)
					.addGap(146))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXstartPoint)
						.addComponent(textXstartPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYstartPoint)
						.addComponent(textYstartPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXendPoint)
						.addComponent(textXendPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYendPoint)
						.addComponent(textYendPoint, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnLineColor)
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
							
							if(textXstartPoint.getText().isEmpty() || textXendPoint.getText().isEmpty() ||
									textYstartPoint.getText().isEmpty() || textYendPoint.getText().isEmpty())
							{
								JOptionPane.showMessageDialog(null, "Please enter all values");
								textXstartPoint.setText("");
								textXendPoint.setText("");
								textYstartPoint.setText("");
								textYendPoint.setText("");
							} else if(Integer.parseInt(textXstartPoint.getText()) <= 0 || 
									Integer.parseInt(textXendPoint.getText()) <= 0 || 
									Integer.parseInt(textYstartPoint.getText()) <= 0 ||
									Integer.parseInt(textYendPoint.getText()) <= 0)
							{
								JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
								textXstartPoint.setText("");
								textXendPoint.setText("");
								textYstartPoint.setText("");
								textYendPoint.setText("");
							}else
							{
								xStartPoint = Integer.parseInt(textXstartPoint.getText());
								yStartPoint = Integer.parseInt(textYstartPoint.getText());
								xEndPoint = Integer.parseInt(textXendPoint.getText());
								yEndPoint = Integer.parseInt(textYendPoint.getText());
								modified = true;
								dispose();
							}
							
						}catch(Exception exception)
						{
							JOptionPane.showMessageDialog(null, "Please fill values with numbers");
							textXstartPoint.setText("");
							textXendPoint.setText("");
							textYstartPoint.setText("");
							textYendPoint.setText("");
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

	public int getxStartPoint() {
		return xStartPoint;
	}

	public void setxStartPoint(int xStartPoint) {
		this.xStartPoint = xStartPoint;
	}

	public int getyStartPoint() {
		return yStartPoint;
	}

	public void setyStartPoint(int yStartPoint) {
		this.yStartPoint = yStartPoint;
	}

	public int getxEndPoint() {
		return xEndPoint;
	}

	public void setxEndPoint(int xEndPoint) {
		this.xEndPoint = xEndPoint;
	}

	public int getyEndPoint() {
		return yEndPoint;
	}

	public void setyEndPoint(int yEndPoint) {
		this.yEndPoint = yEndPoint;
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
