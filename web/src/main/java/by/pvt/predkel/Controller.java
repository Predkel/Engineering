package by.pvt.predkel;

import by.pvt.predkel.command.Command;
import by.pvt.predkel.commandFactory.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ну тот самый контроллер
 */
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.INSTANCE;
        Command command = commandFactory.defineCommand(request);
        String page = command.execute(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
