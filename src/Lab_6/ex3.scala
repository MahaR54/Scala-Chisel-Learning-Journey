package Lab_6
import chisel3._ 
import chisel3.util._

class ex3 extends Module{
    val io= IO(new Bundle{
        val din = Input(Bool())
        val reload = Input(Bool())
        val state = Input(Bool())
    })

val timer_count = RegInit(0.U(8.W))
val done = timer_count === 0.U
val reload = WireInit(false.B) // You need to define the reload condition based on your design.
val next = WireInit(0.U(8.W))
val reload_value = RegInit(0.U(8.W)) // This is the value to reload for the second shot.

when(reload) {
  next := io.din
  timer_count := next
}.elsewhen(!done) {
  next := timer_count - 1.U
  timer_count := next
}.elsewhen(done && reload) {
  next := reload_value
  timer_count := next
}

// Update the reload_value when needed.
// when(reload_condition_for_reload_value) {
//   reload_value := new_reload_value
// }
// // one shot timer implementation
// val timer_count1 = RegInit (0.U (8.W))
// val timer_count2 = RegInit (0.U (8.W))
// val done = timer_count1 === 0.U
// val next = WireInit (0.U )
// when ( reload ) {
// next := din
// }
// .elsewhen (!done ) {
// next := timer_count1 - 1.U
// }
// timer_count1 := next
// }
}