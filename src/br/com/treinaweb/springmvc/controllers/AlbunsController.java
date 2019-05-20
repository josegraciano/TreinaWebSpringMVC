package br.com.treinaweb.springmvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.treinaweb.springmvc.dominios.Album;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {

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
		
		model.addAttribute("album", novoAlbum);
		return "album.exibir.tiles ";
	}
}
