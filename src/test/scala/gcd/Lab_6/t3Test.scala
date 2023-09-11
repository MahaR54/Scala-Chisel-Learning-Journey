package Lab_6
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class t3Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new UpDownCounter) { c =>
    // Test for counting up
    c.io.upDown.poke(true.B)
    c.clock.step(1)
    c.io.count.expect(1.U)

    // Test for counting down
    c.io.upDown.poke(false.B)
    c.clock.step(1)
    c.io.count.expect(0.U)

    // Test for counting up again
    c.io.upDown.poke(true.B)
    c.clock.step(1)
    c.io.count.expect(1.U)

    // Test for counting down again
    c.io.upDown.poke(false.B)
    c.clock.step(1)
    c.io.count.expect(0.U)

    }
  }
}
