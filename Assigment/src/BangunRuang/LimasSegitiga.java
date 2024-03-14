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
public class LimasSegitiga extends Segitiga implements HitungBangunRuang {
    private final double tinggiLimas;

    public LimasSegitiga(double tinggiAlas, double alas, double tinggiLimas) {
        super(tinggiAlas, alas);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double volume() {
        return 1.0 / 3.0 * hitungLuas() * tinggiLimas;
    }
    
    @Override
    public double luasPermukaan() {
        return 4 * hitungLuas();
    }
}

