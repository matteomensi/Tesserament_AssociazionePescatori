
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NodoTest 
{

	@Test
	public void testCostruttoreNodo() 
	{
		Tessera t=new Tessera();
		Nodo n=new Nodo(t);
		assertTrue("Costruttore nodo",n.getInfo().equals(t)&&n.getLink()==null);
	}
	
	@Test
	public void testSetInfo() 
	{
		Tessera t1=new Tessera();
		Tessera t2=new Tessera();
		Nodo n=new Nodo(t1);
		n.setInfo(t2);
		assertTrue("setInfo",n.getInfo().equals(t2)&& n.getLink()==null);
	}
	
	@Test
	public void testSetLink() 
	{
		Tessera t1=new Tessera();
		Tessera t2=new Tessera();
		Nodo n1=new Nodo(t1);
		Nodo n2=new Nodo(t2);
		n1.setLink(n2);
		assertTrue("setLink",n1.getInfo().equals(t1)&& n1.getLink()==n2);
	}
	@Test
	public void testGetInfo()
	{
		Tessera t1=new Tessera();
		Tessera t2=new Tessera();
		Nodo n=new Nodo(t2);
		n.setInfo(t2);
		assertTrue("getInfo",n.getInfo().equals(t2)&& n.getLink()==null);
	}
	
	@Test
	public void testGetLink()
	{
		Tessera t1=new Tessera();
		Tessera t2=new Tessera();
		Nodo n1=new Nodo(t1);
		Nodo n2=new Nodo(t2);
		n1.setLink(n2.getLink());
		assertTrue("getLink",n1.getInfo().equals(t1)&& n1.getLink()==n2);
	
	}
}
