package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Admin on 05.06.2016.
 */
public class ChangeLocale extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter(Parameters.LANGUAGE);
        request.getSession().setAttribute(Attributes.LOCALE, language);
        return Path.FUNCTIONS_PATH;
    }
}
