/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.MainController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateData extends JFrame {
    private int id;
    private MainController controller;
    
    private JFrame window = new JFrame("Update Data Student");
    
    private JLabel lNim = new JLabel("NIM");
    private JTextField fNim = new JTextField();
    
    private JLabel lName = new JLabel("NAME");
    private JTextField fName = new JTextField();
    
    private JLabel lAge = new JLabel("AGE");
    private JTextField fAge = new JTextField();
    
    private JButton btnUpd = new JButton("UPDATE");
    
    public UpdateData(int id, MainController controller){
        this.id = id;
        this.controller = controller;
        
        window.setLayout(null);
        window.setSize(500, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        window.add(lNim);
        window.add(lName);
        window.add(lAge);
        window.add(fNim);
        window.add(fName);
        window.add(fAge);
        window.add(btnUpd);
        
        //LABEL
        lNim.setBounds(5, 35, 120, 20);
        lName.setBounds(5, 60, 120, 20);
        lAge.setBounds(5, 85, 120, 20);
        
        //TEXTFIELD
        fNim.setBounds(150, 35, 120, 20);
        fName.setBounds(150, 60, 120, 20);
        fAge.setBounds(150, 85, 120, 20);
        
        //BUTTON
        btnUpd.setBounds(300, 35, 90, 20);
        
        prefillData();
        
        btnUpd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nim = Integer.parseInt(fNim.getText());
                    String name = fName.getText();
                    int age = Integer.parseInt(fAge.getText());
                    
                    if (name.isEmpty() || fNim.getText().isEmpty() || fAge.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        controller.updateData(id, nim, name, age);
                        JOptionPane.showMessageDialog(null, "Data updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        window.dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void prefillData() {
        String[][] data = controller.readData();
        for (String[] row : data) {
            if (row[0] != null && Integer.parseInt(row[0]) == id) {
                fNim.setText(row[1]);
                fName.setText(row[2]);
                fAge.setText(row[3]);
                break;
            }
        }
    }
}

