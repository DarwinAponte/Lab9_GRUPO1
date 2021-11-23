package com.example.lab9_grupo1;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        System.out.println("hola");
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/home.jsp");
        view.forward(request,response);

    }

    public void destroy() {

    }
}