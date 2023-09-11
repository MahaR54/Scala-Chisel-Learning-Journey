 package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
// import chisel3.iotesters.{Driver, PeekPokeTester}


class ex2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    // test(new eMux(UInt(32.W))) { c=>
  // Test AND operation
    //    c.io.in1. poke (2.U)
    //    c.io.in2.poke (5.U)
    //    c.io.sel.poke (true.B)
    //     c.clock.step(1)
    //    c.io.out.poke(5.U)
    // }
     test(new eMux(SInt(32.W))) { c =>
      c.io.in1.poke(5.S)
      c.io.in2.poke(10.S)
      c.io.sel.poke(false.B)
      c.clock.step(1)

      // c.io.out.expect(5.S)

      // c.io.sel.poke(true.B)
      // c.clock.step(1)

      c.io.out.expect(5.S)
    }
  }
}