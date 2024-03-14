/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunRuang;
import BangunDatar.Segitiga;

/**
 *
 * @author ARDA PUTRA
 */
public class Tabung implements HitungBangunRuang {
    private final double jarijari;
    private final double tinggiTabung;

    public Tabung(double jarijari, double tinggiTabung){
        this.jarijari = jarijari;
        this.tinggiTabung = tinggiTabung;
    }

    @Override
    public double volume(){
        return Math.PI * Math.pow(jarijari, 2) * tinggiTabung;
    }

    @Override
    public double luasPermukaan(){
        return 2 * Math.PI * jarijari * (jarijari + tinggiTabung);
    }
}
