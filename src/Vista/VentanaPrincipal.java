package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame
{
    JPanel ventanaPrincipal;
    JButton BTN_Consultar;
    JButton BTN_Cambio;
    JButton BTN_Salir;
    JButton BTN_Retiro;
    GridBagConstraints gbc;

    public VentanaPrincipal()
    {
        super("Pantalla de Retiro de Dinero");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(424,419);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/Vista/Iconos/home.png");
        super.setIconImage(icono);
        ventanaPrincipal= new JPanel();
        agregarElementos(this.getContentPane());
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void agregarListener(ActionListener action)
    {
        BTN_Consultar.addActionListener(action);
        BTN_Cambio.addActionListener(action);
        BTN_Salir.addActionListener(action);
        BTN_Retiro.addActionListener(action);
    }

    private void agregarElementos(Container contentPane)
    {
        BTN_Consultar = new javax.swing.JButton("Consultar Saldo");
        BTN_Cambio = new javax.swing.JButton("Cambio de Clave");
        BTN_Salir = new javax.swing.JButton("Salir");
        BTN_Retiro = new javax.swing.JButton("Hacer Retiro");

        contentPane.setBackground(new Color(230, 225, 245));
        contentPane.setLayout(new GridBagLayout());

        BTN_Consultar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Consultar.setActionCommand("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 107;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(57, 93, 0, 101);
        contentPane.add(BTN_Consultar, gbc);

        BTN_Cambio.setFont(new Font("Times New Roman", 2, 14));
        BTN_Cambio.setActionCommand("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 99;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(45, 93, 0, 101);
        contentPane.add(BTN_Cambio, gbc);

        BTN_Salir.setFont(new Font("Times New Roman", 2, 14));
        BTN_Salir.setActionCommand("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 171;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(46, 93, 54, 101);
        contentPane.add(BTN_Salir, gbc);

        BTN_Retiro.setFont(new Font("Times New Roman", 2, 14));
        BTN_Retiro.setActionCommand("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 125;
        gbc.ipady = 15;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(57, 93, 0, 101);
        contentPane.add(BTN_Retiro, gbc);
    }
}
