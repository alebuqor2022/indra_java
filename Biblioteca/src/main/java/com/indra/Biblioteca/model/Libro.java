package com.indra.Biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "anyo")
    private int anyo;

    //Many
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "prestamo", joinColumns = @JoinColumn(name = "fk_libro"), inverseJoinColumns = @JoinColumn(name = "fk_lector"))
    private List<Lector> lectores;
}
