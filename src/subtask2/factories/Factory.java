package subtask2.factories;

import subtask2.instruments.Instrument;

public abstract class Factory {

    public void playSound() {
        Instrument instrument = this.create();
        instrument.playSound();
    }

    public abstract Instrument create();
}
