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
    private double sisiA, sisiB, sisiC;

    public Segitiga(double sisiA, double sisiB, double sisiC) {
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    @Override
    public double hitungLuas() {
        double tinggi = cariTinggi();
        return 0.5 * sisiA * tinggi;
    }

    @Override
    public double hitungKeliling() {
        return sisiA + sisiB + sisiC;
    }

    private double cariTinggi() {
        double setengahKeliling = hitungKeliling() / 2.0;
        double tinggi = (2 * Math.sqrt(setengahKeliling * (setengahKeliling - sisiA) *(setengahKeliling - sisiB) * (setengahKeliling - sisiC))) / sisiA;
        return tinggi;
    }
}