package view;
import org.xbill.DNS.*;
import org.xbill.DNS.Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DNSQuerySwingApp {
    private static final String DEFAULT_DOMAIN = "example.com";

    public static void main(String[] args) {
        // Khởi tạo giao diện Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("DNS Query Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Tạo panel chứa các thành phần
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 1));

            // Thêm trường nhập tên miền
            JTextField domainField = new JTextField(DEFAULT_DOMAIN);
            panel.add(new JLabel("Domain:"));
            panel.add(domainField);

            // Thêm nút truy vấn
            JButton queryButton = new JButton("Query DNS");
            panel.add(queryButton);

            // Thêm khu vực hiển thị kết quả
            JTextArea resultArea = new JTextArea();
            resultArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultArea);
            frame.add(scrollPane, BorderLayout.CENTER);

            // Xử lý sự kiện khi nhấp nút
            queryButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String domain = domainField.getText();
                    StringBuilder result = new StringBuilder();

                    try {
                        // Tạo Resolver với máy chủ DNS (Google DNS trong ví dụ này)
                        Resolver resolver = new SimpleResolver("4.2.2.1");

                        // Thực hiện các truy vấn
                        result.append("Results for ").append(domain).append(":\n\n");
                        result.append(queryDNS(domain, Type.A, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.AAAA, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.MX, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.NS, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.PTR, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.SOA, resolver)).append("\n");
                        result.append(queryDNS(domain, Type.TXT, resolver)).append("\n");

                    } catch (Exception ex) {
                        result.append("Error: ").append(ex.getMessage()).append("\n");
                    }

                    // Cập nhật kết quả vào JTextArea
                    resultArea.setText(result.toString());
                }
            });

            frame.add(panel, BorderLayout.NORTH);
            frame.setVisible(true);
        });
    }

    private static String queryDNS(String domain, int recordType, Resolver resolver) {
        StringBuilder result = new StringBuilder();
        try {
            // Tạo Lookup cho loại bản ghi DNS
            Lookup lookup = new Lookup(domain, recordType);
            lookup.setResolver(resolver);
            Record[] records = lookup.run();

            if (records == null || lookup.getResult() != Lookup.SUCCESSFUL) {
                result.append("No records found for ").append(domain).append(" with record type ").append(Type.string(recordType)).append("\n");
                return result.toString();
            }

            result.append("Results for ").append(domain).append(" with record type ").append(Type.string(recordType)).append(":\n");
            for (Record record : records) {
                result.append(record).append("\n");
            }
        } catch (Exception e) {
            result.append("Error querying DNS for ").append(domain).append(" with record type ").append(Type.string(recordType)).append("\n");
        }
        return result.toString();
    }
}
