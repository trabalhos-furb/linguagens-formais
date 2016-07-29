package br.com.furb;

import org.junit.Assert;
import org.junit.Test;

public class PreProcessadorTest {

	@Test
	public void test01() throws Exception {
		PreProcessador preProcessador = new PreProcessador();
		String[] palavras = preProcessador.processar("abc dfg asda asd");
		Assert.assertArrayEquals(new String[] {"abc", "dfg", "asda", "asd"}, palavras);
	}
	
	@Test
	public void test02() throws Exception {
		PreProcessador preProcessador = new PreProcessador();
		String[] palavras = preProcessador.processar("abc dfg asda     \nasd");
		Assert.assertArrayEquals(new String[] {"abc", "dfg", "asda", "asd"}, palavras);
	}
	
	@Test
	public void test03() throws Exception {
		PreProcessador preProcessador = new PreProcessador();
		String[] palavras = preProcessador.processar("abc\tdfg              \r         ");
		Assert.assertArrayEquals(new String[] {"abc", "dfg"}, palavras);
	}
	
	@Test
	public void test04() throws Exception {
		PreProcessador preProcessador = new PreProcessador();
		String[] palavras = preProcessador.processar("abc;def.ghi,jkl");
		Assert.assertArrayEquals(new String[] {"abc", ";", "def", ".", "ghi", ",", "jkl"}, palavras);
	}
}
