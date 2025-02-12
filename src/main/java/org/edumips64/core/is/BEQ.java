/*
 * BEQ.java
 *
 * 8th may 2006
 * Instruction BEQ of the MIPS64 Instruction Set
 * (c) 2006 EduMips64 project - Trubia Massimo, Russo Daniele
 *
 * This file is part of the EduMIPS64 project, and is released under the GNU
 * General Public License.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.edumips64.core.is;
import org.edumips64.core.*;
import org.edumips64.core.fpu.FPInvalidOperationException;

/** <pre>
 *         Syntax: BEQ rs, rt, offset
 *    Description: if rs = rt then branch
 *                 To compare GPRs then do a PC-relative conditional branch
 *</pre>
  * @author Trubia Massimo, Russo Daniele
 */

public class BEQ extends FlowControl_IType {
  private final String OPCODE_VALUE = "000100";

  /** Creates a new instance of BEQ */
  BEQ() {
    super.OPCODE_VALUE = OPCODE_VALUE;
    syntax = "%R,%R,%B";
    name = "BEQ";
  }

  public void EX() throws JumpException, TwosComplementSumException, IrregularWriteOperationException, IrregularStringOfBitsException {
    //getting registers rs and rt
    String rs = this.reservationStation.getValueJ();
    String rt = this.reservationStation.getValueK();
    boolean condition = rs.equals(rt);

    if (condition) {
      jumpToOffset(OFFSET_FIELD);
    }
  }

  @Override
  public Integer op1() {
    return params.get(RS_FIELD);
  }

  @Override
  public Integer op2() {
    return params.get(RT_FIELD);
  }

  @Override
  public Integer dest() {
    return null;
  }

  @Override
  public Integer imme() {
    return params.get(OFFSET_FIELD);
  }
}
