/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunDatar;

/**
 *
 * @author ARDA PUTRA
 */
public class Lingkaran {
    double phi = 3.14;
    double jarijari;
    
    public Lingkaran(double jarijari){
        this.jarijari = jarijari;
    }

    public double luas(){
        return phi * this.jarijari * this.jarijari;
    }

    public double keliling(){
        return 2 * phi * jarijari;
    };
}
