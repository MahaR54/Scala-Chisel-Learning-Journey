package SingleCycle_IR
import chisel3._
import chisel3.util._ 

object Store_op{
    val Store_B = 0.U(3.W)
    val Store_H = 1.U(3.W)
    val Store_W = 2.U(3.W)
}
import Store_op._

class Store extends Module {
    val io = IO ( new Bundle {
        val adr=Input(UInt(10.W))
        val fun3 = Input(UInt(3.W))
        val in = Input(UInt(32.W))
        val out = Output(Vec(4, UInt(32.W)))
        val mask = Output(Vec(4, UInt(32.W)))
    })
    io.out(0) := 0.U
    io.out(1) := 0.U
    io.out(2) := 0.U
    io.out(3) := 0.U

    io.mask(0):=0.B
    io.mask(1):=0.B
    io.mask(2):=0.B
    io.mask(3):=0.B
     val pc = RegInit (0.U(32.W))
     when(io.fun3 === Store_B){
        when(io.adr(1,0)===0.U){
        io.out(0) := (io.in(7,0))
        io.out(1) := 0.U
        io.out(2) := 0.U
        io.out(3) := 0.U

     }
      when(io.adr(1,0)===1.U){
        io.out(1) := (io.in(7,0))
        io.out(0) := 0.U
        io.out(2) := 0.U
        io.out(3) := 0.U

     }
      when(io.adr(1,0)===2.U){
        io.out(2) := (io.in(7,0))
        io.out(0) := 0.U
        io.out(1) := 0.U
        io.out(3) := 0.U

     }
      when(io.adr(1,0)===3.U){
        io.out(3) := (io.in(7,0))
        io.out(0) := 0.U
        io.out(1) := 0.U
        io.out(2) := 0.U
     }
    }
      when(io.fun3 === Store_H){
        when(io.adr(1,0)===0.U){
        io.out(0) := io.in(7,0)
        io.out(1) := io.in(15,8)
        io.out(2) := 0.U
        io.out(3) := 0.U

     }
      when(io.adr(1,0)===1.U){
        io.out(1) := io.in(7,0)
        io.out(2) := io.in(15,8)
        io.out(0) := 0.U
        io.out(3) := 0.U
     }
      when(io.adr(1,0)===2.U){
        io.out(2) := io.in(7,0)
        io.out(3) := io.in(15,8)
        io.out(0) := 0.U
        io.out(1) := 0.U
     }
      when(io.adr(1,0)===3.U){
        io.out(3) := io.in(7,0)
        io.out(0) := io.in(15,8)
        io.out(1) := 0.U
        io.out(2) := 0.U

     }
    }
      when(io.fun3 === Store_W){
        io.out(0) := io.in(7,0)
        io.out(1) := io.in(15,8)
        io.out(2) := io.in(7,0)
        io.out(3) := io.in(15,8)

     }

       
when(io.fun3 === Store_B) {
    when(io.adr(1,0) === 0.U) {
      io.mask(0) := 1.B
      io.mask(1) := 0.B
      io.mask(2) := 0.B
      io.mask(3) := 0.B
    }

    when(io.adr(1,0) === 1.U) {
      io.mask(0) := 0.B
      io.mask(1) := 1.B
      io.mask(2) := 0.B
      io.mask(3) := 0.B
    }

    when(io.adr(1,0) === 2.U) {
      io.mask(0) := 0.B
      io.mask(1) := 0.B
      io.mask(2) :=1.B
      io.mask(3) := 0.B

    }
    when(io.adr(1,0) === 3.U) {
      io.mask(0) := 0.B
      io.mask(1) := 0.B
      io.mask(2) := 0.B
      io.mask(3) := 1.B
    }
  }

  when(io.fun3 === Store_H) {
    when(io.adr(1,0) === 0.U) {
      io.mask(0) :=1.B
      io.mask(1) := 1.B
      io.mask(2) := 0.B
      io.mask(3) := 0.B
    }

    when(io.adr(1,0) === 1.U) {
      io.mask(0) := 0.B
      io.mask(1) := 1.B
      io.mask(2) := 1.B
      io.mask(3) := 0.B
    }

    when(io.adr(1,0) === 2.U) {
      io.mask(0) := 0.B
      io.mask(1) := 0.B
      io.mask(2) :=1.B
      io.mask(3) := 1.B
    }
   
    when(io.adr(1,0) === 3.U) {
      io.mask(0) := 1.B
      io.mask(1) := 0.B
      io.mask(2) := 0.B
      io.mask(3) := 1.B
    }
  
  }
  when(io.fun3 === Store_W) {
      io.mask(0) :=1.B
      io.mask(1) := 1.B
      io.mask(2) := 1.B
      io.mask(3) := 1.B
  }
}