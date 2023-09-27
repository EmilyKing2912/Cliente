package Controlador;

import Modelo.ModeloCliente;
import Vista.VentanaCambioClave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlCambioClave
{
    static VentanaCambioClave ventanaCambioClave;
    ModeloCliente modeloCliente;
    public ControlCambioClave(ModeloCliente modeloCliente)
    {
        ventanaCambioClave = new VentanaCambioClave();
        this.modeloCliente = modeloCliente;
        ListenerBotones action = new ListenerBotones();
        ventanaCambioClave.agregarListener(action);
    }

    private class ListenerBotones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String claveActual, claveNueva, confirmarClave, respuesta;
            int opcion = Integer.parseInt(e.getActionCommand());
            switch (opcion)
            {
                case 1://Regresar
                {
                    ventanaCambioClave.setVisible(false);
                    ventanaCambioClave.limpiar();
                    ControlPrincipal.mostrarVentana(true);
                }
                break;
                case 2://Limpiar
                {
                    ventanaCambioClave.limpiar();
                }
                break;
                case 3://Aceptar
                {
                    claveActual = ventanaCambioClave.getClaveActual();
                    claveNueva = ventanaCambioClave.getCalveNueva();
                    confirmarClave = ventanaCambioClave.getConfirmarClave();
                    try
                    {
                        if (!claveActual.equals(""))
                        {
                            if(!claveNueva.equals(""))
                            {
                                if(!confirmarClave.equals(""))
                                {
                                    modeloCliente.enviarMensaje("Verificar usuario y password:" + modeloCliente.getUsuario() + ";" + claveActual);
                                    respuesta = modeloCliente.recibirMensaje();
                                    if(!respuesta.equals("error"))
                                    {
                                        if (Boolean.valueOf(respuesta))
                                        {
                                            if (claveNueva.equals(confirmarClave))
                                            {
                                                if (claveSegura(claveNueva))
                                                {
                                                    ventanaCambioClave.displayConfirmationMassage("Clave modificada exitosamente");
                                                    modeloCliente.enviarMensaje("Cambio de password:" + modeloCliente.getUsuario() + ";" + claveNueva);
                                                    ventanaCambioClave.limpiar();
                                                }
                                                else
                                                {
                                                    throw new Exception("La clave no es segura");
                                                }
                                            }
                                            else
                                            {
                                                throw new Exception("La contraseña nueva no concuerda con la de la confirmacion");
                                            }
                                        }
                                        else
                                        {
                                            throw new Exception("La contraseña actual no coincide con la del registro");
                                        }
                                    }
                                    else
                                    {
                                        throw new Exception("Lo sentimos, tuvimos problems para verificar el password. Intente de nuevo");
                                    }
                                }
                                else
                                {
                                    throw new Exception("El espacio de la confirmacion de la clave se encuentra vacio");
                                }
                            }
                            else
                            {
                                throw new Exception("El espacio de la clave nueva se encuentra vacio");
                            }
                        }
                        else
                        {
                            throw new Exception("El espacio de la clave actual se encuentra vacio");
                        }
                    }
                    catch (Exception exception)
                    {
                        ventanaCambioClave.displayErrorMassage(exception.getMessage());
                        ventanaCambioClave.limpiar();
                    }
                }
                break;
            }
        }
    }

    public boolean claveSegura(String clave)
    {
        char[] password = clave.toCharArray();
        boolean segura = false;
        boolean hayMinuscula = false, hayNumero = false,hayMayuscula=false, hayOchoCaracteres = true;
        if (password.length < 5 || password.length > 10)
        {
            hayOchoCaracteres = false;
        }
        for (int i = 0; i < password.length-1 ; i++)
        {
            if (65 <= password[i] && password[i] <= 90)
            {
                hayMayuscula = true;
            }
            if (97<= password[i] && password[i] <=122)
            {
                hayMinuscula = true;
            }
            if (48<= password[i] && password[i] <= 57)
            {
                hayNumero = true;
            }
        }
        if(hayMinuscula == true && hayNumero == true && hayMayuscula == true && hayOchoCaracteres == true)
        {
            segura = true;
        }
        return segura;
    }

    static void mostrarVentana(boolean estado)
    {
        ventanaCambioClave.setVisible(estado);
    }
}
