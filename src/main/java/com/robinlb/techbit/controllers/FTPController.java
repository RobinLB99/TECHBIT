package com.robinlb.techbit.controllers;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Robin
 */
public class FTPController {

  private String server = "localhost";
  private int port = 21;
  private String user = "TechBit";
  private String pass = "123456";

  public FTPClient connectServer(FTPClient ftpClient) {
    try {
      ftpClient.connect(server, port);
      ftpClient.login(user, pass);
      ftpClient.enterLocalPassiveMode();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return ftpClient;
  }

  public void disconnectServer(FTPClient ftpClient) {
    try {
      if (ftpClient.isConnected()) {
        ftpClient.logout();
        ftpClient.disconnect();
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public boolean uploadFile(InputStream inputStream, String serverFilePath, FTPClient ftpClient) {
    boolean done;
    try {
      done = ftpClient.storeFile(serverFilePath, inputStream);
    }
    catch (IOException ex) {
      done = false;
    }
    return done;
  }

}
