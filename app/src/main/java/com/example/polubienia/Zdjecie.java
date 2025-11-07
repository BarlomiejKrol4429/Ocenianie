package com.example.polubienia;

public class Zdjecie {
    private String src;
    private Double ocena;

    public Zdjecie(String src, Double ocena) {
        this.src = src;
        this.ocena = ocena;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return src + " " + ocena;
    }
}
