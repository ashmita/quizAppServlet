package controller;

import domains.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Shreha on 8/19/2016.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);
            if (user!=null) {

                request.setAttribute("message","Login Success!");
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }



        }
        if (page.equalsIgnoreCase("logout")) {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("list")) {
            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList",userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
