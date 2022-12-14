package tw.tylu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.tylu.model.Account;
import tw.tylu.model.AccountService;

@Controller
public class LoginSystemController {

	@Autowired
	private AccountService aService;

	@GetMapping("/loginsystemmain.controller")
	public String processMainAction() {
		return "loginSystem";
	}

	@PostMapping("/checklogin.controller")
	public String processAction(@RequestParam("userName") String user, @RequestParam("userPwd") String pwd, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);

		if (user == null || user.length() == 0) {
			errors.put("name", "name is required");
		}

		if (pwd == null || pwd.length() == 0) {
			errors.put("pwd", "user password is required");
		}

		if (errors != null && !errors.isEmpty()) {
			return "loginSystem";
		}

		boolean result = aService.checkLogin(new Account(user, pwd));

		if (result) {
			m.addAttribute("user", user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}

		errors.put("msg", "username or password is not correct");
		return "loginSystem";

	}

}
