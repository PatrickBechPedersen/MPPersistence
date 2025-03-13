package db;


//Klasse til database exception bliver brugt hver gang der laves adgang til databasen
public class DataAccessException extends Exception {
	public DataAccessException(Exception e, String expl) {
		super(expl, e);
	}
}
