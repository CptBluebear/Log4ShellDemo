package org.corodiak.l4jspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@Slf4j
public class FileDownloadController {

    @Value("${file.path}")
    String filePath;

    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        log.info("File Download : {}", filePath);
        byte[] fileByte = FileUtils.readFileToByteArray(new File(filePath));
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; fileName=\"Program.exe\"");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
