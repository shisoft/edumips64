/*
 * HALT.java
 *
 *
 * 15th may 2006
 * Instruction of the MIPS64 Instruction Set
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
import org.edumips64.core.tomasulo.fu.Type;

/** *Syntax:    HALT
 * Description: To terminate the program execution
 *               When an HALT instruction performs ID step, it notifies to CPU
 *              that all instructions in pipeline after HALT instruction must be
 *              ignored
 *Exceptions:   HaltException
 *</pre>
 * @author Trubia Massimo, Russo Daniele
 */
public class HALT extends Instruction {
  private final String OPCODE_VALUE = "000001";
  HALT() {
    name = "HALT";
  }
  public void IF() {
    try {
      dinero.IF(Converter.binToHex(Converter.intToBin(64, cpu.getLastPC().getValue())));
    } catch (IrregularStringOfBitsException e) {
      e.printStackTrace();
    }
  }
  public boolean ISSUE() throws IrregularWriteOperationException, IrregularStringOfBitsException, TwosComplementSumException, JumpException, BreakException, WAWException, FPInvalidOperationException, StoppingException {
    throw new StoppingException();
  }

  public void EX() throws IrregularStringOfBitsException, IntegerOverflowException, TwosComplementSumException, HaltException {
    throw new HaltException();
  }

  public void MEM() throws IrregularStringOfBitsException, MemoryElementNotFoundException, AddressErrorException, IrregularWriteOperationException {
  }

  @Override
  public Type getFUType() {
    return Type.NOP;
  }

  @Override
  public Integer op1() {
    return null;
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

  public void pack() throws IrregularStringOfBitsException {
    repr.setBits(OPCODE_VALUE, 0);
  }

}
