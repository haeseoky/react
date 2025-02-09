package com.ocean.react;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(value = "/file")
@RequiredArgsConstructor
public class FileController {

    @PostMapping(value = "/save", consumes = "multipart/form-data")
    public void postFile(@RequestParam("data") MultipartFile data) {

        String name = data.getName();
        String originalFilename = data.getOriginalFilename();
        InputStream inputStream = null;
        try {
            inputStream = data.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("name: {}, originalFilename: {}", name, originalFilename);
        log.info("inputStream: {}", inputStream);


    }

    @PostMapping(value = "/saves", consumes = "multipart/form-data")
    public void postFile(@RequestParam("data") List<MultipartFile> data) {

        data.forEach(file -> {
            String name = file.getName();
            String originalFilename = file.getOriginalFilename();

//            InputStream inputStream = file.getInputStream();

            File tempFile = new File("/Users/haeseoky/work/study/project/spring/react/" + originalFilename);
            try {
                file.transferTo(tempFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            log.info("name: {}, originalFilename: {}", name, originalFilename);
//            log.info("inputStream: {}", inputStream);
        });

    }

    @PostMapping(value = "/base64EncodingFile")
    public void postBase64EncodingFile(@RequestBody Base64Request data) throws IOException {
        log.info("data.getBase64(): {}", data.getBase64());

        byte[] decode = Base64.getDecoder().decode(data.getBase64());
        Path yyyyMMddHHmmssSSS = Files.write(new File("/Users/haeseoky/work/study/project/spring/react/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))+".png").toPath(),
            decode);

    }
}
