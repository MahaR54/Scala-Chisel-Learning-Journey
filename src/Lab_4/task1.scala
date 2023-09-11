package Lab_4
import chisel3._
import chisel3.util._


   object BranchOP {
    val Br_BEQ = 0.U(3.W)
    val Br_BNE = 1.U(3.W)
    val Br_BLT = 4.U(3.W)
    val Br_BGE  = 5.U(3.W)
    val Br_BLTU = 6.U(3.W)
    val Br_BGEU = 7.U(3.W)
   }

//    trait Config{
//     val WLEN = 32
//     val Branch_SIG_LEN = 4
//    }

   import BranchOP._

    class task1 extends Module {
    val io = IO(new Bundle {
    val rs1 = Input(UInt(32.W))
    val rs2 = Input(UInt(32.W))
    val funct3 = Input(UInt(3.W))
    val branch_pc = Output(UInt(1.W))
    
  })

  // Control logic for different branch types
  io.branch_pc := 0.U
  switch (io.funct3) {
    is("b000".U) { // BEQ
        io.branch_pc:=(io.rs1 === io.rs2) 
    }
    is("b001".U) { // BNE
      io.branch_pc:=(io.rs1 =/= io.rs2) 
    }
    is("b100".U){ //blt
        io.branch_pc:=(io.rs1 < io.rs2 )
    }
    is ("b101".U){ //bge
        io.branch_pc:=(io.rs1 >= io.rs2)
   }
   is ("b110".U){ //bltu
        io.branch_pc:=(io.rs1.asUInt < io.rs2.asUInt)   
   }
   is("b111".U){ //bgeu
        io.branch_pc:=(io.rs1.asUInt >= io.rs2.asUInt)
   }
    // Add cases for other branch types (BLT, BGE, etc.) similarly
  }
  }
