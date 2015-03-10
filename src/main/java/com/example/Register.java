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

public class Register extends HttpServlet {

   protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      
      // Turn off logging to prevent polluting the output.
      Logger.getLogger("com.box.sdk").setLevel(Level.OFF);
      BoxAPIConnection api = new BoxAPIConnection(Main.getDevToken());
     
      BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();
      BoxFolder rootFolder = BoxFolder.getRootFolder(api); 
      
      String email = req.getParameter("email");
      String folder = "Users";
      boolean newUser = true;
      String mainFolderID = "";
         
      // did the user input an email?
      if(!email.isEmpty()) {        
         // search for the folder with the name "Users"
         for (BoxItem.Info itemInfo : rootFolder) {
               
            // determine if the inputed email already exists within the "Users" folder.
            // If not, create a new user folder with inputed email.
            if(itemInfo.getName().equals(folder)) {
               mainFolderID = itemInfo.getID();
               
               BoxFolder user = new BoxFolder(api, itemInfo.getID());
               for(BoxItem.Info userFolder : user) {
                  
                  if(userFolder.getName().equals(email)) {
                     newUser = false;
                     break;
                  }
               }
            }
         }
      }
      else {
         newUser = false;
      }
      
      // if the email is valid and does not exist, create new user folder
      // else, redirect to invalid registration page
      if(newUser) {
         BoxFolder parentFolder = new BoxFolder(api, mainFolderID);
         BoxFolder.Info childFolderInfo = parentFolder.createFolder(email);
         Main.setUserFolderName(email);
         String nextJSP = "/regsuccess.jsp";
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
         dispatcher.forward(req,resp); 
      }
      else {
         String nextJSP = "/invalidregister.jsp";
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
         dispatcher.forward(req,resp);   
      }
      
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
