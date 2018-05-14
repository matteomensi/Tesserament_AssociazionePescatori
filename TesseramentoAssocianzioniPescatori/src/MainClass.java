import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClass 
{
	static ConsoleInput tastiera=new ConsoleInput();
	public static void main(String[] args) throws TesseraException, NumberFormatException, IOException 
	{
		String[] elencoFunzioni=new String[8];
		elencoFunzioni[0]="0-->Esci";
		elencoFunzioni[1]="1-->Registra nuova tessera";
		elencoFunzioni[2]="2-->Visualizza in ordine alfabetico in base al nome";
		elencoFunzioni[3]="3-->Visualizza ordine anzianita";
		elencoFunzioni[4]="4-->Cerca tesserato";
		elencoFunzioni[5]="5-->Elimina tessera";
		elencoFunzioni[6]="6-->Modifica quota";
	
		
		Lista lista=new Lista();
		
		try 
		{
			lista=lista.caricaLista("tessera.bin");
			System.out.println("file caricati");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Impossibile caricare oggetti di tipo Tessera");
		}
		catch (IOException e1) 
		{
			System.out.println("Impossibile leggere da file");
		}
		
		Menu menu=new Menu(elencoFunzioni);
		int scelta=0;
		
		
		
		do 
		{
			scelta=menu.scelta();
			switch (scelta) 
			{
			case 0:
			{
				break;
			}
			
			case 1:
			{	
				Tessera t=new Tessera();
				try 
				{
					
					int anno,m,g;
					LocalDate dataNascita;
					System.out.println("Inserisci codice tessera ");
					t.setCodiceIdentificativo(tastiera.readInt());
					System.out.println("Inserisci nome proprietario tessera ");
					t.setNome(tastiera.readString());
					System.out.println("Inserisci cognome proprietario tessera ");
					t.setCognome(tastiera.readString());
					System.out.println("Inserisci codice fiscale proprietario tessera ");
					t.setCodiceFiscale(tastiera.readString());
					System.out.println("E' un rinnovo o nuova tessera? ");
					t.setInfo(tastiera.readString());
					System.out.println("Inserisci data nascita propritario tessera: ");
					System.out.print("inserisci anno:");
					anno=(tastiera.readInt());
					System.out.print("inserisci mese:");
					m=(tastiera.readInt());
					System.out.print("inserisci giorno:");
					g=(tastiera.readInt());
					
					dataNascita=LocalDate.of(anno,m,g);
					t.setDataNascita(dataNascita);
					lista.inserisci(t);
					
					/*for (int i = 1 ; i < lista.getElementi(); i++) 
					{
						if (lista.getTessera(i).getNome().compareTo(t.getNome())==0 && lista.getTessera(i).getCognome().compareTo(t.getCognome())==0) 
						{
							lista.eliminaInPosizione(1);
							System.out.println("è già stata eliminata una tessera con questo nome");
						}
					}*/
					
					System.out.println("tessera aggiunta");
					lista.salvaLista("tessera.bin");
					System.out.println("salvataggio modifica avvenuta con successo");
				} 
				catch (NumberFormatException e) 
				{
					System.out.println("Formato dati errato. Operazione annullata.");	
				}
				catch (IOException e) 
				{
					System.out.println("Errore sorgente informativa. Operazione annullata.");
				}
				
			}
			break;
			case 2:
			{
				try 
				{
					Tessera[] ArrayLista=lista.convertiLista();
					ArrayLista=Lista.OrdinaAnzianita(ArrayLista);
					Lista listaAnzianita=new Lista();
					listaAnzianita.convertiTessera(ArrayLista);
					System.out.println(listaAnzianita.toString());
					
				}
				catch (TesseraException e)
				{
					System.out.println("Registro vuoto");
				}	
			}
			break;
			case 3:
			{
				try 
				{
					Tessera[] ArrayLista=lista.convertiLista();
					ArrayLista=Lista.OrdinaAnzianita(ArrayLista);
					Lista listaAlfabetico=new Lista();
					listaAlfabetico.convertiTessera(ArrayLista);
					System.out.println(listaAlfabetico.toString());
					
				}
				catch (TesseraException e)
				{
					System.out.println("Registro vuoto");
				}
			}
			break;
			case 4:
			{
				String x,y;
				System.out.println("Inserisci il nome");
				ConsoleInput a=new ConsoleInput();
				x=a.readString();
				System.out.println("Inserisci il cognome");
				ConsoleInput b=new ConsoleInput();
				y=b.readString();
				
				lista.visualizzaNome(x, y);
			}
			break;
			case 5:
			{
				int x;
				System.out.println("Inserisci il codice della tesera che vuoi eliminare");
				ConsoleInput a=new ConsoleInput();
				
				x=a.readInt();
				
				for (int i = 1; i < lista.getElementi(); i++) 
				{
					if(x==lista.getTessera(i).getCodiceIdentificativo())
					{
						lista.eliminaInPosizione(i);
						lista.salvaLista("Tessera.bin");
						System.out.println("Salvataggio modifica avvenuta con successo");
					}
				}
				
			}
			break;
			case 6:
			{
				int x;
				System.out.println("Inserisci il valore della quota");
				ConsoleInput a=new ConsoleInput();
				x=a.readInt();
				lista.getTessera(1).setQuota(x);
			}
			break;
			
			
			
			default:
				System.out.println("Scelta non consentita");
				break;
			}
			
			System.out.println("Premi un tasto per continuare...");
			try
		 	{
				tastiera.readString();
			}
			 catch (NumberFormatException e)
			 {
				System.out.println(" ");
			}
			 catch (IOException e) 
			{
				
				 System.out.println(" ");
			}
			
		} while (scelta!=0);
		
	
		
	}
}
