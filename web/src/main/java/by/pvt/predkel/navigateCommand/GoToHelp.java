package by.pvt.predkel.navigateCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Path;

/**
 *
 */
public class GoToHelp extends AbstractCommand {

    public String execute() {
        return Path.HELP_PATH;
    }
}
