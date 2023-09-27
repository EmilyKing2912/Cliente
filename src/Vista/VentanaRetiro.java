package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRetiro extends JFrame
{
    JPanel ventanaRetiro;
    JLabel LBL_Saldo;
    JLabel LBL_Retiro;
    JLabel LBL_Resultado;
    JTextField TXT_Retiro;
    JTextField TXT_Resultado;
    JTextField TXT_Saldo;
    JButton BTN_Limpiar;
    JButton BTN_Regresar;
    JButton BTN_Aceptar;
    GridBagConstraints gbc;

    public VentanaRetiro()
    {
        super("Pantalla de Retiro de Dinero");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(460,325);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/Vista/Iconos/atm.png");
        super.setIconImage(icono);
        ventanaRetiro= new JPanel();
        agregarElementos(this.getContentPane());
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void agregarListener(ActionListener action)
    {
        BTN_Limpiar.addActionListener(action);
        BTN_Regresar.addActionListener(action);
        BTN_Aceptar.addActionListener(action);
    }

    private void agregarElementos(Container contentPane)
    {
        LBL_Saldo = new JLabel("Saldo de Cuenta");
        LBL_Retiro = new JLabel("Monto a Retirar");
        LBL_Resultado = new JLabel("Resultado");
        TXT_Retiro = new JTextField();
        TXT_Resultado = new JTextField();
        TXT_Saldo = new JTextField();
        BTN_Limpiar = new JButton("Limpiar");
        BTN_Regresar = new JButton("Regresar");
        BTN_Aceptar = new JButton("Aceptar");

        contentPane.setBackground(new Color(230, 225, 245));
        contentPane.setLayout(new GridBagLayout());

        LBL_Saldo.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(46, 38, 0, 0);
        contentPane.add(LBL_Saldo, gbc);

        LBL_Retiro.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(37, 38, 0, 0);
        contentPane.add(LBL_Retiro, gbc);

        LBL_Resultado.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(37, 38, 0, 0);
        contentPane.add(LBL_Resultado, gbc);

        TXT_Retiro.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 159;
        gbc.ipady = 6;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(31, 62, 0, 42);
        contentPane.add(TXT_Retiro, gbc);

        TXT_Resultado.setFont(new Font("Times New Roman", 2, 14));
        TXT_Resultado.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 159;
        gbc.ipady = 6;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(31, 62, 0, 42);
        contentPane.add(TXT_Resultado, gbc);

        TXT_Saldo.setFont(new Font("Times New Roman", 2, 14)); // NOI18N
        TXT_Saldo.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 159;
        gbc.ipady = 6;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(40, 62, 0, 42);
        contentPane.add(TXT_Saldo, gbc);

        BTN_Limpiar.setFont(new java.awt.Font("Times New Roman", 2, 14));
        BTN_Limpiar.setActionCommand("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.ipadx = 5;
        gbc.ipady = 7;
        gbc.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gbc.insets = new java.awt.Insets(44, 38, 35, 0);
        contentPane.add(BTN_Limpiar, gbc);

        BTN_Regresar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Regresar.setActionCommand("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.ipadx = 4;
        gbc.ipady = 7;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(44, 37, 35, 0);
        contentPane.add(BTN_Regresar, gbc);

        BTN_Aceptar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Aceptar.setActionCommand("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.ipadx = 5;
        gbc.ipady = 7;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(44, 26, 35, 0);
        contentPane.add(BTN_Aceptar, gbc);
    }

    public String getRetiro()
    {
        return TXT_Retiro.getText();
    }

    public String getResultado()
    {
        return TXT_Resultado.getText();
    }

    public String getSaldo()
    {
        return TXT_Saldo.getText();
    }

    public void setRetiro(String texto)
    {
        TXT_Retiro.setText(texto);
    }

    public void setResultado(String texto)
    {
        TXT_Resultado.setText(texto);
    }

    public void setSaldo(String texto)
    {
        TXT_Saldo.setText(texto);
    }

    public void limpiar()
    {
        setRetiro("");
        setResultado("");
        setSaldo("");
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
