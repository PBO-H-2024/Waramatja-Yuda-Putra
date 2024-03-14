/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import BangunRuang.Tabung;
import BangunRuang.LimasSegitiga;
import BangunDatar.Segitiga;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\tMENU");
            System.out.println("1. Tabung");
            System.out.println("2. Limas Segitiga");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Menu: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jari-jari tabung: ");
                    double jariJari = scanner.nextDouble();
                    System.out.print("Tinggi tabung: ");
                    double tinggi = scanner.nextDouble();

                    Tabung tabung1 = new Tabung(jariJari, tinggi);
                    System.out.println("\nHasil perhitungan:");
                    System.out.println("Volume: " + tabung1.volume());
                    System.out.println("Luas permukaan: " + tabung1.luasPermukaan());
                    break;

                case 2:
                    System.out.print("Sisi A: ");
                    double sisiA = scanner.nextDouble();
                    System.out.print("Sisi B: ");
                    double sisiB = scanner.nextDouble();
                    System.out.print("Sisi C: ");
                    double sisiC = scanner.nextDouble();
                    System.out.print("Tinggi limas segitiga: ");
                    double tinggiLimas = scanner.nextDouble();
                    
                    Segitiga segitiga = new Segitiga(sisiA, sisiB, sisiC);
                     System.out.println("\nHasil perhitungan:");
                    System.out.println("Luas Segitiga: " + segitiga.hitungLuas());
                    System.out.println("Keliling Segitiga: " + segitiga.hitungKeliling());

                    LimasSegitiga limasSegitiga = new LimasSegitiga(sisiA, sisiB, sisiC, tinggiLimas);
                    System.out.println("Volume: " + limasSegitiga.volume());
                    System.out.println("Luas permukaan: " + limasSegitiga.luasPermukaan());
                    break;

                case 3:
                    System.out.println("\n\tBye.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid.");
                    break;
            }
            System.out.print("\nPress Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
        }
    }
}
