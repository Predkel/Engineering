package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IBuildingService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 02.06.2016.
 */
public class SaveReportCommand extends AbstractCommand {

    public String execute(HttpServletRequest request, IBuildingService buildingService) {
        Building build = (Building) request.getSession().getAttribute(Attributes.BUILDING);
        try {
            buildingService.addBuilding(build);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
        }
        request.getSession().setAttribute(Attributes.SAVE_BUILDING, false);
        return Path.CHART_PATH;
    }
}
