package com.example.pw2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SignUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    Connection conn = connect.connectDb();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String popupScript;

        try {

            query = "SELECT * FROM LOGINTABLE WHERE USERNAME=?";

            ps = conn.prepareStatement(query);
            ps.setString(1, request.getParameter("username"));
            rs = ps.executeQuery();

            if(rs.next()){  //Esiste già un utente con quel nome
                popupScript ="<script> \n" +
                        "titolo_errore.innerText = \"21: Username: " + request.getParameter("username") + " gia utilizzato\" \n" +
                        "var form = document.getElementById(\"formSignUp\") \n" +
                        "form.appendChild(titolo_errore) \n" +
                        "let input = document.getElementById(\"idUsername\");\n" +
                        "input.setAttribute(\"error\",\"true\")\n" +
                        "let input_label = document.getElementById(\"idUsername_label\")\n" +
                        "input_label.setAttribute(\"error_label\",\"true\") \n" +
                        "document.getElementById(\"idName\").value=\"" + request.getParameter("name") + "\" \n" +
                        "document.getElementById(\"idSurname\").value=\"" + request.getParameter("surname") + "\" \n" +
                        "document.getElementById(\"idMail\").value=\"" + request.getParameter("mail") + "\" \n" +
                        "document.getElementById(\"idUsername\").value=\"" + request.getParameter("username") + "\" \n" +
                        "document.getElementById(\"idNumeroDiTelefono\").value=\"" + request.getParameter("phone_number") + "\" \n" +
                        "document.getElementById(\"idDataDiNascita\").value=\"" + request.getParameter("birth") + "\" \n" +
                        "document.getElementById(\"idPassword1\").value=\"" + request.getParameter("password") + "\" \n" +
                        "document.getElementById(\"idPassword2\").value=\"" + request.getParameter("password") + "\" \n" +
                        "</script>";
                response.setContentType("text/html");

                RequestDispatcher requestDispatcher;
                requestDispatcher=request.getRequestDispatcher("signUp.jsp");
                requestDispatcher.include(request, response);

                PrintWriter out = response.getWriter();
                out.println(popupScript);
            }
            else {
                query = "INSERT INTO LOGINTABLE VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?)";

                ps = conn.prepareStatement(query);
                ps.setString(1, request.getParameter("username"));
                ps.setString(2, request.getParameter("password"));
                ps.setString(3, request.getParameter("role"));
                ps.setString(4, request.getParameter("name"));
                ps.setString(5, request.getParameter("surname"));
                ps.setString(6, request.getParameter("birth"));
                ps.setString(7, request.getParameter("mail"));
                ps.setString(8, request.getParameter("phone_number"));

                if(ps.executeUpdate() > 0){

                    RequestDispatcher requestDispatcher;
                    requestDispatcher=request.getRequestDispatcher("/registrazioneCofermata.jsp");
                    requestDispatcher.forward(request, response);

                }
                else {
                    popupScript = "<script> alert('21: Errore nella registrazione!'); window.location.href = 'signUp.jsp'; </script>";
                }
            }



        } catch (SQLException e) {
            System.out.println("(SignUpServlet) Errore: " + e);
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
