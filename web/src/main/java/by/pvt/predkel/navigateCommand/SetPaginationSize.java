package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class SetPaginationSize extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int size = Integer.valueOf(request.getParameter(Parameters.PAGINATION_SIZE));
        request.getSession().setAttribute(Attributes.PAGINATION_SIZE, size);
        return new GoToListOfSubstances().execute(request, response);
    }
}
