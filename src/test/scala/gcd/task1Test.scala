package Lab_3
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task1Test extends FreeSpec with ChiselScalatestTester{
    "Chisel File" in {
        test(new task1) { d=>
        d.io.rs1_data.poke(4.U)
        d.io.rs2_data.poke(4.U)
        d.io.funct3.poke("b000".U)
        d.clock.step(8)
        d.io.branch_pc.expect(true.B)
        }
    }
}