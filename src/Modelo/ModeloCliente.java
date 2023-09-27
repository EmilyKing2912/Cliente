package Modelo;

import Controlador.ControlLogin;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloCliente extends Thread
{
    String Usuario;
    final int PUERTO = 7020;
    final String HOST = "localhost";
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public ModeloCliente()
    {
        Usuario = "";
    }

    public String getUsuario()
    {
        return Usuario;
    }

    public void setUsuario(String usuario)
    {
        Usuario = usuario;
    }

    public void conectarConServidor()
    {
        try
        {
            socket = new Socket(HOST, PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void craarFlujo()
    {
        try
        {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            bufferedReader = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bufferedWriter = new BufferedWriter(osw);
        }
        catch (IOException ex)
        {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(String mensaje)
    {
        try
        {
            bufferedWriter.write(mensaje);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (IOException ex)
        {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String recibirMensaje()
    {
        try
        {
            String mensaje = bufferedReader.readLine();
            return mensaje;
        }
        catch (IOException ex)
        {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
/*
    public void run()
    {
        while (true)
        {
            String mensaje = recibirMensaje();
            System.out.println("El servidor dice: " + mensaje);
            controlador.setRespuesta(mensaje);
        }
    }
 */
}
