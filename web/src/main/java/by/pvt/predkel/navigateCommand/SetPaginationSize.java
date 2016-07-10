package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class SetPaginationSize extends AbstractCommand {

    public String execute(HttpServletRequest request, IFlammableSubstanceService flammableSubstanceService) {
        int size = Integer.valueOf(request.getParameter(Parameters.PAGINATION_SIZE));
        request.getSession().setAttribute(Attributes.PAGINATION_SIZE, size);
        return new GoToListOfSubstances().execute(request, flammableSubstanceService);
    }
}
