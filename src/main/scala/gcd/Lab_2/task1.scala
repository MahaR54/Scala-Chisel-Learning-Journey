package Lab_2
import chisel3._
import chisel3.util._ 
class task1 extends Bundle {
    val s0 = Input (Bool())
    val s1 = Input (Bool())
    val s2 = Input (Bool())
    val out = Output (UInt(32.W))
    
}
class MuxLookups extends Module {
val io = IO ( new task1 )
    val address = Cat ( io.s2, io.s1, io.s0 )
    io.out := MuxLookup (address , 0.U , Array (
        "b000".U -> 0.U,
        "b001".U -> 8.U,
        "b010".U -> 16.U,
        "b011".U -> 24.U,
        "b111".U -> 32.U
    ))
}
