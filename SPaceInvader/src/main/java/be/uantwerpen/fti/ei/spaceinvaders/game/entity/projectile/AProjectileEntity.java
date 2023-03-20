package be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.AMoveableEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

/**
 * EEn projectiel entiteit dat beweegbaar is in de ruimte.
 */
public abstract class AProjectileEntity extends AMoveableEntity {


    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
        public AProjectileEntity(IInput input) {
        super(input);
    }

    /**
     * Overload constructor die een andere coördinaat kan meegeven.
     * @param position      De positie van de entiteit.
     * @param dimension     De dimensie van de entiteit.
     * @param speed         De snelheid waarmee de entiteit zich verplaatst.
     * @param input         Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public AProjectileEntity(IPosition position, IDimension dimension, int speed, IInput input) {
        super(position, dimension, speed, input);
    }
}
