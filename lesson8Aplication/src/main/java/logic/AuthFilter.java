package logic;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * This class discribe Filter for application
 */
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        if(request.getRequestURI().contains("/login")){
                chain.doFilter(req, resp);
        }else {
            HttpSession session = request.getSession();
             synchronized (session) {
                if (session.getAttribute("login1") == null) {
                    ((HttpServletResponse) resp).sendRedirect(String.format("%s/login", request.getContextPath()));
                    return;
                }
           }
        }
       chain.doFilter(req, resp);
    }

    public void destroy() {

    }
}
