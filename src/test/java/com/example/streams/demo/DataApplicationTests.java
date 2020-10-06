package com.example.streams.demo;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataApplicationTests {

	/**
	 * Testar a obtenção da data atual.
	 */
	@Test
	public void testarData() {

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
	}

	/**
	 * Testar a diferença de anos entre duas datas
	 */
	@Test
	public void testarDataFuturaDiffAno() {

		LocalDate dataFutura = LocalDate.of(2021, Month.MAY, 11);
		LocalDate hoje = LocalDate.now();

		int anos = dataFutura.getYear() - hoje.getYear();

		System.out.println(anos);
	}

	/**
	 * Testar a diferença entre datas
	 */
	@Test
	public void testarDiffEntreDatas() {

		LocalDate dataFutura = LocalDate.of(2021, Month.MAY, 11);
		LocalDate hoje = LocalDate.now();

		Period periodo = Period.between(hoje, dataFutura);

		System.out.println(periodo.getDays()); //verificar

	}
	
	/**
	 * Testar a diferença entre datas
	 */
	@Test
	public void testarSubstrairData() {

		
		LocalDate hoje = LocalDate.now();

		LocalDate proxData = hoje.plusYears(1);

		System.out.println(proxData);

	}
}
