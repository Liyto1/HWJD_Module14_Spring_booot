package com.example.HWJD.services.service.impl;

        import com.example.HWJD.controller.controller.data.entities.Note;
        import com.example.HWJD.controller.controller.data.repository.NoteRepository;
        import com.example.HWJD.services.dto.NoteDto;
        import com.example.HWJD.services.exception.NoteNotFoundException;
        import com.example.HWJD.services.service.NoteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.UUID;
        import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteDto save(NoteDto noteDto) {
        Note note = convertToEntity(noteDto);
        Note savedNote = noteRepository.save(note);
        return convertToDto(savedNote);
    }

    @Override
    public void update(NoteDto noteDto) throws NoteNotFoundException {
        UUID id = noteDto.getId();
        if (noteRepository.existsById(id)) {
            Note note = convertToEntity(noteDto);
            noteRepository.save(note);
        } else {
            throw new NoteNotFoundException("Note not found with id: " + id);
        }
    }

    @Override
    public NoteDto findById(UUID id) throws NoteNotFoundException {
        return noteRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));
    }

    @Override
    public List<NoteDto> findAll() {
        return noteRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) throws NoteNotFoundException {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException("Note not found with id: " + id);
        }
    }

    private NoteDto convertToDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        return noteDto;
    }

    private Note convertToEntity(NoteDto noteDto) {
        Note note = new Note();
        note.setId(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return note;
    }
}
