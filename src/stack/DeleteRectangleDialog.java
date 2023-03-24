package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteRectangleDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int answer = 0;
	
	public DeleteRectangleDialog(Rectangle rectangle) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Are you sure you want to delete this rectangle?");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblXcoordinate = new JLabel("X coordinate:");
		
		JLabel lblValueX = new JLabel("");
		lblValueX.setText("" + rectangle.getUpperLeftPoint().getX());
		
		JLabel lblYcoordinate = new JLabel("Y coordinate:");
		
		JLabel lblValueY = new JLabel("");
		lblValueY.setText("" + rectangle.getUpperLeftPoint().getY());
		
		JLabel lblWidth = new JLabel("Width");
		
		JLabel lblHeight = new JLabel("Height");
		
		JLabel lblValueWidth = new JLabel("");
		lblValueWidth.setText("" + rectangle.getWidth());
		
		JLabel lblValueHeight = new JLabel("");
		lblValueHeight.setText("" + rectangle.getHeight());
		
		JButton btnLineColor = new JButton("Line Color");
		btnLineColor.setBackground(rectangle.getLineColor());
		
		JButton btnFillColor = new JButton("Fill Color");
		btnFillColor.setBackground(rectangle.getFillColor());
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblXcoordinate)
									.addGap(18)
									.addComponent(lblValueX))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblHeight)
										.addComponent(lblWidth))
									.addGap(51)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblValueWidth)
										.addComponent(lblValueHeight)))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblYcoordinate)
									.addGap(18)
									.addComponent(lblValueY))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(65)
							.addComponent(btnLineColor)
							.addGap(56)
							.addComponent(btnFillColor)))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValueX)
						.addComponent(lblXcoordinate))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHeight)
								.addComponent(lblValueHeight)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYcoordinate)
								.addComponent(lblValueY))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblValueWidth)
								.addComponent(lblWidth))))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
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
				JButton okButton = new JButton("Yes");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						answer = 1;
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("No");
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

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
}
