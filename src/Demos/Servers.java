package Demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {
	private ServerSocket server;

	Servers() throws IOException {
		server = new ServerSocket(8888);
	}

	public static void main(String[] args) throws IOException {
		Servers serv = new Servers();
		while (true) {
			System.out.println("waiting new connections...");
			Socket client = serv.server.accept();
			ClientHandler ch = new ClientHandler(client);
			ch.start();
		}
	}

	static class ClientHandler extends Thread {

		private Socket s;

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				while (true) {
					String line = br.readLine();
					if ("bye".equals(line)) {
						s.close();
						return;
					} else {
						if ("auth".equals(line)) {
							System.out.println("get the auth request from client:" + s.getRemoteSocketAddress());
							pw.println(System.currentTimeMillis());
							line = br.readLine();
							long ta = System.currentTimeMillis();
							pw.println(line + "," + ta + "," + String.valueOf(System.currentTimeMillis()));
							System.out.println(s.getRemoteSocketAddress() + ":" + line);
							s.close();
							return;
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		ClientHandler(Socket s) {
			this.s = s;
		}
	}
}
