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
@Table(name = "lector")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nSocio")
    private String nSocio;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "prestamo", joinColumns = @JoinColumn(name = "fk_libro"), inverseJoinColumns = @JoinColumn(name = "fk_lextor"))
    private List<Lector> lectores;*/
    @ManyToMany(mappedBy="lectores")
    private List <Libro> libros;
}
