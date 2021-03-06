package me.A5H73Y.parkour.manager;

import java.util.ArrayList;
import java.util.List;

import me.A5H73Y.parkour.utilities.Utils;
import org.bukkit.entity.Player;

public class QuietModeManager {

    private static QuietModeManager instance;
    private final String quietOnMessage = Utils.getTranslation("Parkour.QuietOn");
    private final String quietOffMessage = Utils.getTranslation("Parkour.QuietOff");
    private List<String> quietPlayers = new ArrayList<>();

    private QuietModeManager() {
    }

    public static QuietModeManager getInstance() {
        if (instance == null) {
            instance = new QuietModeManager();
        }

        return instance;
    }

    public void enableQuietMode(Player player) {
        quietPlayers.add(player.getName());
        Utils.sendActionBar(player, getInstance().quietOnMessage, true);
    }

    public void disableQuietMode(Player player) {
        quietPlayers.remove(player.getName());
        Utils.sendActionBar(player, getInstance().quietOffMessage, true);
    }

    public boolean isInQuietMode(String playerName) {
        return quietPlayers.contains(playerName);
    }

    /**
     * Toggle quiet mode
     * Will add / remove the player from the list of quiet players.
     * If enabled, will limit the amount of Parkour messages displayed to the player.
     *
     * @param player
     */
    public void toggleQuietMode(Player player) {
        if (isInQuietMode(player.getName())) {
            enableQuietMode(player);
        } else {
            disableQuietMode(player);
        }
    }
}
