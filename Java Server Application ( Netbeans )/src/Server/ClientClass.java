/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author Michel Mina
 */
public class ClientClass {
    
    private int AccountNumber;
    private String Password;
    private double Balance;
    private String BankName;
    
    /*Default Constructor*/
    ClientClass(){
        this.AccountNumber= -1;
        this.Password = null;
        this.Balance = -1;
        this.BankName = null;
    }
    
    int GetAccountNumner(){
        return this.AccountNumber;
    }
    
    String GetPassword(){
        return this.Password;
    }
    
    double GetBalance(){
        return this.Balance;
    }
    
    String GetBankName(){
        return this.BankName;
    }
    
    
}
