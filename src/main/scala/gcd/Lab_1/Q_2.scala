package Lab_1
import chisel3._
import chisel3.util._

class Q_2(counterBits: UInt) extends Module{
    val io = IO (new Bundle{
        val result = Output(Bool())
    })

    val count = RegInit (0.U(8.W))

    when (count.getWidth.U - 1.U === 0.U){
        count := 0.U
    }.otherwise
    {
        count := count + 1.U
    }
}