package Lab_6
import chisel3._
import chisel3.util._

import chisel3._
import chisel3.util._

class MyModule extends Module {
  val io = IO(new Bundle {
    val in1 = Flipped(Decoupled(UInt(8.W))) // Input interface for queue 1
    val in2 = Flipped(Decoupled(UInt(8.W))) // Input interface for queue 2
    val out1 = Decoupled(UInt(8.W))        // Output interface for queue 1
    val out2 = Decoupled(UInt(8.W))        // Output interface for queue 2
  })

  // Queue for input 1
  val queue1 = Module(new Queue(UInt(8.W), 5))
  queue1.io.enq <> io.in1
  io.out1 <> queue1.io.deq

  // Queue for input 2
  val queue2 = Module(new Queue(UInt(8.W), 5))
  queue2.io.enq <> io.in2
  io.out2 <> queue2.io.deq
}


// class MyQueue extends Module{
//         val io = IO (new Bundle {
//             val in = Flipped(Decoupled(UInt(8.W))) // valid = Input , ready = Output , bits = Input
//             val out = Decoupled( UInt(8.W))// valid = Output , ready = Input , bits = Output
//         })
//         val queue = Queue ( io . in , 5) // 5 - element queue
//         io . out < > queue
// }
   

// class MyModule extends Module {
//   val io = IO(new Bundle {
//     val in1 = new MyQueue
//     val in2 = new MyQueue
//     val out1 = new MyQueue
//     val out2 = new MyQueue
//   })

//   // Create instances of MyQueue for the two queues
//   val queue1 = Module(new MyQueue)
//   val queue2 = Module(new MyQueue)

//   // Connect the input interfaces to the queues
//   queue1.io.in <> io.in1
//   queue2.io.in <> io.in2

//   // Connect the output interfaces to the queues
//   io.out1 <> queue1.io.out
//   io.out2 <> queue2.io.out
// }


// import chisel3._ 
// import chisel3.util._

// class DInterface extends Bundle{
//     val ready = Output(Bool())
//     val valid = Input(Bool())
//     val data = Output(UInt(8.W))
// }

// class MyQueue extends Bundle {
//   val ready = Output(Bool())
//   val valid = Input(Bool())
//   val data = Output(UInt(8.W))
// }

// class MyQueue extends Module {
//   val io = IO(new Bundle {
//     val in = Flipped(new MyQueue)
//     val out = new MyQueue
//   })

//   val queue = Queue(io.in, 5) // Create a queue with depth 5

//   io.out <> queue
// }