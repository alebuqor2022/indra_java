package com.indra.Biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inicio")
    private Date inicio;

    @Column(name = "fin")
    private Date fin;

    @OneToOne
    @JoinColumn(name = "fk_lector")
    private Lector lector;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_libro")
    private Libro libro;
}
