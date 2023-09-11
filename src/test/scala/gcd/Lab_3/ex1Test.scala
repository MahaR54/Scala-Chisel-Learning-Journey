package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex1Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new Decoder2to4) { d =>
      d.io.in.poke("b0010".U)
      d.clock.step(10)
      d.io.out.expect("b0001".U)   
    }
    }
  }