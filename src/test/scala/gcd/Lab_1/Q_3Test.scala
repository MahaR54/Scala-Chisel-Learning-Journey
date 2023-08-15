package Lab_1
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Q_3Test extends FreeSpec with ChiselScalatestTester{
    "Chisel File" in {
        test(new  Counter (4, 8) { d=>
        d.clock.step(100)
        //d.io.result.expect(1.S)
        })
    }
} 