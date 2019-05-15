package test_heap_ide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class menu {
	int []arrays;
	int []results;
	
	private JFrame frmnhap;
	private JButton btnNguNhin;
	private JTextField textxuat;
	private JLabel label;
	private JLabel lblNhpSLng;
	private JButton btnOke;
	private JButton btnKtThc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frmnhap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JSpinner spr = new JSpinner();
		spr.setBounds(37, 81, 98, 33);
		
		frmnhap = new JFrame();
		frmnhap.setTitle("Nh\u1EADp s\u1ED1 l\u01B0\u1EE3ng ph\u1EA7n t\u1EED c\u1EE7a m\u1EA3ng ");
		frmnhap.setBounds(100, 100, 731, 398);
		frmnhap.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmnhap.getContentPane().setLayout(null);
		
		JButton btnNhpTay = new JButton("Nh\u1EADp Tay ");
		btnNhpTay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a = (int) spr.getValue();
				
				if(a==0) {
					textxuat.setEditable(false);
					JOptionPane.showMessageDialog(frmnhap, "Bạn phải nhập một số khác 0 !","Thông báo",JOptionPane.WARNING_MESSAGE);
				}
				else {
					textxuat.setEditable(true);
					textxuat.requestFocus();
				}
			}
		});
		
		//
		frmnhap.getContentPane().add(spr);
		btnNhpTay.setBounds(37, 134, 98, 38);
		frmnhap.getContentPane().add(btnNhpTay);
		
		btnNguNhin = new JButton("Ng\u1EABu Nhi\u00EAn");
		btnNguNhin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n =(int) spr.getValue();
				int[] arrays= new int [n];
				
				if(n == 0) {
					textxuat.setEditable(false);
					JOptionPane.showMessageDialog(frmnhap, "Bạn phải nhập số phần tử khác 0","Thông báo",JOptionPane.ERROR_MESSAGE);
				}
				else {
				
				Random rd = new Random();
				for (int i=0 ; i<n;i++) {
					arrays[i] = rd.nextInt(100);
					}
				StringBuilder sb = new StringBuilder();
				for (int i =0 ; i<arrays.length ; i++) {
					sb.append(arrays[i]).append(" ");
				}
				textxuat.setText(sb.toString());
				}
				
			}
		});
		btnNguNhin.setBounds(37, 189, 98, 38);
		frmnhap.getContentPane().add(btnNguNhin);
		
		textxuat = new JTextField();
		textxuat.setBounds(277, 81, 396, 33);
		frmnhap.getContentPane().add(textxuat);
		textxuat.setColumns(10);
		
		label = new JLabel("Nhập các phần tử của mảng\r\n\r\n");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(277, 47, 203, 26);
		frmnhap.getContentPane().add(label);
		
		lblNhpSLng = new JLabel("Nh\u1EADp s\u1ED1 l\u01B0\u1EE3ng ph\u1EA7n t\u1EED c\u1EE7a m\u1EA3ng");
		lblNhpSLng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhpSLng.setBounds(10, 47, 236, 26);
		frmnhap.getContentPane().add(lblNhpSLng);
		
		btnOke = new JButton("Oke");
		btnOke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String arr=textxuat.getText();
				String []items = arr.split(" ");
				int n= (int) spr.getValue();
				if(n != items.length){
					JOptionPane.showMessageDialog(frmnhap, "Bạn nhập số lượng phần tử mảng không đúng với lựa chọn","Thông báo",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				demo e1 = new demo(textxuat.getText(),(int)spr.getValue());
				e1.frmdemo.setVisible(true);
				frmnhap.dispose();
				}
			}
		});
		btnOke.setBounds(37, 242, 98, 38);
		frmnhap.getContentPane().add(btnOke);
		
		btnKtThc = new JButton("Kết thúc");
		btnKtThc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret=JOptionPane.showConfirmDialog(null,"Bạn muốn thoát hả?", "Thoát",JOptionPane.YES_NO_OPTION);
				if(ret==JOptionPane.YES_OPTION)
					frmnhap.dispose();
			}
		});
		btnKtThc.setBounds(37, 296, 98, 38);
		frmnhap.getContentPane().add(btnKtThc);
	}
}
