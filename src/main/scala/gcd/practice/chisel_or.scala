package practice
import chisel3._
import chisel3.util._

class chisel_or extends Module{
    val io = IO(new Bundle {
        val a = Input(UInt(3.W))
        val b = Input(UInt(3.W))
        val o = Output(UInt(3.W))
    })

    io.o := io.a | io.b
}
