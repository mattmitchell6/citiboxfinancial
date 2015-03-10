package com.example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.List;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.box.sdk.BoxFolder;
import com.box.sdk.BoxUser;
import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxItem;



public class UploadLoanRequest extends HttpServlet {

   protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      
      String email = req.getParameter("email");
      String folder = "Users";
      String toUpload;
      int numFiles = 1;
      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy");
      Date date = new Date();
      String filePath = req.getPathTranslated();
      System.out.println("path: " + filePath);
      
      
      

      // Turn off logging to prevent polluting the output.
      Logger.getLogger("com.box.sdk").setLevel(Level.OFF);
      
      BoxAPIConnection api = new BoxAPIConnection(Main.getDevToken());    
      BoxUser.Info userInfo = BoxUser.getCurrentUser(api).getInfo();
      BoxFolder rootFolder = BoxFolder.getRootFolder(api);
      BoxFolder userFolder = null;

      // search for the folder with the name "Users"
      for (BoxItem.Info itemInfo : rootFolder) {

         // find the folder with the correct ID
         if(itemInfo.getName().equals(folder)) {
            
            BoxFolder user = new BoxFolder(api, itemInfo.getID());
            
            for(BoxItem.Info userFolders : user) {
               
               if(userFolders.getName().equals(Main.getUserFolderName())) {
                  userFolder = new BoxFolder(api, userFolders.getID()); 
                  
                  for(BoxItem.Info file : userFolder)
                     numFiles++;
               }
            }
         }
      }

      System.out.println("Folder name: " + userFolder.getInfo().getName() + ".pdf");
      
      InputStream stream = req.getInputStream();
      //InputStream stream = new FileInputStream("/Users/mattstumitchell/Box Sync/Top 10 things to do in Box.pdf");
      
      /*
      String readLine;
      BufferedReader br = new BufferedReader(new InputStreamReader(stream));
       
      while (((readLine = br.readLine()) != null)) {
      System.out.println(readLine);   
      }
      */
      toUpload = "LoanRequest" + numFiles + "_" + dateFormat.format(date) + ".pdf";

      userFolder.uploadFile(stream, toUpload);
      stream.close();

      String nextJSP = "/homepage.jsp";
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
