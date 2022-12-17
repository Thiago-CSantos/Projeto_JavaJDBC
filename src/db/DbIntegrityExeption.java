package db;

public class DbIntegrityExeption extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3770127267101648755L;
	
	public DbIntegrityExeption(String msg) {
		super(msg);
	}

}
