package com.example.calculadora;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class CalculadoraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculadoraApplication.class, args);
	}

		@GetMapping("/soma/{a}/{b}")
		public int soma(@PathVariable int a, @PathVariable int b) {
			return a + b;
		}

		@GetMapping("/subtrair")
		public int subtrair(@RequestParam int a, @RequestParam int b) {
    		return a - b;
		}

		@GetMapping("/multiplicar/{a}/{b}")
		public int multiplicar(@PathVariable int a, @PathVariable int b) {
		    return a * b;
		}

		@GetMapping("/dividir")
		public double dividir(@RequestParam double a, @RequestParam double b) {
		    return a / b;
		}

		@GetMapping("/quadrado/{n}")
		public int quadrado(@PathVariable int n) {
    		return n * n;
		}

		@GetMapping("/celsiusToFahrenheit")
		public double converter(@RequestParam double c) {
 		    return (c * 9/5) + 32;
		}

		@GetMapping("/imc")
		public double imc(@RequestParam double peso, @RequestParam double altura) {
			return peso / (altura * altura);
		}

		@GetMapping("/vizinho/{n}")
		public String vizinho(@PathVariable int n) {
		    return "Antecessor: " + (n - 1) + ", Sucessor: " + (n + 1);
		}

		@GetMapping("/desconto")
		public double desconto(@RequestParam double valor, @RequestParam double percentual) {
		    return valor - (valor * percentual / 100);
		}

		@GetMapping("/tabuada/{n}")
		public List<String> tabuada(@PathVariable int n) {
		    List<String> resultado = new ArrayList<>();
		    for (int i = 1; i <= 10; i++) {
		        resultado.add(n + " x " + i + " = " + (n * i));
		    }
		    return resultado;
		}
}