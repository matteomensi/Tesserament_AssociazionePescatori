import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe rappresenta una lista di tessere. Ogni lista è composta da tessere.
 *  Gli attributi sono: "elemnti" che indica il numero di elementi della lista e "head" di tipo Nodo che indica 
 *  al primo elemento della lista.
 * @author Matteo Mensi
 *
 */
public class Lista implements Serializable
{
	private Nodo head;
	private int elementi;
	
	/**
	 * Costruttore
	 */
	public Lista()
	{
		head=null;
		elementi=0;
	}
	
	/**
	 * Metodo getter che restituisce gli elementi di una lista
	 */
	public int getElementi()
	{
		return elementi;
	}
	
	/**
	 * Consente di creare un Nodo.
	 * @param persona La persona tesserata
	 * @param link Il link che collega
	 * @return nodo Il nodo
	 */
	private Nodo creaNodo(Tessera persona, Nodo link)
	{
		Nodo nodo= new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	
	/**
	 * Metodo getter che restituisce il nodo "p"
	 * @return p Il nodo p
	 */
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
	
	/**
	 * Consente di inserire una tessera in cima alla lista.
	 * @param persona La persona tesserata
	 */
	public void inserisci(Tessera persona) throws TesseraException
	{
		Nodo p=creaNodo(persona, head);
		head=p;
		elementi++;
		System.out.println("La quota annule è di "+this.getTessera(1).getQuota()+"€");
		
		/*try 
		{
			importaCSV("eliminati.txt");
			
		} 
		catch (IOException e1) 
		{
			System.out.println("File non trovato");
		} 
		catch (TesseraException e1) 
		{
			e1.toString();
		}*/
		
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
	
	/**
	 * Restituisce l'oggetto istanziato come stringa
	 */
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
	
	/**
	 * Consente di eliminare una tessera in testa alla lista.
	 * @param posizione La posizione della tessera nella lista
	 * @param link Il link che collega
	 */
	public void eliminaInTesta(int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		head=head.getLink();
		elementi--;
		
		try 
		{
			esportaCSVeliminati("eliminati.txt",posizione);
		} 
		catch (IOException e) 
		{
			System.out.println("File non trovato");
		}
	}
	
	/**
	 * Consente di eliminare una tessera in coda alla lista.
	 * @param posizione La posizione della tessera nella lista
	 */
	public void eliminaInCoda(int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta(posizione);
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
		
		try 
		{
			esportaCSVeliminati("eliminati.txt",posizione);
		} 
		catch (IOException e) 
		{
			System.out.println("File non trovato");
		}
	}
	
	/**
	 * Consente di eliminare una tessera in una posizione della lista.
	 * @param posizione La posizione della tessera nella lista
	 */
	public void eliminaInPosizione(int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new TesseraException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta(posizione);
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda(posizione);
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
		try 
		{
			esportaCSVeliminati("eliminati.txt",posizione);
		} 
		catch (IOException e) 
		{
			System.out.println("File non trovato");
		}
	}
	
	/**
	 * Metodo getter che restituisce la tessera da una lista
	 * @param posizione La posizione della tessera nella lista
	 * @return le informazioni del nodo p
	 */
	public Tessera getTessera (int posizione) throws TesseraException
	{
		if (elementi==0)
			throw new TesseraException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new TesseraException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	/**
	 * Consente di covertire la lista in un array.
	 * @return arraylista La lista convertita in un array
	 */
	public Tessera[] convertiLista() throws TesseraException
	{
		Nodo n;
		Tessera[] arrayLista=new Tessera[elementi];
		for (int i = 0; i < elementi; i++) 
		{
			n=getLinkPosizione(i+1);
			arrayLista[i]=n.getInfo();
		}
		return arrayLista;
	
	}
	
	/**
	 * Consente di covertire la tessera di una lista.
	 * @param tessera Array tessera
	 */
	public void convertiTessera(Tessera[] tessera) throws TesseraException
	{
		for (int i = tessera.length; i >0; i--) 
		{
			inserisci(tessera[i-1]);
		}
	}
	
	/**
	 * Consente di scambiare di posizione due array tesseara.
	 * @param array Array tessera
	 * @param pos1 posizione dell'arrey 1
	 * @param pos2 posizione dell'arrey 2
	 * @return o 0 o -1, -1 quando le posizioni non sono presenti nell'array e 0 quando avviene lo sca,bio
	 */
	public static int scambia(Tessera[]array,int pos1,int pos2)
	{
		Tessera s;
		if(pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}
	}

	/**
	 * Consente di copiare l'array tessera in un array copia.
	 * @param array Array tessera
	 * @return arrayCopia L'arrey copia
	 */
	private static Tessera[] copiaArray(Tessera[]array)
	{
		Tessera[]arrayCopia=new Tessera[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	
	/**
	 * Consente di ordinare per anzianità la lista.
	 * @param array Array tessera
	 * @return arrayCopia L'arrey di copia
	 */
	public static Tessera[] OrdinaAnzianita(Tessera[] array)
	{
		Tessera[] arrayCopia=copiaArray(array);
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				 if(arrayCopia[i].getDataNascita().isAfter(arrayCopia[j].getDataNascita()))
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	}
	
	/**
	 * Consente di visualizzare una tessera inserendo il nome eil cognome.
	 * @param nome Il nome del tesserato
	 * @param cognome Il cognome del tesserato
	 */
	public void visualizzaNome(String nome, String cognome)
	{
		Nodo p=head;
		int contatore=0;
		
		while(p!=null)
		{
			if(p.getInfo().getNome().compareTo(nome)==0)
			{
				if(p.getInfo().getCognome().compareTo(cognome)==0)
				{
					System.out.println(p.getInfo().toString());
					contatore++;
				}
			}
			p=p.getLink();
		}
		
	}
	
	/**
	 * Consente di riurdinare una lista in ordine alfabetico.
	 * @param tessera Array tessera
	 * @return le informazioni del nodo p
	 */
	public static Tessera[] OrdinaAlfabetico(Tessera[] array)
	{
		Tessera[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i].getNome().compareToIgnoreCase(arrayCopia[j].getNome())>0)
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	
	/**
	 * Consente di esportare la tessera della lista in formato CSV.
	 * @param nomeFile Nome del file
	 */
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
	
	/**
	 * Consente di esportare la tessera della lista in formato CSV.
	 * @param nomeFile Nome del file
	 * @param posizione La posizione della tessera nella lista
	 */
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

	/**
	 * Consente di importare la tessera di una lista in formato CSV.
	 * @param nomeFile Nome del file
	 */
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
					persona=new Tessera(Integer.parseInt(elementiPersona[0]),elementiPersona[1],elementiPersona[2],elementiPersona[3],LocalDate.parse(elementiPersona[4]),elementiPersona[5]);
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
	
	/**
	 * Consente di salvare la lista serializzando.
	 * @param nomeFile Nome del file
	 */
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	/**
	 * Consente di caricare la lista deserializzando.
	 * @param nomeFile Nome del file
	 */
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
