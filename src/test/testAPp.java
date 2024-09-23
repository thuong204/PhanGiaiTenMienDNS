package test;

import javax.swing.UIManager;

import view.ClientView;
import view.LoginView;

public class testAPp {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			if(LoginView.emailGlobal !=null) {
//				
				ClientView frame = new ClientView();
				frame.setVisible(true);
				}else {
					LoginView lgView = new LoginView();
					lgView.setVisible(true);
				}
				}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
