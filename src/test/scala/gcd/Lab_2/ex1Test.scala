package Lab_2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex1Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new Mux_2to1()) { d =>
      d.io.in_A.poke(4.U)
      d.io.in_B.poke(5.U)
      d.io.select.poke(false.B)
      d.clock.step(1)
      d.io.out.expect(5.U)
    }
  }
}