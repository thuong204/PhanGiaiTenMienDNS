package view;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class serverView {
    private static final int PORT = 1115;
    private static Map<String, String> dnsRecords;

    public static void main(String[] args) {
    	 try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
             byte[] receiveData = new byte[1024];
             byte[] sendData;

             System.out.println("DNS Server is running...");

             while (true) {
                 // Nhận yêu cầu từ client (tên miền cần phân giải)
                 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                 serverSocket.receive(receivePacket);

                 String domainName = new String(receivePacket.getData(), 0, receivePacket.getLength());
                 System.out.println("Received domain request: " + domainName);

                 String ipAddress;

                 try {
                     // Phân giải tên miền thành địa chỉ IP
                     InetAddress inetAddress = InetAddress.getByName(domainName);
                     ipAddress = inetAddress.getHostAddress();
                 } catch (UnknownHostException e) {
                     // Nếu không phân giải được, trả về thông báo lỗi
                     ipAddress = "Domain not found";
                 }

                 // Gửi kết quả lại cho client
                 sendData = ipAddress.getBytes();
                 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                 serverSocket.send(sendPacket);

                 System.out.println("Sent IP address: " + ipAddress);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }