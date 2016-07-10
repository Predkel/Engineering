package by.pvt.predkel.controllers;

import by.pvt.predkel.functionalCommand.BuildingsListCommand;
import by.pvt.predkel.functionalCommand.CalculateCommand;
import by.pvt.predkel.functionalCommand.SaveReportCommand;
import by.pvt.predkel.navigateCommand.GoToCalculate;
import by.pvt.predkel.navigateCommand.GoToListOfBuildings;
import by.pvt.predkel.navigateCommand.GoToReCalculate;
import by.pvt.predkel.serviceForDao.IBuildingService;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private IFlammableSubstanceService flammableSubstanceService;
    @Autowired
    private IBuildingService buildingService;

    @RequestMapping(value = "/torecalculate")
    public String goToRecalculate(HttpServletRequest request) throws ServletException, IOException {
        return new GoToReCalculate().execute(request, flammableSubstanceService);
    }

    @RequestMapping(value = "/tocalculate")
    public String goToCalculate(HttpServletRequest request) throws ServletException, IOException {
        return new GoToCalculate().execute(request, flammableSubstanceService);
    }

    @RequestMapping(value = "/tohistory")
    public String goToBuildings(HttpServletRequest request) throws ServletException, IOException {
        return new GoToListOfBuildings().execute(request, buildingService);
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(HttpServletRequest request) throws ServletException, IOException {
        return new CalculateCommand().execute(request, flammableSubstanceService);
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public String buildings(HttpServletRequest request) throws ServletException, IOException {
        return new BuildingsListCommand().execute(request, buildingService);
    }

    @RequestMapping(value = "/savereport")
    public String saveReport(HttpServletRequest request) throws ServletException, IOException {
        return new SaveReportCommand().execute(request, buildingService);
    }

}

