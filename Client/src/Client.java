import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client implements Runnable{
	private Socket client;
	private int port = 3408;
	private DataInputStream input;
	private boolean active = true;
	
	public Client(String Server_IP) throws UnknownHostException, IOException{
		this.client = new Socket(InetAddress.getByName(Server_IP), this.port);
		this.input = new DataInputStream(this.client.getInputStream());
	}
	
	@Override
	public void run() {
		System.out.println("Client active");
		String date;
		while(this.active){
			try {
				date = this.input.readUTF();
				System.out.println(date);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
