import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class Interfaz extends JFrame {

    public Interfaz(){

        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Interfaz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);

        
        AccedeATuCuenta();

        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }

    public void AccedeATuCuenta() {

        JPanel AccedeATuCuenta = new JPanel();
        AccedeATuCuenta.setSize(this.getWidth(),this.getHeight());
        AccedeATuCuenta.setBackground(Color.decode("#2C3333"));
        AccedeATuCuenta.setLocation(0,0);
        AccedeATuCuenta.setLayout(null);
        
        JLabel accedeText = new JLabel("Accede");
        accedeText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        accedeText.setForeground(Color.decode("#0E8388"));
        accedeText.setSize(150,50);
        accedeText.setLocation(175,50);
        AccedeATuCuenta.add(accedeText);

        JLabel aTuCuentaText = new JLabel("a tu cuenta");
        aTuCuentaText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        aTuCuentaText.setForeground(Color.decode("#0E8388"));
        aTuCuentaText.setSize(200,50);
        aTuCuentaText.setLocation(145,80);
        AccedeATuCuenta.add(aTuCuentaText);

        JLabel imagen = new JLabel(new ImageIcon("Interfaz\\img\\ingreso.png"));
        imagen.setLocation(155,170);
        imagen.setSize(150,180);
        AccedeATuCuenta.add(imagen);

        JLabel Nombre = new JLabel("Ingrese su correo");
        Nombre.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Nombre.setForeground(Color.decode("#0E8388"));
        Nombre.setSize(200,50);
        Nombre.setLocation(75,380);
        AccedeATuCuenta.add(Nombre);

        JTextField nombredata = new JTextField();
        nombredata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        nombredata.setSize(350,30);
        nombredata.setLocation(76,425);
        AccedeATuCuenta.add(nombredata);

        JLabel Contrasena = new JLabel("Ingrese su contraseña");
        Contrasena.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Contrasena.setForeground(Color.decode("#0E8388"));
        Contrasena.setSize(350,50);
        Contrasena.setLocation(75,450);
        AccedeATuCuenta.add(Contrasena);

        JPasswordField contradata = new JPasswordField();
        contradata.setSize(350,30);
        contradata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        contradata.setLocation(76,495);
        AccedeATuCuenta.add(contradata);

        JButton IniciarSesion = new JButton();
        IniciarSesion.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		IniciarSesion.setSize(150, 40);
		IniciarSesion.setLocation(255, 550);
		IniciarSesion.setText("Iniciar Sesion");
        IniciarSesion.setBackground(Color.decode("#2C3333"));
        IniciarSesion.setForeground(Color.decode("#FFFFFF"));
		AccedeATuCuenta.add(IniciarSesion);

        // agregar actionListener para conectar el HolaUsuario();

        JButton Cancelar = new JButton();
        Cancelar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		Cancelar.setSize(150, 40);
		Cancelar.setLocation(95, 550);
		Cancelar.setText("Cancelar");
        Cancelar.setBackground(Color.decode("#2C3333"));
        Cancelar.setForeground(Color.decode("#FFFFFF"));
		AccedeATuCuenta.add(Cancelar);

        this.add(AccedeATuCuenta);
    }

    public void HolaUsuario(){
        
        //falta hacer este
    }

}
