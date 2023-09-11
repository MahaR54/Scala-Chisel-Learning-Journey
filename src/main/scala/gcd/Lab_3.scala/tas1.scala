package Lab_3
import chisel3._
import chisel3.util._

class task1 extends Module {
  val io = IO(new Bundle {
    val rs1_data = Input(UInt(32.W))
    val rs2_data = Input(UInt(32.W))
    val funct3 = Input(UInt(3.W))
    // val branch_taken = Input(Bool())
    // val pc = Input(UInt(32.W))
    val branch_pc = Output(Bool())
    // val next_pc = Output(UInt(32.W))
  })

  // Default values
//   io.branch_pc := io.pc + 4.U
//   io.next_pc := io.pc + 4.U

  // Control logic for different branch types
  io.branch_pc := false.B
  switch (io.funct3) {
    is("b000".U) { // BEQ
    
        io.branch_pc:=(io.rs1_data === io.rs2_data)
      
    }
    is("b001".U) { // BNE
      io.branch_pc:=(io.rs1_data =/= io.rs2_data) 
    }
    is("b100".U){ //blt
        io.branch_pc:=(io.rs1_data < io.rs2_data )
    }
    is ("b101".U){ //bge
        io.branch_pc:=(io.rs1_data >= io.rs2_data)
   }
   is ("b110".U){ //bltu
        io.branch_pc:=(io.rs1_data.asUInt < io.rs2_data.asUInt)   
   }
   is("b111".U){ //bgeu
        io.branch_pc:=(io.rs1_data.asUInt >= io.rs2_data.asUInt)
   }
    // Add cases for other branch types (BLT, BGE, etc.) similarly
  }

  // Update next_pc based on branch_taken signal
//   when(io.branch_taken) {
//     io.next_pc := io.branch_pc // Take the branch
  }
