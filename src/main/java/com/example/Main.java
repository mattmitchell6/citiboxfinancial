package com.example;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;
import com.box.sdk.BoxUser;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 */
public class Main {  
 
   private static String userFolderName = new String(); 
   private static final String DEVELOPER_TOKEN = "NAg7gxfH7uXncFbmTaVFyrElv8TnoKa2";
   private static final String YOUR_CLIENT_ID = "no89ya51l401e7922aahz0b9z8e6cdfs";
   private static final String YOUR_CLIENT_SECRET = "jUhsCRNiAGumKiDG8LP0U0K3CTJ8jx3s";
   private static final String YOUR_ACCESS_TOKEN = "7lCXdiyENGUEHQb78VCPd3VlmzzSYh4O";
   private static final String YOUR_REFRESH_TOKEN = "FcMoRVGgJDvodxvyf0xTSLxQoKuoUPgodYK79k0IuKEPIe0KrEPnf3nDmF37AAxi";
   private static final int MAX_DEPTH = 1;  
   
   public static String getDevToken() {
      return DEVELOPER_TOKEN;
   }
   
   public static void setUserFolderName(String email) {
      userFolderName = email;
   }
   
   public static String getUserFolderName() {
      return userFolderName;
   }
      
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
       
       /*
       // This connection won't auto-refresh.
       BoxAPIConnection api = new BoxAPIConnection("YOUR_CLIENT_ID",
        "YOUR_CLIENT_SECRET", "YOUR_ACCESS_TOKEN", "YOUR_REFRESH_TOKEN");
       api.setAutoRefresh(false);

       // If the access token expires, you will have to manually refresh it.
       api.refresh();
       */
     
       
       String webappDirLocation = "src/main/webapp/";
        
        //The port that we should run on can be set into an environment variable
        //Look for that variable and default to 8080 if it isn't there.
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        Server server = new Server(Integer.valueOf(webPort));
        WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        
        root.setParentLoaderPriority(true);
        
        server.setHandler(root);
        
        server.start();
        server.join();   
    }

}
