package Lab_6
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class ex2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new counter(5)) { c =>
    // c.io.in.poke(false.B)
    // c.io.sel.poke(true.B)
    c.clock.step(1)
    c.io.out.expect(1.U)
    }
  }
}