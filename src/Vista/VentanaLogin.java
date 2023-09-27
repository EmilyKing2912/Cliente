package Vista;

import Controlador.ControlLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class VentanaLogin extends JFrame
{
    private ControlLogin controlador;
    JPanel ventana_Login;
    JLabel LBL_Usuario;
    JLabel LBL_Password;
    JTextField TXT_Usuario;
    JButton BTN_Aceptar;
    JButton BTN_Cancelar;
    JPasswordField TXT_Password;
    GridBagConstraints gbc;

    public VentanaLogin()
    {
        super("Pantalla de login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(456,323);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/Vista/Iconos/login.png");
        super.setIconImage(icono);
        ventana_Login = new JPanel();
        agregarElementos(this.getContentPane());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void agregarListener(ActionListener action)
    {
        BTN_Aceptar.addActionListener(action);
        BTN_Cancelar.addActionListener(action);
    }

    public void agregarListenerVentana (WindowListener listener)
    {
        super.addWindowListener(listener);
    }

    private void agregarElementos(Container contentPane)
    {
        LBL_Usuario = new JLabel("Usuario");
        LBL_Password = new JLabel("Password");
        TXT_Usuario = new JTextField();
        BTN_Aceptar = new JButton("Aceptar");
        BTN_Cancelar = new JButton("Cancelar");
        TXT_Password = new JPasswordField();

        contentPane.setBackground(new Color(230, 225, 245));
        contentPane.setLayout(new GridBagLayout());

        LBL_Usuario.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(58, 57, 0, 0);
        contentPane.add(LBL_Usuario, gbc);

        LBL_Password.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(73, 57, 0, 0);
        contentPane.add(LBL_Password, gbc);

        TXT_Usuario.setFont(new Font("Times New Roman", 1, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        gbc.gridheight = 2;
        gbc.ipadx = 221;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(55, 54, 0, 64);
        contentPane.add(TXT_Usuario, gbc);

        BTN_Aceptar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Aceptar.setActionCommand("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 5;
        gbc.ipadx = 77;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(32, 57, 40, 0);
        contentPane.add(BTN_Aceptar, gbc);

        BTN_Cancelar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Cancelar.setActionCommand("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 5;
        gbc.ipadx = 72;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(32, 26, 40, 64);
        contentPane.add(BTN_Cancelar, gbc);

        TXT_Password.setFont(new Font("Times New Roman", 1, 14)); // NOI18N
        TXT_Password.setEchoChar('*');
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 6;
        gbc.gridheight = 2;
        gbc.ipadx = 221;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(70, 54, 0, 64);
        contentPane.add(TXT_Password, gbc);
    }

    public String getUsuario()
    {
        return TXT_Usuario.getText();
    }

    public String getPassword()
    {
        return String.valueOf(TXT_Password.getPassword());
    }

    public void setUsuario(String texto)
    {
        TXT_Usuario.setText(texto);
    }

    public void setPassword(String texto)
    {
        TXT_Password.setText(texto);
    }

    public void setControlador(ControlLogin controlador)
    {
        this.controlador = controlador;
    }

    public void limpiar()
    {
        setPassword("");
        setUsuario("");
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
