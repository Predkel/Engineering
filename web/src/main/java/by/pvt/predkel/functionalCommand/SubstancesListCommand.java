package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.navigateCommand.GoToListOfSubstances;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.serviceForDao.FlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class SubstancesListCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Integer size = Integer.parseInt(request.getParameter(Parameters.AMOUNT_OF_SUBSTANCES));

        FlammableSubstance sub = new FlammableSubstance();
        try {
            for (int i = 0; i < size + 1; i++)
                if (request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty()) {

                    sub.setNameOfSubstance(request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i]);
                    sub.setAmountOfCombustionAir(Double.parseDouble(request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i]));
                    sub.setCombustionHeat(Double.parseDouble(request.getParameterValues(Parameters.COMBUSTION_HEAT)[i]));
                    sub.setAverageSpeedBurnout(Double.parseDouble(request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i]));
                    FlammableSubstanceService.getInstance().createSubstance(sub);

                } else if (!request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() && (
                        request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() ||
                                request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() ||
                                request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() ||
                                request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty())) {

                    sub.setId(Long.parseLong(request.getParameterValues(Parameters.ID_SUBSTANCE)[i]));
                    FlammableSubstanceService.getInstance().deleteSubstance(sub);

                } else if (!request.getParameterValues(Parameters.ID_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.COMBUSTION_HEAT)[i].isEmpty() &&
                        !request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i].isEmpty()) {

                    sub.setId(Long.parseLong(request.getParameterValues(Parameters.ID_SUBSTANCE)[i]));
                    sub.setNameOfSubstance(request.getParameterValues(Parameters.NAME_OF_SUBSTANCE)[i]);
                    sub.setAmountOfCombustionAir(Double.parseDouble(request.getParameterValues(Parameters.AMOUNT_OF_COMBUSTION_AIR)[i]));
                    sub.setCombustionHeat(Double.parseDouble(request.getParameterValues(Parameters.COMBUSTION_HEAT)[i]));
                    sub.setAverageSpeedBurnout(Double.parseDouble(request.getParameterValues(Parameters.AVERAGE_SPEED_BURNOUT)[i]));
                    FlammableSubstanceService.getInstance().updateSubstance(sub);
                }
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return new GoToListOfSubstances().execute(request, response);
        } catch (IllegalArgumentException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.CALCULATE_INCORRECT_ERROR);
            return new GoToListOfSubstances().execute(request, response);
        }
        return new GoToListOfSubstances().execute(request, response);
    }
}
