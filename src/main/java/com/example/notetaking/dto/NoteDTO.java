package com.example.notetaking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class NoteDTO {

        private Long id;

        private String title;


        private String content;

        // getters and setters

}
