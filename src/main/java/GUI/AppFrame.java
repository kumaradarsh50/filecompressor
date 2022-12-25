/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import file_compressor.file_compressor;
import file_compressor.file_decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author adarsh
 */
public class AppFrame extends JFrame implements ActionListener {
    
    JButton compressedButton;
    JButton decompressedButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressedButton=new JButton("Select file to compress");
        compressedButton.addActionListener(this);
        compressedButton.setBounds(20, 100, 200, 30);
        
        decompressedButton=new JButton("Select file to compress");
        decompressedButton.addActionListener(this);
        decompressedButton.setBounds(250,100,200,30);
        
        this.add(compressedButton);
        this.add(decompressedButton);
        this.setSize(500, 200);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
        
       }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressedButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
               File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    file_compressor.method(file);
                }catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }    
        }
        if(e.getSource() == decompressedButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    file_decompressor.method(file);
                }catch(Exception excd){
                    JOptionPane.showMessageDialog(null, excd.toString());
                }
            }
        }
    }
}
