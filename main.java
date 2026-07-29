import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
        private static void WebScan() {
                Scanner target_domain = new Scanner(System.in);
                System.out.print("Enter target website domain: ");
                String target = target_domain.nextLine();

                String full_url = "https://" + target;

                String nmap_scan = "nmap " + target;
                String dmitry_scan = "dmitry " + target;
                String whatweb = "whatweb " + full_url;
                String nslookup = "nslookup " + target;
                String dnsrecon = "dnsrecon -d " + target;

                execute(nmap_scan);
                execute(whatweb);
                execute(nslookup);
                execute(dnsrecon);
                // execute(dmitry_scan);
        }


// sqlmap -u https://tlauncher.org --risk=3 --level=5

   public static void execute(String command) {
    try {
        System.out.println("\n[+] Executing: " + command);
        System.out.println("--------------------------------");

        // Split the command into arguments
        String[] cmd = command.trim().split("\\s+");

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);

        Process process = pb.start();

        Thread outputThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        outputThread.start();

        // Wait up to 5 minutes
        if (!process.waitFor(300, TimeUnit.SECONDS)) {
            System.out.println("[!] Command timed out.");
            process.destroyForcibly();
        }

        outputThread.join();

        System.out.println("--------------------------------");
        System.out.println("Exit Code: " + process.exitValue());

    } catch (Exception e) {
        e.printStackTrace();
    }
}
        // private static void phone_no_lookup(String phoneNo) {

        // }

        private static void wordpress_scan(String url) {
                String command = "wpscan --url " + url;
                execute(command);
        }

        private static void dir_buster(String url) {
                String command = "dirb " + url;
                execute(command);
        }

        private static void tshark() {
                execute("sudo tshark");
        }

        private static void arp_scan() {
                execute("sudo netdiscover");
        }

        private static void make_me_anonymous() {
                execute("service tor start");
                System.out.println("Tor service has been successfully started\n");
        }

        private static void sqlmap(String url) {
                String command = "sqlmap -u " + url + " --risk=3 --level=5";
                execute(command);
        }

        private static void dns(String domain) {
                System.out.println("Scanning Domain");
                String command1 = "dnsenum " + domain;
                String command2 = "dnsmap " + domain;
                String command3 = "nslookup " + domain;
                execute(command3);
                System.out.println("Starting dnsenum");
                execute(command1);
                System.out.println("Starting dnsmap");
                execute(command2);
                System.out.println("Scan Complete");
        }

        private static void web_scraper(String url) {
                String command = "curl " + url;
                System.out.println("PATH = " + System.getenv("PATH"));
                execute(command);
        }

        private static void packet_sender(String ip) {
                String ping = "ping " + ip;
                execute(ping);
        }

        private static void windows_wifi_cracker(String ssid) {
                // System.out.println("\n(1) View Wireless LAN");
                // System.out.println("(2) Crack Password");
        }

  public static void main(String[] args) {
         while (true) {
                    System.out.println("(1) Website Vulnerability Scan");
    System.out.println("(2) SQL Injection");
    System.out.println("(3) Wordpress Scan");
    System.out.println("(4) Web directory buster");
    System.out.println("(5) Tshark");
    System.out.println("(6) Make me anonymous");
    System.out.println("(7) Arp-Scan");
    System.out.println("(8) DNS Scanner");
    System.out.println("(9) Web Scraper");
        System.out.println("(10) Windows Wifi Cracker");
        System.out.println("(0) Exit");

    Scanner option = new Scanner(System.in);
    System.out.print("Enter option: ");
    String op = option.nextLine();

    if (op.equals("1")) {
                WebScan();
    } else if (op.equals("2")) {
                System.out.print("Enter target website url: ");
                String url = option.nextLine();
                sqlmap(url);
        } else if (op.equals("3")) {
                System.out.print("Enter target website url: ");
                String url = option.nextLine();
                wordpress_scan(url);
        } else if (op.equals("4")) {
                System.out.print("Enter target website url: ");
                String url = option.nextLine();
                dir_buster(url);
        } else if (op.equals("5")) {
                System.out.println("Starting tshark");
                tshark();
        } else if (op.equals("6")) {
                make_me_anonymous();
        } else if (op.equals("7")) {
                arp_scan();
        } else if (op.equals("8")) {
                System.out.print("Enter target website domain: ");
                String domain = option.nextLine();
                dns(domain);
        } else if (op.equals("9")) {
                System.out.print("Enter target website domain: ");
                String url = option.nextLine();
                web_scraper(url);
        }  else if (op.equals("10")) {
                System.out.println("\n(1) View Wireless LAN");
                System.out.println("(2) Crack Password");
                System.out.print("\nEnter option: ");
                String wifi_option = option.nextLine();

                if (option.equals("1")) {
                        execute("netsh wlan show profile");
                } else if (option.equals("2")) {
                        System.out.print("Enter wifi name to crack: ");
                        String wifi_ssid = option.nextLine();
                        windows_wifi_cracker(wifi_ssid);
                }

        }
        else if (op.equals("0")) {
                break;
        }
        else {
                System.out.println("Invalid option");
        }
         }
  }
}
