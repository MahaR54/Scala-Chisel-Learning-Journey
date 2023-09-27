// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class LoadTest extends FreeSpec with ChiselScalatestTester{
//     "DataPath File" in {
//         test(new Load) { d=>
//         d.io.in(0).poke(100.U)
//         d.io.in(1).poke(100.U)
//         d.io.in(2).poke(100.U)
//         d.io.in(3).poke(100.U)
//         d.io.fun3.poke(2.U)
//         d.io.adr.poke(1.U)
//         d.clock.step(4)
//         d.io.out.expect(100.S)
//         }
// }
// } 