package by.pvt.predkel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Этот фильтр при переходе на две страницы, где нужно отобразить список
 * определённых объектов (FlammableSubstance) достает их из БД
 * и выкидывает на jsp
 */
@WebFilter(urlPatterns = {"/tosubstances"})
public class ListOfFlammableSubstances implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        List<FlammableSubstance> substances = null;
//
//        try {
//            substances = FlammableSubstanceService.getInstance().getAllSubstances();
//        } catch (DaoException e) {
//            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
//            request.setAttribute("error", Errors.DB_ERROR);
//        }
//
//        req.setAttribute("substances", substances);
//        /*Pattern pat=Pattern.compile("substances");
//        Matcher mat=pat.matcher(req.getRequestURL().toString());
//        if (mat.matches())
//            req.getRequestDispatcher("substances.jsp").forward(req,res);
//        else req.getRequestDispatcher("calculate.jsp").forward(req,res);
//        //обработка прочих фильтров*/
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
