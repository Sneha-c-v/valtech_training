package firstWeb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class CounterFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroy of counter filter...");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	  System.out.println("Do filter of counter filter");
      @SuppressWarnings("unchecked")
	Map<String, Integer> counters=(Map<String,Integer>) ((FilterConfig) request).getServletContext().getAttribute("counters");		
      HttpServletRequest req=(HttpServletRequest)request;
      String uri=req.getRequestURI();
      if(counters.containsKey(uri)) {
    	  counters.put(uri, counters.get(uri)+1);
      }else {
    	  counters.put(uri, 1);
      }
      printCounters(counters);
      chain.doFilter(request, response);
		
	}

	private void printCounters(Map<String, Integer> counters) {
         for(String s:counters.keySet()) {
        	 System.out.println("Uri="+s+" Counter="+counters.get(s));      }
        
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init of counter filter......");
		Map<String,Integer > counters=new HashMap<>();
		filterConfig.getServletContext().setAttribute("counters", counters);
		
	}

}
