package com.example.pw2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterCheckLogin")
public class FilterCheckLogin implements Filter {
    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;     // converto la richiesta in HttpServletRequest
        HttpServletResponse httpResponse = (HttpServletResponse) response;     // converto la richiesta in HttpServletRequest
        HttpSession session = httpRequest.getSession(false);            //controllo se ci sono gia sessioni esistenti, senza crearne di nuove

        boolean isLoggedIn = false;

        if(session != null ){
            isLoggedIn  = (session.getAttribute("logged") != null);
        }

        if(isLoggedIn){

            String encodedURL;

            setAttribute(httpRequest, session);

            if(session.getAttribute("role").toString().equals("amministratore")){
                encodedURL = "amministratore.jsp";
            } else {
                encodedURL ="profilo.jsp";
            }

            RequestDispatcher requestDispatcher;
            requestDispatcher=httpRequest.getRequestDispatcher(encodedURL);
            requestDispatcher.forward(httpRequest, httpResponse);
            
        }else{
            chain.doFilter(request,response);
        }


    }

    static void setAttribute(HttpServletRequest httpRequest, HttpSession session) {
        httpRequest.setAttribute("id",session.getAttribute("id"));
        httpRequest.setAttribute("username",session.getAttribute("username"));
        httpRequest.setAttribute("role",session.getAttribute("role"));
        httpRequest.setAttribute("name",session.getAttribute("name"));
        httpRequest.setAttribute("surname",session.getAttribute("surname"));
        httpRequest.setAttribute("date_of_birth",session.getAttribute("date_of_birth"));
        httpRequest.setAttribute("mail",session.getAttribute("mail"));
        httpRequest.setAttribute("phone_number",session.getAttribute("phone_number"));
        httpRequest.setAttribute("listaAttivita", session.getAttribute("listaAttivita"));
    }
}
