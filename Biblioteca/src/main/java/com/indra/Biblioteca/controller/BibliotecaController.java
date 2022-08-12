package com.indra.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.Biblioteca.model.Lector;
import com.indra.Biblioteca.model.Libro;
import com.indra.Biblioteca.model.Prestamo;
import com.indra.Biblioteca.services.LectorService;
import com.indra.Biblioteca.services.LibroService;
import com.indra.Biblioteca.services.PrestamoService;

@Controller
public class BibliotecaController {
	   @Autowired
	    private LectorService lectorService;
	   @Autowired
	    private LibroService libroService;
	   @Autowired
	    private PrestamoService prestamoService;
	   
//	   @GetMapping("/")
//	   public String viewHomePage(Model model) {
//	        return "index";
//	    }
	   
	   // LIBROS	   
	   @GetMapping("/libros")
	    public String viewHomePageLibros(Model model) {
	        return findPaginatedLibros(1, "titulo", "asc", model);
	    }

	    @GetMapping("/libros/add")
	    public String showNewLibroForm(Model model) {
	        Libro Libro = new Libro();
	        model.addAttribute("libro", Libro);
	        return "new_libro";
	    }

	    @PostMapping("/libros/save")
	    public String saveLibro(@ModelAttribute("libro") Libro libro) {
	        // save Course to database
	        libroService.saveLibro(libro);
	        return "redirect:/libros";
	    }

	    @GetMapping("/libros/update/{id}")
	    public String showFormForUpdateLibro(@PathVariable( value = "id") long id, Model model) {

	        Libro libro = libroService.getLibroById(id);
	        model.addAttribute("libro", libro);
	        return "update_libro";
	    }

	    @GetMapping("/libros/delete/{id}")
	    public String deleteLibro(@PathVariable(value = "id") long id) {

	        this.libroService.deleteLibroById(id);
	        return "redirect:/libros";
	    }


	    @GetMapping("/libros/page/{pageNo}")
	    public String findPaginatedLibros(@PathVariable (value = "pageNo") int pageNo,
	                                @RequestParam("sortField") String sortField,
	                                @RequestParam("sortDir") String sortDir,
	                                Model model) {
	        int pageSize = 4;

	        Page<Libro> page = libroService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List<Libro> listLibro = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());

	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	        model.addAttribute("listLibro", listLibro);
	        return "libro";
	    }
	   
	   // LECTORES
	   
	    @GetMapping("/lector")
	    public String viewHomePageLector(Model model) {
	        return findPaginatedLector(1, "nombre", "asc", model);
	    }

	    @GetMapping("/lector/addLector")
	    public String showNewLectorForm(Model model) {
	        Lector lector = new Lector();
	        model.addAttribute("lector", lector);
	        return "new_lector";
	    }

	    @PostMapping("/lector/saveLector")
	    public String saveLector(@ModelAttribute("lector") Lector lector) {
	        // save Course to database
	        lectorService.saveLector(lector);
	        return "redirect:/lector";
	    }

	    @GetMapping("/lector/updateLector/{id}")
	    public String showFormForUpdateLector(@PathVariable(value = "id") long id, Model model) {

	        Lector lector = lectorService.getLectorById(id);
	        model.addAttribute("lector", lector);
	        return "update_lector";
	    }

	    @GetMapping("/lector/deleteLector/{id}")
	    public String deleteLector(@PathVariable(value = "id") long id) {

	        this.lectorService.deleteLectorById(id);
	        return "redirect:/lector";
	    }


	    @GetMapping("/lector/pageLector/{pageNo}")
	    public String findPaginatedLector(@PathVariable(value = "pageNo") int pageNo,
	                                @RequestParam("sortField") String sortField,
	                                @RequestParam("sortDir") String sortDir,
	                                Model model) {
	        int pageSize = 4;

	        Page<Lector> page = lectorService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List<Lector> listLector = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());

	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	        model.addAttribute("listLector", listLector);
	        return "lector";
	    }
	   
	   // PRESTAMOS
	    
	    @GetMapping("/prestamo")
	    public String viewHomePage(Model model) {
	        return findPaginatedPrestamo(1, "fin", "asc", model);
	    }

	    @GetMapping("/prestamo/addPrestamos")
	    public String showNewPrestamoForm(Model model) {
	        Prestamo prestamo = new Prestamo();
	        model.addAttribute("prestamo", prestamo);
	        return "new_prestamo";
	    }

	    @PostMapping("/prestamo/savePrestamo")
	    public String savePrestamo(@ModelAttribute("prestamo") Prestamo prestamo) {
	        // save Course to database
	        prestamoService.savePrestamo(prestamo);
	        return "redirect:/prestamo";
	    }

	    @GetMapping("/prestamo/updatePrestamo/{id}")
	    public String showFormForUpdatePrestamo(@PathVariable( value = "id") long id, Model model) {

	        Prestamo prestamo = prestamoService.getPrestamoById(id);
	        model.addAttribute("prestamo", prestamo);
	        return "update_prestamo";
	    }

	    @GetMapping("/prestamo/deletePrestamo/{id}")
	    public String deletePrestamo(@PathVariable(value = "id") long id) {

	        this.prestamoService.deletePrestamoById(id);
	        return "redirect:/prestamo";
	    }


	    @GetMapping("/prestamo/pagePrestamo/{pageNo}")
	    public String findPaginatedPrestamo(@PathVariable (value = "pageNo") int pageNo,
	                                @RequestParam("sortField") String sortField,
	                                @RequestParam("sortDir") String sortDir,
	                                Model model) {
	        int pageSize = 4;

	        Page<Prestamo> page = prestamoService.findPaginated(pageNo, pageSize, sortField, sortDir);
	        List<Prestamo> listPrestamo = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());

	        model.addAttribute("sortField", sortField);
	        model.addAttribute("sortDir", sortDir);
	        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	        model.addAttribute("listPrestamo", listPrestamo);
	        return "prestamo";
	    }
}
