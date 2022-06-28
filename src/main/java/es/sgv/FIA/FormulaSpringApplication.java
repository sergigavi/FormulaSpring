package es.sgv.FIA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormulaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormulaSpringApplication.class, args);
		
		identificarse();
	}

	private static void identificarse() {
		System.out.println("estoy en la app 1");
		
	}

}
