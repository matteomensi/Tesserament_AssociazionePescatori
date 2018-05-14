import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe rappresenta una tessera. Ogni tessera è composta da 7 attributi di cui quota statco.
 *  Gli attributi sono: "codiceIdentificativo" che indica il codice della tessera, "nome" che indica il nome
 *  del tesserato, "cognome" che indica il cognome del tesserato, "codiceFiscale" che indica il codice fiscale
 *  del tesserato, "dataNAscita" che indica la data di nascita del tesserato, "info" serve per indicare se la tessera
 *  è un rinnovo o nuva e "quota" che indica la quata da pagare.
 * @author Matteo Mensi
 *
 */

public class Tessera implements Serializable
{
	//Attributi
	private int codiceIdentificativo;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataNascita;
	private String info;
	private static int quota=30;
	
	/**
	 * Costruttore
	 */
	public Tessera (int codiceIdentificativo,String nome, String cognome,
			String codiceFiscale, LocalDate dataNascita, String info)
	{
		this.codiceIdentificativo=codiceIdentificativo;
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.dataNascita=dataNascita;
		this.info=info;
	}
	
	/**
	 * Costruttore copia. Crea una copia del progetto passato come parametro.
	 */
	public Tessera(Tessera t)// costruttore copia
	{
		
		setCodiceIdentificativo(t.getCodiceIdentificativo());
		setNome(t.getNome());
		setCognome(t.getCognome());
		setCodiceFiscale(t.getCodiceFiscale());
		setDataNascita(t.getDataNascita());
		setInfo(t.getInfo());
	}
	
	/**
	 * Costruttore vuoto
	 * @param denominazione Il nome da assegnare al progetto
	 */
	public Tessera()// costruttore vuoto
	{
		
		setCodiceIdentificativo(0);
		setNome(" ");
		setCognome(" ");
		setCodiceFiscale(" ");
		setDataNascita(null);
		setInfo(" ");
	}
	
	/**
	 * Metodo getter che restituisce il codiceIdentificativo di una tessera
	 */
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
	
	/**
	 * Metodo setter che imposta il codiceIdentificativo di una tessera
	 */
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}

	/**
	 * Metodo getter che restituisce il Nome di una tessera
	 */
	public String getNome() 
	{
		return nome;
	}

	/**
	 * Metodo setter che imposta il Nome di una tessera
	 */
	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	/**
	 * Metodo getter che restituisce il Cognome di una tessera
	 */
	public String getCognome() 
	{
		return cognome;
	}

	/**
	 * Metodo setter che imposta il Cognome di una tessera
	 */
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	/**
	 * Metodo getter che restituisce il CodiceFiscale di una tessera
	 */
	public String getCodiceFiscale() 
	{
		return codiceFiscale;
	}

	/**
	 * Metodo setter che imposta il CodiceFiscale di una tessera
	 */
	public void setCodiceFiscale(String codiceFiscale) 
	{
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Metodo getter che restituisce la data di nascita di una tessera
	 */
	public LocalDate getDataNascita() 
	{
		return dataNascita;
	}

	/**
	 * Metodo setter che imposta la data di nascita di una tessera
	 */
	public void setDataNascita(LocalDate dataNascita) 
	{
		this.dataNascita = dataNascita;
	}

	/**
	 * Metodo getter che restituisce il tipo di tessera
	 */
	public String getInfo() 
	{
		return info;
	}

	/**
	 * Metodo setter che imposta il tipo di tessera
	 */
	public void setInfo(String info) 
	{
		this.info = info;
	}
	
	/**
	 * Metodo getter che restituisce la quota di una tessera
	 */
	public static int getQuota() 
	{
		return quota;
	}
	
	/**
	 * Metodo setter che imposta la quota di una tessera
	 */
	public static void setQuota(int quota) 
	{
		Tessera.quota = quota;
	}
	
	/**
	 * Restituisce l'oggetto istanziato come stringa
	 */
	public String toString()
	{
		return getCodiceIdentificativo()+" "+getNome()+" "+getCognome()+" "+getCodiceFiscale()+" "+getDataNascita()+" "+getInfo(); 
	}

}
