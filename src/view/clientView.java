package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class clientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientView frame = new clientView();
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
	public clientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1260, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 10, 1246, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel_trangchu = new JPanel();
		tabbedPane.addTab("Trang chủ", null, panel_trangchu, "");
		panel_trangchu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập tên miền");
		lblNewLabel.setBounds(44, 38, 122, 30);
		panel_trangchu.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Dịch vụ phân giải tên miền");
		lblNewLabel_1.setBounds(133, 23, 610, 49);
		panel_trangchu.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		textField = new JTextField();
		textField.setBounds(150, 195, 553, 30);
		panel_trangchu.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Phan giải");
		btnNewButton.setBounds(623, 149, 131, 30);
		panel_trangchu.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Lịch sử phân giải", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Trang trợ giúp", null, panel_2, null);
		
		JPanel panel_taikhoan = new JPanel();
		panel_taikhoan.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Tài khoản", null, panel_taikhoan, null);
		tabbedPane.setForegroundAt(3, new Color(0, 0, 0));
	}
}
