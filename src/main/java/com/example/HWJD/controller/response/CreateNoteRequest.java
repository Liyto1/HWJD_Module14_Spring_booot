package com.example.HWJD.controller.response;

import com.example.HWJD.controller.request.NoteRequest;
import lombok.Data;

@Data
public class CreateNoteRequest extends NoteRequest {

    public CreateNoteRequest () {
    }

    public CreateNoteRequest (String title, String content) {
        super(title, content);
    }
}