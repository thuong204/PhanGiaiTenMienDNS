package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import helpers.MessageDialogHelper;
import helpers.PlaceholderTextField;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassword;
	public static String emailGlobal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 413);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldPassword = new PlaceholderTextField("Password");
		textFieldPassword.setBounds(110, 199, 323, 35);
		contentPane.add(textFieldPassword);
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setBackground(new Color(255, 255, 255));
		textFieldPassword.setColumns(10);
		
		textFieldEmail = new PlaceholderTextField("Email");
		textFieldEmail.setBounds(110, 137, 323, 35);
		contentPane.add(textFieldEmail);
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setBackground(new Color(255, 255, 255));
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setBounds(65, 137, 44, 35);
		contentPane.add(lblEmail);
		lblEmail.setIcon(new ImageIcon("D:\\Download\\user-interface.png"));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setBounds(65, 193, 53, 46);
		contentPane.add(lblPassword);
		lblPassword.setIcon(new ImageIcon("D:\\Download\\lock.png"));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(300, 290, 133, 35);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String email = textFieldEmail.getText();
		        String password = textFieldPassword.getText();
		        
		        LoginController loginController = new LoginController();
		        
		        try {
		            User user = loginController.CheckLogin(email, password);

		            if (user == null) {
		                MessageDialogHelper.showErrorDialog(null, "Tên đăng nhập hoặc mật khẩu sai", "Lỗi");
		            } else {
		                MessageDialogHelper.showMessageDialog(null, "Đăng nhập thành công", "Thành công");
		                emailGlobal = email;
		                
		                
		                LoginView.this.dispose();
		                ClientView clientView = new ClientView();
		                clientView.setVisible(true);
		            }
		        } catch (Exception ex) {
		            MessageDialogHelper.showErrorDialog(null, "Đã xảy ra lỗi khi đăng nhập", "Lỗi");
		            ex.printStackTrace();
		        }
		    }
		});
		
				btnLogin.setForeground(new Color(255, 255, 255));
				btnLogin.setBackground(new Color(0, 255, 0));
				btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				JLabel lblForgotPassword = new JLabel("Forgot Password");
				lblForgotPassword.setBounds(314, 244, 148, 25);
				contentPane.add(lblForgotPassword);
				lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JButton btnRegister = new JButton("SIGN UP");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnRegister.setBounds(110, 290, 118, 35);
				contentPane.add(btnRegister);
				btnRegister.setForeground(new Color(0, 0, 0));
				btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnRegister.setBackground(new Color(255, 0, 0));
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(-12, 10, 622, 78);
				contentPane.add(panel_1);
				panel_1.setBackground(new Color(47, 79, 79));
				panel_1.setLayout(null);
				
				JLabel lblLogin = new JLabel("LOGIN");
				lblLogin.setBounds(228, 15, 110, 40);
				panel_1.add(lblLogin);
				lblLogin.setForeground(new Color(255, 255, 255));
				lblLogin.setFont(new Font("Tahoma", Font.BOLD, 33));
	}
}
