// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class StoreTest extends FreeSpec with ChiselScalatestTester{
//     "DataPath File" in {
//         test(new Store) { d=>
//         d.io.in.poke(100.S)
//         d.io.fun3.poke(2.U)
//         d.clock.step(4)
//         d.io.out.expect(100.S)
//         }
//     }
// } 