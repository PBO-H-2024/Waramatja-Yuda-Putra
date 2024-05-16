/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Connector;

public class MainController {
    private Connector connector;
    
    public MainController() {
        connector = new Connector();
    }
    
    public void insertData(int nim, String name, int age) {
        connector.insertData(nim, name, age);
    }
    
    public String[][] readData() {
        return connector.readData();
    }
    
    public void updateData(int id, int nim, String name, int age) {
        connector.updateData(id, nim, name, age);
    }
    
    public void deleteData(int id) {
        connector.deleteData(id);
    }
}

