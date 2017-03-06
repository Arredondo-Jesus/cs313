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
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
@WebServlet(name = "addposts", urlPatterns = {"/addposts"})
public class addposts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/enterposts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String post = request.getParameter("post");
        String username = (String) session.getAttribute("username");
        String fileName = request.getRealPath("userposts.txt");
        List<String> posts = new ArrayList<>();

        writeToFile(username, post, fileName);

        posts.add(username + ":" + post);
        //Collections.reverse(posts);
        //readFile(fileName);
        request.getRequestDispatcher("WEB-INF/viewpost.jsp").forward(request, response);

    }

    public void readFile(String fileName) throws FileNotFoundException, IOException {
        boolean data = false;
        String[] userData = null;
        String l = null;

        try (FileReader in = new FileReader(fileName)) {
            BufferedReader br = new BufferedReader(in);

            while ((l = br.readLine()) != null) {
                userData = l.split(",");
                String user = userData[0];
                String post = userData[1];

            }
        }
    }

    public void writeToFile(String username, String post, String filePath) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath), true))) {
            String l = null;
            bw.write(username + "," + post);
            bw.newLine();
            bw.close();
            br.close();
        }
    }
}
