package com.example.streams.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.streams.demo.domais.Curso;
import com.example.streams.demo.util.ComparadorTamanho;
import com.example.streams.demo.util.ImprimeNaLinha;

@SpringBootTest
class DemoApplicationTests {

	List<Curso> cursos = new ArrayList<Curso>();

	@Test
	void contextLoads() {
	}

	/**
	 * Testar ordenação de lista de string por tamanho. Exemplo de default methods
	 */
	@Test
	public void testarOrdenacao() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		Comparator<String> comparator = new ComparadorTamanho();
		palavras.sort(comparator); // novo no java 8

		Consumer<String> consumidor = new ImprimeNaLinha();
		palavras.forEach(consumidor);
	}

	/**
	 * Testar ordenacao de lista utilizando classe anonima
	 */
	@Test
	public void testarOrdenacaoComClasseAnonima() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		Comparator<String> comparator = new ComparadorTamanho();
		palavras.sort(comparator); // novo no java 8

		// utilizando classe anonima
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);

			}
		});
	}

	/**
	 * Testar ordenacao de lista utilizando lambda
	 */
	@Test
	public void testarOrdenacaoComLambda() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		Comparator<String> comparator = new ComparadorTamanho();
		palavras.sort(comparator); // novo no java 8

		// utilizando lambda
		palavras.forEach(s -> System.out.println(s));
	}

	/**
	 * Testar ordenacao e listagem com lambda
	 */
	@Test
	public void testarOrdencacaoComparatorLambda() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		// exemplo de método funcional com lambda
		palavras.sort((String s1, String s2) -> {

			if (s1.length() < s2.length())
				return -1;

			if (s1.length() > s2.length())
				return 1;

			return 0;

		}); // novo no java 8

		// utilizando lambda
		palavras.forEach(s -> System.out.println(s));

	}

	/**
	 * Testar ordenacao e listagem com lambda utilizando a Integer comparator
	 */
	@Test
	public void testarOrdencacaoComparatorLambdaInteger() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		// exemplo de método funcional com lambda
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length())); // novo no java 8

		// utilizando lambda
		palavras.forEach(s -> System.out.println(s));

	}

	/**
	 * Testar ordenacao e listagem com lambda utilizando a Integer comparator
	 */
	@Test
	public void testarOrdencacaoComparatorLambdaIntegerReference() {

		List<String> palavras = new ArrayList<String>();
		palavras.add("Juliherms Vasconcelos");
		palavras.add("Fred Vasconcelos");
		palavras.add("Celia Maria");

		// dado um objeto chama o método do objeto
		// dado uma string chama o método da string
		palavras.sort(Comparator.comparing(s -> s.length())); // compara o tamanho de cada string
		// palavras.sort(Comparator.comparing(String::length)); -> isso aqui é chamado
		// de metodo reference

		// utilizando lambda
		palavras.forEach(s -> System.out.println(s));
	}

	/**
	 * Testar ordenacao de lista com lambda
	 */
	@Test
	public void testarOrdenarCursos() {

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAlunos)); // method reference

		cursos.forEach(c -> System.out.println(c.getNome()));
	}

	/**
	 * Testar filtro por quantidade de alunos com stream
	 */
	@Test
	public void testarImprimirCursosAcimaDe100Alunos() {

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));
	}

	/**
	 * Testar filtro por quantidade de alunos com stream utilizando o total de
	 * alunos por curso
	 */
	@Test
	public void testarImprimirCursosAcimaDe100AlunosTotalizado() {

		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(c -> c.getAlunos()).sum();
		
		System.out.println(sum);

	}
}
