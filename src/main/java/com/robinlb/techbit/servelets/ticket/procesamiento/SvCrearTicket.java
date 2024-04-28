package com.robinlb.techbit.servelets.ticket.procesamiento;

import com.robinlb.techbit.controllers.FTPController;
import com.robinlb.techbit.controllers.LogicController;
import com.robinlb.techbit.model.ArchivoAdjunto;
import com.robinlb.techbit.model.ClienteNatural;
import com.robinlb.techbit.model.TicketSoporte;
import com.robinlb.techbit.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author Robin
 */
@MultipartConfig
@WebServlet(name = "SvCrearTicket", urlPatterns = {"/SvCrearTicket"})
public class SvCrearTicket extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Metodo HTTP <code>POST</code>, que permite crear la creacion y almacenado de datos
   * del ticket de soporte y la carga de archivos adjuntos relacionados.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);

    LogicController control = new LogicController();
    FTPController ftpCon = new FTPController();

    Usuario usuario = (Usuario) request.getSession(false).getAttribute("user");
    ClienteNatural cliente = usuario.getClienteNatural();

    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");
    Part adjunto = request.getPart("adjunto");
    String descripcion = request.getParameter("description");

    try {
      // Crea el ticket de soporte
      TicketSoporte ticket = new TicketSoporte();
      ticket.setCreacion(new Date());
      ticket.setTitulo(titulo);
      ticket.setCategoria(categoria);
      ticket.setDescripcion(descripcion);
      ticket.setEstado("Activo");
      ticket.setClienteNatural(cliente);
      control.crearTicket(ticket);

      try {
        // Conecta al servidor de archivos establecido.
        FTPClient ftpCliente = ftpCon.connectServer(new FTPClient());
        ftpCliente.setFileType(FTP.BINARY_FILE_TYPE);

        // Obtén el InputStream del archivo
        InputStream inputStream = adjunto.getInputStream();

        // Crea el directorio donde el archivo se guarda.
        String carpeta = ticket.getCreacion().getTime()
                + "-" + String.valueOf(Math.round(Math.random() * 100))
                + "-" + ticket.getClienteNatural().getId();
        
        ftpCliente.makeDirectory(carpeta);

        // Define la ruta en el servidor donde quieres guardar el archivo
        String serverFilePath = "/" + carpeta + "/" + adjunto.getSubmittedFileName();

        // Sube el archivo al servidor de archivos.
        boolean done = ftpCon.uploadFile(inputStream, serverFilePath, ftpCliente);

        if (done) {

          try {
            // Crea el archivo adjunto a enlazar
            ArchivoAdjunto adFile = new ArchivoAdjunto();
            adFile.setNombre(adjunto.getSubmittedFileName());
            adFile.setFtpUrl(serverFilePath);
            control.crearAdjunto(adFile);
            
            // Enlaza el adjunto al ticket
            ticket.setArchivoAdjunto(adFile);
            control.actualizarTicket(ticket);
            
            // Redirige a la pagina de creacion de ticket
            response.sendRedirect("CrearTicket.jsp?created=true");
          }
          catch (Exception e) {
            System.out.println("Error al crear el archivo adjunto!");
            response.sendRedirect("PageError500.jsp");
          }

        } else {
          response.sendRedirect("CrearTicket.jsp?adjunto=false");
        }

        // Cerrar el InputStream
        inputStream.close();

        // Cerrar el servidor de archivos
        ftpCon.disconnectServer(ftpCliente);

      }
      catch (Exception e) {
        // Implementar atributo de sesion para expeficicar el error en la pagina de error

        response.sendRedirect("PageError500.jsp");
      }

    }
    catch (Exception e) {
      System.out.println("Error de conexion con la base de datos.");
      response.sendRedirect("PageError500.jsp");
    }

  }// </editor-fold>

}
