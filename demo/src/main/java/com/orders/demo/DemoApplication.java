package com.orders.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.orders.demo.models.Template.Language;
import com.orders.demo.models.Template.ShippingTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class DemoApplication {

	@GetMapping("/test")
	public String templateTest() {
		return new ShippingTemplate(Language.ENGLISH, "Youssef", 20.0, "Maadi").toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
