/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE", length = 100)
    private String title;
    @Column(name = "AUTHOR", length = 50)
    private String author;
    @Column(name = "isPinjam")
    private boolean isPinjam;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "ID_PERPUS")
    private Perpustakaan perpustakaan;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "ID_PEMINJAM")
    private Peminjam peminjam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIsPinjam() {
        return isPinjam;
    }

    public void setIsPinjam(boolean isPinjam) {
        this.isPinjam = isPinjam;
    }

    public Perpustakaan getPerpustakaan() {
        return perpustakaan;
    }

    public void setPerpustakaan(Perpustakaan perpustakaan) {
        this.perpustakaan = perpustakaan;
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Peminjam peminjam) {
        this.peminjam = peminjam;
    }
    
}
