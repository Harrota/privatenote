package testgroup.privatenote.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.privatenote.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class NoteDAOImpl implements NoteDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Note> allNotes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Note").list();
    }

    @Override
    public void add(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(note);
    }

    @Override
    public void delete(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(note);
    }

    @Override
    public void edit(Note note) {
        Session session = sessionFactory.getCurrentSession();
        session.update(note);
    }

    @Override
    public Note getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Note.class, id);
    }
}