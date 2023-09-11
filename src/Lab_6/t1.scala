package Lab_6
import chisel3._
import chisel3.util._

class XORCounter(val maxCount: Int =1) extends Module {
  val io = IO(new Bundle {
    // val enable = Input(Bool())
    // val reset = Input(Bool())
    val count = Output(UInt((log2Ceil(maxCount)).W))
  })

  val counter = RegInit(0.U((log2Ceil(maxCount)).W)) //determines the bit width of the register. log2Ceil() calculates the smallest power of 2

  when(counter((log2Ceil(maxCount))- 1) ^ 1.B){
 
      // XOR the MSB with 1 to reset the counter
      counter := counter + 1.U // 01011011 ^ 00000001 = 01011010. flips on same op
    //   counter := 0.U
    }.otherwise {
      counter := 0.U
    }

  io.count := counter
}

