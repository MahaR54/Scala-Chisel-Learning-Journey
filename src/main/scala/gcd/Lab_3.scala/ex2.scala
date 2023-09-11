 package Lab_3
import chisel3._
import chisel3.util._

class ex2 extends Module {
  val io = IO(new Bundle {
    val in_A = Input(UInt(32.W))
    val in_B= Input(UInt(32.W))
    val alu_Op = Input(UInt(4.W))
    val out = Output(UInt(32.W))
  })
  object ALUOP{
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
  io.out := 0.U
  }
  import ALUOP._

  // ALU operations using switch and is statements
  switch(io.alu_Op) {
    is(ALU_ADD) { io.out := io.in_A + io.in_B} // ADD
    is(ALU_SUB) { io.out := io.in_A - io.in_B} // SUB
    is(ALU_AND) { io.out := io.in_A & io.in_B} // AND
    is(ALU_OR) { io.out := io.in_A | io.in_B} // OR
    is(ALU_XOR) { io.out := io.in_A ^ io.in_B} // XOR
    is(ALU_SLT) { io.out := io.in_A < io.in_B}
    is(ALU_SLL){io.out := (io.in_A << io.in_B(4,0)).asUInt}
    is(ALU_SLTU){io.out := io.in_A.asUInt   < io.in_B.asUInt}
    is(ALU_SRL){io.out := (io.in_A >> io.in_B(4,0)).asUInt}
    is(ALU_SRA){io.out := (io.in_A >> io.in_B(4,0)).asUInt}
    is(ALU_COPY_A){io.out := io.in_A}
    is (ALU_COPY_B){io.out := io.in_B}
  }
}
// import chisel3._
// import chisel3.util._
// object ALU_OP{
//   val ADD = 0.U(5.W)
//   val SUB = 1.U(5.W)
//   val AND = 2.U(5.W)
//   val OR = 3.U(5.W)
//   val XOR = 4.U(5.W)
//   val SLT = 5.U(5.W)
//   val SLL = 6.U(5.W)
//   val SLTU = 7.U(5.W)
//   val SRL = 8.U(5.W)
//   val SRA = 9.U(5.W)
//   val COPY_A = 10.U(5.W)
//   val COPY_B = 11.U(5.W)
//   val XXX = 15.U(5.W)
// }
// import ALU_OP._
// class ex2 extends Module {
//   val io = IO(new Bundle {
//     val Opcode = Input(UInt(7.W))
//     val A = Input(UInt(32.W))
//     val B = Input(UInt(32.W))
//     val out = Output(UInt(32.W))
//   })

//   io.out := 0.U

//   switch(io.Opcode) {
//     is(ADD) {
//       io.out := (io.A + io.B).asUInt
//     }
//     is(SUB) {
//       io.out := (io.A - io.B).asUInt
//     }
//     is(AND) {
//       io.out := (io.A & io.B).asUInt
//     }
//     is(OR) {
//       io.out := (io.A | io.B).asUInt
//     }
//     is(XOR) {
//       io.out := (io.A ^ io.B).asUInt
//     }
//     is(SLT) {
//       io.out := Mux(io.A < io.B, 1.U, 0.U)
//     }
//     is(SLL) {
//       val shift = io.B(4, 0)
//       io.out := (io.A<< shift).asUInt
//     }
//     is(SLTU) {
//       io.out := Mux(io.A.asUInt < io.B.asUInt, 1.U, 0.U)
//     }
//     is(SRL) {
//       val shift = io.B(4, 0)
//          io.out := (io.A>> shift).asUInt
//     }
//     is(SRA) {
//       val shift = io.B(4, 0)
//       io.out :=  (io.A>> shift).asUInt
//     }
//     is(COPY_A) {
//       io.out := io.A.asUInt
//     }
//     is(COPY_B) {
//       io.out := io.B.asUInt
//     }
//   }
// }
 