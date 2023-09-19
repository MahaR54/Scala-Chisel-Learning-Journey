package SingleCycle_IR
import chisel3._
import chisel3.util._ 

class RagFile extends Module {
    val io = IO ( new Bundle {
        val rs1 = Input(UInt(5.W))
        val rs2 = Input(UInt(5.W))
        val rd = Input(UInt(5.W))
        val Wback = Input(SInt(32.W)) //write back
        val writeEnable =Input(Bool())
    
        val read_rs1 = Output(SInt(32.W))
        val read_rs2 = Output(SInt(32.W))
    })
    val regs =Reg(Vec(32,SInt( 32.W)))
    when (io.rs1.orR){
        io.read_rs1 := regs(io.rs1)
    }.otherwise{
        io.read_rs1 := 0.S
    }

    when(io.rs2.orR){
        io.read_rs2 := regs(io.rs2)
    }.otherwise{
        io.read_rs2 := 0.S
    }

    when(io.writeEnable===1.B && io.rd.orR){
        regs(io.rd) := io.Wback // combinational mai otherwise na bhi likhentw woh chalega q kai woh previous value deta ha

    }
}
