package com.example.HWJD.controller.response;

import com.example.HWJD.controller.request.NoteRequest;
import lombok.Data;

@Data
public class UpdateNoteRequest extends NoteRequest {

    public UpdateNoteRequest () {
    }

    public UpdateNoteRequest (String title, String content) {
        super(title, content);
    }
}