package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaConsultaSaldo extends JFrame
{
    JPanel VentanaConsultaSaldo;
    JTextField TXT_Saldo;
    JLabel LBL_Saldo;
    JButton BTN_Regresar;
    GridBagConstraints gbc;

    public VentanaConsultaSaldo()
    {
        super("Pantalla de Consulta de Saldo");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(417,264);
        setResizable(false);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/Vista/Iconos/atm.png");
        super.setIconImage(icono);
        VentanaConsultaSaldo= new JPanel();
        agregarElementos(this.getContentPane());
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void agregarListener(ActionListener action)
    {
        BTN_Regresar.addActionListener(action);
    }

    public String getSaldo()
    {
        return TXT_Saldo.getText();
    }

    public void setSaldo(String saldo)
    {
        TXT_Saldo.setText(saldo);
    }

    public void limpiar()
    {
        setSaldo("");
    }

    private void agregarElementos(Container contentPane)
    {
        TXT_Saldo = new JTextField();
        LBL_Saldo = new JLabel("Saldo de cuenta");
        BTN_Regresar = new JButton("Regresar");

        contentPane.setBackground(new Color(230, 225, 245));
        contentPane.setLayout(new GridBagLayout());

        TXT_Saldo.setFont(new Font("Times New Roman", 2, 14));
        TXT_Saldo.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.ipadx = 237;
        gbc.ipady = 12;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(58, 10, 0, 35);
        contentPane.add(TXT_Saldo, gbc);

        LBL_Saldo.setFont(new Font("Times New Roman", 2, 14));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(67, 39, 0, 0);
        contentPane.add(LBL_Saldo, gbc);

        BTN_Regresar.setFont(new Font("Times New Roman", 2, 14));
        BTN_Regresar.setActionCommand("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 39;
        gbc.ipady = 7;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(42, 22, 97, 0);
        contentPane.add(BTN_Regresar, gbc);
    }
}
