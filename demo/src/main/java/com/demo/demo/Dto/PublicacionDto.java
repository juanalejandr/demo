package com.demo.demo.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PublicacionDto {

    private long id;
    private String titulo;
    private String descripcion;
    private String contenido;
}
