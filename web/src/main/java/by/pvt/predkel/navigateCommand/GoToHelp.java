package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class GoToHelp extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Path.HELP_PATH;
    }
}