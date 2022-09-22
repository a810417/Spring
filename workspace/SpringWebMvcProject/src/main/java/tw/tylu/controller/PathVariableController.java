package tw.tylu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PathVariableController {

	@RequestMapping(path="/members/{mid}", method = RequestMethod.GET)
	public void processAction(@PathVariable("mid") String memberId) {
		System.out.println("memberId: "+memberId);
	}
}
