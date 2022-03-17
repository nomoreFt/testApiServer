# testApiServer

### Server To Server로 MultipartFormData File 받아서 LocalDirectory에 떨구는 것


```java

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


```
