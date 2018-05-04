/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author victo
 */
@Entity
@Table(name = "PERPUSTAKAAN")
public class Perpustakaan {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAMA_PERPUSTAKAAN")
    private String namaPerpustakaan;
    @OneToMany(mappedBy = "peminjam", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    private Set<Book> setBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPerpustakaan() {
        return namaPerpustakaan;
    }

    public void setNamaPerpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
    }

    public Set<Book> getSetBook() {
        return setBook;
    }

    public void setSetBook(Set<Book> setBook) {
        this.setBook = setBook;
    }
    

}
