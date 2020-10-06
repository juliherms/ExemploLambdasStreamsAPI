package com.example.streams.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

		System.out.println(periodo.getDays()); // verificar

	}

	/**
	 * Testar a diferença entre datas
	 */
	@Test
	public void testarSubtrairData() {

		LocalDate hoje = LocalDate.now();
		LocalDate proxData = hoje.plusYears(1);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = formatador.format(proxData);

		System.out.println(valorFormatado);

	}
	
	/**
	 * Testar formatacao de data hora
	 */
	@Test
	public void testarFormatacaoDataHora() {
		
		LocalDateTime agora = LocalDateTime.now();
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		
		System.out.println(agora.format(formatadorComHoras));
		
		
		LocalTime intervalo = LocalTime.of(15,30);
		System.out.println(intervalo);
	}
}
