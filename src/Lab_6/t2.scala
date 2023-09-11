package Lab_6
import chisel3._
import chisel3.util._ 

class UpDownCounter extends Module {
  val io = IO(new Bundle {
    val upDown = Input(Bool())
    val count = Output(UInt(4.W)) // Adjust the width as needed
  })

  val counter = RegInit(0.U(4.W)) // Adjust the width as needed

  when(io.upDown) {
    // Count up when upDown is 1
    counter := counter + 1.U
  }.otherwise {
    // Count down when upDown is 0
    counter := counter - 1.U
  }

  io.count := counter
}
