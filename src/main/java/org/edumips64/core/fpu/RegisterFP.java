/* RegisterFP.java
 *
 * This class models a 64-bit CPU's internal floating point register.
 * (c) 2006 Massimo Trubia
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
 *
 * 18/05/2006 - Andrea Spadaccini:
 *  * Removed lock-related functions, in order to add read and write semaphores
 */
package org.edumips64.core.fpu;


import org.edumips64.core.IrregularStringOfBitsException;
import org.edumips64.core.fpu.BitSet64FP;

/** This class models a 64-bit CPU's internal register.
 * @author Massimo Trubia
 */
public class RegisterFP extends BitSet64FP {
  private String name;

  /** Creates a default new instance of Register. */
  public RegisterFP(String name) {
    this.name = name;
  }

  /**Returns a string with a double value or the name of a special value
    * it is recommended the use of this method only for the visualisation of the double value because it may return an alphanumeric value
    * @return the double value or the special values "Quiet NaN","Signaling NaN", "Positive infinity", "Negative infinity","Positive zero","Negative zero"
    */
  public String getValue() {
    return super.readDouble();
  }

  /** Reset the register and its associated semaphores
   */
  public void reset() {
    super.reset(false);
  }


  public String toString() {
    String s = "";

    try {
      s = getHexString();
    } catch (IrregularStringOfBitsException e) {
      e.printStackTrace();
    } //Impossibile che si verifichi

    return s;
  }

}
