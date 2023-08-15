package Lab_1
import chisel3 . _
class Counter( size : Int , maxValue : Int ) extends Module {
val io = IO ( new Bundle {
val result = Output ( Bool () )
})
// ' genCounter ' with counter size 'n '
val count = RegInit (0. U ( size . W ) )
def genCounter ( n : Int , max : Int ) = {
when ( count === max.asUInt ) {
count := 0. U
} .otherwise {
count := count + 1. U
}
count
}
// genCounter instantiation
val counter1 = genCounter ( size , maxValue )
io . result := counter1 ( size -1)
}
//println (( new chisel3 . stage . ChiselStage ) . emitVerilog ( new Counter (8 , 255. U ) ) )