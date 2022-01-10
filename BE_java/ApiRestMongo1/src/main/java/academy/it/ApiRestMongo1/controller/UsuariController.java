package academy.it.ApiRestMongo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.it.ApiRestMongo1.entity.Usuari;
import academy.it.ApiRestMongo1.repository.UsuariRepository;

@RestController
@RequestMapping("/usuaris")
public class UsuariController {

	@Autowired
	private UsuariRepository usuariRepository;
	
	@PostMapping
	public String nouUsuari(@RequestBody Usuari usuari) {
		usuariRepository.save(usuari);
		return "Usuari afegit correctament";
	}
	
	@GetMapping
	public List<Usuari> getUsers() {
		return usuariRepository.findAll();
	}
	
	@GetMapping("/{nom}")
	public List<Usuari> getUserbyName(@PathVariable String nom) {
		return usuariRepository.findByNom(nom);
	}

	@GetMapping("/direccio/{ciutat}")
	public List<Usuari> getUserbyAddress(@PathVariable String ciutat) {
		return usuariRepository.findByCiutat(ciutat);
	}
	
	
	
	
	
}
