package controller;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.Type;

import Service.DNSService;
import Service.DomainDao;
import helpers.GlobalVariable;
import model.Domain;
import view.LoginView;

public class ServerController {
    
    public static class serverView {
        private static final int PORT = 1114;

        public static void main(String[] args) {
        	// Khởi tạo serverSocket UDP
            try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
                byte[] receiveData = new byte[1024];
                byte[] sendData;
                System.out.println("DNS Server is running...");

                while (true) {
                	
                    // Receive the domain name request from the client
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket); // Receive data from the client
                    String input = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    
                    
                    String[] parts = input.split(";");
                    String email = parts[0];
                    String message = parts[1];
                    String ipAddress = "Domain not found";  // Default value
                    
                   
                    StringBuilder result;
                    Resolver resolver = new SimpleResolver("8.8.8.8");
                    result = new StringBuilder();	
                    
                    //Khoi táo dịch vụ DNS
                    DNSService dnsService = new DNSService();
                    
                    System.out.println(GlobalVariable.getGlobalValue());
                    
                    
                    
                    boolean isIP = dnsService.isValidIPAddress(message);
                    if (isIP) {
                    	String IP = message;
                    	
                    	 result.append("Results for ").append(IP).append(":\n\n");
                    	 result.append(dnsService.iPv4ToDomain(IP, resolver));
                    	 
                    	 String domain = dnsService.getDomainNameFromIP(IP);
                    	 
                    	 result.append(dnsService.iPv4toRecordDNS(domain, Type.AAAA, resolver, IP));
                    	 result.append(dnsService.iPv4toRecordDNS(domain, Type.MX, resolver, IP));
                    	 result.append(dnsService.iPv4toRecordDNS(domain, Type.NS, resolver, IP));
                    	 result.append(dnsService.iPv4toRecordDNS(domain, Type.SOA, resolver, IP));
                    	 result.append(dnsService.iPv4toRecordDNS(domain, Type.TXT, resolver, IP));
                    	 
                    	ipAddress = result.toString();
                    	
                    } else {
                    	System.out.println("ok");
                        String domainName = message;
                        //Server DNS phân giải
                       
                        result = new StringBuilder();

                        // Use the predefined queryDNS method for DNS queries
                        result.append("Results for ").append(domainName).append(":\n\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.A, resolver)).append("\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.AAAA, resolver)).append("\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.MX, resolver)).append("\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.NS, resolver)).append("\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.SOA, resolver)).append("\n");
                        result.append(dnsService.domaintoRecordDNS(domainName, Type.TXT, resolver)).append("\n");
                        
                        ipAddress = result.toString();
                        
                        
                          //Luu vao database
                        Domain domain = new Domain(domainName,ipAddress);
                      
                        DomainDao domainDao = new DomainDao();
                        domainDao.saveDomainImportant(domain,email);

                      
                }

                    // Send the result back to the client
                    sendData = ipAddress.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                    serverSocket.send(sendPacket);
                    System.out.println("Sent response to client.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
