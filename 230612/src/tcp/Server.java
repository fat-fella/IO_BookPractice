package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void testTcpServer(int port) {
		ServerSocket ss = null;
		Socket sc= null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			ss = new ServerSocket(port);
			
			while(true) {
				System.out.println("접속대기");
				sc = ss.accept();
				System.out.println("접속"+sc.getPort());
				in = sc.getInputStream();
				out = sc.getOutputStream();
				br = new BufferedReader(new InputStreamReader(in));
				bw = new BufferedWriter(new OutputStreamWriter(out));
				
				String receivedMsg = null;
				while((receivedMsg = br.readLine())!=null) {
					System.out.println("받은 메세지"+receivedMsg);
					bw.write(": ㅎㅇㅎㅇ\n");
					bw.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
				if (in != null)
					in.close();
				if (out != null)
					out.close();
				if (ss != null)
					ss.close();
				if (sc!=null);
					sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
