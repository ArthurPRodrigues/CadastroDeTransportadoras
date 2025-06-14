package dev.java10x.CadastroDeTransportadoras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class Controller {

	@GetMapping("/transportadoras")
	public String getTransportadoras() {
		return "Lista de Transportadoras";
	}
}

