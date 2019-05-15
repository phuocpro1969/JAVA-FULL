package test_heap;
import java.awt.EventQueue;
import test_heap.main_heapsort;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class demo {
	

	private JFrame Demo;
	private JTextField txtxuat;
	private JTextField txtsort;
	private JTextField txtnhap;
	private JTextField txtheap;
	public int n;
	ArrayList arr = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo window = new demo();
					window.Demo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public demo() {
		initialize();
	}
	public void settxt()
	{
		String txt = txtxuat.getText();
		String so="";
		String xuat="";
		txt = txt.trim();
		txt = txt.replace("\\s+", " ");
		arr.clear();
		if (!txt.isEmpty())
			txt = txt + " ";
		int i= txt.indexOf(" ");
		int dem = 0;
		while (i != -1)
		{
			dem++;
			so = "";
			i = txt.indexOf(" ");
			so = txt.substring(0, i);
			so = String.valueOf(so);
			int k = Integer.parseInt(so);
			arr.add(k);
			txt = txt.substring(i+1, txt.length());
			if (txt.isEmpty()) break;
		}
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		n = 0;
		Demo = new JFrame();
		Demo.setTitle("Demo");
		Demo.setBounds(100, 100, 881, 382);
		Demo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Demo.getContentPane().setLayout(null);
		
		txtxuat = new JTextField();
		txtxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtxuat.setHorizontalAlignment(SwingConstants.CENTER);
		txtxuat.setBackground(Color.PINK);
		txtxuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtxuat.setBounds(33, 112, 236, 95);
		Demo.getContentPane().add(txtxuat);
		txtxuat.setColumns(10);
		
		txtsort = new JTextField();
		txtsort.setHorizontalAlignment(SwingConstants.CENTER);
		txtsort.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtsort.setBackground(Color.PINK);
		txtsort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  scanner = txtsort.getText();
				
				
			}
				
		});
		txtsort.setBounds(598, 112, 236, 95);
		Demo.getContentPane().add(txtsort);
		txtsort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp s\u1ED1 l\u01B0\u1EE3ng ph\u1EA7n t\u1EED c\u1EE7a m\u1EA3ng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 14, 236, 26);
		Demo.getContentPane().add(lblNewLabel);
		
		txtnhap = new JTextField();
		txtnhap.setBackground(Color.WHITE);
		txtnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
						
				
			}
		});
		txtnhap.setBounds(290, 16, 57, 31);
		Demo.getContentPane().add(txtnhap);
		txtnhap.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp c\u00E1c ph\u1EA7n t\u1EED c\u1EE7a m\u1EA3ng\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 51, 203, 26);
		Demo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMngc = new JLabel("M\u1EA3ng sau khi \u0111\u01B0\u1EE3c s\u1EAFp x\u1EBFp l\u00E0");
		lblMngc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMngc.setBounds(604, 51, 203, 26);
		Demo.getContentPane().add(lblMngc);
		
		JButton btnNewButton = new JButton("Draw");
		btnNewButton.setToolTipText("Click vào nút này để nhập mảng ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String st = txtnhap.getText();
				int n;
				if (!st.isEmpty())
					n = Integer.parseInt(st); 
				else 
					n = 0;
				
				if (n <= 0) {
						JOptionPane.showMessageDialog(txtnhap,"Vui lòng nhập một số khác 0 !","Thông Báo",JOptionPane.WARNING_MESSAGE);
						txtnhap.requestFocus();// Đưa con trỏ chuột vào ô nhập
					}
				if (n > 100) {
						JOptionPane.showMessageDialog(txtnhap, "Vui lòng nhập một số nhỏ hơn 100 !","Thông Báo",JOptionPane.WARNING_MESSAGE);
						txtnhap.requestFocus();// Đưa con trỏ chuột vào ô nhập
					}
				if (n>0 && n<100) {
					String xuat = "";
					Random number = new Random();
					for(int i=0; i<n; i++)
					{
						arr.add(number.nextInt(100));
						xuat +=(arr.get(i) + " ");
					}
						txtxuat.setText(xuat);
						
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setBounds(382, 15, 68, 32);
		Demo.getContentPane().add(btnNewButton);
		
		JButton HeapSort = new JButton("BuildHeap");
		HeapSort.setToolTipText("Bấm để sắp xếp ");
		HeapSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settxt();
				main_heapsort sc = new main_heapsort();
				sc.buildheap(arr);
				StringBuilder sb = new StringBuilder();
				for (int i  = arr.size()- 1; i >= 0; i--) {
					sb.append((int)arr.get(i)).append(" ");
				}
				txtheap.setText(sb.toString());
			}
		});
		HeapSort.setForeground(new Color(0, 0, 153));
		HeapSort.setBounds(471, 15, 112, 33);
		Demo.getContentPane().add(HeapSort);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setToolTipText("Bấm để khôi phục lại tất cả ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// xóa
				arr.clear();
				txtxuat.setText(null);
				txtsort.setText(null);
				txtheap.setText(null);
				txtnhap.setText(null);
				txtnhap.requestFocus();
				
			}
		});
		btnReset.setForeground(new Color(0, 0, 153));
		btnReset.setBounds(301, 254, 112, 36);
		Demo.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setToolTipText("Bấm để thoát ");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Exit
				int ret=JOptionPane.showConfirmDialog(null,"Bạn muốn thoát hả?", "Thoát", 
                        JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		btnExit.setForeground(new Color(0, 0, 153));
		btnExit.setBounds(459, 254, 112, 36);
		Demo.getContentPane().add(btnExit);
		
		JButton btnBuild = new JButton("HeapSort");
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				settxt();
				main_heapsort sc = new main_heapsort();
				sc.heap(arr);
				
				StringBuilder sb = new StringBuilder();
				for (int i  = arr.size() - 1; i >= 0; i--) {
					sb.append(arr.get(i)).append(" ");
				}
				txtsort.setText(sb.toString());
			}
		});
		btnBuild.setToolTipText("Bấm để tiến hành vun đống ");
		btnBuild.setForeground(new Color(0, 0, 153));
		btnBuild.setBounds(604, 15, 112, 33);
		Demo.getContentPane().add(btnBuild);
		
		txtheap = new JTextField();
		txtheap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txtheap.setHorizontalAlignment(SwingConstants.CENTER);
		txtheap.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtheap.setColumns(10);
		txtheap.setBackground(Color.PINK);
		txtheap.setBounds(316, 112, 236, 95);
		Demo.getContentPane().add(txtheap);
		
		JLabel lblMngSauKhi = new JLabel("Mảng sau khi vun là");
		lblMngSauKhi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMngSauKhi.setBounds(316, 53, 203, 26);
		Demo.getContentPane().add(lblMngSauKhi);
	}
}
