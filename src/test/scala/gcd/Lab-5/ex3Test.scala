 package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class ex3Test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test( new Operator (2 ,UInt(16.W)) (_+_)){ c=>
  // Test AND operation
    //    c.io.alu_oper. poke ( 3.U)
       c.io.in(0).poke (0.U)
       c.io.in(1).poke (1.U)
        c.clock.step(1)
       c.io.out(0).expect(1.U)
    }
  }
}

