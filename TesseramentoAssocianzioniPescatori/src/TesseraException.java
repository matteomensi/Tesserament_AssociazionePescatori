
public class TesseraException extends Exception
{
	private String messaggio;
	
	public TesseraException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
