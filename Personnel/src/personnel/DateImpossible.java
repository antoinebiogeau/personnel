package personnel;

public class DateImpossible extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DateImpossible()
	{
		super("La date d'arriv�e doit �tre inf�rieur � la date de d�part");
		System.err.println("La date d'arriv�e doit �tre inf�rieur � la date de d�part");
	}
}
