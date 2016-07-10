package by.pvt.predkel.controllers;

import by.pvt.predkel.functionalCommand.ChangeLocale;
import by.pvt.predkel.functionalCommand.LoginUserCommand;
import by.pvt.predkel.functionalCommand.LogoutUserCommand;
import by.pvt.predkel.navigateCommand.GoToHelp;
import by.pvt.predkel.navigateCommand.GoToListOfFunctions;
import by.pvt.predkel.navigateCommand.SetPaginationSize;
import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.serviceForDao.IBuildingService;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import by.pvt.predkel.serviceForDao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IFlammableSubstanceService flammableSubstanceService;
    @Autowired
    private IBuildingService buildingService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage() {
        return Path.INDEX_PATH;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request) throws ServletException, IOException {
        return new LoginUserCommand().execute(request, userService);
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new LogoutUserCommand().execute(request, response);
    }

    @RequestMapping(value = "/tohelp")
    public String goToHelp() throws ServletException, IOException {
        return new GoToHelp().execute();
    }

    @RequestMapping(value = "/tofunctions")
    public String goToFunctions() throws ServletException, IOException {
        return new GoToListOfFunctions().execute();
    }

    @RequestMapping(value = "/setlanguage")
    public String changeLocale(HttpServletRequest request) throws ServletException, IOException {
        return new ChangeLocale().execute(request);
    }

    @RequestMapping(value = "/setsize")
    public String serPaginationSize(HttpServletRequest request) throws ServletException, IOException {
        return new SetPaginationSize().execute(request, flammableSubstanceService);
    }
}

