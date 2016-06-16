package by.pvt.predkel.filter;

import by.pvt.predkel.settings.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class HibernatePropagation implements Filter {


    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Session session = HibernateUtil.currentSession();

    }

    @Override
    public void destroy() {

    }
}
