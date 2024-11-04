package forSale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class AdminClient {

	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	/**
	 * Start Method
	 * @param ip IP
	 * @param port PORT
	 * @throws UnknownHostException ...throw Exception
	 * @throws IOException ...throw Exception
	 */
	public void start(String ip, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(ip, port);
		
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}
	
	/**
	 * SendMessage Method
	 * @param msg MSG
	 * @return return ReadLine
	 * @throws IOException ...throw Exception
	 */
	public String sendMessage(String msg) throws IOException {
		out.println(msg);
		
		return in.readLine();
	}
	
	/**
	 * Cleanup Method
	 * @throws IOException ...throw Exception
	 */
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
	}
	
	/**
	 * Main Method
	 * @param args ...Main
	 * @throws IOException ...throw Exception
	 * @throws InterruptedException ...throw Exception
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		AdminClient adminClient = new AdminClient();
	    adminClient.start("127.0.0.1", 7777);

	    String serverResponse;

	    // Reuse the same Scanner instance for the entire method
	    try (Scanner scanner = new Scanner(System.in)) {
	        while (true) {
	            System.out.println("Enter command ( U - Update, R - Retrieve ): ");
	            String command = scanner.nextLine().toUpperCase();

	            if (command.equals("U")) {
	                System.out.println("Enter a JSON string of Salable Products: ");
	                String jsonPayload = scanner.nextLine();

	                serverResponse = adminClient.sendMessage("JSON" + jsonPayload);
	            } else if (command.equals("R")) {
	                serverResponse = adminClient.sendMessage("GETJSON");
	                System.out.println(serverResponse);
	            } else {
	                System.out.println("Invalid / unknown command");
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        adminClient.cleanup();
	    }
	}
}