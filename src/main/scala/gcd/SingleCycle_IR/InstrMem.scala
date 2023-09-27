package SingleCycle_IR
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

class InstMem(File:String ) extends Module {
  val io = IO(new Bundle {
    val address = Input(UInt(32.W))
    val data_in = Input(SInt(32.W))
    val enb = Input(Bool())
    val data_out = Output(UInt(32.W))
  })

  val mem = Mem(1024, UInt(32.W))
    // dontTouch(memory)

  loadMemoryFromFile(mem, File)
//   when(io.enb){
//     mem.write(io.address)
//     io.data_out := mem(io.address)

//   }
//   io.data_out := mem(io.address)
  io.data_out := mem(io.address>>2.U)// 1000=>10
}
