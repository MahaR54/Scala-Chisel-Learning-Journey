package SingleCycle_IR
import chisel3._
import chisel3.util._ 

class Pc  extends Module {
    val io = IO ( new Bundle {
        val enb = Input(Bool())
        val in = Input(UInt(32.W))
        val out = Output(UInt(32.W))
    })
     val pc = RegInit (0.U(32.W))
     val pc_buffer = Mux(io.enb, io.in , pc+io.in)
     pc := pc_buffer
     io.out := pc
}
