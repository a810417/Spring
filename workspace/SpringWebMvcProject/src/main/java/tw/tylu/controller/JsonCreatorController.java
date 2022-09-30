package tw.tylu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.tylu.model.House;

@Controller
public class JsonCreatorController {

	@GetMapping("/jsoncreator.controller")
	@ResponseBody
	public String processAction() throws JsonProcessingException {
		House h1 = new House();
		h1.setHouseid(1000);
		h1.setHousename("Happy House");

		ObjectMapper om = new ObjectMapper();
		String hJson = om.writeValueAsString(h1);

		House h2 = om.readValue(hJson, House.class);
		System.out.println(h2.getHouseid() + " " + h2.getHousename());

		return hJson;
	}

	@GetMapping("/jsoncreator2.controller")
	@ResponseBody // application/json 為預設格式
	public House processAction2() throws JsonProcessingException {
		House h1 = new House();
		h1.setHouseid(1001);
		h1.setHousename("Amazing House");
		System.out.println(h1.getHouseid()+" "+h1.getHousename());

		return h1;
	}

}
