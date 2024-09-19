package view;
import org.apache.commons.net.whois.WhoisClient;

public class dns {
    public static void main(String[] args) {
        String domainName = "facebook.com"; // Tên miền bạn muốn truy vấn
        WhoisClient whois = new WhoisClient();

        try {
            // Kết nối tới máy chủ WHOIS mặc định
            whois.connect(WhoisClient.DEFAULT_HOST);
            
            // Gửi truy vấn WHOIS và nhận kết quả
            String whoisData = whois.query(domainName);
            
            // Hiển thị kết quả WHOIS
            System.out.println(whoisData);
            
            // Đóng kết nối
            whois.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
