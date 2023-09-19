package SingleCycle_IR
import chisel3._ 
import chisel3.util._ 

class CU extends Module{
    var io=IO(new Bundle{
        val inst=Input(UInt(32.W))
        val rs1=Output(UInt(5.W))
        val rs2=Output(UInt(5.W))
        val rd=Output(UInt(5.W))
        val fun3_7=Output(UInt(4.W))
        val WB=Output(Bool())
        val load=Output(Bool())
        val store=Output(Bool())
        // val auipc=Output(UInt(32.W))
        val jump_pc=Output(Bool())

    })

    io.rd:=io.inst(11,7)
    io.rs1:=io.inst(19,15)
    io.rs2:=io.inst(24,20)

    //i-type mai hi funct3 aur 7 check hota baqi sb mai sirf func3 deekhte
    io.fun3_7:=Mux(io.inst(6,0)==="b0110011".U,Cat(io.inst(30),io.inst(14,12)),io.inst(14,12))
    io.WB := 0.B
    // store aur branch mai wback nhi hota for regfile
    // io.WB := Mux((io.inst(6,0)==="b0100011".U) || (io.inst(6,0)==="b1100011".U), 1.U, 0.U)
    when( (io.inst(6,0) === "b0110011".U) ||
     (io.inst(6,0) === "b0010011".U)||
      (io.inst(6,0)==="b0000011".U) || 
      (io.inst(6,0)==="b0110111".U) ||
      (io.inst(6,0)==="b1101111".U)|| 
      (io.inst(6,0)==="b0010111".U) )
    {
        io.WB := 1.B
    }.otherwise{
        io.WB := 0.B
    }

    //load and store pin for datamemory
    io.load:=Mux(io.inst(6,0)=== "b0000011".U, 1.B, 0.B)
    io.store:=Mux(io.inst(6,0)=== "b0100011".U, 1.B, 0.B)

    // io.auipc:=(Cat(Fill(20,0.U),io.ins(31,12))).asUInt

    io.jump_pc := Mux(io.inst(6,0)==="b1100111".U, 1.B, 0.B) //enablepin to jump
    
}