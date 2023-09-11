 package Lab_5
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
// import chisel3.iotesters.{Driver, PeekPokeTester}


class ex1Test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new ALU(32)) { c=>
  // Test AND operation
       c.io.alu_oper. poke ( 3.U)
       c.io.arg_x.poke (0.U)
       c.io.arg_y.poke (1.U)
        c.clock.step(1)
       c.io.alu_out.expect(1.U)
    }
  }
}

//   // Test OR operation
//   poke(c.io.alu_oper, "b0001".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 7.U)

//   // Test ADD operation
//   poke(c.io.alu_oper, "b0010".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 8.U)

//   // Test SUB operation
//   poke(c.io.alu_oper, "b0110".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 2.U)

//   // Test XOR operation
//   poke(c.io.alu_oper, "b0011".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 6.U)

//   // Test SLL operation
//   poke(c.io.alu_oper, "b0100".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 2.U)
//   step(1)
//   expect(c.io.alu_out, 20.U)

//   // Test SRL operation
//   poke(c.io.alu_oper, "b0101".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 2.U)
//   step(1)
//   expect(c.io.alu_out, 1.U)

//   // Test SRA operation
//   poke(c.io.alu_oper, "b0111".U)
//   poke(c.io.arg_x, -8.S)
//   poke(c.io.arg_y, 2.U)
//   step(1)
//   expect(c.io.alu_out, 3.U)

//   // Test SLT operation
//   poke(c.io.alu_oper, "b1000".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 0.U)

//   // Test SLTU operation
//   poke(c.io.alu_oper, "b1001".U)
//   poke(c.io.arg_x, 5.U)
//   poke(c.io.arg_y, 3.U)
//   step(1)
//   expect(c.io.alu_out, 0.U)
// }

// object ALUTesterMain extends App {
//   val width = 8  // Set your desired width here
//   Driver(() => new ALU(width)) {
//     c => new ALUTester(c)
//   }
// }
