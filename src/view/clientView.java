package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.spi.Resolver;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.invoke.MethodHandles.Lookup;
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
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextArea textAreaIP;

    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
//					if(LoginView.emailGlobal !=null) {
//						System.out.println(LoginView.emailGlobal+"dffhdhfhsdhf");
//					
					ClientView frame = new ClientView();
					frame.setVisible(true);
//					}else {
//						LoginView lgView = new LoginView();
//						lgView.setVisible(true);
//					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1158, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setForeground(new Color(0, 0, 0));
		tabbedPane.setBounds(0, 10, 1144, 590);
		contentPane.add(tabbedPane);
		
		JPanel panel_trangchu = new JPanel();
		tabbedPane.addTab("Trang chủ", null, panel_trangchu, "");
		panel_trangchu.setLayout(null);
		
		JLabel lblDomainl = new JLabel("Input Domain or IP of Domain");
		lblDomainl.setForeground(new Color(0, 128, 0));
		lblDomainl.setBounds(55, 105, 237, 30);
		panel_trangchu.add(lblDomainl);
		lblDomainl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Domain Name Resolution System");
		lblNewLabel_1.setBounds(327, 29, 646, 49);
		panel_trangchu.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		textField = new JTextField();
		textField.setBounds(302, 106, 555, 30);
		panel_trangchu.add(textField);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Resolute");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(950, 106, 131, 30);
		panel_trangchu.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(55, 175, 1026, 378);
		panel_trangchu.add(panel);
		panel.setLayout(null);
		
		JLabel lblKtQu = new JLabel("Result");
		lblKtQu.setForeground(new Color(255, 0, 0));
		lblKtQu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblKtQu.setBounds(10, 0, 122, 30);
		panel.add(lblKtQu);
		
		JButton btnNewButton_saveDomain = new JButton("Save important Domain");
		btnNewButton_saveDomain.setIcon(new ImageIcon("D:\\Download\\diskette (1).png"));
		btnNewButton_saveDomain.setBounds(774, 20, 199, 30);
		panel.add(btnNewButton_saveDomain);
		
		JButton btnNewButton_1_1 = new JButton("Truy cập website");
		btnNewButton_1_1.setBackground(new Color(255, 0, 128));
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(56, 338, 156, 30);
		panel.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 67, 915, 261);
		panel.add(scrollPane);
		
		textAreaIP = new JTextArea();
		textAreaIP.setEditable(false);
		scrollPane.setViewportView(textAreaIP);
		btnNewButton_saveDomain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    String message = textField.getText();

	                    // Tạo DatagramSocket để gửi gói tin qua UDP
	                    DatagramSocket clientSocket = new DatagramSocket();
	                    InetAddress serverAddress = InetAddress.getByName("192.168.1.15");
	                    byte[] sendData = message.getBytes();
	                    byte[] receiveData = new byte[1024];
	                    
	                    byte[] buffer = message.getBytes();
	                    

	                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1111);
	                    clientSocket.send(sendPacket);
	                    
	                    
	                    
	                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	                    clientSocket.receive(receivePacket);

	                    // Chuyển đổi dữ liệu nhận được thành chuỗi, chỉ lấy phần dữ liệu thực tế
	                    String str = new String(receivePacket.getData(), 0, receivePacket.getLength());

	                    // Đặt giá trị vào JTextField
	                    
	                    textAreaIP.setText(str);
	                    
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
