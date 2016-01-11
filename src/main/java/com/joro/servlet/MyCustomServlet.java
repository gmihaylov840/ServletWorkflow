package com.joro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/hello" )
public class MyCustomServlet extends HttpServlet {
	private static final long serialVersionUID = -1L;

	private static final String CONTENT_HTML = "<html><head><title>Servlet Workflow Test Page</title></head><body><h1>Servlet Workflow Test Page</h1><h3>Hello from MyCustomServlet</h3><h4></h4>This client side request just started MyCustomServlet's lifecycle on the server side</body></html>";
	private static final String CONTENT_TYPE_TEXT_HTML = "text/html";

	@Override
	public void init() throws ServletException {
		System.out.println( "MyCustomServlet: init called in " + getClass().getName() );
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
