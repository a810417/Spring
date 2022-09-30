package fifth.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {

	@GetMapping("/test.controller")
	public String testController() {
		
		return "test";
	}
}
