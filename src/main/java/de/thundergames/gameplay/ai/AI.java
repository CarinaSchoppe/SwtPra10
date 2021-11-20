/*
 * Copyright Notice for Swtpra10
 * Copyright (c) at ThunderGames | SwtPra10 2021
 * File created on 18.11.21, 10:40 by Carina Latest changes made by Carina on 18.11.21, 10:40
 * All contents of "AI" are protected by copyright. The copyright law, unless expressly indicated otherwise, is
 * at ThunderGames | SwtPra10. All rights reserved
 * Any type of duplication, distribution, rental, sale, award,
 * Public accessibility or other use
 * requires the express written consent of ThunderGames | SwtPra10.
 */
package de.thundergames.gameplay.ai;

import de.thundergames.gameplay.ai.networking.AIClientThread;
import de.thundergames.gameplay.ai.networking.AIPacketHandler;
import de.thundergames.gameplay.player.networking.Client;
import de.thundergames.playmechanics.map.Map;
import de.thundergames.playmechanics.util.interfaceItems.GameState;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class AI extends Client {

  private final ArrayList<Integer> playerMolesInHoles = new ArrayList<>();
  private final ArrayList<Integer> playerMolesOnField = new ArrayList<>();
  private final HashMap<Integer, List<Integer>> molePositions = new HashMap<>();
  private final int gameID;
  private final AILogic logic;
  private final AIUtil aiUtil;
  private boolean isDraw = false;
  private int card;
  private boolean placedMoles;
  private int placedMolesAmount = 0;
  private Map map;
  private int clientID;
  private GameState gameState;

  /**
   * @param ip
   * @param port
   * @param gameID
   * @author Carina
   * @use creates the AI instance needed to run the AI
   */
  public AI(@NotNull final String ip, final int port, final int gameID) {
    super(port, ip, "AI");
    this.gameID = gameID;
    clientPacketHandler = new AIPacketHandler();
    logic = new AILogic();
    aiUtil = new AIUtil();
  }

  /**
   * @author Carina
   * @use connects the AI to the server
   */
  @Override
  public void connect() {
    try {
      socket = new Socket(ip, port);
      clientThread = new AIClientThread(socket, 0, this);
      clientThread.start();
      //TODO: hier   clientPacketHandler.loginPacket(clientThread, getName());
    } catch (IOException exception) {
      System.out.println("Is the server running?!");
    }
  }

  public Map getMap() {
    return map;
  }

  public void setMap(Map map) {
    this.map = map;
  }

  public ArrayList<Integer> getPlayerMolesInHoles() {
    return playerMolesInHoles;
  }

  public AIPacketHandler getAIPacketHandler() {
    return (AIPacketHandler) clientPacketHandler;
  }

  public HashMap<Integer, List<Integer>> getMolePositions() {
    return molePositions;
  }

  public AIUtil getAiUtil() {
    return aiUtil;
  }

  public int getCard() {
    return card;
  }

  public void setCard(int card) {
    this.card = card;
  }

  public boolean isPlacedMoles() {
    return placedMoles;
  }

  public void setPlacedMoles(boolean placedMoles) {
    this.placedMoles = placedMoles;
  }

  public int getGameID() {
    return gameID;
  }

  public AILogic getLogic() {
    return logic;
  }

  public boolean isDraw() {
    return isDraw;
  }

  public void setDraw(boolean draw) {
    isDraw = draw;
  }

  public int getPlacedMolesAmount() {
    return placedMolesAmount;
  }

  public void setPlacedMolesAmount(int placedMolesAmount) {
    this.placedMolesAmount = placedMolesAmount;
  }

  public void setClientID(int clientID) {
    this.clientID = clientID;
  }

  public ArrayList<Integer> getPlayerMolesOnField() {
    return playerMolesOnField;
  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }
}
