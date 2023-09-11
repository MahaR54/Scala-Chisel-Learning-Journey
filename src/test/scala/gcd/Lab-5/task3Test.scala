package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class task3Test extends FreeSpec with ChiselScalatestTester {
  "Router" in { 
 test(new EMuxInclusive) { dut =>
      dut.io.inputA.poke(true.B)
      dut.io.inputB.poke(42.U)
      dut.io.select.poke(false.B)
      dut.clock.step()

      dut.io.output.expect(1.U)

      dut.io.select.poke(true.B)
      dut.clock.step()

      dut.io.output.expect(42.U)
    }
  }
}