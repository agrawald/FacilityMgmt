package com.fms;

import com.fms.services.FacilitySvc;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by e7006722 on 11/03/14.
 */
public class FMSServlet extends HttpServlet{
    private static ApplicationContext appContext;
    private FacilitySvc facilitySvc;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        facilitySvc = (FacilitySvc) appContext.getBean("facilitySvc");
        resp.getWriter().print("Hello from Java!\n");
    }
    public static void main(String[] args) throws Exception{
        appContext =
                new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml");
        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        Server server = new Server(5000);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new DispatcherServlet()),"/*");
        server.start();
        server.join();
    }
}
