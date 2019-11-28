package org.edumips64.core.tomasulo.fu;

public class ReservationStation {

    private Type rsType;

    private boolean busy;
    private int op;
    private Long valueJ;
    private Long valueK;
    private Integer qj;
    private Integer qk;
    private Long imme;

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Long getValueJ() {
        return valueJ;
    }

    public void setValueJ(Long valueJ) {
        this.valueJ = valueJ;
    }

    public Long getValueK() {
        return valueK;
    }

    public void setValueK(Long valueK) {
        this.valueK = valueK;
    }

    public Integer getQj() {
        return qj;
    }

    public void setQj(Integer qj) {
        this.qj = qj;
    }

    public Integer getQk() {
        return qk;
    }

    public void setQk(Integer qk) {
        this.qk = qk;
    }

    public Long getImme() {
        return imme;
    }

    public void setImme(Long imme) {
        this.imme = imme;
    }

    public Type getRsType() {
        return rsType;
    }
}
