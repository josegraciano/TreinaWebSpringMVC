package br.com.treinaweb.springmvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	//<servidor:port>/app/hello/message
	
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
	
	//por esse método é possível passar vários objetos para a view
	//Model é uma interface que retorna um mapa de objetos
	@RequestMapping("/mensagemDoServidor")
	public String mensagemDoServidor(Model model) {
		model.addAttribute("mensagem", new Date().toString());
		return "mensagemDoServidor";
	}
	
	//por esse método só é possível passar um objeto, mas ele é mais semântico (elegante)
	//ModelAndView é uma classe que possui vários outros métodos
	@RequestMapping("/mensagemDoServidor2")
	public ModelAndView mensagemDoServidorV2() {
		ModelAndView resultado = new ModelAndView("mensagemDoServidor", "mensagem", "Data e Hora Atual: " + new Date().toString());
		return resultado;
	}
	
	//recebe a mensagem por path variable (na rota)
	//a mensgaem é obrigatória pois o Path Variable torna a rota completa obrigatória, caso contrário retorna 404
	@RequestMapping("/receberMensagem/{mensagem}")
	public String receberMensagem(Model model, @PathVariable("mensagem") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
	
	//recebe a mensagem por parâmetro (query string)
	//não modifica a rota, pode não ser obrigatório via configuração required e permite configurar valor padrão
	@RequestMapping("/receberMensagem2")
	public String receberMensagemV2 (Model model, @RequestParam(value="mensagem", required = false, defaultValue = "Padrão") String msg) {
		model.addAttribute("mensagem", msg);
		return "mensagemDoServidor";
	}
}
