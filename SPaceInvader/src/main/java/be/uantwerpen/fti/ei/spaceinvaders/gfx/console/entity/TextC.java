package be.uantwerpen.fti.ei.spaceinvaders.gfx.console.entity;

import be.uantwerpen.fti.ei.spaceinvaders.game.entity.abstracts.ATextEntity;
import be.uantwerpen.fti.ei.spaceinvaders.game.entity.entitycomponents.PositionComponent;
import be.uantwerpen.fti.ei.spaceinvaders.gfx.console.GraphicsContext;

public class TextC extends ATextEntity {
    private final GraphicsContext gfx;

    public TextC(GraphicsContext gfx) {
        this.gfx = gfx;
    }

    public TextC(PositionComponent positionComponent, String preText, GraphicsContext gfx) {
        super(positionComponent, preText);
        this.gfx = gfx;
    }

    public TextC(PositionComponent positionComponent, String preText, String text, GraphicsContext gfx) {
        super(positionComponent, preText, text);
        this.gfx = gfx;
    }

    @Override
    public void visualize() {
        int counter = 0;
        for (int c : this.getInformationComponent().getPreInfoText().chars().toArray()) {
            try {
                gfx.getGamePicture()[(int) this.getPositionComponent().getY()][(int) this.getPositionComponent().getX() + counter] = Character.toString(c);
                counter++;
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
        if (getInformationComponent() != null) {
            for (int c : this.getInformationComponent().getInformation().chars().toArray()) {
                try {
                    gfx.getGamePicture()[(int) this.getPositionComponent().getY()][(int) this.getPositionComponent().getX() + counter] = Character.toString(c);
                    counter++;
                } catch (IndexOutOfBoundsException ignored) {

                }
            }
        }
    }
}
