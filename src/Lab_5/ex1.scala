package Lab_5
import chisel3._
import chisel3.util._
// import chisel3.iotesters.{Driver,PeekPokeTester}

  class ex1 ( width:Int ) extends Bundle {
       val alu_oper = Input ( UInt ( width.W ) )
       val arg_x = Input ( UInt ( width.W ) )
       val arg_y = Input ( UInt ( width.W ) )
       val alu_out = Output ( UInt ( width.W ) )
    }
  class ALU ( width_parameter : Int ) extends Module {
    val io = IO ( new ex1( width_parameter ) )
    io.alu_out := 0.U
    val index = log2Ceil ( width_parameter )
   
    // AND
    when (io.alu_oper === "b0000".U ) {
        io.alu_out := io.arg_x & io.arg_y
    } // OR
      when (io.alu_oper ===  "b0001".U ) {
        io.alu_out := io.arg_x | io.arg_y
    } // ADD
    when (io.alu_oper ===  "b0010".U ) {
        io.alu_out := io.arg_x + io.arg_y
    } // SUB
    when (io.alu_oper ===  "b0110".U ) {
        io.alu_out := io.arg_x - io.arg_y
    } // XOR
    when (io.alu_oper === "b0011".U ) {
        io.alu_out := io.arg_x ^ io.arg_y
    } // SLL
    when (io.alu_oper === "b0100".U ) {
        io.alu_out := io.arg_x << io.arg_y(4,0)
    } // SRL
    when (io.alu_oper === "b0101".U ) {
       io.alu_out := io.arg_x << io.arg_y(4,0)
    } // SRA
    when (io.alu_oper === "b0111" . U ) {
    io . alu_out := io.arg_x >> io.arg_y(4,0)
    } // SLT
    when (io.alu_oper === "b1000" . U ) {
    io . alu_out := io.arg_x < io.arg_y
    } // SLTU
    when (io.alu_oper ===  "b1001" . U ) {
    io . alu_out := io.arg_x < io.arg_y
    }
    }
    
