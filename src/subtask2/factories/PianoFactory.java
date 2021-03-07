package subtask2.factories;

import subtask2.instruments.Instrument;
import subtask2.instruments.Piano;

public class PianoFactory extends Factory {

    @Override
    public Instrument create() {
        return new Piano();
    }
}
