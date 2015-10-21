package com.andrei;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Server {

	private static final Logger log = Logger.getLogger(Server.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket serv = new ServerSocket(8071);
			System.out.println("initialized");
			while (true) {
				Socket sock = serv.accept();
				System.out.println(sock.getInetAddress().getHostName() + " connected");
				ServerThread server = new ServerThread(sock);
				server.start();
			}
		} catch (IOException e) {
			log.error(e);
			System.out.println(e.getMessage());
		}

	}

}
