// import chisel3 . _
// import chisel3 . util . _
// import java . io . File
// class counter_up_down ( n : Int ) extends Module {
// val io = IO ( new Bundle {
// val data_in = Input ( UInt ( n . W ) )

// val out = Output ( Bool () )
// })
// val counter = RegInit (0. U ( n . W ) )
// val clock = RegInit (1. U ( 1 . W ) )
//   when(clock===1.U && counter===io.data_in){
//      counter=counter+1.U
//      clock=0.U  
// }
//     .elsewhen(clock===1.U && counter<<io.data_in){
//         counter=counter+1.U
//     }
//     .elsewhen(clock=0.U && counter===0.U ){
//         counter=counter+1
//     }
//     .elsewhen(clock===0.U && counter>>0.U){
//         counter=counter-1
//     }
//        counter=io.data_in   
// }