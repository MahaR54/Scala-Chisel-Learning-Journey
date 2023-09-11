package Lab_5
import chisel3 . _
import chisel3 . util . _

class Transaction_in[T <: Data](gen: T) extends Bundle {
  val data = gen.cloneType
  val address = Input(UInt (32.W))
  val output = Output (UInt (32.W))
}

class Transaction_out[T <: Data](gen: T) extends Bundle {
  val data = gen.cloneType
  val address = Input(UInt (32.W))
  val output = Output (UInt (32.W))
}

class Router[T <: Data](gen: T) extends Module {
  val io = IO(new Bundle {
    val in = new Transaction_in(gen)
    val out = new Transaction_out(gen)
  })

  // Router logic the router simply passes packets from input to output
  io.out.address:= io.in.address
  io.out.data := io.in.data
  io.out.output := io.in.output

}

