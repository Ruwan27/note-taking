package com.example.notetaking.service;

import com.example.notetaking.dto.NoteDTO;
import com.example.notetaking.entity.Note;
import com.example.notetaking.repo.NoteRepository;
import com.example.notetaking.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ModelMapper modelMapper;
    public String saveNote(NoteDTO noteDtO){
        if (noteRepository.existsById(noteDtO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            noteRepository.save(modelMapper.map(noteDtO, Note.class));
            return VarList.RSP_SUCCESS;
        }
    }


    public List<NoteDTO> getAllNotes(){
        List<Note> noteList = noteRepository.findAll();
        return modelMapper.map(noteList,new TypeToken<ArrayList<NoteDTO>>(){
        }.getType());
    }


    public NoteDTO getNoteById(long id){
        if (noteRepository.existsById(id)){
            Note note =noteRepository.findById(id).orElse(null);
            return modelMapper.map(note,NoteDTO.class);
        }else {
            return null;
        }
    }
}
