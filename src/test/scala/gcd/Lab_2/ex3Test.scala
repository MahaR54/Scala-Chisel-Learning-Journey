package Lab_2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex3Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new ex3 ) { d =>
           d.io.in0.poke(0.U) //2^0
           d.io.in1.poke(1.U) //2^1
           d.io.in2.poke(2.U) //
           d.io.in3.poke(3.U)
           d.io.sel.poke(8.U) //2^3=8
           d.clock.step(1)
           d.io.out.expect(3.U) //power=output
    }
  }
}