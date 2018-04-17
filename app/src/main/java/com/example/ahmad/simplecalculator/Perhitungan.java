package com.example.ahmad.simplecalculator;

public class Perhitungan {
    private Double bil1;
    private Double bil2;

    public Perhitungan(Double bil1, Double bil2) {
        this.bil1 = bil1;
        this.bil2 = bil2;
    }

    public Double tambah(){
        return bil1+bil2;
    }

    public Double kurang(){
        return bil1-bil2;
    }

    public Double kali(){
        return bil1*bil2;
    }

    public String bagi(){
        if(bil2==0){
            return "Error";
        }else{
            return String.valueOf(bil1/bil2);
        }
    }
}
