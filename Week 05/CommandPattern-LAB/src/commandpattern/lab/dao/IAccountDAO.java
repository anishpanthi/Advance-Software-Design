/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab.dao;

import commandpattern.lab.domain.Account;
import java.util.Collection;

/**
 *
 * @author Anish Panthi
 */
public interface IAccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(long accountnumber);

    Collection<Account> getAccounts();
}
