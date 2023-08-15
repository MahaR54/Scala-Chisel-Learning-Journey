package Lab_2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new Mux_8to1) { d =>
      d.io.in0.poke(false.B)
      d.io.in1.poke(false.B)
      d.io.in2.poke(false.B)
      d.io.in3.poke(true.B)
      d.io.in4.poke(false.B)
      d.io.in5.poke(false.B)
      d.io.in6.poke(false.B)
      d.io.in7.poke(false.B)
      d.io.s0.poke(false.B)
      d.io.s1.poke(true.B)
      d.io.s2.poke(true.B)
       d.clock.step(1)
      d.io.out.expect(true.B)   
    }

    }
  }
