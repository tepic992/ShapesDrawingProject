package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.Rectangle;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrameStack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<String> model = new DefaultListModel<>();
	List<Rectangle> listRectangle = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStack frame = new FrameStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameStack() {
		setTitle("Stack");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JList<String> list = new JList<>(model);
		contentPane.add(list, BorderLayout.CENTER);
		
		JButton btnAdd = new JButton("Add on stack");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogRectangle dialog = new DialogRectangle();
				dialog.setVisible(true);
				
				if(dialog.getRectangle() != null)
				{
					model.add(0, dialog.getRectangle().toString());
					listRectangle.add(0, dialog.getRectangle());
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Rectangle is null, please add new Rectangle.");
				}
			}
		});
		leftPanel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete from stack");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(model.getSize() == 0)
				{
					JOptionPane.showMessageDialog(null, "Stack is empty, please add new Rectangle in model");
				}else
				{					
					Rectangle rectangle = listRectangle.get(0);
					DeleteRectangleDialog dialog = new DeleteRectangleDialog(rectangle);
					dialog.setVisible(true);
					
					if(dialog.getAnswer() == 1)
					{
						model.remove(0);
						listRectangle.remove(0);
					}
					
				}				
			}
		});
		leftPanel.add(btnDelete);			
	}
}
