// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class RegFileTest extends FreeSpec with ChiselScalatestTester{
//     "DataPath File" in {
//         test(new RagFile) { d=>
//         d.io.rs1.poke(2.U)
//         d.io.rs2.poke(4.U)
//         d.io.rd.poke(5.U)
//         d.io.Wback.poke(3.U)
      
//         d.clock.step(1)
//         d.io.read_rs1.expect(0.U)//read
//         d.io.read_rs2.expect(0.U)

//         // d.clock.step(1)
//         // d.io.data_out.expect(2.U)//write
//         }
// }
// } 