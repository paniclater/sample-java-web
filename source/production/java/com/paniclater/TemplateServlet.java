package com.paniclater;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TemplateServlet extends HttpServlet {
	private static final String DEFAULT_NAME = "Guest";
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped.");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started.");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name;
		if(req.getParameter("name") == null || req.getParameter("name") == "") {
			name = DEFAULT_NAME;
		} else {
			name = req.getParameter("name");
		}
		String html = 	"<!doctype html>";
		html +=		  	"<html><header><title>Hello " + name + "</title></header><body>";
		html +=			"<p>Hello " + name + "</p>";
		html +=			"<form action=\"greeting\" method=\"POST\"><input type=\"text\" name=\"name\">";
		html += 		"<input type=\"submit\" value=\"submit\"></form></body></html>";
		resp.getWriter().println(html);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		this.doGet(req, resp);
	}
	
}
