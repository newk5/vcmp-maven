package com.github.newk5.vcmp.maven.controllers;


import com.google.common.io.LittleEndianDataInputStream;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import java.io.ByteArrayInputStream;
import java.io.DataInput;

public class ClientDataController {

  

    public void onClientScriptData(Player player, byte[] data) {

        try {
            DataInput stream = new LittleEndianDataInputStream(new ByteArrayInputStream(data));
        
            System.out.println("RECEIVED CLIENT STREAM, SIZE:" + data.length);
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
