package Lab_2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task11Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new MuxLookups) { d =>
    d.io.s0.poke(false.B)
    d.io.s1.poke(false.B)
    d.io.s2.poke(false.B)
    d.io.out.expect(5.U)
    }
  }
}
