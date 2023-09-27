package SingleCycle_IR
import chisel3._
import chisel3.util._
object ALUPOimm{
    val ALU_I="b0010011".U(32.W)
    val ALU_S="b0100011".U(32.W)
    val ALU_B="b1100011".U(32.W)
    val ALU_U="b0110111".U(32.W)
    val ALU_L="b0000011".U(32.W)
    val ALU_J="b1101111".U(32.W)
    val JAL_R="b1100111".U(32.W)    
    // val aui_pc="b0010111".U(32.W)

}
   
import ALUPOimm._
class ImmGen extends Module{
    val io =IO(new Bundle{
        val ins=Input(UInt(32.W))
        val imm=Output(SInt(32.W))
    })
    io.imm:=0.S
     switch(io.ins(6,0)){
        is(ALU_I){    //I-format
            io.imm:= Cat(Fill(20, io.ins(31)),io.ins(31,20)).asSInt
        }
        is(ALU_S){      //S-format
            io.imm:= (Cat(Fill(20, 0.U),Cat(io.ins(31,24),io.ins(12,7)))).asSInt
        }
        is(ALU_B){      //B-format
            io.imm:= (Cat(Cat(io.ins(31),io.ins(7)),Cat(io.ins(30,25),io.ins(11,8)))).asSInt
        }
        is(ALU_U){      //U-format
            io.imm:= Cat(Fill(12,io.ins(31)),io.ins(31,12)).asSInt
        }
        is(ALU_L){      //L-format
            io.imm:= (Cat(Fill(20, 0.U),io.ins(31,20))).asSInt
        }
        is(ALU_J){      //J-format
            io.imm:= Cat(Fill(11,io.ins(31)),io.ins(31),io.ins(19,12),io.ins(20),io.ins(30,21),0.U).asSInt  
        }
        is(JAL_R){ 
            io.imm:= Cat(Fill(20,io.ins(31)),io.ins(31,20)).asSInt //31(MSB) signed
        }
        // lui takes upper imm
        // auipc takes upper imm and add rd wd pc
        // is(aui_pc){
        //      io.imm:=Cat(Fill(20,0.U),io.ins(31,12)).asSInt
        // }
     }
}