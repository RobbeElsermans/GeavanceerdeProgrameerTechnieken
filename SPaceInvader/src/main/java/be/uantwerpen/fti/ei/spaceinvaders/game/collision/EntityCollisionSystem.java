package be.uantwerpen.fti.ei.spaceinvaders.game.collision;

import be.uantwerpen.fti.ei.spaceinvaders.game.entitycomponents.MovementComponent;

/**
 * Een klasse om entity vs entity te detecteren.
 */
public class EntityCollisionSystem {
    public static boolean entityCollision(MovementComponent mc1, MovementComponent mc2){
        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links boven.
         */
        if(     (mc1.getX() <= mc2.getX() && mc1.getX()+mc1.getWidth() >= mc2.getX())&&
                (mc1.getY() <= mc2.getY() && mc1.getY()+mc1.getHeight() >= mc2.getY())){
            return true;
        }

        /**
         * Als entiteit 1, entiteit 2 aanraakt langs rechts onder.
         */
        if(     (mc2.getX() <= mc1.getX() && mc2.getX()+mc2.getWidth() >= mc1.getX())&&
                (mc2.getY() <= mc1.getY() && mc2.getY()+mc2.getHeight() >= mc1.getY())){
            return true;
        }

        /**
         * Als entiteit 1, entiteit 2 aanraakt langs links onder.
         */
        if(     (mc1.getX()+mc1.getWidth() >= mc2.getX() && mc1.getX()+mc1.getWidth() <= mc2.getX()+mc2.getWidth())&&
                (mc1.getY() <= mc2.getY()+mc2.getHeight() && mc1.getY() >= mc2.getY())){
            return true;
        }

        /**
         * Als entiteit 2, entiteit 1 aanraakt langs rechts onder.
         */
        return (mc2.getX() + mc2.getWidth() >= mc1.getX() && mc2.getX() + mc2.getWidth() <= mc1.getX() + mc1.getWidth()) &&
                (mc2.getY() <= mc1.getY() + mc1.getHeight() && mc2.getY() >= mc1.getY());
    }

    /**
     * Check of dat een entiteit op dezelfde lijn is of niet.
     * @param mc1
     * @param mc2
     * @return
     */
    public static boolean entityIsOnSameLine(MovementComponent mc1, MovementComponent mc2){
        return mc2.getY() + mc2.getHeight() >= mc1.getY();
    }
}

/*
﻿using Microsoft.Xna.Framework;

namespace Pigit.Collision
{
    static class NPCCollision
    {
        private const int oneBlockStep = 32;
        private const int marginLeft = oneBlockStep * 3;
        private const int marginRight = oneBlockStep * 1;
        private const int marginTop = oneBlockStep * 2;
        private const int marginBottom = oneBlockStep * 1;
        public static bool IsTouchingNPC(Rectangle player1, Rectangle player2)
        {
            if (player1.Intersects(player2))
            {
                return true;
            }

            return false;
        }
        public static bool IsAroundNPC(Vector2 player1, Vector2 player2)
        {
            if (player1.X > (player2.X) - marginLeft &&
                player1.X < (player2.X) + marginRight &&
                player1.Y < (player2.Y) + marginBottom &&
                player1.Y > (player2.Y) - marginTop)
            {
                return true;
            }
            return false;
        }
        public static bool IsLeftFromNPC(Vector2 player1, Vector2 player2)
        {
            if (player1.X + oneBlockStep < player2.X)
            {
                return true;
            }
            return false;
        }
        public static bool IsRightFromNPC(Vector2 player1, Vector2 player2)
        {
            if (player1.X + oneBlockStep > player2.X)
            {
                return true;
            }
            return false;
        }
        public static bool IsAboveNPC(Vector2 player1, Vector2 player2)
        {
            if (player1.Y + oneBlockStep < player2.Y)
            {
                return true;
            }
            return false;
        }

    }
}
 */