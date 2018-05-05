
public class Tessera 
{
	//Attributi
	private int codiceIdentificativo;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String dataNascita;
	private String info;
	
	public Tessera (int codiceIdentificativo,String nome, String cognome,
			String codiceFiscale, String dataNascita, String info)
	{
		this.codiceIdentificativo=codiceIdentificativo;
		this.nome=nome;
		this.cognome=cognome;
		this.codiceFiscale=codiceFiscale;
		this.dataNascita=dataNascita;
		this.info=info;
	}
	
	public int getCodiceIdentificativo() 
	{
		return codiceIdentificativo;
	}
	
	public void setCodiceIdentificativo(int codiceIdentificativo) 
	{
		this.codiceIdentificativo = codiceIdentificativo;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getCodiceFiscale() 
	{
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) 
	{
		this.codiceFiscale = codiceFiscale;
	}

	public String getDataNascita() 
	{
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) 
	{
		this.dataNascita = dataNascita;
	}

	public String getInfo() 
	{
		return info;
	}

	public void setInfo(String info) 
	{
		this.info = info;
	}
	
	public String toString()
	{
		return getCodiceIdentificativo()+" "+getNome()+" "+getCognome()+" "+
				getCodiceFiscale()+" "+getDataNascita()+" "+getInfo(); 
	}

}
