package Demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client extends Thread {
	Socket s;

	Client() throws UnknownHostException, IOException {
	}

	@Override
	public void run() {
		try {
			s = new Socket("139.129.93.72", 10086);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
//			Thread.sleep(5000);
			pw.println("auth");
			String line = br.readLine();
			long firstTimes = System.currentTimeMillis();// 第一次接收时服务器的时间
			long firstTimec = Long.parseLong(line);// 第一次接收时客户端的时间
			long ca = Math.abs(firstTimes - firstTimec);
//			Thread.sleep(5000);
			// System.out.println("first time distence:" + ca);
			pw.println(System.currentTimeMillis());// 发送客户端时间
			line = br.readLine();
			long thirdTimec = System.currentTimeMillis();// 第三次客户端时间
			String[] paras = line.split(",");
			long secondTimec = Long.parseLong(paras[0]);
			long secondTimes = Long.parseLong(paras[1]);
			long thirdTimes = Long.parseLong(paras[2]);
			long cb = Math.abs(secondTimes - secondTimec);
			long cc = Math.abs(thirdTimec - thirdTimes);
			long delaya = Math.abs(Math.abs(secondTimes - firstTimes) - Math.abs(secondTimec - firstTimec));
			long delayb = Math.abs(Math.abs(thirdTimec - secondTimec) - Math.abs(thirdTimes - secondTimes));
			// System.out.println("second time distence:" + cb);
			// System.out.println("third time distence:" + cc);
			long delay = ((delaya + delayb) / 2);
			System.out.println("delay:" + delay);
			long difa = Math.abs(firstTimec - firstTimes) - delay;
			long difb = Math.abs(secondTimes - secondTimec) - delay;
			long difc = Math.abs(thirdTimec - thirdTimes) - delay;
			long dif = (difa + difb + difc) / 3;
			// System.out.println("diff:" + dif);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		List<Client> list = new ArrayList<>();
		for (int i = 0; i < 300; i++) {
			Client c = new Client();
			list.add(c);
		}
		for (Client c : list) {
			c.start();
		}
	}

}
