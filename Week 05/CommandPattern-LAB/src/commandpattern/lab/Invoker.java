/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern.lab;

import commandpattern.lab.commands.Command;

/**
 *
 * @author Anish Panthi
 */
public class Invoker {

    private Command previousCommand;

    public void execute(Command command) {
        previousCommand = command;
        command.execute();
    }

    public void undo() {
        previousCommand.undo();
    }

    public void redo() {
        previousCommand.redo();
    }
}
