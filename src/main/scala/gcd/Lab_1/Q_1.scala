package Lab_1
import chisel3._
import chisel3.util._

class Q_1 ( counterBits : SInt ) extends Module { // Counter
    val io = IO ( new Bundle {
    val result = Output(SInt(32.W))
    })

    val max = (1.U << counterBits.asUInt) - 1.U
    val count = RegInit (0.S (16.W ) )
    // result := 0.B

    when ( count.asUInt === max ) {
    count := 0.S
    io.result := 1.B
    }.otherwise {
    count := count + 1.S
    }
    io.result := count
}
