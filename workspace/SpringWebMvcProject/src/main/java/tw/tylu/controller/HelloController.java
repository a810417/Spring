package tw.tylu.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 接收、驗證資料、呼叫 Model、根據執行結果導向 View

		String userName = request.getParameter("userName");

		HashMap<String, String> errors = new HashMap<String, String>();
		request.setAttribute("errors", errors);
		if (userName == null || userName.length() == 0) {
			// 若沒輸入會將括弧內資訊塞入 HashMap 的 errors 內
			errors.put("name", "name is required");
		}

		if (errors != null && !errors.isEmpty()) {
			// 如果 errors 內不是空的就會再次跳轉到 form.jsp 頁面
			// request 結束 -> 新的 jsp 頁面 errors 仍是空的 
			return new ModelAndView("/form.jsp");
		}

		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);

		// new ModelAndView(); -> 指定跳轉的頁面(View)
		return new ModelAndView("/success.jsp");
	}

}
