/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypattern.lab.dao;

import java.util.Collection;
import strategypattern.lab.domain.Account;

/**
 *
 * @author Anish Panthi
 */
public interface IAccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(long accountNumber);

    Collection<Account> getAccounts();

}
