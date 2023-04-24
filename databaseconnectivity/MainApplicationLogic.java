package databaseconnectivity;

public class MainApplicationLogic {
    public static void main(String[] args){
        CreateDatabaseClass dbConnectionObject = new CreateDatabaseClass();
        dbConnectionObject.dbConnectivityMethod();
    }
}
