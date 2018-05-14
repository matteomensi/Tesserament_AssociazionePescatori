import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

public class TesseraTest 
{
	@Test
	public void testCostruttoreTessera()
	{
		Tessera t=new Tessera();
		assertTrue("Costruttore tessera",t.setCodiceIdentificativo(t.getCodiceIdentificativo()) &&
				t.setNome(t.getNome()) && t.setCognome(t.getCognome()) && t.setCodiceFiscale(t.getCodiceFiscale()) &&
				t.setDataNascita(t.getDataNascita()) && t.setInfo(t.getInfo()));
	}
	
	@Test
	public void testCostruttoreCopia()
	{
		
	}
	
	@Test
	public void testCostruttoreVuoto()
	{
		
	}
	
	@Test
	public void testgetCodiceIdentificativo()
	{
		Tessera t1=new Tessera();
		assertTrue("getCodiceIdentificativo", t1.setCodiceIdentificativo(t1.getCodiceIdentificativo()));
	}
	
	@Test
	public void testsetCodiceIdentificativo()
	{
		
	}
	
	@Test
	public void testgetNome()
	{
		
	}
	
	@Test
	public void testsetNome()
	{
		
	}
	
	@Test
	public void testgetCognome()
	{
		
	}
	
	@Test
	public void testsetCognome()
	{
		
	}
	
	@Test
	public void testgetCodiceFiscale()
	{
		
	}
	
	@Test
	public void testsetCodiceFiscale()
	{
		
	}
	
	@Test
	public void testgetDataNascita()
	{
		
	}
	
	@Test
	public void testsetDataNascita()
	{
		
	}
	
	@Test
	public void testgetInfo()
	{
		
	}
	
	@Test
	public void testsetInfo()
	{
		
	}
	
	@Test
	public void testgetQuota()
	{
		
	}
	
	@Test
	public void testsetQuota()
	{
		
	}
	
	@Test
	public void testtoString()
	{
		
	}

}
