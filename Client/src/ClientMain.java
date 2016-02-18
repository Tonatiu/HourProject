import java.io.IOException;
import java.net.UnknownHostException;


public class ClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Client cli = new Client("192.168.5.100");
		new Thread(cli).start();
	}
}
