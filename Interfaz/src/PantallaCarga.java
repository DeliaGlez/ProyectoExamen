import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PantallaCarga extends JFrame{
    JProgressBar barraCarga;
    public PantallaCarga(){
        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Interfaz");
        this.setLayout(null);
        this.setUndecorated(true);
        componentes();

        this.repaint();
        this.revalidate();
    }

    public void componentes(){
        JPanel panel = new JPanel();
        panel.setSize(500, 700);
		panel.setLocation(0, 0);
		panel.setLayout(null);
		panel.setBackground(Color.decode("#2C3333"));

        JLabel e1 = new JLabel("Cargando...");
        e1.setFont(new Font("Consolas", Font.BOLD,20));
        e1.setForeground(Color.decode("#CBE4DE"));
		e1.setSize(280, 40);
		e1.setLocation(200, 380);
        panel.add(e1);

        barraCarga = new JProgressBar();
        barraCarga.setSize(260, 40);
        barraCarga.setLocation(((this.getWidth()/2)-(barraCarga.getWidth()/2)),((this.getHeight()/2)-(barraCarga.getHeight()/2))); //barra centrada a la ventana
        barraCarga.setValue(0);
        barraCarga.setStringPainted(true);
        panel.add(barraCarga);

        this.add(panel);
    }


}
