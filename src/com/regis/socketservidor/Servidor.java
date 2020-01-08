package com.regis.socketservidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public void server() {
		try {
			ServerSocket servidor = new ServerSocket(4321);
			System.out.println("---------- Servidor iniciado na porta 4321 -----------");
			Socket socket = servidor.accept();
			System.out.println("Cliente do IP " + socket.getInetAddress().getHostAddress() + " conectado");

			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			out.println("recebida sua requisição");
			
			String resposta = input.readLine();
			System.out.println("Requisição do cliente: " + resposta);

			servidor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}