package jpa.myboard;

import org.springframework.web.bind.annotation.*;

@RestController
public class testController {

	@GetMapping("/test")
	public String test(){
		return "hello test";
	}
	@PostMapping("/test")
	public String postTest(@RequestParam String test){
		return test;
	}
}
