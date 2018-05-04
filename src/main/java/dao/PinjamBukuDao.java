/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;
import model.Peminjam;
import model.Perpustakaan;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author victo
 */
@Repository
public class PinjamBukuDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<Book> findAllBookHibernate() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Book");
        return query.list();
    }

    @Transactional(readOnly = true)
    public Book findByIdBookdHibernate(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Bank b where b.id = :id ")
                .setParameter("id",
                        id);
        return (Book) query.list().get(0);
    }

    @Transactional(readOnly = false)
    public void simpanBookHibernate(Book book) {

        sessionFactory.getCurrentSession().save(book);
    }

    @Transactional(readOnly = false)
    public void updateBookHibernate(Book book) {

        sessionFactory.getCurrentSession().update(book);
    }

    @Transactional(readOnly = false)
    public void hapusBookHibernate(Book book) {
        sessionFactory.getCurrentSession().delete(book);;
    }

    @Transactional(readOnly = true)
    public List<Perpustakaan> findAllPerpus() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Perpustakaan");
        return query.list();
    }

    @Transactional(readOnly = true)
    public Perpustakaan findByIdPerpusdHibernate(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Perpustakaan b where b.id = :id ")
                .setParameter("id",
                        id);
        return (Perpustakaan) query.list().get(0);
    }

    @Transactional(readOnly = false)
    public void simpanPerpusHibernate(Perpustakaan perpus) {
        sessionFactory.getCurrentSession().save(perpus);
    }

    @Transactional(readOnly = false)
    public void updatePerpusHibernate(Perpustakaan perpus) {
        sessionFactory.getCurrentSession().update(perpus);
    }

    @Transactional(readOnly = false)
    public void hapusPerpusHibernate(Perpustakaan perpus) {
        sessionFactory.getCurrentSession().delete(perpus);;
    }
    
      @Transactional(readOnly = true)
    public List<Peminjam> findAllPeminjam() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Peminjam");
        return query.list();
    }

    @Transactional(readOnly = true)
    public Peminjam findByIdPeminjamdHibernate(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Peminjam b where b.id = :id ")
                .setParameter("id",
                        id);
        return (Peminjam) query.list().get(0);
    }

    @Transactional(readOnly = false)
    public void simpanPeminjamsHibernate(Peminjam Peminjam) {
        sessionFactory.getCurrentSession().save(Peminjam);
    }

    @Transactional(readOnly = false)
    public void updatePeminjamHibernate(Peminjam Peminjam) {
        sessionFactory.getCurrentSession().update(Peminjam);
    }

    @Transactional(readOnly = false)
    public void hapusPeminjamHibernate(Peminjam peminjam) {
        sessionFactory.getCurrentSession().createQuery("UPDATE Book SET isPinjam=:isPinjam, peminjam =:null WHERE peminjam.id=:peminjam" ).
                setParameter("isPinjam", false).setParameter("null", null).setParameter("peminjam", peminjam.getId()).executeUpdate();
          
        sessionFactory.getCurrentSession().delete(peminjam);
    }

    @Transactional(readOnly=false)
    public void updateNullPeminjam(Peminjam peminjam){
        
        sessionFactory.getCurrentSession().createQuery("UPDATE Book SET isPinjam=:isPinjam, peminjam =:kosong WHERE id=:peminjam" ).
                setParameter("isPinjam", false).setParameter("kosong", null).setParameter("peminjam", peminjam.getId());
                
    }
    
    @Transactional(readOnly = false)
    public void deleteBookByPerpustakaan(Perpustakaan perpustakaan){
        
        sessionFactory.getCurrentSession().createQuery("DELETE Book WHERE Perpustakaan.id =:perpustakaan").setParameter("perpistalaam", perpustakaan.getId());
    }
}
