package SingleCycle_IR
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class TopModuleTest extends FreeSpec with ChiselScalatestTester{
    "DataPath File" in {
        test(new TopModule) { d=>
       
        d.clock.step(300)
        }
    }
} 