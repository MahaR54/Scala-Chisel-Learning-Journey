package Lab_5
import chisel3._
import chisel3.util._

// class definition with function as parameter
    class Operator [ T <: Data ]( n:Int, generic:T ) ( op:(T,T) => T ) extends Module {
      require (n > 0) // " reduce only works on non - empty Vecs "
      val io = IO ( new Bundle {
      val in = Input ( Vec (n , generic ) )
      val out = Output ( Vec (n-1, generic ))
    })
     // Apply the operation to each input bit and assign the results to the output vector
  for (i <- 0 until n-1) {
    io.out(i) := op(io.in(i), io.in(i+1))
  }
      // io.out := io.in.reduce( op )
    }











  // Define the operation function
  // def op(bit: UInt): UInt = {
    // Perform your operation on the bit and return the result
    // Example: return ~bit  // This would invert the bit
    // bit
  // }
