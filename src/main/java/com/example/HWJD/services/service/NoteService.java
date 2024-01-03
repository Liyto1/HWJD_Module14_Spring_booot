package com.example.HWJD.services.service;

import com.example.HWJD.services.dto.NoteDto;
import com.example.HWJD.services.exception.NoteNotFoundException;


import java.util.List;
import java.util.UUID;

public interface NoteService {

    NoteDto save(NoteDto note);

    void update(NoteDto note) throws NoteNotFoundException;

    NoteDto findById(UUID id)  throws NoteNotFoundException;

    List<NoteDto> findAll()  throws NoteNotFoundException;

    void deleteById(UUID id)  throws NoteNotFoundException;
}