package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.box.sdk.BoxFolder;
import com.box.sdk.BoxUser;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.BoxUser;

public class HelloServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      
      // Turn off logging to prevent polluting the output.
      Logger.getLogger("com.box.sdk").setLevel(Level.OFF);

      BoxAPIConnection api = new BoxAPIConnection(Main.getDevToken());
      
      BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();
      System.out.format("Welcome, %s <%s>!\n\n", userInfo.getName(), userInfo.getLogin());

      BoxFolder rootFolder = BoxFolder.getRootFolder(api); 
      
      String email = req.getParameter("email");
      String pass = req.getParameter("pass");
      String folder = "Users";
         
      if(!email.isEmpty()) {
         
         // search for the folder with the name "Users"
         for (BoxItem.Info itemInfo : rootFolder) {
   
            // determine if the inputted email exists within the "Users" folder
            if(itemInfo.getName().equals(folder)) {
               
               BoxFolder user = new BoxFolder(api, itemInfo.getID());
               for(BoxItem.Info userFolder : user) {
                  
                  if(userFolder.getName().equals(email)) {
                     Main.setUserEmail(email);
                     String nextJSP = "/homepage.jsp";
                     RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                     dispatcher.forward(req,resp);
                     break;
                  }
               }
            }
         }
         
      
      }
      
      String nextJSP = "/invalidindex.jsp";
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
      dispatcher.forward(req,resp);
   }
   
   
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      processRequest(req, resp);
    }
	
   @Override	
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processRequest(req, resp);
   }
    
}
