package fifth.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Try {
	
	@GetMapping("/try.controller")
	public String tryController() {
		return "try";
	}

}
