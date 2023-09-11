package Lab_4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random
import BranchOP._

class task1Test  extends FreeSpec with ChiselScalatestTester {
  "Branch Module" in {
    test(new task1) { d =>
    val arr = Array(Br_BEQ, Br_BNE, Br_BLT, Br_BGE, Br_BLTU, Br_BGEU)
      // Test parameters
    //   val arr = Array()
       //  val branchCount = 100
      
      // Test loop
      for (i<-0 until 100) {
        val rs1 = Random.nextInt(32)
        val rs2 = Random.nextInt(32)
        val opr = Random.nextInt(5)
        val branchOp = arr(opr)
        // val pc = Random.nextInt(1024)
        // val taken = Random.nextBoolean()
        val result = branchOp match{
           
        case Br_BEQ => if(rs1 === rs2)1 else 0 
        case Br_BNE => if(rs1 != rs2)1 else 0
        case Br_BLT => if(rs1 < rs2 )1 else 0
        case Br_BGE => if(rs1 >= rs2)1 else 0
        case Br_BLTU =>if(rs1 < rs2 )1 else 0  
        case Br_BGEU => if(rs1 >= rs2)1 else 0
        case _ => 0  
       } 
 
     
        d.io.rs1.poke(rs1.U)
        d.io.rs2.poke(rs2.U)
        d.io.funct3.poke(branchOp)
        d.clock.step(1)
        d.io.branch_pc.expect(result.U)
        // val expectedOutput = if (taken) pc + 4 else pc
      }
        d.clock.step(1)
        
        // d.io.new_pc.expect(expectedOutput.U)
      }
    }
  }

