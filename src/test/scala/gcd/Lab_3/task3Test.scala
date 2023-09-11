package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task3Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new decoder_with_valid  ) { d =>
      d.io.in.poke(1.U)
      d.clock.step(10)
    //   d.io.out.bits.expect(1.U)   
      d.io.out.valid.expect(true.B)
    }
    }
  }