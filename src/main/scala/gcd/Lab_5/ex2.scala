package Lab_5

import chisel3._
import chisel3.util._

class ex2[T <: Data](gen: T) extends Bundle {
  val out = Output(gen)
  val in1 = Input(gen)
  val in2 = Input(gen)
  val sel = Input(Bool())
}

class eMux[T <: Data](gen: T) extends Module {
  val io = IO(new ex2(gen))

  io.out := Mux(io.sel, io.in2, io.in1)
  }

