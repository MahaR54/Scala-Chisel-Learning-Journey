
 package Lab_4
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import Lab_4.ALUOP._

class Task0Test extends FreeSpec with ChiselScalatestTester {
  "Chisel File" in {
    test(new Lab_3.ex2) { c =>
      // ALU operations
      val array_op = Array(ALU_ADD, ALU_SUB, ALU_AND, ALU_OR, ALU_XOR, ALU_SLT,
        ALU_SLL, ALU_SLTU, ALU_SRL, ALU_SRA, ALU_COPY_A, ALU_COPY_B)

      for (i <- 0 until 1) {
        val rs1 = Random.nextLong() & 0xFFFFFFFFL
        val rs2 = Random.nextLong() & 0xFFFFFFFFL // masking 100010110 & 00001111 -> 0110
        val opr = Random.nextInt(12)
        val aluop = array_op(6)

        // ALU functional implementation using Scala match
        val result = aluop match {
          case ALU_ADD => rs1 + rs2
          case ALU_SUB => rs1 - rs2
          case ALU_AND => rs1 & rs2
          case ALU_OR => rs1 | rs2
          case ALU_XOR => rs1 ^ rs2
          case ALU_SLT => if(rs1.toInt < rs2.toInt)1 else 0
          case ALU_SLL => rs1 << (rs2 & 0x1F)
          case ALU_SLTU => if(rs1.toInt < rs2.toInt)1 else 0
          case ALU_SRL => rs1 >> (rs2 & 0x1F)
          case ALU_SRA => (rs1.toInt).toLong >> (rs2 & 0x1F)
          case ALU_COPY_A => rs1
          case ALU_COPY_B => rs2
          case _ => 0
        }

        val result1: BigInt = if (result < 0)
        (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
        else result & 0xFFFFFFFFL //1111 + 1011 +1 = 1011 +10000 = 11011 & 01111 =1011

        c.io.in_A.poke(rs1.U)
        c.io.in_B.poke(rs2.U)
        c.io.alu_Op.poke(aluop)
        c.clock.step(1)
        c.io.out.expect(result1.U)
      }
      c.clock.step(2)
    }
  }
}
// import chisel3._
// import chisel3.tester._
// import chisel3.util._
// import org.scalatest._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._
// import chiseltest.experimental.TestOptionBuilder._
// import scala.util.Random
// import ALUOP._


// class Task3Test extends FreeSpec with ChiselScalatestTester{
//     "ALU test "in{
//         test(new Lab_3.ex2) {c=>
//             val array_op=Array(ALU_ADD,ALU_SUB,ALU_AND,ALU_OR,ALU_XOR,ALU_SLT,ALU_SLL,ALU_SLTU,ALU_SRL,ALU_SRA,ALU_COPY_A,ALU_COPY_B)   

//         for(i<-0 until 1){
//             val rs1 = Random.nextLong() & 0xFFFFFFFFL

//             val rs2 = Random.nextLong() & 0xFFFFFFFFL

//             val opr=Random.nextInt(11)
//             val aluop=array_op(opr)

//             val result = aluop match {
//                 case ALU_ADD=> rs1+rs2
//                 case ALU_SUB=> rs1-rs2
//                 case ALU_AND=> rs1&rs2
//                 case ALU_OR=> rs1|rs2
//                 case ALU_XOR=> rs1^rs2
//                 case ALU_SLT=>  if((rs1<rs2))1 else 0       
//                 case ALU_SLL=> rs1<<(rs2 &0x1F)
//                 case ALU_SLTU => if(rs1<rs2)1 else 0  
//                 case ALU_SRL=> rs1>>(rs2 &0x1F)
//                 case ALU_SRA=> rs1>>(rs2 &0x1F)
//                 case ALU_COPY_A=> rs1
//                 case ALU_COPY_B=> rs2
//                 case _ => 0

            
//             }
//             val result1: BigInt = if (result < 0L)
//   (BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL
// else
//   result & 0xFFFFFFFFL
//             c.io.A.poke(rs1.U)
//             c.io.B.poke(rs2.U)
//             c.io.Opcode.poke(aluop)
//             c.clock.step(1)
//             c.io.out.expect(result1.asUInt)
//             // println(":==="+c.io.in_A.peek())
//             // println(c.io.in_B.peek())
//             // println(c.io.alu_Op.peek())
//             // println(c.io.out.peek())

//         }         
//         c.clock.step(2)
//         }
//tx decide karigi kai kb valid hai, jis cycle mai v r dono high hain tw rx data store krega, ideal pr reset hoga,
// tx mai valid tb tk appne pas data rkhega tb tk ready nhi hoga
//     }
// }