package me.allink.jetpointtemplate;

import me.allink.jetpointtemplate.endpoint.EndpointHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class Main {

	private static final String SPECIAL_CHARACTERS_REGEX = "((?![a-zA-Z0-9\s\\p{Punct}]).)+";
	private static final QueuedThreadPool THREAD_POOL = new QueuedThreadPool();
	private static final Server SERVER = new Server(THREAD_POOL);
	private static final ServerConnector CONNECTOR = new ServerConnector(SERVER);

	static {
		CONNECTOR.setPort(8080);
		THREAD_POOL.setName("server");
		SERVER.addConnector(CONNECTOR);
	}

	public static void main(String[] args) throws Exception {
		SERVER.setHandler(new EndpointHandler());
		SERVER.start();
	}

	public static String clean(String str) {
		return str.replaceAll(SPECIAL_CHARACTERS_REGEX, "");
	}
}