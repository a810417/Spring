package tw.tylu.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.tylu.model.Picture;
import tw.tylu.model.PictureService;

@Controller
public class UploadFileController {

	@GetMapping("/uploadfilemain.contorller")
	public String processMainAction() {
		return "uploadFile";
	}

	@PostMapping("/upload.controller")
	@ResponseBody
	public String processAction(@RequestParam("myFiles") MultipartFile mf) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		System.out.println("fileName:" + fileName);

		String saveFileDir = "c:/temp/upload/";
		File saveFilePath = new File(saveFileDir, fileName);

		byte[] b = mf.getBytes();
		mf.transferTo(saveFilePath);

		if (fileName != null && fileName.length() != 0) {
			savePicture(fileName, b);
		}

		return "SaveFilePath:" + saveFilePath;
	}

	@Autowired
	private PictureService pService;

	public void savePicture(String fileName, byte[] b) {
		Picture p1 = new Picture(fileName, b);
		pService.insert(p1);
	}

}
