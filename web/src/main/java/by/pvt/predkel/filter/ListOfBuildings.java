package by.pvt.predkel.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Этот фильтр при переходе на две страницы, где нужно отобразить список
 * определённых объектов (FlammableSubstance) достает их из БД
 * и выкидывает на jsp
 */
//@WebFilter(urlPatterns = {"/*"})
public class ListOfBuildings implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        User user = (User) req.getSession().getAttribute("User");
//        String uri=req.getQueryString();
//        if ((uri.contentEquals(Path.CALCULATE_PATH))||(uri.contentEquals(Path.SUBSTANCES_PATH))){
//
//            List<FlammableSubstance> substances = null;
//            try {
//                substances = FlammableSubstanceService.getInstance().getAllSubstances();
//            } catch (DaoException e) {
//                MyLogger.INSTANCE.logError(getClass(), e.getMessage());
//                request.setAttribute("error", Errors.DB_ERROR);
//            }
//            req.getSession().setAttribute("substances",substances);
//
//        }else if(uri.contentEquals(Path.BUILDINGS_PATH)){
//
//            List<Building> buildings = null;
//            try {
//                buildings = BuildingDao.getInstance().getAllByFkId(user.getId());
//            } catch (DaoException e) {
//                MyLogger.INSTANCE.logError(getClass(), e.getMessage());
//                request.setAttribute("error", Errors.DB_ERROR);
//            }
//            req.getSession().setAttribute("buildings", buildings);
//
//        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
