package SingleCycle_IR
import chisel3._
import chisel3.util._ 

object Load_op{
    val Load_B = 0.U(3.W)
    val Load_H = 1.U(3.W)
    val Load_W = 2.U(3.W)
    val Load_BU = 4.U(3.W)
    val Load_HU = 5.U(3.W)
}
import Load_op._

class Load extends Module {
    val io = IO ( new Bundle {
        val fun3 = Input(UInt(3.W))
        val in = Input(Vec(4,UInt(8.W)))
        val out = Output(SInt(32.W))
        val adr = Input(UInt(2.W))
    })
    io.out := 0.S
     val pc = RegInit (0.U(32.W))
     when(io.fun3 === Load_B){
      when(io.adr===0.U){
        io.out := Cat(Fill(24,(io.in(0))(7)),io.in(0)).asSInt
     }.elsewhen(io.adr===1.U){
        io.out := Cat(Fill(24,(io.in(1))(7)),io.in(1)).asSInt
     }.elsewhen(io.adr===2.U){
        io.out := Cat(Fill(24,(io.in(2))(7)),io.in(2)).asSInt
     }.elsewhen(io.adr===3.U){
        io.out := Cat(Fill(24,(io.in(3))(7)),io.in(3)).asSInt
     }
    }.elsewhen(io.fun3 === Load_H){
        when(io.adr===0.U){
          val temp = Cat(io.in(1),io.in(0))
          io.out := Cat(Fill(16,temp(15)),temp).asSInt
        }.elsewhen(io.adr===1.U){
          val temp = Cat(io.in(2),io.in(1))
          io.out := Cat(Fill(16,temp(15)),temp).asSInt
        }.elsewhen(io.adr===2.U){
          val temp = Cat(io.in(3),io.in(2))
          io.out := Cat(Fill(16,temp(15)),temp).asSInt
        }.elsewhen(io.adr===3.U){
          val temp = Cat(io.in(0),io.in(3))
          io.out := Cat(Fill(16,temp(15)),temp).asSInt
        }
    }.elsewhen(io.fun3 === Load_W){
        io.out := Cat((io.in(3)),(io.in(2)),(io.in(1)),(io.in(0))).asSInt
    }.elsewhen(io.fun3 === Load_BU){
        when(io.adr===0.U){
        io.out := (Cat(Fill(24,(io.in(0))(7)),io.in(0)).asUInt).asSInt
      }.elsewhen(io.adr===1.U){
        io.out := (Cat(Fill(24,(io.in(1))(7)),io.in(1)).asUInt).asSInt
      }.elsewhen(io.adr===2.U){
        io.out := (Cat(Fill(24,(io.in(2))(7)),io.in(2)).asUInt).asSInt
      }.elsewhen(io.adr===3.U){
        io.out := (Cat(Fill(24,(io.in(3))(7)),io.in(3)).asUInt).asSInt
      }
    }.elsewhen(io.fun3 === Load_HU){        
         when(io.adr===0.U){
          val temp = Cat(io.in(1),io.in(0))
          io.out := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
        }.elsewhen(io.adr===1.U){
          val temp = Cat(io.in(2),io.in(1))
          io.out := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
        }.elsewhen(io.adr===2.U){
          val temp = Cat(io.in(3),io.in(2))
          io.out := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
        }.elsewhen(io.adr===3.U){
          val temp = Cat(io.in(0),io.in(3))
          io.out := (Cat(Fill(16,temp(15)),temp).asUInt).asSInt
        }
      }
}
