package com.apiServer.testApiServer.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class testController {

    private final String URL = "http://192.168.20.56:8080/custom/apiset.do";

    private final String test = "fwefwe";




    @PostMapping("/api/getMultiFile")
    public void getMultiFile() throws Exception{

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MediaType mediaType = new MediaType(MediaType.MULTIPART_FORM_DATA, StandardCharsets.UTF_8);
        headers.setContentType(mediaType);

        

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.put("method", Collections.singletonList("sendFileByFileOID"));
        map.put("fileOID", Collections.singletonList("1N_MlGxk05Z"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.postForObject( URL, request , byte[].class );
        File file = new File("D:\\testRRR.xlsx");

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(response);
        fileOutputStream.flush();
        fileOutputStream.close();
        //response.getBody().getBytes(StandardCharsets.UTF_8)
        System.out.println(response);
        System.out.println("test");
    }
}
