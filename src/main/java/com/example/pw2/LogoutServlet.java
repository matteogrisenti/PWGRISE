package com.example.pw2;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Rimuovo i Session Cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("JSESSIONID=" + cookie.getValue());
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        // Rimuovo i cookie per il form ricontattami
        if(ModelCookies.checkCookiesAllowed(request)){
            Cookie nome_cognome = new Cookie("nome_cognome","");
            Cookie mail = new Cookie("mail", "");
            nome_cognome.setMaxAge(0);   // stessa età della sessione
            mail.setMaxAge(0);
            response.addCookie(nome_cognome);
            response.addCookie(mail);
        }

        response.sendRedirect("login.jsp");
    }

}
