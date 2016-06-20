package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.logger.MyLogger;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Errors;
import by.pvt.predkel.parameters.Parameters;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LoginUserCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        if (request.getParameter(Parameters.LOGIN).isEmpty() || request.getParameter(Parameters.PASSWORD).isEmpty()) {
            request.setAttribute(Attributes.ERROR, Errors.USER_EMPTY_ERROR);
            return Path.INDEX_PATH;
        }
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);

        try {

            User user = UserService.getInstance().loginUser(login, password);
            if (user != null) {
                request.getSession(true).setAttribute(Attributes.USER, user);
                return Path.FUNCTIONS_PATH;
            } else {
                request.setAttribute(Attributes.ERROR, Errors.USER_INCORRECT_ERROR);
                return Path.INDEX_PATH;
            }
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.INDEX_PATH;
        }
    }
}
