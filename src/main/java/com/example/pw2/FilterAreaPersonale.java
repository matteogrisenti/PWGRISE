package com.example.pw2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "FilterAreaPersonale")
public class FilterAreaPersonale implements Filter {

    ModelSessione ms;

    public void init(FilterConfig config) throws ServletException {}
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;     // converto la richiesta in HttpServletRequest
        HttpServletResponse httpResponse = (HttpServletResponse) response;     // converto la richiesta in HttpServletRequest
        HttpSession session = httpRequest.getSession(false);            //controllo se ci sono gia sessioni esistenti, senza crearne di nuove

        if(session != null){
            chain.doFilter(request, response);
        }else{
            RequestDispatcher requestDispatcher;
            requestDispatcher=httpRequest.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(httpRequest, httpResponse);
        }

    }


}
