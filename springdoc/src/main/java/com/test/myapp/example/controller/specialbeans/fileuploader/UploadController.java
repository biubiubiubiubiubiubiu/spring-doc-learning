package com.test.myapp.example.controller.specialbeans.fileuploader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class UploadController {

    @RequestMapping(value="file-upload.do", method = RequestMethod.GET)
    public String uploadPage() {
        return "fileUpload";
    }

    @RequestMapping(value="fileUpload.do", method = RequestMethod.POST)
    public void fileUpload(@RequestPart(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        String name = file.getName();

        String originalFilename = file.getOriginalFilename();

        String contentType = file.getContentType();

        System.out.println("name -> " + name +
                " originalFilename -> " + originalFilename +
                " contentType -> " + contentType);
        String filePath = request.getServletContext().getRealPath("/");
        file.transferTo(new File(filePath + "/" + originalFilename));
    }

}
