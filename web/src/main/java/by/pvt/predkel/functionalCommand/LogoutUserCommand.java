package by.pvt.predkel.functionalCommand;

import by.pvt.predkel.command.AbstractCommand;
import by.pvt.predkel.parameters.Attributes;
import by.pvt.predkel.parameters.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class LogoutUserCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute(Attributes.ERROR, "Вы покинули приложение");
        request.getSession().invalidate();
        return Path.INDEX_PATH;
    }
}
