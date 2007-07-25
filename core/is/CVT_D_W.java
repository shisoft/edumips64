/*
 * CVT_D_W.java
 *
 * 25th july 2007
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


package edumips64.core.is;
import edumips64.core.*;
import edumips64.core.fpu.*;
import edumips64.utils.*;
import java.math.*;

/**
 * <pre>
 * whether a qnan or snan is passed or the rounded value is outside the range [2^63,2^63-1]
 *  null is returned
 */
class CVT_D_W extends FPConversionFCSRInstructions {
	static String OPCODE_VALUE="100101";
	static String FMT_FIELD="10100"; //WORD IS 20
	static String NAME = "CVT.D.W";
	
	public CVT_D_W() {
		super.OPCODE_VALUE = OPCODE_VALUE;
		super.FMT_FIELD = FMT_FIELD;
		super.name=NAME;
	}
	
	public void EX() throws IrregularStringOfBitsException, FPInvalidOperationException, IrregularWriteOperationException, FPUnderflowException, FPOverflowException {
		//getting values from temporary registers
		BigDecimal bd;
		String fs=TRfp[FS_FIELD].getBinString();
		if((bd=FPInstructionUtils.fixedPoint32ToDouble(fs))==null)
			if(cpu.getFPExceptions(CPU.FPExceptions.INVALID_OPERATION))
				throw new FPInvalidOperationException();
			else{
				cpu.setFCSRFlags("V",1);
				TRfp[FD_FIELD].setBits("0000000000000000000000000000000000000000000000000000000000000000",0);
			}
		else{
			TRfp[FD_FIELD].writeDouble(bd.doubleValue());
		}
		if(enableForwarding) {
			doWB();
		}
	}
}
