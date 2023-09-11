package Lab_6
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class t1Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new XORCounter(5)) { c =>
    c.clock.step(5)
    c.io.count.expect(0.U)

    }
  }
}