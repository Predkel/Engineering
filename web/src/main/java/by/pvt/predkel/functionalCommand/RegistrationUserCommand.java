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
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class RegistrationUserCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        ApplicationContext context = new XmlWebApplicationContext();
        User user = (User) context.getBean("registerUser");

        if (request.getParameter(Parameters.LOGIN).isEmpty() ||
                request.getParameter(Parameters.PASSWORD).isEmpty()) {
            request.setAttribute(Attributes.ERROR, Errors.USER_EMPTY_ERROR);
            return Path.REGISTER_PATH;
        } else {
            user.setLogin(request.getParameter(Parameters.LOGIN));
            user.setPassword(request.getParameter(Parameters.PASSWORD));
            user.setRole(Integer.valueOf(request.getParameter(Parameters.ROLE)));
        }

        Boolean checker;
        try {
            checker = UserService.getInstance().registerUser(user);
        } catch (DaoException e) {
            MyLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Attributes.ERROR, Errors.DB_ERROR);
            return Path.REGISTER_PATH;
        }
        if (!checker) {
            request.setAttribute(Attributes.ERROR, Errors.USER_NOT_EMPTY_LOGIN_ERROR);
            return Path.REGISTER_PATH;
        }

        return Path.FUNCTIONS_PATH;
    }
}
