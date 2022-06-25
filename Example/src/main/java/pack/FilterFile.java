package pack;

import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;  
import javax.servlet.*;  
  
public class FilterFile implements Filter{  
  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
          
    out.print("inside filter");  
    chain.doFilter(req, resp); 
    out.print("outside filter");  

     
          
}  
    public void destroy() {}  
  
}  

