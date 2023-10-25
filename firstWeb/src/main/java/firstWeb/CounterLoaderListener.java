package firstWeb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterLoaderListener  implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("context Destroyed");		
	}
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
         System.out.println("context Inialized");		
	}

}
