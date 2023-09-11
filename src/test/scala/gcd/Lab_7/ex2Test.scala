package Lab_7
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._


class ex2Test extends FreeSpec with ChiselScalatestTester{
 "Chisel Tester file " in{
     test(new Manchester_Decoding){ d=> 
      d.io.in.poke(1.U)
      d.io.start.poke(1.B)
      d.clock.step(1)
      println("out"+d.io.out.peek())
       println("out1"+d.io.flag.peek())
    //   d.io.out.expect(0.U)
    //   d.io.flag.expect(0.U)
    }
  }
}