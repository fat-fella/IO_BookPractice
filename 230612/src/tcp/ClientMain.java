package tcp;

public class ClientMain {
	public static void main(String[] args) {
		new Client().testTcpClient("127.0.0.2", 9002);
	}
}
