package Lab_1
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Q_2Test extends FreeSpec with ChiselScalatestTester{
    "Chisel File" in {
         test(new Q_2(4.U) { d=>
         d.clock.step(8)
         // d.io.result.expect(1.S)
         })
     }
 }