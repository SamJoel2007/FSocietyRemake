# fsociety

Minimal Java project containing a single source file.

Prerequisites
- Java JDK 11 or later installed and `javac`/`java` on PATH.

Build & run
```bash
javac main.java
java main
```

Files
- `main.java` — program entry point.

Notes
- If `main.java` declares a package, run from the project root and use the package-qualified class name with `java`.

## About main.java

`main.java` (class `Main`) is a simple command-line wrapper that invokes several external security tools by running shell commands. It presents an interactive menu with options such as:

- Website Vulnerability Scan (runs `nmap`, `whatweb`, `nslookup`, `dnsrecon`)
- SQL Injection (runs `sqlmap` against a provided URL)
- WordPress Scan (runs `wpscan`)
- Web directory buster (runs `dirb`)
- Packet capture (runs `tshark`)
- Start Tor service (attempts to run `service tor start`)
- ARP/network discovery (runs `netdiscover`)
- DNS scanning (`dnsenum`, `dnsmap`, `nslookup`)
- Web scraping (`curl`)
- Windows Wi-Fi helper (placeholder; not fully implemented)

Implementation notes:

- The program uses `ProcessBuilder` to execute external commands and streams their output to the console.
- Each menu option maps to a helper method that constructs and executes the corresponding command.

Requirements & caution:

- Java 11 or later to compile and run `main.java`.
- Many menu options call external tools that must be installed and available on your PATH (e.g., `nmap`, `sqlmap`, `wpscan`, `dirb`, `tshark`, `dnsenum`, `dnsmap`, `curl`, `netdiscover`, `tor`).
- This program executes powerful network/security tools. Use them only on systems you own or have explicit authorization to test. Unauthorized scanning or intrusion attempts may be illegal and unethical.

