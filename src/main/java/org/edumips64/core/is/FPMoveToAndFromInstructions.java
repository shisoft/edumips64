/*
 * FPMoveInstructions.java
 *
 * 16th july 2007
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
import org.edumips64.core.fpu.FPInvalidOperationException;

/**This is the base class of the move to and from instructions
 *
 * @author Trubia Massimo
 */

public abstract class FPMoveToAndFromInstructions extends ComputationalInstructions {
  protected final static int RT_FIELD = 0;
  private final static int RT_FIELD_INIT = 11;
  private final static int RT_FIELD_LENGTH = 5;
  protected final static int FS_FIELD = 1;
  private final static int FS_FIELD_INIT = 16;
  private final static int FS_FIELD_LENGTH = 5;
  private final static String ZERO_FIELD = "00000000000";
  private final static int ZERO_FIELD_INIT = 21;
  private final static String COP1_FIELD = "010001";
  private final static int COP1_FIELD_INIT = 0;
  private final static int OPCODE_VALUE_INIT = 6;
  protected String OPCODE_VALUE = "";

  FPMoveToAndFromInstructions() {
    this.syntax = "%R,%F";
    this.paramCount = 2;
  }

  public abstract void EX() throws IrregularStringOfBitsException, IrregularWriteOperationException;

  public void pack() throws IrregularStringOfBitsException {
    //conversion of instruction parameters of params list to the "repr" 32 binary value
    repr.setBits(COP1_FIELD, COP1_FIELD_INIT);
    repr.setBits(OPCODE_VALUE, OPCODE_VALUE_INIT);
    repr.setBits(Converter.intToBin(RT_FIELD_LENGTH, params.get(RT_FIELD)), RT_FIELD_INIT);
    repr.setBits(Converter.intToBin(FS_FIELD_LENGTH, params.get(FS_FIELD)), FS_FIELD_INIT);
    repr.setBits(ZERO_FIELD, ZERO_FIELD_INIT);
  }
}
