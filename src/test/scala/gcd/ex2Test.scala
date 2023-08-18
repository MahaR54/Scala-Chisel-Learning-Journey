package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new ex2) { d =>
      d.io.op1.poke("b00000000010000000000000010010011".U)
      d.io.op2.poke("b00000000010000000000000010010011".U)
      d.io.aluOp.poke(1.U)
      d.clock.step(10)
      d.io.result.expect("b00000000000100001000000100110011".U)   
    }
    }
  }