package catcher;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author ncvescera
 */
public class ThreadCatcher extends Thread{
    
    private int sleep_time;
    private JTextArea textArea;
    private JTextPane textPane;
    
    private static boolean haveToRun; //server per uccidere il thread
    
    public ThreadCatcher(JTextArea textArea){
        this.sleep_time = 60000;
        this.textArea = textArea;
        haveToRun = true;
    }
    
    public ThreadCatcher(JTextPane textPane){
        this.sleep_time = 100;
        this.textPane = textPane;
        haveToRun = true;
    }
    
    @Override
    public void run(){
        while(haveToRun){
            /*try{
                    //btn.setEnabled(false);
                    Catcher.take(textArea);
                    Thread.currentThread().sleep(sleep_time);
                }
                catch(Exception e){
                    System.err.println(e);
                }*/
            try{
                    //btn.setEnabled(false);
                    Catcher.prova(textPane);
                    Thread.currentThread().sleep(sleep_time);
                }
                catch(Exception e){
                    System.err.println(e);
                }
        }
    }
    
    public static void kill(){
        haveToRun = false;
    }
}
