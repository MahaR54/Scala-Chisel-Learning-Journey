// shift register example
package Lab_6
import chisel3._
import chisel3.util._ 

class shift_register ( val init : Int = 1) extends Module {
    val io = IO ( new Bundle {
        val sel = Input(Bool())
        val in = Input (Bool())
        val out = Output (UInt(4.W))
    })
    val state = RegInit (init.U(4.W))
// register initialization
// parallel datain at MSB
   when(io.sel === 0.U){
    state := io.in
   }.otherwise{
    val next = state >> 1
    state := next
   }
   io.out := state
//    // serial data in at LSB
//     val nextState = ( state < < 1) | io . in
//         state := nextState
//         io . out := state
}