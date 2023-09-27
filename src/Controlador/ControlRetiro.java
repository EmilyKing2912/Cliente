package Controlador;

import Modelo.ModeloCliente;
import Vista.VentanaRetiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlRetiro
{
    static VentanaRetiro ventanaRetiro;
    ModeloCliente modeloCliente;


    public ControlRetiro(ModeloCliente modeloCliente)
    {
        ventanaRetiro = new VentanaRetiro();
        this.modeloCliente = modeloCliente;
        ListenerBotones action = new ListenerBotones();
        ventanaRetiro.agregarListener(action);
    }

    private class ListenerBotones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String montoRetiro, respuesta;
            int MontoRetiro,saldo,saldoActual;
            int opcion = Integer.parseInt(e.getActionCommand());
            switch (opcion)
            {
                case 1://Limpiar
                {
                    ventanaRetiro.setRetiro("");
                    ventanaRetiro.setResultado("");
                }
                break;
                case 2://Regresar
                {
                    ventanaRetiro.setVisible(false);
                    ventanaRetiro.limpiar();
                    ControlPrincipal.mostrarVentana(true);
                }
                break;
                case 3://Aceptar
                {
                    try
                    {
                        montoRetiro = ventanaRetiro.getRetiro();
                        modeloCliente.enviarMensaje("Verificar monto:" + modeloCliente.getUsuario() + ";" + montoRetiro);
                        respuesta = modeloCliente.recibirMensaje();
                        if (!respuesta.equals("error"))
                        {
                            if (Boolean.valueOf(respuesta))
                            {
                                MontoRetiro = Integer.valueOf(montoRetiro);
                                modeloCliente.enviarMensaje("Devolver saldo:" + modeloCliente.getUsuario());
                                saldoActual = Integer.valueOf(modeloCliente.recibirMensaje());
                                ventanaRetiro.displayConfirmationMassage("Transacción procesada");
                                saldo = saldoActual - MontoRetiro;
                                modeloCliente.enviarMensaje("Actualizar saldo:" + modeloCliente.getUsuario() + ";" + saldo + "*" + montoRetiro);
                                ventanaRetiro.setResultado(String.valueOf(saldo));
                                ventanaRetiro.displayConfirmationMassage("Retire su dinero");
                            }
                            else
                            {
                                throw new Exception("Dinero insuficiente");
                            }
                        }
                        else
                        {
                            throw new Exception("Lo sentimos, tuvimos problems para verificar que el monto fuera valido. Intente de nuevo");
                        }
                    }
                    catch ( NumberFormatException exception)
                    {
                        ventanaRetiro.displayErrorMassage("En el campo de retiro solo se aceptan números");
                        ventanaRetiro.setRetiro("");
                    }
                    catch (Exception exception)
                    {
                        ventanaRetiro.displayErrorMassage(exception.getMessage());
                        ventanaRetiro.setRetiro("");
                    }
                }
                break;
            }
        }
    }

    public void mostrarSaldo()
    {
        modeloCliente.enviarMensaje("Devolver saldo:" + modeloCliente.getUsuario());
        String saldo = modeloCliente.recibirMensaje();
        ventanaRetiro.setSaldo(saldo);
    }

    static void mostrarVentana(boolean estado)
    {
        ventanaRetiro.setVisible(estado);
    }
}
