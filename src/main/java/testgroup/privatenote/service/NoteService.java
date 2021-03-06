package testgroup.privatenote.service;

import testgroup.privatenote.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> allNotes();
    void add(Note note);
    void delete(Note note);
    void edit(Note note);
    Note getById(int id);
}
