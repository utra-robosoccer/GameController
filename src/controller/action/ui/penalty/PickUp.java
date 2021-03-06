package controller.action.ui.penalty;

import common.Log;

import data.states.AdvancedData;
import data.PlayerInfo;
import data.values.Penalties;

/**
 * @author Michel Bartsch
 * 
 * This action means that the request for pickup penalty has been selected.
 */
public class PickUp extends Penalty
{
    /**
     * Performs this action`s penalty on a selected player.
     * 
     * @param data      The current data to work on.
     * @param player    The player to penalise.
     * @param side      The side the player is playing on (0:left, 1:right).
     * @param number    The player`s number, beginning with 0!
     */
    @Override
    public void performOn(AdvancedData data, PlayerInfo player, int side, int number)
    {
        if (player.penalty == Penalties.NONE) {
            data.whenPenalized[side][number] = data.getTime();
            data.robotPenaltyCount[side][number] = 0;
        }
        
        player.penalty = Penalties.SPL_REQUEST_FOR_PICKUP;
        Log.state(data, "Request for PickUp " + data.team[side].teamColor + " " + (number+1));
    }
    
    /**
     * Checks if this action is legal with the given data (model).
     * Illegal actions are not performed by the EventHandler.
     * 
     * @param data      The current data to check with.
     */
    @Override
    public boolean isLegal(AdvancedData data)
    {
        return true;
    }
}