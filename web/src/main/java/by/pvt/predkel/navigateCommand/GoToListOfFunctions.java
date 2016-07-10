package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Path;

/**
 *
 */
public class GoToListOfFunctions extends AbstractCommand {

    public String execute() {
        return Path.FUNCTIONS_PATH;
    }
}
