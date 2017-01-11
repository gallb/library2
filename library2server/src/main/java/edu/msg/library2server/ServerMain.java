package edu.msg.library2server;

import edu.msg.library2server.repository.jdbc.SqlHandler;

public class ServerMain {

	public static void main(String[] args) {
		SqlHandler cHandler;
		while(true){
		cHandler = SqlHandler.getInstance();
		}

	}

}
