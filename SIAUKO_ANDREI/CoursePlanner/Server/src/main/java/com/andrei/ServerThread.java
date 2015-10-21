package com.andrei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.andrei.Convertator;

public class ServerThread extends Thread {
	
	private static final Logger log = Logger.getLogger(ServerThread.class);

	private final String ERROR_EXECUTING_METHOD = "Selected operation can not be performed";

	private PrintStream os;
	private BufferedReader is;
	private InetAddress addr;
	private String result;

	private MethodRunner runner;

	public ServerThread(Socket s) throws IOException {
		os = new PrintStream(s.getOutputStream());
		is = new BufferedReader(new InputStreamReader(s.getInputStream()));
		addr = s.getInetAddress();
		runner = new MethodRunner();
		result = null;
	}

	public void run() {
		String str;
		try {
			while ((str = is.readLine()) != null) {
				String[] mass = str.split("<>");
				try {
					if (mass.length == 1) {
						result = runner.run(mass[0]);
					} else {
						result = runner.run(mass[0], mass[1]);
					}
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					log.info(e);
					e.printStackTrace();
					result = ERROR_EXECUTING_METHOD;
				}
				if (result != null) {
					os.println(Convertator.convertTo(result));
				}
			}
		} catch (IOException e) {
			log.error(e);
			System.out.println("Disconnect");
		} finally {
			disconnect();
		}
	}

	public void disconnect() {
		try {
			System.out.println(addr.getHostName() + " disconnected");
			os.close();
			is.close();
		} catch (IOException e) {
			log.error(e);
			System.out.println(e.getMessage());
		} finally {
			this.interrupt();
		}
	}

}
