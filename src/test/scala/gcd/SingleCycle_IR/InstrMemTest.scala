// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class InstrMemTest extends FreeSpec with ChiselScalatestTester{
//     "mm test File" in {
//         test(new InstMem) { d=>
//         // d.io.data_in.poke(2.U)
//         // d.io.enb.poke(1.B)
//         d.io.address.poke(0.U)
//         d.clock.step(1)
//         d.io.data_out.expect("h00300113".U)
//         //d.io.data_out.expect(0.U)//read

//          d.clock.step(1)
//         // d.io.data_out.expect(2.U)//write
//         }
// }
// } 