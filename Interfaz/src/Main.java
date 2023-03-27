public class Main {
    public static void main(String[] args) throws Exception {

        PantallaCarga carga = new PantallaCarga();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            carga.setVisible (true) ;
            }
        });

        try {
            for(int i=0;i<=100;i++){
                Thread.sleep(30); // tiempo de carga
                carga.barraCarga.setValue(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        Interfaz interfaz = new Interfaz();

        carga.setVisible(false);
        interfaz.setVisible(true);

        carga.dispose();
    }
}
