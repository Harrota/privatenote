package testgroup.privatenote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import testgroup.privatenote.model.Note;
import testgroup.privatenote.service.NoteService;
import testgroup.privatenote.service.NoteServiceImpl;

import java.util.List;

@Controller
public class NoteController {

    private NoteService noteService;

    @Autowired
    public void setFilmService(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allNotes() {
        List<Note> notes = noteService.allNotes();
        ModelAndView modelAndView = new ModelAndView("/notes");
        modelAndView.addObject("notesList", notes);
        return modelAndView;
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("note", note);

        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
        public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        noteService.edit(note);
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/edit");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addFilm(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        noteService.add(note);
        return modelAndView;
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteNote(@PathVariable("id") int id){
        Note note = noteService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        noteService.delete(note);
        return modelAndView;
    }
}