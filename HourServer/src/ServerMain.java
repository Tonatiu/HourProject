import java.io.IOException;


public class ServerMain {
	public static void main(String[] args) throws IOException{
		Server s = new Server();
		new Thread(s).start();
	}
}
