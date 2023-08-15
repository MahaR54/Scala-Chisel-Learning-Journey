package Lab_2
import chisel3 . _
import chisel3 . util . _

class ex2 extends Bundle {
val in0 = Input ( Bool () )
val in1 = Input ( Bool () )
val in2 = Input ( Bool () )
val in3 = Input ( Bool () )
val in4 = Input ( Bool () )
val in5 = Input ( Bool () )
val in6 = Input ( Bool () )
val in7 = Input ( Bool () )
val s0 = Input ( Bool () )
val s1 = Input ( Bool () )
val s2 = Input ( Bool () )
val out = Output ( Bool () )

}

class Mux_8to1 extends Module {
val io = IO ( new ex2)

// val Mux4_to_1_a = Mux ( io . s1 , Mux ( io . s0 , io . in3 , io . in2 ) ,
// Mux ( io . s0 , io . in1  , io . in0 ) )
// val Mux4_to_1_b = Mux ( io . s1 , Mux ( io . s0 , io . in7 , io . in6 ) ,
// Mux ( io . s0 , io . in5 , io . in4 ) )
// val Mux2_to_1 = Mux ( io . s2 , Mux4_to_1_b , Mux4_to_1_a )
     io . out := MuxLookup ( io . s0 , false .B , Array (
        0.U -> MuxLookup (io.s1 , false.B , Array(
            0.U -> MuxLookup(io.s2 , false.B , Array(
                (0.U) -> io.in0,
                (1.U) -> io.in1
            )),
            1.U -> MuxLookup(io.s2 , false.B , Array(
                (0.U) -> io.in2,
                (1.U) -> io.in3
                ))
            )),
        1.U -> MuxLookup (io.s1 , false.B , Array(
            0.U -> MuxLookup(io.s2 , false.B , Array(
                (0.U) -> io.in4,
                (1.U) -> io.in5
            )),
            1.U -> MuxLookup(io.s2 , false.B , Array(
                (0.U) -> io.in6,
                (1.U) -> io.in7))
            ))
    
     ))
             
}