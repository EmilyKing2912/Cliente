package Controlador;

import Modelo.ModeloCliente;
import Vista.VentanaCambioClave;
import Vista.VentanaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPrincipal
{
    static VentanaPrincipal ventanaPrincipal;
    ControlConsultaSaldo ventaConsultaSaldo;
    ControlCambioClave ventanaCambioClave;
    ControlRetiro ventanaRetiro;
    ModeloCliente modeloCliente;

    public ControlPrincipal(ModeloCliente modeloCliente)
    {
        ventanaPrincipal = new VentanaPrincipal();
        this.modeloCliente = modeloCliente;
        ventaConsultaSaldo = new ControlConsultaSaldo(modeloCliente);
        ventanaCambioClave = new ControlCambioClave(modeloCliente);
        ventanaRetiro = new ControlRetiro(modeloCliente);
        ListenerBotones action = new ListenerBotones();
        ventanaPrincipal.agregarListener(action);
    }

    private class ListenerBotones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int opcion = Integer.parseInt(e.getActionCommand());
            switch (opcion)
            {
                case 1://Consultar
                {
                    ventanaPrincipal.setVisible(false);
                    ventaConsultaSaldo.mostrarSaldo();
                    ventaConsultaSaldo.mostrarVentana(true);
                }
                break;
                case 2://Cambio
                {
                    ventanaPrincipal.setVisible(false);
                    ventanaCambioClave.mostrarVentana(true);
                }
                break;
                case 3://Salir
                {
                    ventanaPrincipal.setVisible(false);
                    modeloCliente.setUsuario("");
                    ControlLogin.mostrarVentana(true);
                }
                break;
                case 4://Retiro
                {
                    ventanaPrincipal.setVisible(false);
                    ventanaRetiro.mostrarSaldo();
                    ventanaRetiro.mostrarVentana(true);
                }
                break;
            }
        }
    }

    static void mostrarVentana(boolean estado)
    {
        ventanaPrincipal.setVisible(estado);
    }
}
