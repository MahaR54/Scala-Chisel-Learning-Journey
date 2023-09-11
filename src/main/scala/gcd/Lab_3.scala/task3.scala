package Lab_3
import chisel3 . _
import chisel3 . util . _
class task3 extends Bundle {
val in = Input ( UInt (2. W ) )
val out = Valid ( Output ( UInt (4. W ) ) )
}
class decoder_with_valid extends Module {
val io = IO ( new task3 )

io.out.valid := false.B // Initialize valid signal to false
  io.out.bits := 0.U      // Initialize output bits to 0

when ( io . in === " b00 " . U ) {
 io.out.bits := " b0001 " . U
 io.out.valid := true.B
} .elsewhen ( io . in === " b01 " . U ) {
 io.out.bits := " b0010 " . U
 io.out.valid := true.B
} .elsewhen ( io . in === " b10 " . U ) {
 io.out.bits:= " b0100 " . U
 io.out.valid := true.B
} .otherwise {
 io.out := " b1000 " . U
 io.out.valid := true.B
}
}
