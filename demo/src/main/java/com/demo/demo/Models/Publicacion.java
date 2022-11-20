package com.demo.demo.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "publicaciones",uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name= "titulo", nullable = false)
    private String titulo;

    @Column(name= "descripcion", nullable = false)
    private String descripcion;

    @Column(name= "contenido", nullable = false)
    private String contenido;


}

