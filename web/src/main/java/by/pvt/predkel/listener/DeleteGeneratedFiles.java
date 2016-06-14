package by.pvt.predkel.listener;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.utils.DeleteFiles;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Листенер был создан для создания папки с именем пользователя, когда он заходит
 * там бы складывались его графики и отчеты
 * а после выхода удалялись
 * НО пока есть косячок
 */
public class DeleteGeneratedFiles extends HttpServlet implements HttpSessionListener {

    Map sessions = new HashMap();

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User us = (User) session.getAttribute("User");
        File myPath = new File(System.getProperty("user.dir") + "/tomcat/webapps/project/other/" + us.getLogin() + "/");
        myPath.mkdirs();
        sessions.put(session, session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        HttpSession sessionInMap = (HttpSession) sessions.get(session);
        User user = (User) sessionInMap.getAttribute("User");
        DeleteFiles.deleteDir(new File((System.getProperty("user.dir") + "/tomcat/webapps/project/other/" + user.getLogin() + "/")));
    }
}
