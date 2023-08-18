package Lab_3
import chisel3._
import chisel3.util._

class ex2 extends Module {
  val io = IO(new Bundle {
    val op1 = Input(UInt(32.W))
    val op2 = Input(UInt(32.W))
    val aluOp = Input(UInt(4.W))
    val result = Output(UInt(32.W))
  })
val ALU_ADD = 0.U (4. W )
val ALU_SUB = 1.U (4. W )
val ALU_AND = 2.U (4. W )
val ALU_OR = 3.U (4. W )
val ALU_XOR = 4.U (4. W )
val ALU_SLT = 5.U (4. W )
val ALU_SLL = 6.U (4. W )
val ALU_SLTU = 7.U (4. W )
val ALU_SRL = 8.U (4. W )
val ALU_SRA = 9.U (4. W )
val ALU_COPY_A = 10.U (4. W )
val ALU_COPY_B = 11.U (4. W )
  io.result := 0.U

  // ALU operations using switch and is statements
  switch(io.aluOp) {
    is(ALU_ADD) { io.result := io.op1 + io.op2 } // ADD
    is(ALU_SUB) { io.result := io.op1 - io.op2 } // SUB
    is(ALU_AND) { io.result := io.op1 & io.op2 } // AND
    is(ALU_OR) { io.result := io.op1 | io.op2 } // OR
    is(ALU_XOR) { io.result := io.op1 ^ io.op2 } // XOR
    is(ALU_SLT) { io.result := io.op1 < io.op2 }
    is(ALU_SLL){io.result := io.op1 << io.op2}
    is(ALU_SLTU){io.result := io.op1.asUInt   < io.op2.asUInt}
    is(ALU_SRL){io.result := io.op1 >> io.op2}
    is(ALU_SRA){io.result := io.op1 >> io.op2}
    is(ALU_COPY_A){io.result := io.op1}
    is (ALU_COPY_B){io.result := io.op2}
  }
}
