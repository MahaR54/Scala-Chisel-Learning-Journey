package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class t2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test( new Adder(32)){ c=>
  // Test AND operation
    //    c.io.alu_oper. poke ( 3.U)
       c.io.in0.poke(0.U)
       c.io.in1.poke(1.U)
        c.clock.step(1)
       c.io.sum.expect(1.U)
    }
  }
}

