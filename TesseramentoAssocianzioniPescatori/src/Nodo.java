import java.io.Serializable;

/**
 * 
 * @author Matteo Mensi
 */
public class Nodo implements Serializable
{
	private Tessera info;
	private Nodo link;
	
	/**
	*Il costruttore riceve come parametro un oggetto di tipo Tessera e assegna al proprio
	*attributo info una copia di questa tessera
	* L'attributo link viene posto a null.
	* @param persona è il tesserato da aggiungere di tpon tessera
	*/
	public Nodo(Tessera persona)
	{
		setInfo(persona);
		link=null;
	}

	/**
	 * Metodo getter che restituisce la componente informativa di un nodo
	 * @return la componente informativa di un nodo
	 */
	public Tessera getInfo() 
	{
		return info;
	}

	/**
	 * Metodo setter che consente di impostare la componente informativa di un nodo
	 * @param info componente informativa di un nodo
	 */
	public void setInfo(Tessera info) 
	{
		this.info = info;
	}

	/**
	 * Metodo getter che restituisce il link di un nodo
	 * @return il link di un nodo
	 */
	public Nodo getLink() 
	{
		return link;
	}

	/**
	 *  Metodo setter che consente di impostare il link di un nodo 
	 * @param link link di un nodo
	 */
	public void setLink(Nodo link) 
	{
		this.link = link;
	}
	
	
}
