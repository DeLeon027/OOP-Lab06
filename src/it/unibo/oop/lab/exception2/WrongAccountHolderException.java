package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Override
    public String toString() {
        return "This account is unauthorized";
    }

}
