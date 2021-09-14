package com.isi.isiapi.general.classes;

import com.google.gson.annotations.SerializedName;

public class AdditionaInformation {
    @SerializedName("Id")
    private final int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Description")
    private String description;
    @SerializedName("NoteUtente")
    private String noteUtente;

    public AdditionaInformation(int id, String name, String description, String noteUtente) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.noteUtente = noteUtente;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoteUtente() {
        return noteUtente;
    }

    public void setNoteUtente(String noteUtente) {
        this.noteUtente = noteUtente;
    }
}
