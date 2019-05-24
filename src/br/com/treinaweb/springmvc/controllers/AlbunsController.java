package br.com.treinaweb.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.treinaweb.springmvc.dominios.Album;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {

	@Autowired
	private RepositorioAlbum repositorio;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Album> albuns = repositorio.findAll();
		model.addAttribute("albuns", albuns);
		
		return "album.listar.tiles";
	}
	
	//retorna uma página pelo método GET
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
		return "album.adicionar.tiles";
	}

	//Recebe o formulário por POST, lincando o objeto com o form através do Model Attribute
	//o objeto é marcado para ser validado e retorna o resultado
	//o BindResult tem que estar ao lado do objeto validado sempre
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		//se houver algum erro de validação, retornar para formulário de inserção
		if(result.hasErrors()) {
			return "album.adicionar.tiles";
		}
		
		repositorio.save(novoAlbum);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) {
		Album albumASerAlterado = repositorio.findOne(id);
		model.addAttribute("album", albumASerAlterado);
		return "album.alterar.tiles";
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		if(result.hasErrors()) {
			return "album.alterar.tiles";
		}
		repositorio.save(album);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		repositorio.delete(id);
		return "redirect:/albuns/listar";
	}
}
