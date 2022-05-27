package base.events;

import base.Game;
import base.gameobjects.Animal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NPCEvent extends Event {

    private static final Logger logger = LoggerFactory.getLogger(NPCEvent.class);

    public NPCEvent() {
        repeatable = true;
    }

    @Override
    void calculateChance(Game game) {
        chance = -1;

        if ((!repeatable && happened) || !game.getNpcs().isEmpty()) {
            chance = 0;
            return;
        }
        if (happened) {
            chance--;
        }
        for (List<Animal> animalList : game.getAnimalsOnMaps().values()) {
            chance += animalList.size();
        }
        if (game.isBackpackEmpty()) {
            chance++;
        } else {
            chance--;
        }
        logger.info(String.format("Event 'NPC comes to adopt' chance is %d", chance));
    }

    @Override
    void startEvent(Game game) {
        game.spawnNpc();
    }
}
