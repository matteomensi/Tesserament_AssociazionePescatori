import java.io.Serializable;
import java.time.LocalDate;

public class Tessera implements Serializable
{
	//Attributi
	private int codiceIdentificativo;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataNascita;
	private String info;
	
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
	public Tessera(Tessera t)// costruttore copia
	{
		
		setCodiceIdentificativo(t.getCodiceIdentificativo());
		setNome(t.getNome());
		setCognome(t.getCognome());
		setCodiceFiscale(t.getCodiceFiscale());
		setDataNascita(t.getDataNascita());
		setInfo(t.getInfo());
	}
	public Tessera()// costruttore vuoto
	{
		
		setCodiceIdentificativo(0);
		setNome(" ");
		setCognome(" ");
		setCodiceFiscale(" ");
		setDataNascita(null);
		setInfo(" ");
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

	public LocalDate getDataNascita() 
	{
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) 
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
		return getCodiceIdentificativo()+" "+getNome()+" "+getCognome()+" "+getCodiceFiscale()+" "+getDataNascita()+" "+getInfo(); 
	}

}
