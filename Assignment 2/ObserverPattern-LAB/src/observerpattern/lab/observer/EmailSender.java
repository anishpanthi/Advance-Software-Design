/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern.lab.observer;

import observerpattern.lab.dao.IAccountDAO;

/**
 *
 * @author Anish Panthi
 */
public class EmailSender implements IObserver{

    public EmailSender(IAccountDAO accountDAO) {
        accountDAO.register(this);
    }

    @Override
    public void provideService() {
        System.out.println("Email has been sent...");
    }
    
}
