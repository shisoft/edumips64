package org.edumips64.core.tomasulo.fu;

import org.edumips64.core.is.InstructionInterface;
import org.edumips64.core.tomasulo.CommonDataBus;

import java.util.HashMap;
import java.util.OptionalLong;

public abstract class FunctionUnit {
    private int id;
    private ReservationStation reservationStation;
    private int Op;
    private Status status;
    private CommonDataBus cdb;
    private InstructionInterface instruction;
    private HashMap<Integers, Integers> registerStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReservationStation getReservationStation() {
        return reservationStation;
    }

    public void setReservationStation(ReservationStation reservationStation) {
        this.reservationStation = reservationStation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getOp() {
        return Op;
    }

    public CommonDataBus getCdb() {
        return cdb;
    }

    public void step() {
        switch (this.status) {
            case Idle:
                break; //do nothing
            case Running:
                this.step_fu();
                break;
            case Finished:
                if (cdb.set(this.id, this.get_fu_result())) {
                    this.status = Status.Idle;
                }
                break;
            case Waiting:
                // may waiting for other function units
                // should check CDB for data
                Integer qj = this.reservationStation.getQj();
                Integer qk = this.reservationStation.getQk();
                assert qj != null || qk != null;
                if (qj != null) {
                    OptionalLong cdbRes = this.cdb.get(qj);
                    if (cdbRes.isPresent()) {
                       this.reservationStation.setValueJ(cdbRes.getAsLong());
                       this.reservationStation.setQj(null);
                    }
                }
                if (qk != null) {
                    OptionalLong cdbRes = this.cdb.get(qk);
                    if (cdbRes.isPresent()) {
                        this.reservationStation.setValueK(cdbRes.getAsLong());
                        this.reservationStation.setQk(null);
                    }
                }
                if (this.reservationStation.getValueJ() != null && this.reservationStation.getValueK() != null) {
                    this.status = Status.Running;
                    this.reservationStation.setBusy(true);
                }
        }
    }

    public InstructionInterface getInstruction() {
        return this.instruction;
    }

    public boolean issue(InstructionInterface instruction) {
        if (this.instruction == null) {

            if (registerStatus[instruction.get])
            this.instruction = instruction;
        }
        return false;
    }

    abstract void step_fu();

    public abstract int steps_remain();

    abstract long get_fu_result();
}
