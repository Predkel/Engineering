package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.BuildingService;
import by.pvt.predkel.utils.CreateReport;
import by.pvt.predkel.utils.Transliterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 *
 */
public class BuildingsListCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter(Parameters.BUILDING_ACTION);

        String idBuilding = request.getParameter(Parameters.ID_BUILDING);

        Building build;
        try {
            build = BuildingService.getInstance().readBuilding(Long.parseLong(idBuilding));

            User user = (User) request.getSession(false).getAttribute(Attributes.USER);

            if (action.equals(Parameters.SAVE)) {//если пользователь выбрал скачивание отчета
                //здесь надо либо создавать новый отчет или достать старый
                CreateReport create = new CreateReport(build);

                File myPath = new File(Path.REPORT_PATH);
                myPath.mkdirs();
                try {
                    create.create(Path.REPORT_PATH);
                } catch (Exception e) {
                    MyLogger.INSTANCE.logError(getClass(), e.getMessage());
                    request.setAttribute(Attributes.ERROR, Errors.REPORT_ERROR);
                    return Path.BUILDINGS_PATH;
                }

                request.getSession().setAttribute(Attributes.BUILDING, build);
                request.getSession().setAttribute(Attributes.USERNAME, user.getLogin());
                request.getSession().setAttribute(Attributes.NAME_OF_BUILDING, Transliterator.transliterate(build.getNameOfBuilding()));
                //request.setAttribute("rooms",build.getRoom());
                request.getSession().setAttribute(Attributes.NAME_OF_CHARTS, create.getChart().getImageNames());
//        request.getSession().setAttribute("size", create.getChart().getImageNames().size());
                request.getSession().setAttribute(Attributes.REPORT_FILEPATH, Path.REPORT_PATH);
//        Boolean save=true;
                request.getSession().setAttribute(Attributes.SAVE_BUILDING, true);

                return Path.CHART_PATH;
            } else if (action.equals(Parameters.DELETE)) {//если пользователь выбрал удаление отчета

                BuildingService.getInstance().deleteBuilding(build);
//                Building removeBuild = null;
//                for (Building temp : user.getBuilding()) {
//                    if (temp.equals(build)) {
//                        removeBuild = temp;
//                        break;
//                    }
//                }
//                if (removeBuild != null)
//                    user.getBuilding().remove(removeBuild);

                request.setAttribute(Attributes.ALL_USER_BUILDINGS, BuildingService.getInstance().getAllByFk(user.getId()));
                return Path.BUILDINGS_PATH;
            }
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.BUILDINGS_PATH;
        }
        return Path.BUILDINGS_PATH;
    }
}
