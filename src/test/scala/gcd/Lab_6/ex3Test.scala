package Lab_6
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class ex3Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new ex3) { dut =>
    dut.io.din.poke(true.B)
      dut.io.reload.poke(false.B)
      dut.timer_count.poke(5.U)
      dut.io.state.poke(false.B)

      dut.clock.step(1) //Initial values

      dut.io.reload.poke(true.B) 
      dut.clock.step(1) 
      dut.io.reload.poke(false.B)

    }
  }
}