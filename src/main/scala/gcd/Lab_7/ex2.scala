package Lab_7
import chisel3._
import chisel3.util._
import chisel3.stage.ChiselStage
import chisel3.experimental.ChiselEnum

 class Manchester extends Bundle{
    val in = Input(UInt(1.W))
    val start = Input(Bool())
    val out = Output(UInt(8.W))
    val flag = Output(UInt(1.W))
 }

object States extends ChiselEnum {
    val IDLE, BIT_0, BIT_1 = Value
  }

 import States._
class Manchester_Decoding extends Module {
  val io = IO(new Manchester)

  // Register to hold the decoded 8-bit data
  val dataReg = RegInit(0.U(8.W))
  val stateReg = RegInit(States.IDLE)
 

  // State transition logic
  switch(stateReg) {
    is(IDLE) {
      when(io.start) {
        stateReg := BIT_0
      }
    }
    is(BIT_0) {
      when(io.in === 0.U) {
        stateReg := BIT_1
      }
    }
    is(BIT_1) {
      when(io.in === 1.U) {
        stateReg := BIT_0
        dataReg := Cat(dataReg(6, 0), io.in)
      }
    }
  }

  // Output logic
  io.out := dataReg
  io.flag := stateReg === IDLE

  // Sample on the positive edge of the clock
  when(RegNext(io.start, false.B) && io.start) {
    dataReg := 0.U // Reset the data register on a new start signal
  }
}
