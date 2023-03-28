import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;

public class Interfaz extends JFrame {

	public JPanel panel;
	public int anterior;
	public int actual;
	public String nombreUser; 
    public String correoUser;
    public String correoComboSelect;
	
    public Interfaz(){
    	
        Image icono = Toolkit.getDefaultToolkit().getImage("frameicon.jpg");
        this.setIconImage(icono);
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Gestor de usuarios");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        panel = AccedeATuCuenta();
        this.add(panel);
        anterior=1;
        actual=1;
        
        //AccedeATuCuenta();
        //HolaUsuario();
        //CuentaPersonal();
        //ListaDeUsuarios();
        //CrearUsuario();
        //ComoCrearUnUsuario();

        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }
    
    public void actualizarPanel(int ventSiguiente) {
    	anterior=actual;
    	actual=ventSiguiente;
    	
    	if(panel!= null) {
			this.remove(panel);
		}
		
    	switch (actual) {
    	case 1:
    		panel = AccedeATuCuenta(); 
			this.add(panel);
    		break;
    	case 2:
    		panel = HolaUsuario(); 
			this.add(panel);
    		break;
    	case 3:
    		panel = CuentaPersonal(); 
			this.add(panel);
    		break;
    	case 4:
    		panel = ListaDeUsuarios(); 
			this.add(panel);
    		break;
    	case 5:
    		panel = CrearUsuario(); 
			this.add(panel);
    		break;
    	case 6:
    		panel = ComoCrearUnUsuario(); 
			this.add(panel);
    		break;
    	case 7:
    		panel=editarUsuario();
    		this.add(panel);
    		break;
    	}
    	this.repaint();
        this.revalidate();
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
		
        item11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(3);
			}
        	
        });
        item12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(1);
			}
        });
        
        item21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(4);				
			}        	
        });
        
        item22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(5);	
			}
        });
        
        item31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(6);				
			}        	
        });
                       
        opc1.add(item11);
        opc1.add(item12);
		opc2.add(item21);
        opc2.add(item22);
		opc3.add(item31);

        nuevo.add(barra);
    }

    public JPanel AccedeATuCuenta() {

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

        JLabel imagen = new JLabel(new ImageIcon("ingreso.png"));
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

        JButton iniciarSesion = new JButton();
        iniciarSesion.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        iniciarSesion.setSize(150, 40);
		iniciarSesion.setLocation(255, 550);
		iniciarSesion.setText("Iniciar Sesion");
		iniciarSesion.setBackground(Color.decode("#2C3333"));
		iniciarSesion.setForeground(Color.decode("#FFFFFF"));
		
		iniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

                String correo = nombredata.getText();
                String password = String.valueOf(contradata.getPassword());
                String[] data;

                try{
                    BufferedReader BR = new BufferedReader(new FileReader("users.txt"));
                    String renglon;
                    boolean validacion = false;

                    while((renglon = BR.readLine()) != null ){

                        data = renglon.split(",");

                        if (data[2].equals(correo) && data[3].equals(password)) {
                        	nombreUser=data[0];
                            correoUser=data[2];
                            JOptionPane.showMessageDialog(null, "Bienvenido "+ nombreUser,"INGRESO EXITOSO", JOptionPane.INFORMATION_MESSAGE);
                            actualizarPanel(2);
                            validacion = true;
                        }
                    }
                    if (validacion == false){
                        JOptionPane.showMessageDialog(null, "El usuario y contraseña no coindicen","Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }catch(Exception f){
                	System.err.println("No se encontro archivo");
                }
                
				
			}			
		});
		
		AccedeATuCuenta.add(iniciarSesion);

        JButton Cancelar = new JButton();
        Cancelar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		Cancelar.setSize(150, 40);
		Cancelar.setLocation(95, 550);
		Cancelar.setText("Cancelar");
        Cancelar.setBackground(Color.decode("#2C3333"));
        Cancelar.setForeground(Color.decode("#FFFFFF"));
        
        // accion boton cancelar 
        Cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(1);
			}
			
		});
		AccedeATuCuenta.add(Cancelar);

        this.add(AccedeATuCuenta);
		return AccedeATuCuenta;
    }

    public JPanel HolaUsuario(){

        JPanel HolaUsuario = new JPanel();
        HolaUsuario.setSize(this.getWidth(),this.getHeight());
        HolaUsuario.setBackground(Color.decode("#2C3333"));
        HolaUsuario.setLocation(0,0);
        HolaUsuario.setLayout(null);

        Menu(HolaUsuario);

        JLabel HolaUsuarioText = new JLabel("Hola "+ nombreUser +" !", JLabel.CENTER);
        HolaUsuarioText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        HolaUsuarioText.setForeground(Color.decode("#0E8388"));
        HolaUsuarioText.setSize(300,50);
        HolaUsuarioText.setLocation(110,110);
        HolaUsuario.add(HolaUsuarioText);

        JLabel imagen = new JLabel(new ImageIcon("hand.png"));
        imagen.setLocation(170,200);
        imagen.setSize(150,150);
        HolaUsuario.add(imagen);

        this.add(HolaUsuario);
		return HolaUsuario;
    }
    public JPanel CuentaPersonal(){

        JPanel CuentaPersonal = new JPanel();
        CuentaPersonal.setSize(this.getWidth(),this.getHeight());
        CuentaPersonal.setBackground(Color.decode("#2C3333"));
        CuentaPersonal.setLocation(0,0);
        CuentaPersonal.setLayout(null);

        Menu(CuentaPersonal);

        JLabel CuentaPersonalText = new JLabel("Cuenta personal");
        CuentaPersonalText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        CuentaPersonalText.setForeground(Color.decode("#0E8388"));
        CuentaPersonalText.setSize(300,50);
        CuentaPersonalText.setLocation(105,60);
        CuentaPersonal.add(CuentaPersonalText);

        JLabel imagen = new JLabel(new ImageIcon("iconcyan.png"));
        imagen.setSize(150,170);
        imagen.setLocation(170,130);
        CuentaPersonal.add(imagen);

        JLabel Nombre = new JLabel("Nombre:");
        Nombre.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Nombre.setForeground(Color.decode("#0E8388"));
        Nombre.setSize(200,50);
        Nombre.setLocation(75,300);
        CuentaPersonal.add(Nombre);

        JTextField nombredata = new JTextField();
        nombredata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        nombredata.setSize(350,30);
        nombredata.setLocation(76,340);
        CuentaPersonal.add(nombredata);

        JLabel Apellidos = new JLabel("Apellidos:");
        Apellidos.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Apellidos.setForeground(Color.decode("#0E8388"));
        Apellidos.setSize(200,50);
        Apellidos.setLocation(75,360);
        CuentaPersonal.add(Apellidos);

        JTextField Apellidosdata = new JTextField();
        Apellidosdata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Apellidosdata.setSize(350,30);
        Apellidosdata.setLocation(76,400);
        CuentaPersonal.add(Apellidosdata);

        JLabel Email = new JLabel("Correo electronico:");
        Email.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Email.setForeground(Color.decode("#0E8388"));
        Email.setSize(200,50);
        Email.setLocation(75,420);
        CuentaPersonal.add(Email);

        JTextField Emaildata = new JTextField();
        Emaildata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Emaildata.setSize(350,30);
        Emaildata.setLocation(76,460);
        CuentaPersonal.add(Emaildata);

        JLabel Contrasena = new JLabel("Contraseña:");
        Contrasena.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Contrasena.setForeground(Color.decode("#0E8388"));
        Contrasena.setSize(200,50);
        Contrasena.setLocation(75,480);
        CuentaPersonal.add(Contrasena);

        JTextField contradata = new JTextField();
        contradata.setSize(350,30);
        contradata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        contradata.setLocation(76,520);
        CuentaPersonal.add(contradata);
       
        //lectura de datos y asignacion de los datos a los campos 
        String[] data;

        try{
            BufferedReader BR = new BufferedReader(new FileReader("users.txt"));
            String renglon;

            while((renglon = BR.readLine()) != null ){

                data = renglon.split(",");
                if (data[2].equals(correoUser)) {
                	nombredata.setText(data[0]);
                	Apellidosdata.setText(data[1]);
                	Emaildata.setText(data[2]);
                	contradata.setText(data[3]);
   
                }
            }
            BR.close();
 
        }catch(Exception f){
        	System.err.println("No se encontro archivo");
        }
        
        //
        JButton ActualizarDatos = new JButton("Actualizar datos");
        ActualizarDatos.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		ActualizarDatos.setSize(150, 40);
		ActualizarDatos.setLocation(255, 570);
        ActualizarDatos.setBackground(Color.decode("#2C3333"));
        ActualizarDatos.setForeground(Color.decode("#FFFFFF"));
        
        //accion  boton actualizar datos
        ActualizarDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				String nuevoNombre=nombredata.getText();
				String nuevoApell=Apellidosdata.getText();
				String nuevoEmail=Emaildata.getText();
				String nuevaContra=contradata.getText();
				
				FileWriter archivo = null;
                PrintWriter editor = null;
                String[] data;
				boolean encontrado = false;
				
				if(!nuevoNombre.isEmpty()&&!nuevoApell.isEmpty()&&!nuevoEmail.isEmpty()&&!nuevaContra.isEmpty()) {

                    String texto="";
                    String renglon;

                    try (BufferedReader BR = new BufferedReader(new FileReader("users.txt"))) {
                        String temp="";
                        while((renglon = BR.readLine()) != null ){
                            temp= temp + renglon;
                            data = renglon.split(",");
                            
                            if (!(nuevoEmail.contentEquals(correoUser)) && data[2].equals(nuevoEmail)) {
                                JOptionPane.showMessageDialog(null, "Correo ya existente.","ERROR!", JOptionPane.ERROR_MESSAGE);
                                Emaildata.setText(correoUser);
                                encontrado= true;
                            }
                            
                        }
                        texto= temp;
                        BR.close();
                    } catch (HeadlessException | IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
			
                    if(!encontrado){
                        
                        String[] arrText = null;
                        arrText = texto.split(",");

                        for (int i = 0; i < arrText.length; i++){
                            
                            if(arrText[i].equals(correoUser)){
                                arrText[i-2]=nuevoNombre;
                                arrText[i-1]=nuevoApell;
                                arrText[i]=nuevoEmail;
                                arrText[i+1]=nuevaContra;
                            }

                        }

                        correoUser=nuevoEmail;
                        
                        try {

                            archivo = new FileWriter("users.txt");
                            editor = new PrintWriter(archivo);
        
                            for(int i=0; i<arrText.length;i+=4) {

                                if(i!=arrText.length-4){
                                    editor.println(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                                }
                                else{
                                    editor.print(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                                }
                            }

                            JOptionPane.showMessageDialog(null, "Informacion actualizada","Message!", JOptionPane.INFORMATION_MESSAGE);                       

                        } 
                        catch (Exception e1) {
                            System.err.println("Datos NO guardados");
                        } finally{
                            try {
                                archivo.close();
                            } catch (IOException e1) {
                                System.err.println("ERROR");
                            }
                        }
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Llene todos los campos.",null,JOptionPane.ERROR_MESSAGE);
                }
			}   
        });
        
        
		CuentaPersonal.add(ActualizarDatos);

        JButton Cancelar = new JButton();
        Cancelar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		Cancelar.setSize(150, 40);
		Cancelar.setLocation(95, 570);
		Cancelar.setText("Cancelar");
        Cancelar.setBackground(Color.decode("#2C3333"));
        Cancelar.setForeground(Color.decode("#FFFFFF"));
        
        // accion boton cancelar 
        Cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(anterior);
			}
			
		});
        
		CuentaPersonal.add(Cancelar);

        this.add(CuentaPersonal);
		return CuentaPersonal;
    }

    public JPanel editarUsuario(){

        JPanel CuentaPersonal = new JPanel();
        CuentaPersonal.setSize(this.getWidth(),this.getHeight());
        CuentaPersonal.setBackground(Color.decode("#2C3333"));
        CuentaPersonal.setLocation(0,0);
        CuentaPersonal.setLayout(null);

        Menu(CuentaPersonal);

        JLabel CuentaPersonalText = new JLabel("Editando a "+correoComboSelect);
        CuentaPersonalText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        CuentaPersonalText.setForeground(Color.decode("#0E8388"));
        CuentaPersonalText.setSize(300,50);
        CuentaPersonalText.setLocation(105,60);
        CuentaPersonal.add(CuentaPersonalText);

        JLabel imagen = new JLabel(new ImageIcon("iconcyan.png"));
        imagen.setSize(150,170);
        imagen.setLocation(170,130);
        CuentaPersonal.add(imagen);

        JLabel Nombre = new JLabel("Nombre:");
        Nombre.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Nombre.setForeground(Color.decode("#0E8388"));
        Nombre.setSize(200,50);
        Nombre.setLocation(75,300);
        CuentaPersonal.add(Nombre);

        JTextField nombredata = new JTextField();
        nombredata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        nombredata.setSize(350,30);
        nombredata.setLocation(76,340);
        CuentaPersonal.add(nombredata);

        JLabel Apellidos = new JLabel("Apellidos:");
        Apellidos.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Apellidos.setForeground(Color.decode("#0E8388"));
        Apellidos.setSize(200,50);
        Apellidos.setLocation(75,360);
        CuentaPersonal.add(Apellidos);

        JTextField Apellidosdata = new JTextField();
        Apellidosdata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Apellidosdata.setSize(350,30);
        Apellidosdata.setLocation(76,400);
        CuentaPersonal.add(Apellidosdata);

        JLabel Email = new JLabel("Correo electronico:");
        Email.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Email.setForeground(Color.decode("#0E8388"));
        Email.setSize(200,50);
        Email.setLocation(75,420);
        CuentaPersonal.add(Email);

        JTextField Emaildata = new JTextField();
        Emaildata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Emaildata.setSize(350,30);
        Emaildata.setLocation(76,460);
        CuentaPersonal.add(Emaildata);

        JLabel Contrasena = new JLabel("Contraseña:");
        Contrasena.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Contrasena.setForeground(Color.decode("#0E8388"));
        Contrasena.setSize(200,50);
        Contrasena.setLocation(75,480);
        CuentaPersonal.add(Contrasena);

        JTextField contradata = new JTextField();
        contradata.setSize(350,30);
        contradata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        contradata.setLocation(76,520);
        CuentaPersonal.add(contradata);
       
        //lectura de datos y asignacion de los datos a los campos 
        String[] data;

        try{
            BufferedReader BR = new BufferedReader(new FileReader("users.txt"));
            String renglon;

            while((renglon = BR.readLine()) != null ){

                data = renglon.split(",");
                if (data[2].equals(correoComboSelect)) {
                	nombredata.setText(data[0]);
                	Apellidosdata.setText(data[1]);
                	Emaildata.setText(data[2]);
                	contradata.setText(data[3]);
   
                }
            }
            BR.close();
 
        }catch(Exception f){
        	System.err.println("No se encontro archivo");
        }
        
        //
        JButton ActualizarDatos = new JButton("Actualizar datos");
        ActualizarDatos.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		ActualizarDatos.setSize(150, 40);
		ActualizarDatos.setLocation(255, 570);
        ActualizarDatos.setBackground(Color.decode("#2C3333"));
        ActualizarDatos.setForeground(Color.decode("#FFFFFF"));
        
        //accion  boton actualizar datos
        ActualizarDatos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e){
				// TODO Auto-generated method stub
				String nuevoNombre=nombredata.getText();
				String nuevoApell=Apellidosdata.getText();
				String nuevoEmail=Emaildata.getText();
				String nuevaContra=contradata.getText();
				
				FileWriter archivo = null;
                PrintWriter editor = null;
                String[] data;
				boolean encontrado = false;
				
				if(!nuevoNombre.isEmpty()&&!nuevoApell.isEmpty()&&!nuevoEmail.isEmpty()&&!nuevaContra.isEmpty()) {

                    String texto="";
                    String renglon;

                    try (BufferedReader BR = new BufferedReader(new FileReader("users.txt"))) {
                        String temp="";
                        while((renglon = BR.readLine()) != null ){
                            temp= temp + renglon;
                            data = renglon.split(",");
                            
                            if (!(nuevoEmail.contentEquals(correoComboSelect)) && data[2].equals(nuevoEmail)) {
                                JOptionPane.showMessageDialog(null, "Correo ya existente.","ERROR!", JOptionPane.ERROR_MESSAGE);
                                Emaildata.setText(correoComboSelect);
                                encontrado= true;
                            }
                            
                        }
                        texto= temp;
                        BR.close();
                    } catch (HeadlessException | IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
			
                    if(!encontrado){
                        
                        String[] arrText = null;
                        arrText = texto.split(",");

                        for (int i = 0; i < arrText.length; i++){
                            
                            if(arrText[i].equals(correoComboSelect)){
                                arrText[i-2]=nuevoNombre;
                                arrText[i-1]=nuevoApell;
                                arrText[i]=nuevoEmail;
                                arrText[i+1]=nuevaContra;
                            }

                        }

                        correoComboSelect=nuevoEmail;
                        
                        try {

                            archivo = new FileWriter("users.txt");
                            editor = new PrintWriter(archivo);
        
                            for(int i=0; i<arrText.length;i+=4) {

                                if(i!=arrText.length-4){
                                    editor.println(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                                }
                                else{
                                    editor.print(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                                }
                            }

                            JOptionPane.showMessageDialog(null, "Informacion actualizada","Message!", JOptionPane.INFORMATION_MESSAGE);                       

                        } 
                        catch (Exception e1) {
                            System.err.println("Datos NO guardados");
                        } finally{
                            try {
                                archivo.close();
                            } catch (IOException e1) {
                                System.err.println("ERROR");
                            }
                        }
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Llene todos los campos.",null,JOptionPane.ERROR_MESSAGE);
                }
			}   
        });
        
        
		CuentaPersonal.add(ActualizarDatos);

        JButton Cancelar = new JButton();
        Cancelar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		Cancelar.setSize(150, 40);
		Cancelar.setLocation(95, 570);
		Cancelar.setText("Cancelar");
        Cancelar.setBackground(Color.decode("#2C3333"));
        Cancelar.setForeground(Color.decode("#FFFFFF"));
        
        // accion boton cancelar 
        Cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(anterior);
			}
			
		});
        
		CuentaPersonal.add(Cancelar);

        this.add(CuentaPersonal);
		return CuentaPersonal;
    }   
    public JPanel ListaDeUsuarios(){

        JPanel ListaDeUsuarios = new JPanel();
        ListaDeUsuarios.setSize(this.getWidth(),this.getHeight());
        ListaDeUsuarios.setBackground(Color.decode("#2C3333"));
        ListaDeUsuarios.setLocation(0,0);
        ListaDeUsuarios.setLayout(null);

        Menu(ListaDeUsuarios);

        JLabel ListaDeUsuariosText = new JLabel("Lista de usuarios");
        ListaDeUsuariosText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        ListaDeUsuariosText.setForeground(Color.decode("#0E8388"));
        ListaDeUsuariosText.setSize(300,50);
        ListaDeUsuariosText.setLocation(95,60);
        ListaDeUsuarios.add(ListaDeUsuariosText);

        JLabel Editar = new JLabel("Editar");
        Editar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Editar.setForeground(Color.decode("#0E8388"));
        Editar.setSize(200,50);
        Editar.setLocation(75,140);
        ListaDeUsuarios.add(Editar);
		
        String[] data;
		String renglon;
        String texto="";

        try (BufferedReader BR = new BufferedReader(new FileReader("users.txt"))) {

            String temp="";

            while((renglon = BR.readLine()) != null ){
                
                data = renglon.split(",");
                temp= temp + data[2]+",";

            }
            texto = temp;
            
            BR.close();
        } catch (HeadlessException | IOException e1) {
            e1.printStackTrace();
        }

        String[] datosCorreos = null;
        datosCorreos = texto.split(",");

        JComboBox EscogerUsuario = new JComboBox();
        EscogerUsuario.setSize(350,40);
        EscogerUsuario.setSelectedItem(null);
        EscogerUsuario.setLocation(75,190);
        EscogerUsuario.setModel(new DefaultComboBoxModel(datosCorreos));
        EscogerUsuario.setOpaque(true);
        EscogerUsuario.setBackground(Color.decode("#0E8388"));

        JButton EditarUsuario = new JButton("Editar a");
        EditarUsuario.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        EditarUsuario.setSize(350, 40);
        EditarUsuario.setLocation(75, 250);
        EditarUsuario.setBackground(Color.decode("#CBE4DE"));
        EditarUsuario.setForeground(Color.decode("#2C3333"));
        ListaDeUsuarios.add(EditarUsuario);

        EditarUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                correoComboSelect = (String)EscogerUsuario.getSelectedItem();
                actualizarPanel(7);
                
            }
            
        });
        
        EscogerUsuario.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String UsuarioX = (String)EscogerUsuario.getSelectedItem();
                EditarUsuario.setText("Editar a “" + UsuarioX + "” ");
            }
            
        });

        ListaDeUsuarios.add(EscogerUsuario);
        

        TablaConBoton tablita = new TablaConBoton();
        ListaDeUsuarios.add(tablita.getSPTabla());

        JLabel espacioTabla = new JLabel("Espacio de la tabla", JLabel.CENTER);
        espacioTabla.setOpaque(true);
        espacioTabla.setBackground(Color.decode("#0E8388"));
        espacioTabla.setBounds(50,330,400,300);
        ListaDeUsuarios.add(espacioTabla);

        this.add(ListaDeUsuarios);
		return ListaDeUsuarios;
    }

    public JPanel CrearUsuario(){

        JPanel CrearUsuario = new JPanel();
        CrearUsuario.setSize(this.getWidth(),this.getHeight());
        CrearUsuario.setBackground(Color.decode("#2C3333"));
        CrearUsuario.setLocation(0,0);
        CrearUsuario.setLayout(null);

        Menu(CrearUsuario);

        JLabel CuentaPersonalText = new JLabel("Crear usuario");
        CuentaPersonalText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 40));
        CuentaPersonalText.setForeground(Color.decode("#0E8388"));
        CuentaPersonalText.setSize(300,50);
        CuentaPersonalText.setLocation(130,50);
        CrearUsuario.add(CuentaPersonalText);

        JLabel imagen = new JLabel(new ImageIcon("createUsercyan.png"));
        imagen.setSize(150,170);
        imagen.setLocation(190,100);
        CrearUsuario.add(imagen);

        JLabel Nombre = new JLabel("Nombre:");
        Nombre.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Nombre.setForeground(Color.decode("#0E8388"));
        Nombre.setSize(200,50);
        Nombre.setLocation(75,240);
        CrearUsuario.add(Nombre);

        JTextField nombredata = new JTextField();
        nombredata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        nombredata.setSize(350,30);
        nombredata.setLocation(76,280);
        CrearUsuario.add(nombredata);

        JLabel Apellidos = new JLabel("Apellidos:");
        Apellidos.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Apellidos.setForeground(Color.decode("#0E8388"));
        Apellidos.setSize(200,50);
        Apellidos.setLocation(75,300);
        CrearUsuario.add(Apellidos);

        JTextField Apellidosdata = new JTextField();
        Apellidosdata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Apellidosdata.setSize(350,30);
        Apellidosdata.setLocation(76,340);
        CrearUsuario.add(Apellidosdata);

        JLabel Email = new JLabel("Correo electronico:");
        Email.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Email.setForeground(Color.decode("#0E8388"));
        Email.setSize(200,50);
        Email.setLocation(75,360);
        CrearUsuario.add(Email);

        JTextField Emaildata = new JTextField();
        Emaildata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        Emaildata.setSize(350,30);
        Emaildata.setLocation(76,400);
        CrearUsuario.add(Emaildata);

        JLabel Contrasena = new JLabel("Contraseña:");
        Contrasena.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        Contrasena.setForeground(Color.decode("#0E8388"));
        Contrasena.setSize(200,50);
        Contrasena.setLocation(75,420);
        CrearUsuario.add(Contrasena);

        JPasswordField contradata = new JPasswordField();
        contradata.setSize(350,30);
        contradata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        contradata.setLocation(76,460);
        CrearUsuario.add(contradata);

        JLabel confContrasena = new JLabel("Confirmar contraseña:");
        confContrasena.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 20));
        confContrasena.setForeground(Color.decode("#0E8388"));
        confContrasena.setSize(200,50);
        confContrasena.setLocation(75,480);
        CrearUsuario.add(confContrasena);

        JPasswordField confcontradata = new JPasswordField();
        confcontradata.setSize(350,30);
        confcontradata.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        confcontradata.setLocation(76,520);
        CrearUsuario.add(confcontradata);

        JButton CrearUsuariobutton = new JButton("Crear usuario");
        CrearUsuariobutton.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		CrearUsuariobutton.setSize(150, 40);
		CrearUsuariobutton.setLocation(255, 570);
        CrearUsuariobutton.setBackground(Color.decode("#2C3333"));
        CrearUsuariobutton.setForeground(Color.decode("#FFFFFF"));
        
        // accion crear usuario
        CrearUsuariobutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String valorNombre= nombredata.getText();
				String valorApellidos= Apellidosdata.getText();
				String valorEmail= Emaildata.getText();
				String valorContra = new String(((JPasswordField) contradata).getPassword());
				String valorConfContra = new String(((JPasswordField) confcontradata).getPassword());
				
				FileWriter archivo = null;
                PrintWriter editor = null;
                String[] data;
				boolean encontrado = false;
				
				if(!valorNombre.isEmpty()&&!valorApellidos.isEmpty()&&!valorEmail.isEmpty()&&!valorContra.isEmpty()&&!valorConfContra.isEmpty()) {
					
					if (valorContra.contentEquals(valorConfContra) )	{
						
						String renglon;
						try (BufferedReader BR = new BufferedReader(new FileReader("users.txt"))) {
							
							while((renglon = BR.readLine()) != null ){

								data = renglon.split(",");

								if (data[2].equals(valorEmail)) {
									JOptionPane.showMessageDialog(null, "Correo ya existente.","ERROR!", JOptionPane.ERROR_MESSAGE);
									encontrado= true;
								}
								
							}
						} catch (HeadlessException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						if(!encontrado){
							try {
								JOptionPane.showMessageDialog(null, "Usuario creado","Message!", JOptionPane.INFORMATION_MESSAGE);
		                        archivo = new FileWriter("users.txt",true);
		                        editor = new PrintWriter(archivo);
		                        //editor.println();
		                        editor.print(valorNombre + "," + valorApellidos + "," + valorEmail + "," + valorContra + "," + "\n");
		                        
		                        nombredata.setText(null);
		                        Apellidosdata.setText(null);
		        				Emaildata.setText(null);
		        				contradata.setText(null);
		        				confcontradata.setText(null);		                        

		                    } 
		                    catch (Exception e1) {

		                        System.err.println("Datos NO guardados");
		                    } finally{
		                        try {
		                            archivo.close();
		                        } catch (IOException e1) {
		                            System.err.println("ERROR");
		                        }
		                    }
						}

					}
					else{
	                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden","ERROR!", JOptionPane.ERROR_MESSAGE);
	                }
				}
				else
					JOptionPane.showMessageDialog(null, "Llene todos los campos.",null,JOptionPane.ERROR_MESSAGE);
			}
        	
        });
        
		CrearUsuario.add(CrearUsuariobutton);

        JButton Cancelar = new JButton();
        Cancelar.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		Cancelar.setSize(150, 40);
		Cancelar.setLocation(95, 570);
		Cancelar.setText("Cancelar");
        Cancelar.setBackground(Color.decode("#2C3333"));
        Cancelar.setForeground(Color.decode("#FFFFFF"));
        
     // accion boton cancelar 
        Cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(anterior);
			}
			
		});
		CrearUsuario.add(Cancelar);

        this.add(CrearUsuario);
		return CrearUsuario;
    }

    public JPanel ComoCrearUnUsuario(){

        JPanel ComoCrearUnUsuario = new JPanel();
        ComoCrearUnUsuario.setSize(this.getWidth(),this.getHeight());
        ComoCrearUnUsuario.setBackground(Color.decode("#2C3333"));
        ComoCrearUnUsuario.setLocation(0,0);
        ComoCrearUnUsuario.setLayout(null);

        Menu(ComoCrearUnUsuario);

        JLabel ComoCrearUnUsuarioText = new JLabel("¿Como crear un usuario?");
        ComoCrearUnUsuarioText.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 30));
        ComoCrearUnUsuarioText.setForeground(Color.decode("#0E8388"));
        ComoCrearUnUsuarioText.setSize(340,50);
        ComoCrearUnUsuarioText.setLocation(90,50);
        ComoCrearUnUsuario.add(ComoCrearUnUsuarioText);

        JLabel imagen = new JLabel(new ImageIcon("helpcyan.png"));
        imagen.setSize(150,170);
        imagen.setLocation(170,120);
        ComoCrearUnUsuario.add(imagen);
        
        JButton CrearUnUsuarioAhora = new JButton();
        CrearUnUsuarioAhora.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
		CrearUnUsuarioAhora.setSize(200, 40);
		CrearUnUsuarioAhora.setLocation(152, 550);
		CrearUnUsuarioAhora.setText("Crear un usuario ahora");
        CrearUnUsuarioAhora.setBackground(Color.decode("#2C3333"));
        CrearUnUsuarioAhora.setForeground(Color.decode("#FFFFFF"));
        
     // accion boton cancelar 
        CrearUnUsuarioAhora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizarPanel(5);
			}
			
		});
		ComoCrearUnUsuario.add(CrearUnUsuarioAhora);
        
        JTextArea helptext = new JTextArea("  1. Hacer click en la opción “Usuarios” en el menú superior." + "\n" + "\n  2. Hacer click en la opción “Crear Usuario” en el menú" + "\n      desplegado" + "\n" + "\n  3. Llenar los campos solicitados" + "\n" + "\n  4. Hacer click en el botón “Crear usuario”" + "\n" + "\n  5. Listo, el usuario se ha creado");
        helptext.setFont(new Font("Franklin Gothic Demi", Font.TRUETYPE_FONT, 15));
        helptext.setForeground(Color.decode("#0E8388"));
        helptext.setSize(400,250);
        helptext.setLocation(50,330);
        helptext.setOpaque(true);
        helptext.setBackground(null);
        helptext.setEditable(false);
        ComoCrearUnUsuario.add(helptext);


        this.add(ComoCrearUnUsuario);
		return ComoCrearUnUsuario;
    }
}
