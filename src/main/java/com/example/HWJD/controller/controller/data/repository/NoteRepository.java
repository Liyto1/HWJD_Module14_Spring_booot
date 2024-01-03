package com.example.HWJD.controller.controller.data.repository;

import com.example.HWJD.controller.controller.data.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
}
