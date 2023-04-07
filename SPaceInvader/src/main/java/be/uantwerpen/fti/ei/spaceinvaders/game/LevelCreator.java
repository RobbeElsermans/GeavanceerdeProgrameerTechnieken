package be.uantwerpen.fti.ei.spaceinvaders.game;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABigEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ABonusEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AEnemyEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AObstacleEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.position.Position;
import be.uantwerpen.fti.ei.spaceinvaders.game.factory.AFactory;

import java.util.ArrayList;
import java.util.List;

public class LevelCreator {
    public LevelCreator(){

    }

    /**
     * Initialiseer een level a.d.h.v. de inGameState.
     *
     * @param level
     */
    public static void levelInitialize(InGameStates level,
                                       AFactory gfxFactory,
                                       IDimension gameDimension,
                                       List<AEnemyEntity> enemyEntityList,
                                       List<ABigEnemyEntity> bigEnemyEntityList,
                                       List<AObstacleEntity> obstacleEntityList,
                                       List<ABonusEntity> bonusEntityList) {
        //Clear all entities
        clearEntityLists(enemyEntityList, bigEnemyEntityList, obstacleEntityList,bonusEntityList);

        switch (level) {

            case LEVEL_1 -> {
                //Create enemy
                for (int i = (int) (gameDimension.getWidth()*1/3); i < gameDimension.getWidth() - (int) (gameDimension.getWidth()*1/3); i++) {
                    if (i % 2 == 0) {
                        enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(i, 3), 3, 1, 1));
                        enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(i, 4), 2, 1, 1));
                        enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(i, 5), 1, 1, 1));
                    }
                }
                //bonusEntityList.add(gfxFactory.getBonusEntity(new Position(2,1),1,3,0.5, CollectableComponent.collectableType.life,1));

                //Create Obstacles
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(1, gameDimension.getHeight() - 3), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position((gameDimension.getWidth()-1)/2.0, gameDimension.getHeight() - 4), 5));
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(gameDimension.getWidth()-4, gameDimension.getHeight() - 3), 5));
            }
            case LEVEL_2 -> {

                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(2, 3), 3, 2, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(4, 4), 3, 2, 0.5));

                //Create Obstacles
                obstacleEntityList.add(gfxFactory.getObstacleEntity(new Position(15, gameDimension.getHeight() - 2), 3));
            }
            case BOSS_LEVEL -> {
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(2, 2), 1, 2, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(2, 3), 3, 3, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(4, 4), 3, 4, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(4, 4), 3, 5, 0.5));
                enemyEntityList.add(gfxFactory.getEnemyEntity(new Position(4, 4), 3, 6, 0.5));
            }
        }
    }

    public static void clearEntityLists(List<AEnemyEntity> enemyEntityList,
                                        List<ABigEnemyEntity> bigEnemyEntityList,
                                        List<AObstacleEntity> obstacleEntityList,
                                        List<ABonusEntity> bonusEntityList) {
        //playerEntitieList = new ArrayList<>();
        enemyEntityList = new ArrayList<>();
        bigEnemyEntityList = new ArrayList<>();
        obstacleEntityList = new ArrayList<>();
        bonusEntityList = new ArrayList<>();
    }
}
