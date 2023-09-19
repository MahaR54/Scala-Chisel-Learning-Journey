package SingleCycle_IR
import chisel3._
import chisel3.util._ 
import chisel3.stage.ChiselStage
object ALUOP {
    val ALU_ADD = 0.U(4.W)
    val ALU_SUB = 8.U(4.W)
    val ALU_AND = 7.U(4.W)
    val ALU_OR  = 6.U(4.W)
    val ALU_XOR = 4.U(4.W)
    val ALU_SLT = 2.U(4.W)
    val ALU_SLL = 1.U(4.W)
    val ALU_SLTU= 3.U(4.W)
    val ALU_SRL = 5.U(4.W)
    val ALU_SRA = 13.U(4.W)
}

 object Branch {
  val ALU_Beq = 0.U(4.W)
  val ALU_Bne = 1.U(4.W)
  val ALU_Blt = 4.U(4.W)
  val ALU_Bge = 5.U(4.W)
  val ALU_Bltu = 6.U(4.W)
  val ALU_Bgeu = 7.U(4.W)
}

import Branch._  
import ALUOP._

class ALUIO extends Bundle{
    val opcode= Input(UInt(7.W))
    val in_A = Input(SInt(32.W))
    val in_B = Input(SInt(32.W))
    val alu_Op = Input(UInt(4.W))
    val out = Output(SInt(32.W))
}

class ALU extends Module  {
    val io = IO(new ALUIO)
    io.out := 0.S
     //AND
      when((io.opcode === "b0110011".U) || (io.opcode === "b0010011".U)) {
     when (io.alu_Op === ALU_ADD ) {
        io.out := io.in_A + io.in_B
    } // OR
     .elsewhen(io.alu_Op === ALU_OR ) {
        io.out := io.in_A | io.in_B
    } // ADD
    .elsewhen(io.alu_Op ===  ALU_AND ) {
        io.out := io.in_A & io.in_B
    } // SUB
    .elsewhen(io.alu_Op ===  ALU_SUB) {
        io.out := io.in_A - io.in_B
    } // XOR
    .elsewhen(io.alu_Op === ALU_XOR) {
        io.out := io.in_A ^ io.in_B
    } // SLL
    .elsewhen(io.alu_Op === ALU_SLL) {
        io.out := io.in_A << io.in_B(4,0)
    } // SRL
    .elsewhen(io.alu_Op === ALU_SRL) {
       io.out := io.in_A >> io.in_B(4,0)
    } // SRA
    .elsewhen(io.alu_Op === ALU_SRA) {
      io.out := io.in_A >> io.in_B(4,0)
    } // SLT
    .elsewhen(io.alu_Op === ALU_SLT) {
      io.out := (io.in_A < io.in_B).asSInt
    } // SLTU
    .elsewhen(io.alu_Op ===  ALU_SLTU) {
      io.out := ((io.in_A < io.in_B).asUInt).asSInt
    }
 }
    // load address calculation
    .elsewhen(io.opcode === "b0000011".U) { //offset+ baseaddress
      io.out := io.in_A+io.in_B
    }
     //jalr 
    .elsewhen(io.opcode === "b1100111".U) { //in_B=imm + in_A=returnAddress
      io.out := io.in_A + io.in_B 
    }
    
    
    //branch  
    .elsewhen(io.opcode ==="b1100011".U){
    switch (io.alu_Op) {
    is(ALU_Beq) { // BEQ
       io.out:=(io.in_A === io.in_B).asSInt 
    }
    is(ALU_Bne) { // BNE
     io.out:=Mux(io.in_A =/= io.in_B, 1.S, 0.S)
    }
    is(ALU_Blt){ //blt
       io.out:=(io.in_A < io.in_B ).asSInt
    }
    is (ALU_Bge){ //bge
       io.out:=(io.in_A >= io.in_B).asSInt
   }
   is (ALU_Bltu){ //bltu
       io.out:=(io.in_A.asUInt < io.in_B.asUInt).asSInt   
   }
   is(ALU_Bgeu){ //bgeu
       io.out:=(io.in_A.asUInt >= io.in_B.asUInt).asSInt
   }
  }
    }
}
