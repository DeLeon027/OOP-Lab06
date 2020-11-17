package it.unibo.oop.lab.exception2;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
        AccountHolder accountHolder1 = new AccountHolder("Luca", "Morlo", 12);
        AccountHolder accountHolder2 = new AccountHolder("Gianni", "Mortadeo", 3);
        StrictBankAccount account1 = new StrictBankAccount(accountHolder1.getUserID(), 10000, 10);
        StrictBankAccount account2 = new StrictBankAccount(accountHolder2.getUserID(), 10000, 10);
        /* 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
        try {
             account1.deposit(accountHolder1.getUserID(), 1200);
             account1.deposit(accountHolder1.getUserID(), 1400);
             account1.withdrawFromATM(accountHolder1.getUserID(), 14000);
             account1.withdrawFromATM(accountHolder2.getUserID(), 10000);
             
        }
        catch(WrongAccountHolderException e) {
            System.out.println(e.toString());
        }
        catch(NotEnoughFoundsException e) {
            System.out.println(e.toString());
        }
       
        
    }
}
