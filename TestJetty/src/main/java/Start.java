import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Start {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8000);
		ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/example");
		servletContextHandler.addServlet("MyServlet", "/sayHello");
		server.start();
	}
}
