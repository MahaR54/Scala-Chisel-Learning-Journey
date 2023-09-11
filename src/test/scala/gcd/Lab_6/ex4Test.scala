package Lab_6
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class ex4Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new MyModule) { c =>
      // Drive inputs for queue 1
      c.io.in1.valid.poke(true.B)
      c.io.in1.bits.poke(42.U)
      c.io.in2.valid.poke(false.B) // in2 is not active
      c.io.in2.bits.poke(0.U)

      c.clock.step(1)

      // Check the output of out1
      c.io.out1.ready.poke(true.B)
      c.clock.step(1)
      c.io.out1.valid.expect(true.B)
      c.io.out1.bits.expect(42.U)

      // Check the output of out2
      c.io.out2.ready.poke(true.B)
      c.clock.step(1)
      c.io.out2.valid.expect(false.B) // in2 is not active, so out2 should be invalid
      c.io.out2.bits.expect(0.U)
    }
  }
}


