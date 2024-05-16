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

    public LimasSegitiga(double sisiA, double sisiB, double sisiC, double tinggiLimas) {
        super(sisiA, sisiB, sisiC);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double volume() {
        return (1.0/3.0) * super.hitungLuas() * tinggiLimas;
    }

    @Override
    public double luasPermukaan() {
        double luasAlas = super.hitungLuas();
        double luasSegitigaSisi = (super.hitungKeliling() * tinggiLimas) / 2.0;
        return luasAlas + 3 * luasSegitigaSisi;
    }
}

