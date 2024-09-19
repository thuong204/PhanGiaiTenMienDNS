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
		setBounds(100, 100, 831, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 26, 817, 495);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldEmail = new PlaceholderTextField("Email");
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldEmail.setBackground(new Color(255, 255, 255));
		textFieldEmail.setBounds(265, 198, 323, 35);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPassword = new PlaceholderTextField("Password");
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldPassword.setBackground(new Color(255, 255, 255));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(265, 260, 323, 35);
		panel.add(textFieldPassword);
		
		JLabel lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon("D:\\Download\\user-interface.png"));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(220, 198, 44, 35);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setIcon(new ImageIcon("D:\\Download\\lock.png"));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(220, 254, 53, 46);
		panel.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
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
		btnLogin.setBackground(new Color(0, 128, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(440, 381, 148, 35);
		panel.add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 64));
		panel_1.setBounds(0, 0, 817, 92);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(355, 27, 110, 40);
		panel_1.add(lblLogin);
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 33));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(new Color(0, 0, 0));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBackground(new Color(255, 128, 64));
		btnRegister.setBounds(264, 381, 148, 35);
		panel.add(btnRegister);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblForgotPassword.setBounds(450, 305, 148, 25);
		panel.add(lblForgotPassword);
	}
}
