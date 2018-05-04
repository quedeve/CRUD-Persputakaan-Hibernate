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
@Table(name = "PEMINJAM")
public class Peminjam {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NAMA", length = 100)
    private String Nama;
    @Column(name = "ALAMAT", length = 255)
    private String Alamat;
    
    @OneToMany(mappedBy="peminjam",cascade= {CascadeType.ALL, CascadeType.REMOVE} )
    private Set<Book> setBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public Set<Book> getSetBook() {
        return setBook;
    }

    public void setSetBook(Set<Book> setBook) {
        this.setBook = setBook;
    }

}
