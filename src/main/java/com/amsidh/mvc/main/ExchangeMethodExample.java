package com.amsidh.mvc.main;

import java.io.File;
import java.util.concurrent.ExecutionException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;

public class ExchangeMethodExample {

	public static void main(String[] args) {
		
		
		AsyncRestTemplate asycTemp = new AsyncRestTemplate();
		String url = "http://localhost:8181/SpringBootFileUpload/fileService/uploadFile";
		
		// create request entity using HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		//map.add("file", new ClassPathResource(""));
		map.add("file", new FileSystemResource(new File("D:\\education\\workspace-sts-3.7.0.RELEASE\\Java_UserMap\\bin\\jdk-8u25-docs-all.zip")));
		
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new    HttpEntity<LinkedMultiValueMap<String, Object>>(
                map, headers);
		asycTemp.exchange(url, HttpMethod.POST, requestEntity,  String.class);
		
		/*ListenableFuture<ResponseEntity<String>> future = asycTemp.exchange(url, HttpMethod.POST, requestEntity,  String.class);
		try {
			// waits for the result
			ResponseEntity<String> entity = future.get();
			// prints body source code for the given URL
			System.out.println(entity.getBody());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/

	}

}
