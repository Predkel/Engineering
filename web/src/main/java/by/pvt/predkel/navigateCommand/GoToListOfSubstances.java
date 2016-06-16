package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.FlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 */
public class GoToListOfSubstances extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer page;
        try {//тут схитрил маленько
            page = Integer.valueOf(request.getParameter(Parameters.PAGE));//если заходим в первый раз
        } catch (NumberFormatException e) {// то выкинет null и попадем на первую
            page = 1;//а если просто переходим на след. страницу
        }//достанем из параметров номер страницы

        Integer maxResult = 10;

        Integer countOfPages = 0;
        List<FlammableSubstance> substances = null;
        try {
            Long countOfSubstances = FlammableSubstanceService.getInstance().getCountOfSubstances();
            countOfPages = (int) Math.ceil((double) countOfSubstances / maxResult);
            substances = FlammableSubstanceService.getInstance().getSubstancesForPage(page, maxResult);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }
        if (countOfPages == 0) countOfPages++;
        request.setAttribute(Attributes.ALL_SUBSTANCES, substances);
        request.setAttribute(Attributes.COUNT_OF_PAGES, countOfPages);
        request.setAttribute(Attributes.PAGE, page);
        return Path.SUBSTANCES_PATH;
    }
}
