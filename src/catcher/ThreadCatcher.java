/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catcher;

import javax.swing.JTextArea;

/**
 *
 * @author ncvescera
 */
public class ThreadCatcher extends Thread{
    
    private int sleep_time;
    private JTextArea textArea;
    private static boolean haveToRun; //server per uccidere il thread
    
    public ThreadCatcher(JTextArea textArea){
        this.sleep_time = 60000;
        this.textArea = textArea;
        haveToRun = true;
    }
    
    @Override
    public void run(){
        while(haveToRun){
            try{
                    //btn.setEnabled(false);
                    Catcher.take(textArea);
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
