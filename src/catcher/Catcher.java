package catcher;

import java.awt.Color;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class Catcher {

    public static void take(JTextArea textArea) throws Exception{
    
        URL moodle = new URL("http://moodlevolta.ictvalleumbra.it/");
        BufferedReader in = new BufferedReader(new InputStreamReader(moodle.openStream()));
        
        String line;
        ArrayList inputLine = new ArrayList();
        while((line = in.readLine()) != null){
            line = line.replace(" ", "");
            inputLine.add(line);
            //System.out.println(line);
        }
        
        String[] arrayLine = new String[inputLine.size()];
        inputLine.toArray(arrayLine);
        
        ArrayList nomi = new ArrayList();
        for(String elem:arrayLine){
            if(!(elem.length()<20)) {          
                String cmp = elem.substring(0,20);
                if(cmp.equals("<liclass=\"listentry\"")){
                    int inizio = elem.lastIndexOf("16")+4;
                    int fine = elem.lastIndexOf('a')-1;

                    nomi.add(elem.substring(inizio, fine));
                }
            }
        }
        String toInsert = "";
        
        Date data = new Date();
        
        toInsert = "\t["+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds()+"]\n";
        
        String[] nomiArray = new String[nomi.size()];
        nomi.toArray(nomiArray);
        
        for(String nome:nomiArray){
            /*if(nome.indexOf("d.")>0)
                nome = nome.replace("d.", " DOCENTE ");*/
            nome = aggiusta(nome);
                //textArea.setForeground(Color.blue);
            /*else
                textArea.setForeground(Color.black);*/
            //System.out.println(nome);
            
            toInsert += nome+"\n";
            
            
        }
        
        toInsert += "------------------------------------------------------------\n";
        textArea.insert(toInsert, 0);
     
    }
    
    public static void prova(JTextPane textPane) throws MalformedURLException, IOException{
        URL moodle = new URL("http://moodlevolta.ictvalleumbra.it/");
        BufferedReader in = new BufferedReader(new InputStreamReader(moodle.openStream()));
        
        String line;
        ArrayList inputLine = new ArrayList();
        while((line = in.readLine()) != null){
            line = line.replace(" ", "");
            inputLine.add(line);
            //System.out.println(line);
        }
        
        String[] arrayLine = new String[inputLine.size()];
        inputLine.toArray(arrayLine);
        
        ArrayList nomi = new ArrayList();
        for(String elem:arrayLine){
            if(!(elem.length()<20)) {          
                String cmp = elem.substring(0,20);
                if(cmp.equals("<liclass=\"listentry\"")){
                    int inizio = elem.lastIndexOf("16")+4;
                    int fine = elem.lastIndexOf('a')-1;

                    nomi.add(elem.substring(inizio, fine));
                }
            }
        }
        String toInsert = "";
        
        Date data = new Date();
        
        toInsert = "<center><h2>["+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds()+"]</h2><br>";
        
        String[] nomiArray = new String[nomi.size()];
        nomi.toArray(nomiArray);
        
        for(String nome:nomiArray){
            /*if(nome.indexOf("d.")>0)
                nome = nome.replace("d.", " DOCENTE ");*/
            nome = aggiusta(nome);
                //textArea.setForeground(Color.blue);
            /*else
                textArea.setForeground(Color.black);*/
            //System.out.println(nome);
            
            toInsert += "<span style=\"font-size: 16px;\">"+nome+"</span><br>";
            
            
        }
        
        toInsert += "</center><br><hr>";
        textPane.setText(toInsert+textPane.getText());
    }
    
    private static String aggiusta(String nome){
        String out = "";
        if(nome.indexOf("d.")>0)
            out = nome.replace("d.", " DOCENTE ");
        else{
        int i;
            for(i=1;i<6;i++){
                if(nome.indexOf(Integer.toString(i))>0){
                    out = nome.replace(""+nome.charAt(nome.indexOf(Integer.toString(i))), " "+nome.charAt(nome.indexOf(Integer.toString(i))));
                    out = out.replace("_", " ");
                }
            }
        }
        return out;
    }

}
