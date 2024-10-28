package forSale;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdminService {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	
	private InventoryManager inventoryManager;
	
	/**
	 * Constructor to initialize cart
	 */
	public AdminService(InventoryManager inventoryManager) {
		this.inventoryManager = inventoryManager;
	}
	
	/**
	 * Start Method
	 * @param port Port
	 * @return 
	 * @throws IOException ...throw Exception
	 */
	public void start(int port) throws IOException {
		//System.out.println("Waiting for a Client connection...");
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		//System.out.println("Received a Client connection on port: " + clientSocket.getLocalPort());
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			switch (inputLine) {
	            case "GETJSON":
	            	out.println(productListJSON());
	            
	                break;
	            case "JSON":
	            	break;
	            default:
	                break;
	        }
			
			//System.out.println("Got a message of: " + inputLine);
		}
		
		System.out.println("Server is shut down.");
	}
	
	/**
	 * List products available
	 */
	public String productListJSON() {
		String output = "[";
		
		for (SalableProduct product : inventoryManager.getInventory()) {
			output += "{" + product.getItemJSON() + "},";
		}
		
		output += "]";
		return output;
	}
	
	/**
	 * Cleanup Method
	 * @throws IOException ...throw Exception
	 */
	public void cleanup() throws IOException {
		in.close();
		out.close();
		clientSocket.close();
		serverSocket.close();
	}

}
