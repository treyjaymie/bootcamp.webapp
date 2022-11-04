package com.bootcamp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bootcamp.demo.bean.RegistrationFormBean;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 4319441655255225651L;
	
	private static final Logger LOGGER = LogManager.getLogger(RegistrationServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final RegistrationFormBean registrationFormBean = toRegistrationFormBean(request);
		request.setAttribute("registrationFormBean", registrationFormBean);
		LOGGER.info("action=register, registration_form_bean={}", registrationFormBean);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/success");
		dispatcher.forward(request, response);
	}
	
	private RegistrationFormBean toRegistrationFormBean(HttpServletRequest request) {
		RegistrationFormBean registrationFormBean = new RegistrationFormBean();
		registrationFormBean.setFirstName(request.getParameter("firstName"));
		registrationFormBean.setLastName(request.getParameter("lastName"));
		registrationFormBean.setEmail(request.getParameter("email"));
		registrationFormBean.setPassword(request.getParameter("password"));
		registrationFormBean.setConfirmPassword(request.getParameter("confirmPassword"));
		return registrationFormBean;
		// From the form to the back end
	}
}
