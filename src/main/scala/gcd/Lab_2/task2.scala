package Lab_2
import chisel3._
import chisel3.util._

class task2 extends Module{
    val io =IO(new Bundle{
        val in=Vec(4,Input(Bool()))
        val s=Vec(2,Input(Bool()))
        val shift=Input(Bool())
        val out=Vec(4,Output(Bool()))
    })
io.out(0):= Mux(io.s(0),Mux(io.s(1),io.in(3),io.in(2)),Mux(io.s(1),io.in(1),io.in(0)))
io.out(1):= Mux(io.s(0),Mux(io.s(1),Mux(io.shift,io.in(0),0.U),io.in(2)),Mux(io.s(1),io.in(1),io.in(0)))
io.out(2):= Mux(io.s(0),Mux(io.s(1),Mux(io.shift,io.in(1),0.U),Mux(io.shift,io.in(0),0.U)),Mux(io.s(1),io.in(1),io.in(0)))
io.out(3):= Mux(io.s(0),Mux(io.s(1),Mux(io.shift,io.in(2),0.U),Mux(io.shift,io.in(1),0.U)),Mux(io.s(1),Mux(io.shift,io.in(0),0.U),io.in(0)))


}