/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunDatar;

/**
 *
 * @author ARDA PUTRA
 */
public class Segitiga implements HitungBangunDatar {
    private final double tinggiAlas;
    private final double alas;

    public Segitiga(double tinggiAlas, double alas){
        this.tinggiAlas = tinggiAlas;
        this.alas = alas;
    }

    @Override
    public double hitungLuas() {
        return alas * tinggiAlas / 2.0;
    }

    @Override
    public double hitungKeliling() {
        double sisimiring = Math.sqrt(Math.pow(alas / 2.0, 2) + Math.pow(tinggiAlas, 2));
        return (2 * sisimiring) + alas;
    }
}