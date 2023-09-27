
// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class CUtest extends FreeSpec with ChiselScalatestTester{
//     "CU File" in {
//         test(new CU) { d=>
//         d.io.instr.poke("b00000000010000000000000010010011".U)
//         d.clock.step(1)
//         d.io.rs1.expect(0.U)
//         d.io.rs2.expect(4.U)
//         d.io.rd.expect(1.U)
//         d.io.imm.expect(4.U)
//         d.io.opcode.expect(0.U)
//         }
//     }
// }