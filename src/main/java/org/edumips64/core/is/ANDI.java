/*
 * ANDI.java
 *
 * 8th may 2006
 * Instruction ANDI of the MIPS64 Instruction Set
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


/** <pre>
 *        Syntax: ANDI rt, rs, immediate
 *   Description: rt = rs AND immediate
 *                Does a bitwise logical AND with a constant
 *                The 16-bit immediate is zero-extended to the left and combined
 *                with the contents of GPR rs in a bitwise logical AND
 *                operation. The result is placed into GPR rt.
 *</pre>
  * @author Trubia Massimo, Russo Daniele
 */
class ANDI extends ALU_IType {
  private final String OPCODE_VALUE = "001100";

  ANDI() {
    super.OPCODE_VALUE = OPCODE_VALUE;
    this.name = "ANDI";
  }
  //since this operation is carried out with zero padding of immediate, against sign_extend(immediate) methodology
  //of all others instructions in the same category, is necessary the overriding of ID method
//  public boolean ISSUE() throws IrregularWriteOperationException, IrregularStringOfBitsException, TwosComplementSumException, JumpException, BreakException, WAWException, FPInvalidOperationException {
//    //if the source register is valid passing its own values into a temporary register
//    Register rs = cpu.getRegister(params.get(RS_FIELD));
//
//    TR[RS_FIELD] = rs;
//    //locking the target register
//    Register rt = cpu.getRegister(params.get(RT_FIELD));
//    //writing the immediate value of "params" on a temporary register
//    TR[IMM_FIELD].writeHalf(params.get(IMM_FIELD));
//    //forcing zero-padding in the same temporary register
//    StringBuffer sb = new StringBuffer();
//
//    for (int i = 0; i < 48; i++) {
//      sb.append('0');
//    }
//
//    TR[IMM_FIELD].setBits(sb.substring(0), 0);
//    return false;
//  }
  public void EX() throws IrregularStringOfBitsException {
    //getting values from temporary registers
    String imm = Long.toBinaryString(this.reservationStation.getImme());
    String rs = this.reservationStation.getValueJ();
    StringBuffer sb = new StringBuffer();
    boolean immbit, rsbit, resbit;

    //performing bitwise AND between immediate and rs register
    for (int i = 0; i < 64; i++) {
      rsbit = rs.charAt(i) == '1';
      immbit = imm.charAt(i) == '1';
      resbit = rsbit && immbit;
      sb.append(resbit ? '1' : '0');
    }

    this.resReg.setBits(sb.substring(0), 0);

  }
  @Override
  public Type getFUType() {
    return Type.Integer;
  }
}
