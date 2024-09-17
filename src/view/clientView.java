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

public class clientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		setBounds(100, 100, 966, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 10, 942, 566);
		contentPane.add(tabbedPane);
		
		JPanel panel_trangchu = new JPanel();
		tabbedPane.addTab("Trang chủ", null, panel_trangchu, "");
		panel_trangchu.setLayout(null);
		
		JLabel lblDomainl = new JLabel("Nhập tên miền");
		lblDomainl.setBounds(62, 105, 122, 30);
		panel_trangchu.add(lblDomainl);
		lblDomainl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Dịch vụ phân giải tên miền");
		lblNewLabel_1.setBounds(264, 24, 463, 49);
		panel_trangchu.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		textField = new JTextField();
		textField.setBounds(222, 106, 463, 30);
		panel_trangchu.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Phân giải");
		btnNewButton.setBounds(737, 106, 131, 30);
		panel_trangchu.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(55, 175, 839, 309);
		panel_trangchu.add(panel);
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(180, 68, 398, 30);
		panel.add(textField_1);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setColumns(10);
		
		JLabel lblIpv4 = new JLabel("IPv4");
		lblIpv4.setBounds(115, 67, 55, 30);
		panel.add(lblIpv4);
		lblIpv4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblIpv = new JLabel("IPv6");
		lblIpv.setBounds(115, 106, 60, 30);
		panel.add(lblIpv);
		lblIpv.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(180, 107, 398, 30);
		panel.add(textField_2);
		
		JLabel lblKtQu = new JLabel("Kết quả");
		lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKtQu.setBounds(10, 0, 122, 30);
		panel.add(lblKtQu);
		
		JLabel lblMac = new JLabel("Người sở hữu");
		lblMac.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMac.setBounds(54, 186, 116, 30);
		panel.add(lblMac);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(180, 187, 398, 30);
		panel.add(textField_3);
		
		JLabel lblMailExchangemx = new JLabel("Mail Exchange(MX)");
		lblMailExchangemx.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMailExchangemx.setBounds(10, 146, 148, 30);
		panel.add(lblMailExchangemx);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(180, 147, 398, 30);
		panel.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Lưu vào tên miền  qua trọng");
		btnNewButton_1.setBounds(629, 66, 142, 37);
		panel.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(180, 227, 398, 30);
		panel.add(textField_5);
		
		JLabel lblLink = new JLabel("Link ");
		lblLink.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLink.setBounds(119, 226, 37, 30);
		panel.add(lblLink);
		
		JButton btnNewButton_1_1 = new JButton("Truy cập");
		btnNewButton_1_1.setBounds(598, 227, 73, 30);
		panel.add(btnNewButton_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    // Lấy giá trị từ JTextField
	                    String message = textField.getText();

	                    // Tạo DatagramSocket để gửi gói tin qua UDP
	                    DatagramSocket clientSocket = new DatagramSocket();
	                    InetAddress serverAddress = InetAddress.getByName("localhost");
	                    byte[] sendData = message.getBytes();
	                    byte[] receiveData = new byte[1024];

	                    // Tạo DatagramPacket để gửi dữ liệu tới server
	                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1112);
	                    clientSocket.send(sendPacket);
	                    
	                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                    clientSocket.receive(receivePacket);

	                    // Chuyển đổi dữ liệu nhận được thành chuỗi, chỉ lấy phần dữ liệu thực tế
	                    String str = new String(receivePacket.getData(), 0, receivePacket.getLength());

	                    // Đặt giá trị vào JTextField
	                    textField_1.setText(str);

	                    // Đóng kết nối sau khi xử lý
	                    clientSocket.close();

	                    clientSocket.close();
	               
	                    
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
				
				
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
