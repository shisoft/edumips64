package org.edumips64.core.tomasulo;

import java.util.OptionalLong;

public class CommonDataBus {
    private boolean busy;
    private int fuSorce;
    private long value;

    public boolean set(int source, long value) {
        if (busy) {
            return false;
        }
        this.fuSorce = source;
        this.value = value;
        this.busy = true;
        return true;
    }

    public OptionalLong get(int source) {
        if (!busy && fuSorce == source) {
            return OptionalLong.empty();
        } else  {
            busy = false;
            return OptionalLong.of(value);
        }
    }
}
