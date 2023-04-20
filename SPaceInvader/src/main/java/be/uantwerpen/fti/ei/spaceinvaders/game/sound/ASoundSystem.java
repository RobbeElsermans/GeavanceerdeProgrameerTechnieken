package be.uantwerpen.fti.ei.spaceinvaders.game.sound;

public abstract class ASoundSystem {
    public abstract void playShortSound(SoundType soundType);
    public abstract void playBackgroundMusic(SoundType soundType);
    public abstract void stopBackgroundMusic(SoundType soundType);
}
