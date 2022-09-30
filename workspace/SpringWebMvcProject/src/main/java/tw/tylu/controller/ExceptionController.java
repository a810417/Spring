package tw.tylu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	@RequestMapping("/exception.controller")
	public void processExceptionAction() throws Exception {
		throw new Exception();
	}
}
