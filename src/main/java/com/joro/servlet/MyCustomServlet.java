package com.joro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/servletTest" )
public class MyCustomServlet extends HttpServlet {
	private static final long serialVersionUID = -1L;

	private static final String CONTENT_TYPE_TEXT_HTML = "text/html";
	private static final String CONTENT_HTML = 
			"<html>"
			+ 	"<head>"
			+ 		"<title>Servlet Workflow Test Page</title>"
			+ 	"</head>"
			+ 	"<body>"
			+ 		"<h1>Servlet Workflow Test Page</h1>"
			+ 		"<h3>Hello from MyCustomServlet</h3>"
			+ 		"This client side request just started MyCustomServlet's "
			+ 		"lifecycle on the server side"
			+ 	"</body>"
			+ "</html>";

	@Override
	public void init() throws ServletException {
		System.out.println( "MyCustomServlet: init called in " + getClass().getName() );
	}
	
	@Override
	public void service( ServletRequest req, ServletResponse res ) throws ServletException, IOException {
		System.out.println( "MyCustomServlet: service called in " + getClass().getName() );
		super.service( req, res );
	}

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException,
			IOException {

		System.out.println( "MyCustomServlet: doGet called in " + getClass().getName() );
		response.setContentType( CONTENT_TYPE_TEXT_HTML );
		response.getWriter().print( CONTENT_HTML );
	}

	@Override
	public void destroy() {
		System.out.println( "MyCustomServlet: destroyed called in " + getClass().getName() );
	}
}
