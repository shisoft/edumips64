/*
 * FlowControl_JType.java
 *
 * 15th may 2006
 * Subgroup of the MIPS64 Instruction Set
 * (c) 2006 EduMips64 project - Trubia Massimo, Russo Daniele
 *
 * This file is part of the EduMIPS64 project, and is released under the GNU
 * General Public License.
 *
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

/**This is the base class for J-Type flowcontrol instructions
 *
 * @author Massimo
 */
public abstract class FlowControl_JType extends FlowControlInstructions {
  protected final static int INSTR_INDEX = 0;
  private final static int OPCODE_VALUE_INIT = 0;
  private final static int INSTR_INDEX_INIT = 6;
  private final static int INSTR_INDEX_LENGTH = 26;
  protected String OPCODE_VALUE = "";
  /** Creates a new instance of FlowControl_JType */
  FlowControl_JType() {
    this.syntax = "%E";
    this.paramCount = 1;
  }

  public boolean ISSUE() throws IrregularWriteOperationException, IrregularStringOfBitsException, TwosComplementSumException, JumpException, BreakException, WAWException, FPInvalidOperationException {
    return false;
  }

  public void EX() throws IrregularStringOfBitsException, IntegerOverflowException, IrregularWriteOperationException, JumpException {
  }

  public void pack() throws IrregularStringOfBitsException {
    //conversion of instruction parameters of "params" list to the "repr" form (32 binary value)
    repr.setBits(OPCODE_VALUE, OPCODE_VALUE_INIT);
    repr.setBits(Converter.intToBin(INSTR_INDEX_LENGTH, params.get(INSTR_INDEX) / 4), INSTR_INDEX_INIT);
  }


}
