package sort;

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

public class FrameSort extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<Rectangle> sortedModel = new DefaultListModel<>();
	private List<Rectangle> rectangleList = new ArrayList<>();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSort frame = new FrameSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public FrameSort() {
		setTitle("Sorting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel leftPanel = new JPanel();
		contentPane.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JList list = new JList();
		contentPane.add(list, BorderLayout.CENTER);
		list.setModel(sortedModel);
		
		JButton btnAddRectangle = new JButton("Add rectangle for sort");
		btnAddRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogRectangleSort sortDialog = new DialogRectangleSort();
				sortDialog.setVisible(true);
				
				if(sortDialog.getRectangle() != null) 
				{
					rectangleList.add(sortDialog.getRectangle());
					sortedModel.removeAllElements();
					Rectangle pivotRectangle = null;
					int rectangleListSize = rectangleList.size();
									
					for(int i=0; i < rectangleListSize; i++) 
					{
						for(int j=i; j < rectangleListSize; j++)
						{
							int area1 = rectangleList.get(i).area();
							int area2 = rectangleList.get(j).area();
							
							if(area1 > area2)
							{
								pivotRectangle = rectangleList.get(i);
								rectangleList.set(i, rectangleList.get(j));
								rectangleList.set(j, pivotRectangle);
							}
						}
					}
					
					for(int x=0; x < rectangleListSize; x++)
					{
						sortedModel.add(x, rectangleList.get(x));
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Rectangle is null. Please add new Rectangle.");
				}
				
			}
		});
		leftPanel.add(btnAddRectangle);
				
	}

}
