import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TablaConBoton{

    DefaultTableModel dtm;
    private JTable tabla;
    private JScrollPane sp;

    String text = "";

    public TablaConBoton(){
        Inicializador();
    }

    public void Inicializador(){

        setDefaulTableModel(getData(), getnombreColumnas());
        setTable(dtm);
        setSPTabla(tabla);
        
        inicializarAccion();
    }

    public void setDefaulTableModel(Object data[][], String[] nombreColumnas){
        //                      Nombre,      Apellidos,   Correo,      Contraseña,  Boton.
        Class[] tipoColumnas = {String.class,String.class,String.class,String.class,JButton.class};
        
        dtm = new DefaultTableModel(data,nombreColumnas){

            public Class getColumnClass(int indexColumna){

                return tipoColumnas[indexColumna];
            }
        };
    }

    
    public String[] getnombreColumnas(){
        
        String[] nombreColumnas = {"Nombre","Apellidos","Correo","Contraseña", "Acciones"};
        
        return nombreColumnas;
    }
    
    public void setTable(DefaultTableModel dtm){
        
        tabla = new JTable(dtm);

        //editar el tamaño de las celdas
        tabla.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(80);

        tabla.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column) {
                
                return(Component)value;
            }
            
        });

        /*DefaultTableCellRenderer allign = new DefaultTableCellRenderer();
        allign.setHorizontalAlignment(SwingConstants.CENTER);                   PARA ALINEAR DE MANERA CENTRADA LA INFORMACION DE LA TABLA
        tabla.getColumnModel().getColumn(2).setCellRenderer(allign);*/
        
    }

    public void inicializarAccion(){

        tabla.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e){

                int row = tabla.getSelectedRow();
                int column = tabla.getSelectedColumn();

                if(column == 4){

                    for (int i = 0; i < tabla.getModel().getColumnCount()-1; i++) {
                        text+=tabla.getModel().getColumnName(i) + " : " + tabla.getModel().getValueAt(row, i) + "\n";
                    }

                    JOptionPane.showMessageDialog(null, text, "titulo", 1);
                    text = "";

                }

            }
        });
    }

    public JTable getTabla(){
        return this.tabla;
    }

    public void setSPTabla(JTable tabla){

        sp = new JScrollPane(tabla);
        sp.setBounds(50,330,400,300);

    }

    public JScrollPane getSPTabla(){
        
        return this.sp;
    }
    
    public Object[][] getData(){
    
        JButton Eliminar = new JButton("Eliminar");
    
    
        Object[][] data = {
            {"Christian","Rodriguez Moreno","christianrodmor@gmail.com","christian12345",Eliminar},
            {"Alma Delia", "Vargas Gonzalez", "almadeliaVG@gmail.com","delia12345",Eliminar},
            {"Jonathan Giovanni", "Soto Muñoz", "jsoto@uabcs.mx", "elyonaxdxd", Eliminar},
        };
    
        return data;
    }

}