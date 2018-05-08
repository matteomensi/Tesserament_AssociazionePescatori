import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args) throws TesseraException, NumberFormatException, IOException 
	{
		Lista l1=new Lista();
		
		Tessera t1=new Tessera(1,"Matteo","Mensi","MNSMTT110500","11/05/00","si");
		Tessera t2=new Tessera(2,"Marco","Manenti","MNTMRC100605","10/06/05","no");
		Tessera t3=new Tessera(3,"Aurelia","Lullu","ARLLLL131167","13/11/67","si");
		
		l1.inserisci(t1);
		l1.inserisci(t2);
		l1.inserisci(t3);
		
		System.out.println(l1.visita(1));
		System.out.println(l1.visita(2));
		System.out.println(l1.visita(3));
		
		int x;
		System.out.println("Inserisci il codice della tesera che vuoi eliminare");
		ConsoleInput a=new ConsoleInput();
		
		x=a.readInt();
		
		for (int i = 0; i < l1.getElementi(); i++) 
		{
			if(x==l1.getTessera(i).getCodiceIdentificativo())
				l1.eliminaInPosizione(i);
		}
		
	}
}
