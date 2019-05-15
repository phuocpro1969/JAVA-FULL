package test_heap_ide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.peer.TrayIconPeer;

import javax.swing.JTextArea;

public class demo {
	int [] results;
	int n;
	String arr;

	JFrame frmdemo;
	JTextField txtxuat;
	JTextField txtsort;
	JTextField txtheap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo window = new demo();
					window.frmdemo.setVisible(true);
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
	public demo(String s,int x) {
		initialize();
		txtxuat.setText(s);
		n=x;
		arr=s;
		results = new int [x];
	}
	void toIntArr() {
		String []items = arr.split(" ");
		for(int i = 0; i < n ; i++) {
			try {
				results[i] = Integer.parseInt(items[i]);
			} catch (Exception e) {
			}
		}
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmdemo = new JFrame();
		frmdemo.setTitle("Demo");
		frmdemo.setBounds(100, 100, 881, 382);
		frmdemo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmdemo.getContentPane().setLayout(null);
		
		txtxuat = new JTextField();
		txtxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		txtxuat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		txtxuat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		txtxuat.setHorizontalAlignment(SwingConstants.CENTER);
		txtxuat.setBackground(Color.PINK);
		txtxuat.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtxuat.setBounds(33, 112, 236, 95);
		frmdemo.getContentPane().add(txtxuat);
		txtxuat.setColumns(10);
		
		txtsort = new JTextField();
		txtsort.setHorizontalAlignment(SwingConstants.CENTER);
		txtsort.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtsort.setBackground(Color.PINK);
		txtsort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
				
		});
		txtsort.setBounds(598, 112, 236, 95);
		frmdemo.getContentPane().add(txtsort);
		txtsort.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nhập số lượng phần tử của mảng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 14, 236, 26);
		frmdemo.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("phần tử của mảng\r\n\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 51, 203, 26);
		frmdemo.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMngc = new JLabel("M\u1EA3ng sau khi \u0111\u01B0\u1EE3c s\u1EAFp x\u1EBFp l\u00E0");
		lblMngc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMngc.setBounds(604, 51, 203, 26);
		frmdemo.getContentPane().add(lblMngc);
		
		JButton btnNewButton = new JButton("Press");
		btnNewButton.setToolTipText("Click vào nút này để nhập số lượng phần tử của mảng ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				menu mn = new menu();
				mn.main(null);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 153));
		btnNewButton.setBounds(301, 13, 68, 32);
		frmdemo.getContentPane().add(btnNewButton);
		
		JButton HeapSort = new JButton("BuildHeap");
		HeapSort.setToolTipText("Bấm để sắp xếp ");
		HeapSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toIntArr();
				HeapSort sc = new HeapSort();
				sc.buildheap(results);
				
				StringBuilder sb = new StringBuilder();
				for (int i  = results.length - 1; i >= 0; i--) {
					sb.append(results[i]).append(" ");
				}
				txtheap.setText(sb.toString());
			}
		});
		HeapSort.setForeground(new Color(0, 0, 153));
		HeapSort.setBounds(392, 13, 112, 33);
		frmdemo.getContentPane().add(HeapSort);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setToolTipText("Bấm để khôi phục lại tất cả ");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// xóa
				txtxuat.setText(null);
				txtsort.setText(null);
				txtheap.setText(null);
				//txtnhap.setText(null);
				//txtnhap.requestFocus();
				
			}
		});
		btnReset.setForeground(new Color(0, 0, 153));
		btnReset.setBounds(301, 254, 112, 36);
		frmdemo.getContentPane().add(btnReset);
		
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
		frmdemo.getContentPane().add(btnExit);
		
		JButton btnBuild = new JButton("HeapSort");
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				toIntArr();
				HeapSort sc = new HeapSort();
				sc.heap(results);
				
				StringBuilder sb = new StringBuilder();
				for (int i  = results.length - 1; i >= 0; i--) {
					sb.append(results[i]).append(" ");
				}
				txtsort.setText(sb.toString());
			}
		});
		btnBuild.setToolTipText("Bấm để tiến hành vun đống ");
		btnBuild.setForeground(new Color(0, 0, 153));
		btnBuild.setBounds(525, 13, 112, 33);
		frmdemo.getContentPane().add(btnBuild);
		
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
		frmdemo.getContentPane().add(txtheap);
		
		JLabel lblMngSauKhi = new JLabel("Mảng sau khi vun là");
		lblMngSauKhi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMngSauKhi.setBounds(316, 53, 203, 26);
		frmdemo.getContentPane().add(lblMngSauKhi);
	}
}
