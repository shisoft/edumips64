package org.edumips64.core.tomasulo.fu;

import org.edumips64.core.tomasulo.CommonDataBus;

public class FPMultipliers extends FunctionUnit {
    public FPMultipliers(int id, CommonDataBus cdb) {
        super(id, cdb);
    }

    @Override
    void step_fu() {

    }

    @Override
    public int steps_remain() {
        return 0;
    }

    @Override
    long get_fu_result() {
        return 0;
    }

    @Override
    public Type fuType() {
        return Type.FPMultiplier;
    }
}
