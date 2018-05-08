import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Lista implements Serializable
{
	private Nodo head;
	private int elementi;
	
	public Lista()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Tessera persona, Nodo link)
	{
		Nodo nodo= new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws TesseraException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new TesseraException("Posizione non valida");
		if (elementi==0)
			throw new TesseraException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	
	public void inserisci(Tessera persona)
	{
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
		try 
		{
			esportaCSV("lista.txt");
		} 
		catch (IOException e) 
		{
			System.out.println("File non trovato");
		} 
		catch (TesseraException e) 
		{
			e.toString();
		}
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	
	public void eliminaInTesta() throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws TesseraException
	{
		try 
		{
			esportaCSVeliminati("eliminati.txt",posizione);
		} 
		catch (IOException e) 
		{
			System.out.println("File non trovato");
		}
		
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new TesseraException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new TesseraException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	public Tessera getTessera (int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new TesseraException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	public void esportaCSV (String nomeFile) throws IOException, TesseraException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String personaCSV;
		Tessera persona;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			persona=getTessera(i);
			personaCSV=persona.getCodiceIdentificativo()+";"+persona.getNome()+";"+persona.getCognome()+";"
						+persona.getCodiceFiscale()+";"+persona.getDataNascita()+";"+persona.getInfo();
			file.toFile(personaCSV);
		}
		file.closeFile();
	}
	
	public void esportaCSVeliminati (String nomeFile, int posizione) throws IOException, TesseraException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String personaCSV;
		Tessera persona;
		
			persona=getTessera(posizione);
			personaCSV=persona.getCodiceIdentificativo()+";"+persona.getNome()+";"+persona.getCognome()+";"
						+persona.getCodiceFiscale()+";"+persona.getDataNascita()+";"+persona.getInfo();
			file.toFile(personaCSV);
		
		file.closeFile();
	}

	public Lista importaCSV (String nomeFile) throws IOException, TesseraException
	{
		Lista lista=new Lista();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiPersona;
		Tessera persona;
		
			try 
			{
				while(true)
				{
					rigaLetta=file.fromFile();
					elementiPersona=rigaLetta.split(";");
					persona=new Tessera(Integer.parseInt(elementiPersona[0]),elementiPersona[1],elementiPersona[2],elementiPersona[3],elementiPersona[4],elementiPersona[5]);
					lista.inserisci(persona);
				}
				
			} 
			catch (TesseraException e) 
			{
				if (e.toString().compareTo("End of file")==0)
					file.closeFile();
				else
					throw new TesseraException(e.toString());
			}
		
			return lista;	
	}
	
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Lista caricaLista (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Lista lista;
		
		lista=(Lista)(reader.readObject());
		file.close();
		return lista;
	}

}
