 package Lab_4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import ALUPOimm._
import ALUPOins._

class task2Test extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new imm) { a =>
      val array_op = Array(ALU_I, ALU_S, ALU_B, ALU_U, ALU_L, ALU_J)
      val array_ins = Array(ALU_i, ALU_s, ALU_b, ALU_u, ALU_l, ALU_j)

      for (i <- 0 until 100) {
        val ran = Random.nextInt(5)
        val op = array_op(ran)
        val ins = array_ins(ran)

        val results = op match {
         case ALU_I => 5.U
          case ALU_S =>0.U
          case ALU_B =>4.U
          case ALU_U =>12.U
          case ALU_L =>0.U
          case ALU_J =>2.U
          case _ => 0.U
        }

        a.io.ins.poke(ins)
        a.clock.step(1)
        a.io.imm.expect(results)
        println("=== ins"+a.io.ins.peek())
        println("=== imm"+a.io.imm.peek())
        println("=== random"+ran)
        
      }
        a.clock.step(1)

    }
  }
}