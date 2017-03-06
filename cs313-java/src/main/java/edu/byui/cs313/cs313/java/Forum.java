/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.cs313.cs313.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus Arredondo
 */
@WebServlet(name = "Forum", urlPatterns = {"/Forum"})
public class Forum extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        File directory = new File("/userinfo.txt");
        String fileName = request.getRealPath("/userinfo.txt");

        boolean line = this.readFile(fileName, username, password);

        if (line == true) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            request.getRequestDispatcher("WEB-INF/viewpost.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
        }

    }

    public boolean readFile(String fileName, String username, String password) throws FileNotFoundException, IOException {
        boolean data = false;
        String[] userData = null;
        try (FileReader in = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(in);
            String l = null;

            while ((l = br.readLine()) != null) {
                userData = l.split(",");
                String savedUserName = userData[0];
                String savedPassword = userData[1];

                if (savedUserName.equals(username) && savedPassword.equals(password)) {
                    data = true;
                    return data;
                }
            }
        }
        return data;
    }
}
