package Controlador;

import Modelo.ModeloCliente;
import Vista.VentanaConsultaSaldo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlConsultaSaldo
{
    static VentanaConsultaSaldo ventanaConsultaSaldo;
    ModeloCliente modeloCliente;

    public ControlConsultaSaldo(ModeloCliente modeloCliente)
    {
        ventanaConsultaSaldo = new VentanaConsultaSaldo();
        ListenerBotones action = new ListenerBotones();
        ventanaConsultaSaldo.agregarListener(action);
        this.modeloCliente = modeloCliente;
    }

    private class ListenerBotones implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int opcion = Integer.parseInt(e.getActionCommand());
            switch (opcion)
            {
                case 1:
                {
                    ventanaConsultaSaldo.setVisible(false);
                    ventanaConsultaSaldo.limpiar();
                    ControlPrincipal.mostrarVentana(true);
                }
                break;
            }
        }
    }

    public void mostrarSaldo()
    {
        modeloCliente.enviarMensaje("Devolver saldo:" + modeloCliente.getUsuario());
        String saldo = modeloCliente.recibirMensaje();
        ventanaConsultaSaldo.setSaldo(saldo);
    }

    static void mostrarVentana(boolean estado)
    {
        ventanaConsultaSaldo.setVisible(estado);
    }
}
