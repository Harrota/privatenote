package testgroup.privatenote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testgroup.privatenote.dao.NoteDAO;
import testgroup.privatenote.dao.NoteDAOImpl;
import testgroup.privatenote.model.Note;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    private NoteDAO noteDAO;

    @Autowired
    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    @Transactional
    public List<Note> allNotes() {
        return noteDAO.allNotes();
    }

    @Override
    @Transactional
    public void add(Note note) {
        noteDAO.add(note);
    }

    @Override
    @Transactional
    public void delete(Note note) {
        noteDAO.delete(note);
    }

    @Override
    @Transactional
    public void edit(Note note) {
        noteDAO.edit(note);
    }

    @Override
    @Transactional
    public Note getById(int id) {
        return noteDAO.getById(id);
    }
}
