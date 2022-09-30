package tw.tylu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tw.tylu.model.Members;

@Controller
public class MembersController {

	@GetMapping(path="/membersmain.controller")
	public String processMainAction(Model m) {
//		Members members = new Members(); // 不帶參數 new 的物件，會顯示各變數的 default 值(String: null / int: 0)
		Members members = new Members("jack","male",35); // 帶參數就會顯示設定的參數在表格上
		m.addAttribute("members", members); // 前方字串指 JSP 中的 modelAttribute 的字串，用來連結；後方則是上面一行 new 的物件，用來代入 JSP 作為初始顯示用
		return "members"; // JSP
	}
	
	@PostMapping(value="/addMembers")
	public String processAction(@ModelAttribute("members") Members mem2, BindingResult result, Model m) {
		if(result.hasErrors()) {
			return "membersError";
		}
		
		m.addAttribute("mName", mem2.getMemberName());
		m.addAttribute("mGender", mem2.getGender());
		m.addAttribute("mAge", mem2.getAge());
		
		return "membersResult";
		
	}
	
}
