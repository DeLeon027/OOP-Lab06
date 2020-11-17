package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalArgumentException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Maximum threshold exceeded";
    }
    
    

}
