package com.example.dell.note.bean;

/**
 * Created by Dell on 2019/11/9.
 */

public class NotepadBean {
    private String id;
    private String notepadContent;
    private String notepadTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotepadContent() {
        return notepadContent;
    }

    public void setNotepadContent(String notepadContent) {
        this.notepadContent = notepadContent;
    }

    public String getNotepadTime() {
        return notepadTime;
    }

    public void setNotepadTime(String notepadTime) {
        this.notepadTime = notepadTime;
    }
}
