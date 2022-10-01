package fifth.project.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fifth.project.model.Member;
import fifth.project.model.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService mService;

	@GetMapping("/main.controller")
	public String processMain() {
		return "main";
	}

	@GetMapping(path = "/delete/{id}")
	public String processDeleteAction(@PathVariable("id") Integer id) {
		mService.deleteById(id);
		return "deleteDone";
	}

	@GetMapping(path = "/delM.controller")
	public String processDelAction(Member m) {
		mService.delete(m);
		return "deleteDone";
	}

	@PostMapping(path = "/insertMem.controller")
	public String processInsertAction(@RequestParam("account") String account,
			@RequestParam("password") String password, @RequestParam("nickname") String nickname,
			@RequestParam("email") String email, @RequestParam("photo") MultipartFile photo) throws IOException {

		byte[] pByte = photo.getBytes();
		Member m = new Member();
		m.setAccount(account);
		m.setPassword(password);
		m.setNickname(nickname);
		m.setEmail(email);
		m.setPhoto(pByte);
		mService.insertMem(m);

		return "insertDone";
	}
	
	@GetMapping(path = "/show.controller")
	public String processSelectAction(Model m) {
		List<Member> list = mService.selectAll();
		m.addAttribute("list", list);
		
		return "showPage";
	}

	
	@GetMapping("/downloadImage/{id}")
	public ResponseEntity<byte[]> downloadImage(@PathVariable Integer id){
		byte[] pByte = mService.getPhotoById(id);

		System.out.println(pByte);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(pByte, headers, HttpStatus.OK);
	}
}
