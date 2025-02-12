/*
 * FPConversionFCSRInstructions.java
 *
 * 24th july 2007
 * (c) 2006 EduMips64 project - Trubia Massimo
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
import org.edumips64.core.fpu.*;
import org.edumips64.core.tomasulo.fu.Type;

/**This is the base class of the conversion instructions in which the FCSR register is read in order to perform the conversion
 *
 * @author Trubia Massimo
 */

public abstract class FPConversionFCSRInstructions extends FPFormattedOperandMoveInstructions {
  protected String OPCODE_VALUE = "";
  protected String FMT_FIELD = "";
  FPConversionFCSRInstructions() {
    this.syntax = "%F,%F";
    this.paramCount = 2;
  }
  public abstract void EX() throws IrregularStringOfBitsException, FPInvalidOperationException, IrregularWriteOperationException, FPUnderflowException, FPOverflowException;

  @Override
  public Type getFUType() {
    return Type.FPAdder;
  }


  @Override
  public Integer op1() {
    return cpu.getInstructions() + params.get(FS_FIELD);
  }

  @Override
  public Integer op2() {
    return null;
  }

  @Override
  public Integer dest() {
    return cpu.getInstructions() + params.get(FD_FIELD);
  }

  @Override
  public Integer imme() {
    return null;
  }
}






