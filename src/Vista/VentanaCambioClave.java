package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaCambioClave extends JFrame
{
    JPanel ventanaCambio;
    JLabel LBL_ClaveActual;
    JLabel LBL_ClaveNueva;
    JLabel LBL_ConfirmarClave;
    JButton BTN_Regresar;
    JButton BTN_Limpiar;
    JButton BTN_Aceptar;
    JTextField TXT_ClaveActual;
    JTextField TXT_ClaveNueva;
    JTextField TXT_ConfirmarClave;
    GridBagConstraints gbc;

    public VentanaCambioClave()
    {
        super("Cambio de clave");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(493,324);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/Vista/Iconos/user.png");
        super.setIconImage(icono);
        ventanaCambio = new JPanel();
        agregarElementos(this.getContentPane());
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void agregarListener(ActionListener action)
    {
        BTN_Regresar.addActionListener(action);
        BTN_Limpiar.addActionListener(action);
        BTN_Aceptar.addActionListener(action);
    }

    private void agregarElementos(Container contentPane)
    {
        LBL_ClaveActual = new JLabel("Clave Actual");
        LBL_ClaveNueva = new JLabel("Clave Nueva");
        LBL_ConfirmarClave = new JLabel("Confirmar Clave");
        BTN_Regresar = new javax.swing.JButton("Regresar");
        BTN_Limpiar = new javax.swing.JButton("Limpiar");
        BTN_Aceptar = new javax.swing.JButton("Aceptar");
        TXT_ClaveActual = new javax.swing.JTextField();
        TXT_ClaveNueva = new javax.swing.JTextField();
        TXT_ConfirmarClave = new javax.swing.JTextField();

        contentPane.setBackground(new Color(230, 225, 245));
        contentPane.setLayout(new GridBagLayout());

        LBL_ClaveActual.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(45, 40, 0, 0);
        contentPane.add(LBL_ClaveActual, gbc);

        LBL_ClaveNueva.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(45, 40, 0, 0);
        contentPane.add(LBL_ClaveNueva, gbc);

        LBL_ConfirmarClave.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(45, 40, 0, 0);
        contentPane.add(LBL_ConfirmarClave, gbc);

        BTN_Regresar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Regresar.setActionCommand("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.gridwidth = 3;
        gbc.ipadx = 17;
        gbc.ipady = 8;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(44, 47, 37, 22);
        contentPane.add(BTN_Regresar, gbc);

        BTN_Limpiar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Limpiar.setActionCommand("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.ipadx = 23;
        gbc.ipady = 8;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(44, 40, 37, 0);
        contentPane.add(BTN_Limpiar, gbc);

        BTN_Aceptar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Aceptar.setActionCommand("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.ipadx = 23;
        gbc.ipady = 8;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(44, 84, 37, 0);
        contentPane.add(BTN_Aceptar, gbc);

        TXT_ClaveActual.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 269;
        gbc.ipady = 9;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(38, 14, 0, 0);
        contentPane.add(TXT_ClaveActual, gbc);

        TXT_ClaveNueva.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 269;
        gbc.ipady = 9;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(38, 14, 0, 0);
        contentPane.add(TXT_ClaveNueva, gbc);

        TXT_ConfirmarClave.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 269;
        gbc.ipady = 9;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(38, 14, 0, 0);
        contentPane.add(TXT_ConfirmarClave, gbc);
    }

    public String getClaveActual()
    {
        return TXT_ClaveActual.getText();
    }

    public String getCalveNueva()
    {
        return TXT_ClaveNueva.getText();
    }

    public String getConfirmarClave()
    {
        return TXT_ConfirmarClave.getText();
    }

    public void setClaveActual(String texto)
    {
        TXT_ClaveActual.setText(texto);
    }

    public void setClaveNueva(String texto)
    {
        TXT_ClaveNueva.setText(texto);
    }

    public void setConfirmarClave(String texto)
    {
        TXT_ConfirmarClave.setText(texto);
    }

    public void limpiar()
    {
        setClaveActual("");
        setClaveNueva("");
        setConfirmarClave("");
    }

    public void displayErrorMassage(String error)
    {
        JOptionPane.showMessageDialog(this,error,"Error de formato !",JOptionPane.ERROR_MESSAGE);
    }

    public void displayConfirmationMassage(String mensaje)
    {
        JOptionPane.showMessageDialog(this,mensaje,"Confirmacion !",JOptionPane.INFORMATION_MESSAGE);
    }
}
