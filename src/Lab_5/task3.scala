package Lab_5
import chisel3.util._
import chisel3._

class EMuxInclusive extends Module {
  val io = IO(new Bundle {
    val inputA = Input(Bool())
    val inputB = Input(UInt(32.W))
    val select = Input(Bool())
    val output = Output(UInt(32.W))
  })

  when(io.select) {
    io.output := io.inputB
  } .otherwise {
    io.output := io.inputA
  }
}
