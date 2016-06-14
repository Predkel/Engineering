package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
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
        List<FlammableSubstance> substances = null;
        try {
            substances = FlammableSubstanceService.getInstance().getAllSubstances();
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }

        request.setAttribute(Attributes.ALL_SUBSTANCES, substances);
        return Path.SUBSTANCES_PATH;
    }
}
