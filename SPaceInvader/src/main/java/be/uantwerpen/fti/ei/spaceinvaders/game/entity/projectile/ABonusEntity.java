package be.uantwerpen.fti.ei.spaceinvaders.game.entity.projectile;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IDimension;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.position.IPosition;
import be.uantwerpen.fti.ei.spaceinvaders.game.inputcontroller.IInput;

public abstract class ABonusEntity extends AProjectileEntity {

    /**
     * Default constructor waarbij de parameters de default waarden krijgen.
     * @param input Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public ABonusEntity(IInput input) {
        super(input);
    }

    /**
     * Overload constructor die een andere coördinaat kan meegeven.
     * @param position      De positie van de entiteit.
     * @param dimension     De dimensie van de entiteit.
     * @param speed         De snelheid waarmee de entiteit zich verplaatst.
     * @param input         Een IInput object waarmee de entiteit zichzelf mee kan bewegen.
     */
    public ABonusEntity(IPosition position, IDimension dimension, int speed, IInput input) {
        super(position, dimension, speed, input);
    }
}
