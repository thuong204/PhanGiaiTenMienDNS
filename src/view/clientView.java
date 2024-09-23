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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.invoke.MethodHandles.Lookup;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Service.DomainDao;
import helpers.GlobalVariable;
import model.Domain;
import model.SearchHistory;

import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class ClientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldIP;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextArea textAreaIP;
	private JTable table;
	private ArrayList<SearchHistory> listDomainHistory;
	DefaultTableModel modelHistory;
	
	
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if(LoginView.emailGlobal !=null) {
//					
					ClientView frame = new ClientView();
					frame.setVisible(true);
					}else {
						LoginView lgView = new LoginView();
						lgView.setVisible(true);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ClientView() throws Exception {
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
		
		JLabel lblDomainTitlle = new JLabel("Domain Name Resolution System");
		lblDomainTitlle.setBounds(327, 29, 646, 49);
		panel_trangchu.add(lblDomainTitlle);
		lblDomainTitlle.setForeground(new Color(255, 0, 0));
		lblDomainTitlle.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		textFieldIP = new JTextField();
		textFieldIP.setBounds(302, 106, 555, 30);
		panel_trangchu.add(textFieldIP);
		textFieldIP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldIP.setColumns(10);
		
		JButton btnResolute = new JButton("Resolute");
		btnResolute.setForeground(new Color(255, 255, 255));
		btnResolute.setBackground(new Color(0, 128, 0));
		btnResolute.setBounds(950, 106, 131, 30);
		panel_trangchu.add(btnResolute);
		btnResolute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
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
		
		JButton btnLink = new JButton("Truy cập website");
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    // Tạo URL từ địa chỉ IP
					 	String ipAddress = textFieldIP.getText();
	                    String website = "http://" + ipAddress;
	                    
	                    if (Desktop.isDesktopSupported()) {
	                        Desktop desktop = Desktop.getDesktop();
	                        desktop.browse(new URI(website));
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Desktop không được hỗ trợ", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                    }
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
			}
		});
		btnLink.setBackground(new Color(255, 0, 128));
		btnLink.setForeground(new Color(255, 255, 255));
		btnLink.setBounds(56, 338, 156, 30);
		panel.add(btnLink);
		
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
		btnResolute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    String message = textFieldIP.getText();
	                    
	                    String email = GlobalVariable.getGlobalValue();
	                    
	                    String dataToSend = email + ";" + message;

	                    // Tạo DatagramSocket để gửi gói tin qua UDP
	                    DatagramSocket clientSocket = new DatagramSocket();
	                    InetAddress serverAddress = InetAddress.getByName("192.168.1.15");
	                    
	           
	                   
	                    byte[] sendData = dataToSend.getBytes();
	                    byte[] receiveData = new byte[1024];
	                    
	                    byte[] buffer = message.getBytes();
	                    

	                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 1112);
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
		panel_1.setLayout(null);
		
		JLabel lblDomainNameResolution = new JLabel("Domain Name Resolution System History");
		lblDomainNameResolution.setBounds(252, 26, 667, 37);
		lblDomainNameResolution.setForeground(Color.RED);
		lblDomainNameResolution.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(lblDomainNameResolution);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 73, 1090, 480);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DomainName", "Record", "Date_Resolution"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(605);
		table.getColumnModel().getColumn(1).setMinWidth(2);
		table.getColumnModel().getColumn(1).setMaxWidth(2147483646);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());

                if (col == 1) { // Cột "Domain Content"
                    String cellContent = (String) table.getValueAt(row, col);
                    if (cellContent != null && cellContent.length() > 20) {
                        JOptionPane.showMessageDialog(
                            table,
                            cellContent,
                            "Full Content",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            }
        });
		

		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientView frame2;
				try {
					ClientView.this.dispose();
					
					
					frame2 = new ClientView();
					frame2.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(53, 26, 85, 21);
		panel_1.add(btnNewButton);
		table.getColumnModel().getColumn(1).setCellRenderer(new MultiLineCellRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(new TruncatedCellRenderer(20));

		
		
		listDomainHistory = new DomainDao().getListDomains(GlobalVariable.getGlobalValue());
		modelHistory = (DefaultTableModel) table.getModel();
		
		
		showTableHistory();
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Trang trợ giúp", null, panel_2, null);
		
		JPanel panel_taikhoan = new JPanel();
		panel_taikhoan.setForeground(new Color(0, 0, 0));
		tabbedPane.addTab("Tài khoản", null, panel_taikhoan, null);
		tabbedPane.setForegroundAt(3, new Color(0, 0, 0));
	}
	public void showTableHistory() {
		for (SearchHistory search : listDomainHistory) {
			modelHistory.addRow(new Object[] {
				     
					 search.getDomain_name(), search.getDomain_content(), search.getSearch_date()
			});
		}
	}
	public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

        public MultiLineCellRenderer() {
            setLineWrap(true);
            setWrapStyleWord(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value != null ? value.toString() : "");
            setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
            if (table.getRowHeight(row) != getPreferredSize().height) {
                table.setRowHeight(row, getPreferredSize().height);
            }
            return this;
        }
    }
	class TruncatedCellRenderer extends DefaultTableCellRenderer {
        private int maxLength;

        public TruncatedCellRenderer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String text = (value != null) ? value.toString() : "";
            if (text.length() > maxLength) {
                text = text.substring(0, maxLength) + "...";
            }
            setText(text);
            return cellComponent;
        }
    }
	public void showResultDiemThiSinh() {
		SearchHistory s = listDomainHistory.get(listDomainHistory.size());
		modelHistory.addRow(new Object[] {
				s.getDomain_name(), s.getDomain_content(), s.getSearch_date()
		});
		showDataDiemThiSinh();
	}
	public void showDataDiemThiSinh() {
		modelHistory.setRowCount(0);
		for (SearchHistory search : listDomainHistory) {
			modelHistory.addRow(new Object[] {
					 search.getDomain_name(), search.getDomain_content(), search.getSearch_date()
			});
		}
	}
}
