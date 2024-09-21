package Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.Type;

public class DNSService {
	public static String domaintoRecordDNS(String domain, int recordType, Resolver resolver) {
        StringBuilder result = new StringBuilder();
        try {
            long startTime = System.currentTimeMillis();
            
            // Tạo Lookup cho loại bản ghi DNS(phan giai ten mien thanh dia chi)
            Lookup lookup = new Lookup(domain, recordType);
            lookup.setResolver(resolver);
            Record[] records = lookup.run();
            
            //Xu li thoi gian
            long endTime = System.currentTimeMillis();
            long queryTime = endTime - startTime;

            if (records == null || lookup.getResult() != Lookup.SUCCESSFUL) {
                result.append("No records found for ").append(domain)
                      .append(" with record type ").append(Type.string(recordType)).append("\n")
                      .append("Query time: ").append(queryTime).append(" ms\n");
                return result.toString();
            }
            

            result.append("Results for ").append(domain)
                  .append(" with record type ").append(Type.string(recordType)).append(":\n");
            for (Record record : records) {
                result.append(record).append("\n");
            }

            // Thêm thời gian truy vấn vào kết quả
            result.append("Query time: ").append(queryTime).append(" ms\n");

        } catch (Exception e) {
            result.append("Error querying DNS for ").append(domain)
                  .append(" with record type ").append(Type.string(recordType)).append("\n");
        }
        return result.toString();
    }
    
    
    
    
    
    public static boolean isValidIPAddress(String ip) {
        String ipv4Pattern = 
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return Pattern.matches(ipv4Pattern, ip);
    }
    
    
    public static String getReverseIP(String ip) {
        String[] octets = ip.split("\\.");
        return octets[3] + "." + octets[2] + "." + octets[1] + "." + octets[0]+ ".in-addr.arpa";
    }
    
    
    
    
    public static String iPv4ToDomain(String ip, Resolver resolver) {
        StringBuilder result = new StringBuilder();
        try {
        	
            // Chuyển đổi IP sang dạng phân giải ngược (reverse lookup)
            String reverseIP = getReverseIP(ip);
            
            System.out.println(reverseIP);
            long startTime = System.currentTimeMillis();

            // Tạo Lookup cho bản ghi PTR (phân giải ngược)
            Lookup lookup = new Lookup(reverseIP, Type.PTR);
            lookup.setResolver(resolver);
            Record[] records = lookup.run();
            
            long endTime = System.currentTimeMillis();
            long queryTime = endTime - startTime;

            
            if (records == null || lookup.getResult() != Lookup.SUCCESSFUL) {
                result.append("No record PTR for IP: ").append(ip).append("\n");
                result.append("Query time: ").append(queryTime).append(" ms\n");
                return result.toString();
            }

            result.append("Result  ").append(ip).append(" to domain:\n");
            result.append("Query time: ").append(queryTime).append(" ms\n");

            for (Record record : records) {
                result.append(record).append("\n");
            }
            
           

        } catch (Exception e) {
            result.append("Error in reverse resolution for IP: ").append(ip).append("\n");
        }
        return result.toString();
    }
    public static String getDomainNameFromIP(String ip) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        return inetAddress.getHostName();
    }
    
    
    
    public static String iPv4toRecordDNS(String domain,int recordType, Resolver resolver,String ip) {
    	StringBuilder result = new StringBuilder();
        try {
        	
        	
        	
            long startTime = System.currentTimeMillis();
            
            // Tạo Lookup cho loại bản ghi DNS(phan giai ten mien thanh dia chi)
            Lookup lookup = new Lookup(domain, recordType);
            lookup.setResolver(resolver);
            Record[] records = lookup.run();
            
            //Xu li thoi gian
            long endTime = System.currentTimeMillis();
            long queryTime = endTime - startTime;

            if (records == null || lookup.getResult() != Lookup.SUCCESSFUL) {
                result.append("No records found for ").append(ip)
                      .append(" with record type ").append(Type.string(recordType)).append("\n")
                      .append("Query time: ").append(queryTime).append(" ms\n");
                return result.toString();
            }
            

            result.append("Results for ").append(ip)
                  .append(" with record type ").append(Type.string(recordType)).append(":\n");
            for (Record record : records) {
                result.append(record).append("\n");
            }

            // Thêm thời gian truy vấn vào kết quả
            result.append("Query time: ").append(queryTime).append(" ms\n");

        } catch (Exception e) {
            result.append("Error querying DNS for ").append(ip)
                  .append(" with record type ").append(Type.string(recordType)).append("\n");
        }
        return result.toString();
    }


}
