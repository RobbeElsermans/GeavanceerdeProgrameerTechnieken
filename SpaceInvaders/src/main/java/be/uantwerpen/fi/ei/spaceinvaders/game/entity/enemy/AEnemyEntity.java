package be.uantwerpen.fi.ei.spaceinvaders.game.entity.enemy;

import be.uantwerpen.fi.ei.spaceinvaders.game.entity.abstracts.ALivableEntity;

public abstract class AEnemyEntity extends ALivableEntity {
    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     */
    public AEnemyEntity(){
        super();
    }

    /**
     * Overload constructor die de entiteit andere parameter waardes kan geven.
     * @param x de x-coördinaat als integer
     * @param y de y-coördinaat als integer
     * @param life de levenswaarde als integer
     * @param speed de snelheid als integer
     */
    public AEnemyEntity(int x, int y, int life, int speed){
        super(x, y, speed, life);
    }
}
