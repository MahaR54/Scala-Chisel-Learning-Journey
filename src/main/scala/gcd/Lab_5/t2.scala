package Lab_5
import chisel3 . _
import chisel3 . util . _
// import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
class ex4 ( width:Int ) extends Bundle {
       val in0 = Input (UInt (width.W))
       val in1 = Input (UInt (width.W))
       val sum = Output (UInt (width.W))
}
class Adder (Width_P:Int) extends Module {
     val io = IO(new ex4(Width_P))
     require (Width_P >= 0)
     io.sum := io.in0 + io.in1
  }
