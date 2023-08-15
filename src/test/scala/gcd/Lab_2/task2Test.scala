package Lab_2
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class tasks2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new task2) { d =>
    d.io.in(0).poke(false.B)
    d.io.in(1).poke(false.B)
    d.io.in(2).poke(false.B)
    d.io.in(3).poke(true.B)
    
    d.io.s(0).poke(false.B)
    d.io.s(1).poke(true.B)
    d.io.shift.poke(true.B)

    d.clock.step(1)

    d.io.out(0).expect(false.B)
    d.io.out(1).expect(false.B)
    d.io.out(2).expect(false.B)
    d.io.out(3).expect(false.B)
    }
  }
}