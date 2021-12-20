package com.github.newk5.vcmp.maven.controllers;

import com.github.newk5.vcmp.maven.commands.AdminCommands;
import com.github.newk5.vcmp.maven.commands.OpenCommands;
import com.maxorator.vcmp.java.plugin.integration.RootEventHandler;
import com.maxorator.vcmp.java.plugin.integration.placeable.CheckPoint;
import com.maxorator.vcmp.java.plugin.integration.placeable.GameObject;
import com.maxorator.vcmp.java.plugin.integration.placeable.Pickup;
import com.maxorator.vcmp.java.plugin.integration.player.Player;
import com.maxorator.vcmp.java.plugin.integration.server.Server;
import com.maxorator.vcmp.java.plugin.integration.vehicle.Vehicle;
import com.maxorator.vcmp.java.tools.commands.CommandRegistry;
import com.maxorator.vcmp.java.tools.timers.TimerRegistry;

public class MainController extends RootEventHandler {

    public ClientDataController client;
    public static TimerRegistry timerRegistry;
    private final CommandRegistry commandRegistry;
    public static Server server;

    public MainController(Server s) {
        super(s);

        this.commandRegistry = new CommandRegistry(s);
        this.timerRegistry = new TimerRegistry();
        this.client = new ClientDataController();

        server = s;
    }

    @Override
    public boolean onServerInitialise() {
        commandRegistry.addController(new OpenCommands());
        commandRegistry.addController(new AdminCommands());
        System.out.println("SERVER STARTED");

        return true;
    }

    @Override
    public void onPlayerActionChange(Player player, int oldAction, int newAction) {

    }

    @Override
    public boolean onPlayerCommand(Player player, String message) {

        return commandRegistry.processCommand(player, message);

    }

    @Override
    public void onPlayerSpawn(Player player) {

    }

    @Override
    public boolean onPlayerRequestClass(Player player, int classIndex) {

        return true;
    }

    @Override
    public void onPlayerConnect(Player player) {
        server.sendClientMessage(null, 0xFFb3f99d, player.getName() + " has joined the server");

    }

    @Override
    public void onClientScriptData(Player player, byte[] data) {
        client.onClientScriptData(player, data);
    }

    @Override
    public void onServerFrame() {
        timerRegistry.process();

    }

    @Override
    public void onPlayerModuleList(Player player, String list) {
    }

    @Override
    public void onPlayerCrashReport(Player player, String crashLog) {

    }

    @Override
    public void onCheckPointExited(CheckPoint checkPoint, Player player) {

    }

    @Override
    public void onCheckPointEntered(CheckPoint checkPoint, Player player) {

    }

    @Override
    public void onPickupRespawn(Pickup pickup) {

    }

    @Override
    public void onPickupPicked(Pickup pickup, Player player) {

    }

    @Override
    public boolean onPickupPickAttempt(Pickup pickup, Player player) {
        return true;
    }

    @Override
    public void onObjectTouched(GameObject object, Player player) {

    }

    @Override
    public void onObjectShot(GameObject object, Player player, int weaponId) {
    }

    @Override
    public void onVehicleRespawn(Vehicle vehicle) {
    }

    @Override
    public void onVehicleExplode(Vehicle vehicle) {
    }

    @Override
    public void onVehicleUpdate(Vehicle vehicle, int updateType) {
    }

    @Override
    public void onPlayerSpectate(Player player, Player spectated) {
    }

    @Override
    public void onPlayerKeyBindUp(Player player, int keyBindIndex) {
    }

    @Override
    public void onPlayerKeyBindDown(Player player, int keyBindIndex) {
    }

    @Override
    public boolean onPlayerPrivateMessage(Player player, Player recipient, String message) {
        return true;
    }

    @Override
    public boolean onPlayerMessage(Player player, String message) {
        return true;
    }

    @Override
    public void onPlayerAwayChange(Player player, boolean isAway) {

    }

    @Override
    public void onPlayerEndTyping(Player player) {

    }

    @Override
    public void onPlayerBeginTyping(Player player) {

    }

    @Override
    public void onPlayerGameKeysChange(Player player, int oldKeys, int newKeys) {

    }

    @Override
    public void onPlayerCrouchChange(Player player, boolean isCrouching) {

    }

    @Override
    public void onPlayerOnFireChange(Player player, boolean isOnFire) {

    }

    @Override
    public void onPlayerStateChange(Player player, int oldState, int newState) {

    }

    @Override
    public void onPlayerNameChange(Player player, String oldName, String newName) {

    }

    @Override
    public void onPlayerExitVehicle(Player player, Vehicle vehicle) {

    }

    @Override
    public void onPlayerEnterVehicle(Player player, Vehicle vehicle, int slot) {

    }

    @Override
    public boolean onPlayerRequestEnterVehicle(Player player, Vehicle vehicle, int slot) {
        return true;
    }

    @Override
    public void onPlayerUpdate(Player player, int updateType) {

    }

    @Override
    public void onPlayerDeath(Player player, Player killer, int reason, int bodyPart) {

    }

    @Override
    public boolean onPlayerRequestSpawn(Player player) {
        return true;
    }

    @Override
    public void onPlayerDisconnect(Player player, int reason) {

    }

    @Override
    public String onIncomingConnection(String name, String password, String ip) {
        return name;
    }

    @Override
    public void onServerPerformanceReport(int entry, String[] descriptions, long[] times) {
    }

    @Override
    public void onServerLoadScripts() {

    }

}
