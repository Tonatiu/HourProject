import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Server implements Runnable{
	private ServerSocket server;
	private Socket client;
	private int port = 3408;
	private boolean active = true;
	private DataOutputStream output;
	private Date date;
	
	public Server() throws IOException{
		this.server = new ServerSocket(this.port);
	}

	@Override
	public void run() {
		System.out.println("Server active");
		while(this.active){
			try {
				this.client = this.server.accept();
				System.out.println("Client Accepted in port: " + this.port);
				this.output = new DataOutputStream(this.client.getOutputStream());
				this.date = new Date();
				DateFormat datetime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				this.output.writeUTF(datetime.format(date));
				System.out.println("Sended " + datetime.format(date));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
