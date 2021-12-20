package com.github.newk5.vcmp.maven.commands;

import static com.github.newk5.vcmp.maven.controllers.MainController.server;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.tools.commands.AllMatch;
import com.maxorator.vcmp.java.tools.commands.Command;
import com.maxorator.vcmp.java.tools.commands.CommandController;

public class AdminCommands implements CommandController {

    public AdminCommands() {
    }

    @Override
    public boolean checkAccess(Player player) {
        //check if the player is admin here, return true if yes and false if not
        //if you return false the command will not be executed
        return true;
    }

    @Command(usage = "<playerName>")
    public void kick(Player player, @AllMatch Player target) {
        if (target != null) {
            server.sendClientMessageToAll(target.getName() + " was kicked");
            target.kick();

        }

    }

   

}
