package jpa.myboard;

import jakarta.persistence.Column;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String redirection(){
		return "redirect:/boardPost/list";
	}
}
