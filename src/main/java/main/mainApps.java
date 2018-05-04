/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.Konfigurasi;
import dao.PinjamBukuDao;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import model.Book;
import model.Peminjam;
import model.Perpustakaan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author victo
 */
public class mainApps {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Konfigurasi.class);
        ctx.refresh();

        Scanner input = new Scanner(System.in);

        PinjamBukuDao pinjamBukuDao = ctx.getBean(PinjamBukuDao.class);
        List<Book> listBook = new LinkedList<>();
        List<Peminjam> listPeminjam = new LinkedList<>();
        List<Perpustakaan> listPerpustakaan = new LinkedList<>();
        Book book = new Book();
        Peminjam peminjam = new Peminjam();
        Perpustakaan perpustakaan = new Perpustakaan();

        while (true) {
            System.out.println("1. Read Data");
            System.out.println("2. Create Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");

            System.out.println("pilih menu");
            int pilihan = input.nextInt();
            if (pilihan == 1) {
                System.out.println("1. Read Data Perpustakaan");
                System.out.println("2. Read Data Peminjam");
                System.out.println("3. Read Data Buku");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    listPerpustakaan = pinjamBukuDao.findAllPerpus();
                    for (Perpustakaan perpus : listPerpustakaan) {
                        System.out.println("ID Perpustakaan : " + perpus.getId() + " Nama Perpustakaan : " + perpus.getNamaPerpustakaan());
                    }
                }
                if (pilih == 2) {
                    listPeminjam = pinjamBukuDao.findAllPeminjam();
                    for (Peminjam peminjam1 : listPeminjam) {
                        System.out.println("ID Peminjam : " + peminjam1.getId() + " Nama Peminjam : " + peminjam1.getNama() + " Alamat Peminjam : " + peminjam1.getAlamat());
                    }
                }
                if (pilih == 3) {
                    listBook = pinjamBukuDao.findAllBookHibernate();
                    for (Book book1 : listBook) {
                        String pinjam;
                        if (book1.isIsPinjam() == false) {
                            pinjam = "Tidak di pinjam";
                        } else {
                            pinjam = "Di pinjam";
                        }
                        System.out.println("ID Buku : " + book1.getId() + " Judul Buku : " + book1.getTitle() + " Pengarang Buku : " + book1.getAuthor() + " Status peminjaman : " + pinjam);
                    }
                }
            }
            if (pilihan == 2) {
                System.out.println("1. Create Data Perpustakaan");
                System.out.println("2. Create Data Peminjam");
                System.out.println("3. Create Data Buku");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    System.out.println("Masukkan Nama Perpustakaan");
                    perpustakaan.setNamaPerpustakaan(input.next());
                    pinjamBukuDao.simpanPerpusHibernate(perpustakaan);
                }
                if (pilih == 2) {
                    System.out.println("Masukkan Nama Peminjam");
                    peminjam.setNama(input.next());
                    System.out.println("Masukkan Alamat Peminjam");
                    peminjam.setAlamat(input.next());
                    pinjamBukuDao.simpanPeminjamsHibernate(peminjam);

                }
                if (pilih == 3) {
                    System.out.println("Masukkan Judul Buku");
                    book.setTitle(input.next());
                    System.out.println("Masukkan Penulis Buku");
                    book.setAuthor(input.next());
                    listPerpustakaan = pinjamBukuDao.findAllPerpus();
                    for (Perpustakaan perpus : listPerpustakaan) {
                        System.out.println("ID Perpustakaan : " + perpus.getId() + " Nama Perpustakaan : " + perpus.getNamaPerpustakaan());
                    }
                    System.out.println("Pilih ID perspustakaan untuk menyimpan buku");
                    perpustakaan.setId(input.nextInt());
                    book.setPerpustakaan(perpustakaan);
                    System.out.println("Buku ini dipinjam? Y/N");
                    String pinjam = input.next();
                    if (pinjam.equalsIgnoreCase("Y")) {
                        listPeminjam = pinjamBukuDao.findAllPeminjam();
                        for (Peminjam peminjam1 : listPeminjam) {
                            System.out.println("ID Peminjam : " + peminjam1.getId() + " Nama Peminjam : " + peminjam1.getNama() + " Alamat Peminjam : " + peminjam1.getAlamat());
                        }
                        System.out.println("Pilih ID Peminjam BUku");
                        peminjam.setId(input.nextInt());
                        book.setIsPinjam(true);
                        book.setPeminjam(peminjam);
                    } else {
                        book.setIsPinjam(false);
                    }
                    pinjamBukuDao.simpanBookHibernate(book);

                }
            }
            if (pilihan == 3) {
                System.out.println("1. update Data Perpustakaan");
                System.out.println("2. update Data Peminjam");
                System.out.println("3. update Data Buku");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    listPerpustakaan = pinjamBukuDao.findAllPerpus();
                    for (Perpustakaan perpus : listPerpustakaan) {
                        System.out.println("ID Perpustakaan : " + perpus.getId() + " Nama Perpustakaan : " + perpus.getNamaPerpustakaan());
                    }
                    System.out.println("Pilih ID Perpustakaan yang Ingin di Update");
                    perpustakaan.setId(input.nextInt());
                    System.out.println("Masukkan Nama Perpustakaan");
                    perpustakaan.setNamaPerpustakaan(input.next());
                    pinjamBukuDao.updatePerpusHibernate(perpustakaan);
                }
                if (pilih == 2) {
                    listPeminjam = pinjamBukuDao.findAllPeminjam();
                    for (Peminjam peminjam1 : listPeminjam) {
                        System.out.println("ID Peminjam : " + peminjam1.getId() + " Nama Peminjam : " + peminjam1.getNama() + " Alamat Peminjam : " + peminjam1.getAlamat());
                    }
                    System.out.println("Pilih Id Peminjam yang Ingin di Update");
                    peminjam.setId(input.nextInt());
                    System.out.println("Masukkan Nama Peminjam");
                    peminjam.setNama(input.next());
                    System.out.println("Masukkan Alamat Peminjam");
                    peminjam.setAlamat(input.next());
                    pinjamBukuDao.simpanPeminjamsHibernate(peminjam);
                }
                if (pilih == 3) {
                    listBook = pinjamBukuDao.findAllBookHibernate();
                    for (Book book1 : listBook) {
                        String pinjam;
                        if (book1.isIsPinjam() == false) {
                            pinjam = "Tidak di pinjam";
                        } else {
                            pinjam = "Di pinjam";
                        }
                        System.out.println("ID Buku : " + book1.getId() + " Judul Buku : " + book1.getTitle() + " Pengarang Buku : " + book1.getAuthor() + " Status peminjaman : " + pinjam);
                    }
                    System.out.println("Pilih Id Buku yang Ingin di Update");
                    book.setId(input.nextInt());
                    System.out.println("Masukkan Judul Buku");
                    book.setTitle(input.next());
                    System.out.println("Masukkan Penulis Buku");
                    book.setAuthor(input.next());
                    listPerpustakaan = pinjamBukuDao.findAllPerpus();
                    for (Perpustakaan perpus : listPerpustakaan) {
                        System.out.println("ID Perpustakaan : " + perpus.getId() + " Nama Perpustakaan : " + perpus.getNamaPerpustakaan());
                    }
                    System.out.println("Pilih ID perspustakaan untuk menyimpan buku");
                    perpustakaan.setId(input.nextInt());
                    book.setPerpustakaan(perpustakaan);
                    System.out.println("Buku ini dipinjam? Y/N");
                    String pinjam = input.next();
                    if (pinjam.equalsIgnoreCase("Y")) {
                        listPeminjam = pinjamBukuDao.findAllPeminjam();
                        for (Peminjam peminjam1 : listPeminjam) {
                            System.out.println("ID Peminjam : " + peminjam1.getId() + " Nama Peminjam : " + peminjam1.getNama() + " Alamat Peminjam : " + peminjam1.getAlamat());
                        }
                        System.out.println("Pilih ID Peminjam BUku");
                        peminjam.setId(input.nextInt());
                        book.setIsPinjam(true);
                        book.setPeminjam(peminjam);
                    } else {
                        book.setIsPinjam(false);
                    }
                    pinjamBukuDao.simpanBookHibernate(book);

                }

            }
            if (pilihan == 4) {
                System.out.println("1. Delete Data Perpustakaan");
                System.out.println("2. Delete Data Peminjam");
                System.out.println("3. Delete Data Buku");
                int pilih = input.nextInt();
                if (pilih == 1) {
                    listPerpustakaan = pinjamBukuDao.findAllPerpus();
                    for (Perpustakaan perpus : listPerpustakaan) {
                        System.out.println("ID Perpustakaan : " + perpus.getId() + " Nama Perpustakaan : " + perpus.getNamaPerpustakaan());
                    }
                    System.out.println("Pilih ID Perpustakaan yang Ingin di Delete");
                    perpustakaan = pinjamBukuDao.findByIdPerpusdHibernate(input.nextInt());
                    pinjamBukuDao.deleteBookByPerpustakaan(perpustakaan);
                    pinjamBukuDao.hapusPerpusHibernate(perpustakaan);
                }
                if (pilih == 2) {
                    listPeminjam = pinjamBukuDao.findAllPeminjam();
                    for (Peminjam peminjam1 : listPeminjam) {
                        System.out.println("ID Peminjam : " + peminjam1.getId() + " Nama Peminjam : " + peminjam1.getNama() + " Alamat Peminjam : " + peminjam1.getAlamat());
                    }
                    System.out.println("Pilih ID Peminjam");

                    peminjam = pinjamBukuDao.findByIdPeminjamdHibernate(input.nextInt());
//                    pinjamBukuDao.updateNullPeminjam(peminjam);
                    pinjamBukuDao.hapusPeminjamHibernate(peminjam);
                }
                if (pilih == 3) {
                    listBook = pinjamBukuDao.findAllBookHibernate();
                    for (Book book1 : listBook) {
                        String pinjam;
                        if (book1.isIsPinjam() == false) {
                            pinjam = "Tidak di pinjam";
                        } else {
                            pinjam = "Di pinjam";
                        }
                        System.out.println("ID Buku : " + book1.getId() + " Judul Buku : " + book1.getTitle() + " Pengarang Buku : " + book1.getAuthor() + " Status peminjaman : " + pinjam);
                    }
                    System.out.println("Pilih Id Buku yang Ingin di Hapus");
                    book.setId(input.nextInt());
                    pinjamBukuDao.hapusBookHibernate(book);
                }
            }
            System.out.println("Lagi?  (true/false)");
            boolean bool = input.nextBoolean();
            if (false) {
                break;
            }
        }

    }

}
