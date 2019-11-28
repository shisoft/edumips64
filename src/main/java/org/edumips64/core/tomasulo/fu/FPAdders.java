package org.edumips64.core.tomasulo.fu;

import org.edumips64.core.tomasulo.CommonDataBus;

public class FPAdders extends FunctionUnit {

    public FPAdders(int id, CommonDataBus cdb) {
        super(id, cdb);
    }

    @Override
    public void step() {

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
        return Type.FPAdder;
    }
}
