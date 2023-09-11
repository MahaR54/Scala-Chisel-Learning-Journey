package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new ImmdValGen) { d =>
      d.io.instr.poke("b00000000001000001000000100010011".U)
      d.clock.step(10)
      d.io.immd_se.expect(2.U)   
    }
    }
  }