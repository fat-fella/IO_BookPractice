package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void testTcpClient(String ip, int port) {
		
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pw = null;
	
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	
		try {
			socket = new Socket(ip, port);
			System.out.println("접속 성공");
			in = socket.getInputStream();
			out = socket.getOutputStream();
			br = new BufferedReader(new InputStreamReader(in));
			pw = new PrintWriter(new OutputStreamWriter(out));
			String sendMsg = null;
			while (true) {
				System.out.print("msg >>> ");
				sendMsg = stdIn.readLine();
				System.out.println("~~" + sendMsg);
				
				pw.println(sendMsg);
				pw.flush();
				
				String receivedMsg = br.readLine();
				System.out.println("받은 메세지" + receivedMsg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			try {
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (socket != null)
					socket.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
