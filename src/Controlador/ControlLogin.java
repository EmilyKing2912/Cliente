package Controlador;

import Modelo.ModeloCliente;
import Vista.VentanaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ControlLogin
{
    static VentanaLogin ventanaLogin;
    ControlPrincipal ventanaPrincipal;
    static ModeloCliente modeloCliente;

    public ControlLogin()
    {
        ventanaLogin = new VentanaLogin();
        modeloCliente = new ModeloCliente();
        ventanaPrincipal = new ControlPrincipal(modeloCliente);
        ventanaLogin.setControlador(this);
        ListenerBotones action = new ListenerBotones();
        WindowListener listener = new WindowListener();
        ventanaLogin.agregarListener(action);
        ventanaLogin.agregarListenerVentana(listener);
        arrancar();
    }

    private class ListenerBotones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String usuario,password;
            String respuesta;
            int opcion = Integer.parseInt(e.getActionCommand());
            switch (opcion)
            {
                case 1://Aceptar
                {
                    try
                    {
                        usuario = ventanaLogin.getUsuario();
                        password = ventanaLogin.getPassword();
                        if(!usuario.equals(""))
                        {
                            if(!password.equals(""))
                            {
                                modeloCliente.enviarMensaje("Verificar usuario:" + usuario);
                                respuesta = modeloCliente.recibirMensaje();
                                if(!respuesta.equals("error"))
                                {
                                    if (Boolean.valueOf(respuesta))
                                    {
                                        modeloCliente.enviarMensaje("Verificar usuario y password:" + usuario + ";" + password);
                                        respuesta = modeloCliente.recibirMensaje();
                                        if(!respuesta.equals("error"))
                                        {
                                            if (Boolean.valueOf(respuesta))
                                            {
                                                ventanaLogin.setVisible(false);
                                                ventanaLogin.limpiar();
                                                modeloCliente.setUsuario(usuario);
                                                ventanaPrincipal.mostrarVentana(true);
                                            }
                                            else
                                            {
                                                throw new Exception("La contraseña no es correcta");
                                            }
                                        }
                                        else
                                        {
                                            throw new Exception("Lo sentimos, tuvimos problems para verificar el password. Intente de nuevo");
                                        }
                                    }
                                    else
                                    {
                                        throw new Exception("El usuario no se encuentra registrado");
                                    }
                                }
                                else
                                {
                                    throw new Exception("Lo sentimos, tuvimos problems para verificar el usuario. Intente de nuevo");
                                }
                            }
                            else
                            {
                                throw new Exception("El campo de password se encuentra vacio");
                            }
                        }
                        else
                        {
                            throw new Exception("El campo de usuario se encuentra vacio");
                        }
                    }
                    catch ( NumberFormatException exception)
                    {
                        ventanaLogin.displayErrorMassage("En el campo de usuario solo se aceptan números");
                        ventanaLogin.limpiar();
                    }
                    catch (Exception exception)
                    {
                        ventanaLogin.displayErrorMassage(exception.getMessage());
                        ventanaLogin.limpiar();
                    }
                }
                break;
                case 2://Cancelar
                {
                    ventanaLogin.limpiar();
                }
                break;
            }
        }
    }

    private class WindowListener implements java.awt.event.WindowListener
    {

        @Override
        public void windowOpened(WindowEvent e)
        {
        }

        @Override
        public void windowClosing(WindowEvent e)
        {
            modeloCliente.enviarMensaje("Salir");
            System.out.println("Y nos fuimos");
        }

        @Override
        public void windowClosed(WindowEvent e)
        {
        }

        @Override
        public void windowIconified(WindowEvent e)
        {
        }

        @Override
        public void windowDeiconified(WindowEvent e)
        {
        }

        @Override
        public void windowActivated(WindowEvent e)
        {
        }

        @Override
        public void windowDeactivated(WindowEvent e)
        {
        }
    }

    public void arrancar()
    {
        System.out.println("Conectando con el Servidor. . .");
        modeloCliente.conectarConServidor();
        modeloCliente.craarFlujo();
        modeloCliente.start();
        modeloCliente.enviarMensaje("CL Listo");
        System.out.println("Conectado Exitosamente");
    }

    static void mostrarVentana(boolean estado)
    {
        ventanaLogin.setVisible(estado);
    }
}
