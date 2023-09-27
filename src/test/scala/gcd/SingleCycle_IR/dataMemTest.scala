// package SingleCycle_IR
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class dataMemTest extends FreeSpec with ChiselScalatestTester{
//     "DataPath File" in {
//         test(new dataMem(1024, 32)) { d=>
//         d.io.writeData.poke(100.U)
//         d.io.load.poke(1.B)
//         d.io.store.poke(1.B)
//         d.io.addr.poke(2.U)
//         d.clock.step(4)
//         d.io.readData.expect(100.U)
//         }
//     }
// } 