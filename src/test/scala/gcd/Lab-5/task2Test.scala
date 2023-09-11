package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._

class task2Test extends FreeSpec with ChiselScalatestTester {
  "Router" in {
    test(new Router(UInt(32.W))) { router =>
      // Set input values
      router.io.in.address.poke(42.U)
      router.io.in.data.poke(23.U)
      router.io.in.output.poke(0.U)

      // Wait a cycle for the router logic to process
      router.clock.step(1)

      // Check if output matches input
      router.io.out.address.expect(42.U)
      router.io.out.data.expect(23.U)
      router.io.out.output.expect(0.U)
    }
  }

}


