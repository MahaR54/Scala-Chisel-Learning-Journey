// Mux - Onehot example
package Lab_2
import chisel3 . _
import chisel3 . util . _
class ex3 extends Module {
val io = IO ( new Bundle {
val in0 = Input ( UInt (4. W ) )
val in1 = Input ( UInt (4. W ) )
val in2 = Input ( UInt (4. W ) )
val in3 = Input ( UInt (4. W ) )
val sel = Input ( UInt (4. W ) )
val out = Output ( UInt (2. W ) )
})
io . out := Mux1H ( io . sel , Seq ( io . in0 , io . in1 , io . in2 , io . in3 ) )
}