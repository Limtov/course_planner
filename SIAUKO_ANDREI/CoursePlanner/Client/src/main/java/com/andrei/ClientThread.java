package com.andrei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

import com.andrei.Convertator;
import com.andrei.ui.Controller;
import com.andrei.ui.io.Input;

public class ClientThread {

	private static final Logger log = Logger.getLogger(ClientThread.class);

	public static void main(String[] args) {
		Input input = new Input();
		Controller controller = new Controller();
		int item = 0;
		String result = null;
		Socket s = null;
		try {
			s = new Socket(InetAddress.getLocalHost(), 8071);
			PrintStream ps = new PrintStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			while (true) {
				try {
					controller.printMenu();
					item = input.readItem();
					result = controller.perform(item);

					if (result != null) {
						if ("exit".equals(result)) {
							System.exit(0);
						} else {
							ps.println(result);
							ps.flush();
							System.out.println(Convertator.convertFrom(br.readLine()));
						}
					}
				} catch (IndexOutOfBoundsException | NumberFormatException e) {
					log.info(e);
					System.out.println("Not valid value. Enter value again");
				} catch (Exception e) {
					log.error(e);
					System.out.println(e.getMessage());
				}
			}
		} catch (UnknownHostException e) {
			log.error(e);
			System.out.println("Address not available");
		} catch (IOException e) {
			log.error(e);
			System.out.println("Error I/O stream");
		} finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (IOException e) {
				log.error(e);
				System.out.println("Error closing");
			}
		}
	}
}
