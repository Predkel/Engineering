package by.pvt.predkel.filter;

import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Path;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Фильтр проверяющий вошел ли пользователь (не доработан)
 */
@WebFilter(urlPatterns = {"/WebApp/*"})
public class SecurityRedirect implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        if (httpRequest.getSession(false).getAttribute(Attributes.USER) == null)
            httpResponse.sendRedirect(httpRequest.getContextPath() + Path.INDEX_PATH);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
