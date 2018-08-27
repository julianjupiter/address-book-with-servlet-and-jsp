package io.github.julianjupiter.addressbook.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContactController", urlPatterns = "/contacts")
public class ContactController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
        System.out.println("GET " + request.getRequestURI());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
        
    }
    
}
