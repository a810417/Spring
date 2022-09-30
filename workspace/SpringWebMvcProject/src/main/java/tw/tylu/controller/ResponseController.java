package tw.tylu.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

	@GetMapping(path = "/response1.controller", produces = "text/plain;charset=UTF-8")
	@ResponseBody // default: application/json
	public String processResponseAction() {
		return "hi how are you?你好"; // 字串無法辨識中文
	}

	@GetMapping(path = "/responseentity.action", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> processResponseEntityAction() {
		return new ResponseEntity<String>("Custom Information", HttpStatus.FORBIDDEN);
		// HttpStatus.FORBIDDEN -> 拒絕存取
		// 不同瀏覽器會有不同結果，ex: Google Chrome 會顯示前方的 "Custom Information" (就是 HTTP 403 的狀況)
		// 但 IE 會直接拒絕存取
	}

	@GetMapping(path = "/responseentityheader.action")
	@ResponseBody
	public ResponseEntity<String> processResponseEntityHeaderAction() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("Custom Header Information",headers, HttpStatus.OK);
	}

	@GetMapping(path = "/imagesstream.controller", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public byte[] processResponseImageAsStreamAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/Pikachu.jpg");
		return IOUtils.toByteArray(in);
	}
}
