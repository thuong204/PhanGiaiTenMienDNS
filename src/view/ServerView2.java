package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

public class ServerView2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerView2 frame = new ServerView2();
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
	public ServerView2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 709);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 10, 1104, 662);
		contentPane.add(tabbedPane);
		
		JPanel panel_ = new JPanel();
		tabbedPane.addTab("Trang chủ", null, panel_, "");
		panel_.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Quản lí dịch vụ phân giải tên miền");
		lblNewLabel_1.setBounds(312, 22, 620, 49);
		panel_.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(61, 95, 952, 423);
		panel_.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 79, 776, 263);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn mi\u1EC1n", "Ipv4", "Ipv6", "Hosting", "Ng\u01B0\u1EDDi s\u1EE1 h\u1EEFu", "Ng\u00E0y t\u1EA1o", "Link"
			}
		));
		table.getColumnModel().getColumn(6).setPreferredWidth(102);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_1 = new JLabel("Các tên miền thông dụng");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(23, 10, 620, 49);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_history = new JPanel();
		tabbedPane.addTab("Lịch sử phân giải", null, panel_history, null);
		panel_history.setLayout(null);
		
		JPanel panel_taikhoan = new JPanel();
		panel_taikhoan.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Tài khoản", null, panel_taikhoan, null);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 0));
	}
}
