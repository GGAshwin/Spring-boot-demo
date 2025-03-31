package com.example.demo.Student;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@RequestMapping(path = "/api/test")
public class TestController {
	@GetMapping(path = "/normal")
	Map getDummyJson(){
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts/1";
		Map response = restTemplate.getForObject(url, Map.class);
		System.out.println(response);
		return response;
	}

	@GetMapping(path = "/webclient")
	String getDummyJsonUsingWebClient(){
		WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com/posts/1");

		String response = webClient.get()
				.uri("")
				.retrieve()
				.bodyToMono(String.class)
				.block();  // Blocking call (use in non-reactive apps)

		System.out.println(response);

		return response;
	}
}
