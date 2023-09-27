// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._
// import chiseltest.internal.VerilatorBackendAnnotation
// import chiseltest.experimental.TestOptionBuilder._

// class ALUtest extends FreeSpec with ChiselScalatestTester{
//     "DataPath File" in {
//         test(new ALU).withAnnotations(Seq(VerilatorBackendAnnotation)) { d=>
//         d.io.in_A.poke(2.S)
//         d.io.in_B.poke(8.S)
//         d.io.alu_Op.poke(1.U)
//         d.clock.step(1)
//         d.io.out.expect(512.S)
//         }
// }
// } 