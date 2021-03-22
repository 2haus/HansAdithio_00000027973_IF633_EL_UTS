package com.example.hansadithio_27973_uts;

import java.io.Serializable;

public class SausLagu implements Serializable {
    private String judul;
    private String keterangan;
    private String playerURI;

    public SausLagu(String judul, String keterangan, String playerURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.playerURI = playerURI;
    }

    public String getJudul() {
        return judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getPlayerURI() { return this.playerURI; }

    public void setJudul(String judul){
        this.judul = judul;
    }

    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }

    public void setPlayerURI(String playerURI) { this.playerURI = playerURI; }

    public String toString(){
        return this.getJudul() + " => " + this.getKeterangan();
    }
}
