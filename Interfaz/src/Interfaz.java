import javax.swing.JFrame;

public class Interfaz extends JFrame {

    public Interfaz(){

        this.setSize(500,700);
        this.setLocationRelativeTo(null);
        this.setTitle("Interfaz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        

        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }
}
