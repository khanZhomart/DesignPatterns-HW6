package subtask2.factories;

import subtask2.instruments.Guitar;
import subtask2.instruments.Instrument;

public class GuitarFactory extends Factory {

    @Override
    public Instrument create() {
        return new Guitar();
    }
}
