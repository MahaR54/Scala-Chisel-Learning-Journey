package Lab_2
import chisel3._
import chisel3.util._

// Mux IO interface class
class ex1 extends Bundle {
  val in_A = Input(UInt(32.W))
  val in_B = Input(UInt(32.W))
  val select = Input(Bool())
  val out = Output(UInt())
}

// 2 to 1 Mux implementation
class Mux_2to1 extends Module {
  val io = IO(new ex1)
  
  // when(io.select) {
  //   io.out := io.in_A
  // }.otherwise {
  //   io.out := io.in_B
  // }
  io . out := io . in_A & (~Fill(32,io . select)) | io . in_B & Fill(32,io . select) 
}