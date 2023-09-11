package Lab_7
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._


class ex1Test extends FreeSpec with ChiselScalatestTester{
 "Chisel Tester file " in{
 test(new ex1){ d=> 
      d.io.f1.poke(0.B)
      d.io.r1.poke(0.B)
      d.clock.step(1)
      d.io.out.expect(0.U)
     }
 
  }
}