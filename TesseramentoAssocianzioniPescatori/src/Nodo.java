import java.io.Serializable;

public class Nodo implements Serializable
{
	private Tessera info;
	private Nodo link;
	
	public Nodo(Tessera persona)
	{
		setInfo(persona);
		link=null;
	}

	public Tessera getInfo() 
	{
		return info;
	}

	public void setInfo(Tessera info) 
	{
		this.info = info;
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
