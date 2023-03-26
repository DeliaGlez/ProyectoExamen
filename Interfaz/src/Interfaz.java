import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

        
        //AccedeATuCuenta();
        HolaUsuario();

        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }

    public void Menu(JPanel nuevo){

        //JMENUBAR
		JMenuBar barra = new JMenuBar();
		barra.setLocation(0,0);
		barra.setSize(500, 20);
		
		JMenu opc1 = new JMenu("Cuenta");
		JMenu opc2 = new JMenu("Usuarios");
		JMenu opc3 = new JMenu("Ayuda");
		
		barra.add(opc1);
		barra.add(opc2);
		barra.add(opc3);
		
        JMenuItem item11 = new JMenuItem("Mi Cuenta");
        JMenuItem item12 = new JMenuItem("Cerrar Sesion");
		JMenuItem item21 = new JMenuItem("Lista De Usuarios");
		JMenuItem item22 = new JMenuItem("Crear Usuario");
        JMenuItem item31 = new JMenuItem("¿Como crear usuarios?");
		
        opc1.add(item11);
        opc1.add(item12);
		opc2.add(item21);
        opc2.add(item22);
		opc3.add(item31);

        nuevo.add(barra);
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

        JPanel HolaUsuario = new JPanel();
        HolaUsuario.setSize(this.getWidth(),this.getHeight());
        HolaUsuario.setBackground(Color.decode("#2C3333"));
        HolaUsuario.setLocation(0,0);
        HolaUsuario.setLayout(null);

        Menu(HolaUsuario);

        JLabel HolaUsuarioText = new JLabel("Hola Usuario!");
        HolaUsuarioText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        HolaUsuarioText.setForeground(Color.decode("#0E8388"));
        HolaUsuarioText.setSize(250,50);
        HolaUsuarioText.setLocation(130,110);
        HolaUsuario.add(HolaUsuarioText);

        JLabel imagen = new JLabel(new ImageIcon("Interfaz\\img\\hand.png"));
        imagen.setLocation(170,200);
        imagen.setSize(150,150);
        HolaUsuario.add(imagen);

        this.add(HolaUsuario);
    }

}
