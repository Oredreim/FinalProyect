package dominio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class JPanelSalida {
    public JFrame jpanel=new JFrame();
    private JTextField textfield1;
    private JLabel label1;
    private JButton boton1;
    private Date salida;
    public JPanelSalida() {
        jpanel.setLayout(null);

        /* Etiqueta de usuario */
        label1=new JLabel("Usuario:");
        label1.setBounds(10,10,100,30);
        jpanel.add(label1);

        /* Campo de texto */
        textfield1=new JTextField();
        textfield1.setBounds(120,10,150,20);
        jpanel.add(textfield1);

        /* Botón de Aceptar */
        boton1=new JButton("Aceptar");
        boton1.setBounds(10,80,100,30);
        jpanel.add(boton1);



        /* Inicializo escuchador del botón */
        try{
            boton1.addActionListener(this::actionPerformed);
        }
        catch (Exception e){

        }
        jpanel.setBounds(0,0,300,150);
        jpanel.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){// throws FroggerException {
        if (e.getSource()==boton1) {
            /*if (textfield1.getText()==""){
                throw new FroggerException(FroggerException.TEXTONULL);
            }*/
            salida=new Date();
            ArrayList<String>partidas=Abrir.leer("C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\Salidas.txt");
            partidas.add(String.valueOf(salida)+" "+textfield1.getText()+"\n");
            for(int i=0;i<partidas.size();i++){
                System.out.println();
            }
            Guardar.guarda(partidas,"C:\\Users\\urrea\\IdeaProjects\\FinalProyect\\src\\res\\Salidas.txt");
            jpanel.setVisible(false);
        }
    }

}
