/*
 * LW.java
 *
 * 20th may 2006
 * Instruction LW of the MIPS64 Instruction Set
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


/** <pre>
 *  Format:        LW rt, offset(base)
 *  Description:   rt = memory[base+offset]
 *                 To load a word from memory as a signed value
  * </pre>
 * @author Trubia Massimo, Russo Daniele
 */
class LW extends Loading {
  private final String OPCODE_VALUE = "100011";

  LW(Memory memory) {
    super(memory);
    super.OPCODE_VALUE = OPCODE_VALUE;
    this.name = "LW";
    this.memoryOpSize = 4;
  }

  public void doMEM() throws IrregularStringOfBitsException, NotAlignException, MemoryElementNotFoundException, AddressErrorException, IrregularWriteOperationException {
    this.resReg.writeWord(memEl.readWord((int)(address % 8)));
  }
}
