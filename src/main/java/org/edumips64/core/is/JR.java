/*
 * JR.java
 *
 *  20th may 2006
 * Instruction JR of the MIPS64 Instruction Set
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

/**
 * <pre>
 *      Syntax: JR rs
 * Description: To execute a branch to an instruction address in a register
 *</pre>
 * @author Trubia Massimo, Russo Daniele
 *
 */

public class JR extends FlowControl_RType {
  private final  String OPCODE_VALUE = "001000";
  JR() {
    super.OPCODE_VALUE = OPCODE_VALUE;
    this.name = "JR";

  }

  public void EX() throws IrregularStringOfBitsException, IntegerOverflowException, IrregularWriteOperationException, JumpException {
    cpu.getPC().setBits(this.reservationStation.getValueJ(), 0);
    throw new JumpException();
  }

  @Override
  public Integer op1() {
    return params.get(RS_FIELD);
  }

  @Override
  public Integer op2() {
    return null;
  }

  @Override
  public Integer dest() {
    return null;
  }

  @Override
  public Integer imme() {
    return null;
  }
}



