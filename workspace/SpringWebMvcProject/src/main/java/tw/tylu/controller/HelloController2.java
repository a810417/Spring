package tw.tylu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(names= {"userName"})
public class HelloController2 {

	@RequestMapping(path = "/hello2.controller", method = RequestMethod.GET)
	public String processAction(@RequestParam("userName") String userName, Model m, SessionStatus status) {
//		String userName = request.getParameter("userName");


		Map<String, String> errors = new HashMap<String, String>();
		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			// 若沒輸入會將括弧內資訊塞入 HashMap 的 errors 內
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			// 如果 errors 內不是空的就會再次跳轉到 form.jsp 頁面
			// request 結束 -> 新的 jsp 頁面 errors 仍是空的
			return "/form.jsp";
			
		}
		
		// 會清空 session 內的資料
		status.setComplete();

//		HttpSession session = request.getSession();
//		session.setAttribute("userName", userName);
		m.addAttribute("userName", userName);
		// new ModelAndView(); -> 指定跳轉的頁面(View)
		return "/success.jsp";
	}
	
	@RequestMapping(path = "/hello2.controller", method = RequestMethod.POST)
	public String processAction2(@RequestParam("userName") String userName, Model m, SessionStatus status) {
//		String userName = request.getParameter("userName");


		Map<String, String> errors = new HashMap<String, String>();
		// request.setAttribute("errors", errors);
		m.addAttribute("errors", errors);

		if (userName == null || userName.length() == 0) {
			// 若沒輸入會將括弧內資訊塞入 HashMap 的 errors 內
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			// 如果 errors 內不是空的就會再次跳轉到 form.jsp 頁面
			// request 結束 -> 新的 jsp 頁面 errors 仍是空的
			return "/form.jsp";
			
		}
		
		// 會清空 session 內的資料
		status.setComplete();

//		HttpSession session = request.getSession();
//		session.setAttribute("userName", userName);
		m.addAttribute("userName", userName);
		// new ModelAndView(); -> 指定跳轉的頁面(View)
		return "/success.jsp";
	}



	
}
