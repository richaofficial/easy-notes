package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com. example.easynotes.model.Note;
import com.example.easynotes.model.Student;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    NoteService noteService;

    // Get All Notes

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        System.out.print(noteService);
        return noteRepository.findAll();
    }

    // Create a new Note

    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note){
        System.out.print(note);
        return noteRepository.save(note);
    }

    // Get a Single Note

    @GetMapping("/notes/{id}")
    public  Note getNoteById(@PathVariable (value= "id") Long noteId){
        return noteRepository.findById(noteId)
                .orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
    }

    // POST for Student

    @PostMapping("/student")
    public void creatStudent(@RequestBody Student student){
        System.out.println(student);
    }



    // Delete a Note
}
