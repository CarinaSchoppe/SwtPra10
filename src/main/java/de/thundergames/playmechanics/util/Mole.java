/*
 * Copyright Notice for Swtpra10
 * Copyright (c) at ThunderGames | SwtPra10 2021
 * File created on 18.11.21, 10:33 by Carina Latest changes made by Carina on 18.11.21, 09:41
 * All contents of "Mole" are protected by copyright. The copyright law, unless expressly indicated otherwise, is
 * at ThunderGames | SwtPra10. All rights reserved
 * Any type of duplication, distribution, rental, sale, award,
 * Public accessibility or other use
 * requires the express written consent of ThunderGames | SwtPra10.
 */
package de.thundergames.playmechanics.util;

import de.thundergames.networking.util.interfaceItems.NetworkField;
import de.thundergames.networking.util.interfaceItems.NetworkMole;
import de.thundergames.playmechanics.map.Field;
import org.jetbrains.annotations.NotNull;

public class Mole extends NetworkMole {

  private final int MoleID;
  private final Player player;
  private final boolean inHole = false;
  private Field field;

  public Mole(final int moleID, @NotNull final Player player) {
    super(player, null);
    this.player = player;
    MoleID = moleID;
  }



  public int getMoleID() {
    return MoleID;
  }

  public Field getMoleField() {
    return field;
  }

  public void setMoleField(Field field) {
    setNetworkField(new NetworkField(field.getX(), field.getY()));
    this.field = field;
  }

  public Player getPlayer() {
    return player;
  }
}
