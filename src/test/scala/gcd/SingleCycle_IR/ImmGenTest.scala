// package SingleCycle_IR
// import chisel3._
// import chisel3.util._
// import org.scalatest._
// import chiseltest._
// import chiseltest.experimental.TestOptionBuilder._


// class ImmGenTest extends FreeSpec with ChiselScalatestTester {
//   "Chisel" in {
//     test(new ImmGen) { a =>

//         a.io.ins.poke("b0010011".U)
//         a.clock.step(1)
//         a.io.imm.expect(0.U)
//     }
//   }
// }