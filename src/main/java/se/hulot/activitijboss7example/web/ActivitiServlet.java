package se.hulot.activitijboss7example.web;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.hulot.activitijboss7example.ejb.BpmService;

public class ActivitiServlet extends HttpServlet {
	private static final long serialVersionUID = -6637792492207480164L;

	@EJB
	private BpmService bpmService;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        long processInstanceId = -1;
        try {
        	bpmService.startProcess();
        } catch (Exception e) {
            throw new ServletException(e);
        }

        req.setAttribute("message", "process instance (id = "
                + processInstanceId + ") has been started.");

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
    }

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        long processInstanceId = -1;
        try {
        } catch (Exception e) {
            throw new ServletException(e);
        }

        req.setAttribute("message", "process instance (id = "
                + processInstanceId + ") has been started.");

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context
                .getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, res);
    }
}