package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new ex2) { c =>
      c.io.in_A.poke("b00000000010000000000000010010011".U)
      c.io.in_B.poke("b00000000010000000000000010010011".U)
      c.io.alu_Op.poke(1.U)
      c.clock.step(10)
      c.io.out.expect("b00000000000100001000000100110011".U)   
    }
    }
  }