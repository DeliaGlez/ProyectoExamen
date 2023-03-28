import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
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
    	
    	Object[] info = null;
    	Object[] arrBoton = new Object[5]; 
    	
    	JButton Eliminar = new JButton("Eliminar");
        Object[][] data = null;

        setDefaulTableModel(data, getnombreColumnas());

        try{
            BufferedReader BR = new BufferedReader(new FileReader("users.txt"));
            String renglon;
            

            while((renglon = BR.readLine()) != null ){
                
                info = renglon.split(",");
                
               for(int i=0;i<arrBoton.length;i++) {
                	if((i % 4 == 0)&& (i!=0)) {
                		arrBoton[i]= Eliminar;
                	}
                	else {
                		arrBoton[i]=info[i];
                	}
                	
                	
                }
               
                dtm.addRow(arrBoton);

            }
            
            
        }catch(Exception f){
        	System.err.println("No se encontro archivo");
        }

        
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
        tabla.getTableHeader().setReorderingAllowed(false);

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
                String correoAux = "";

                if(column == 4){

                    for (int i = 0; i < tabla.getModel().getColumnCount()-1; i++) {
                        text+=tabla.getModel().getColumnName(i) + ": " + tabla.getModel().getValueAt(row, i) + "\n";
                        if(i==2){
                            correoAux=(String) tabla.getModel().getValueAt(row, i) ;
                            System.out.println("correo: "+correoAux);
                        }
                        
                    }

                    //JOptionPane.showMessageDialog(null, text, "titulo", 1);
                    int salida=JOptionPane.showConfirmDialog(null, text, "seguuuuro?", 2);
                    
                    text = "";
                    if(salida==0){
                        System.out.println("borrando...");
                        actualizarText(correoAux);
                        correoAux = "";
                        

                    }

                }

            }
        });
    }

    public void actualizarText(String correoUser){
        FileWriter archivo = null;
        PrintWriter editor = null;
       // String[] data;
        
        String texto="";
        String renglon;
         
        try (BufferedReader BR = new BufferedReader(new FileReader("users.txt"))) {
            String temp="";
            while((renglon = BR.readLine()) != null ){
                temp= temp + renglon;
                //data = renglon.split(",");
            }
            texto= temp;
            BR.close();
        } catch (HeadlessException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

		String[] arrText = null;
        arrText = texto.split(",");
        
        for (int i = 0; i < arrText.length; i++){
            
            if(arrText[i].equals(correoUser)){
                arrText[i-2]="0";
                arrText[i-1]="0";
                arrText[i]="0";
                arrText[i+1]="0";
            }
        }
        
        try {

            archivo = new FileWriter("users.txt");
            editor = new PrintWriter(archivo);

            for(int i=0; i<arrText.length;i+=4) {

                if(arrText[i]!="0"){
                    if(i!=arrText.length-4){
                        editor.println(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                    }
                    else{
                        editor.print(arrText[i]+","+arrText[i+1]+","+arrText[i+2]+","+arrText[i+3]+",");
                    }
                }
                
            }
  
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
    
    /*
    public Object[][] getData(){
    
        JButton Eliminar = new JButton("Eliminar");
    
    
        Object[][] data = {
            {"Christian","Rodriguez Moreno","christianrodmor@gmail.com","christian12345",Eliminar},
            {"Alma Delia", "Vargas Gonzalez", "almadeliaVG@gmail.com","delia12345",Eliminar},
            {"Jonathan Giovanni", "Soto Muñoz", "jsoto@uabcs.mx", "elyonaxdxd", Eliminar},
        };
    
        return data;
    }*/

}