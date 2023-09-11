 package Lab_7

 import chisel3._
 import chisel3.util._
 import chisel3.stage.ChiselStage
 import chisel3.experimental.ChiselEnum

 class Fsm extends Bundle{
   val f1 = Input(Bool())
   val f2 = Input(Bool())
   val r1 = Input(Bool())
   val r2 = Input(Bool())
  val out = Output( UInt(32.W))
  
 }

 object State extends ChiselEnum {
    val s0, s1, s2, s3, s4, s5 = Value
 }
 import State._
  class ex1 extends Module {
    val io = IO ( new Fsm)
 
   
    val stateReg = RegInit (State.s0)
     // val Ready = RegNext(io.ready)
    val dataToTransfer = Reg(UInt(32.W))

   io.out := 0.U
    switch(stateReg){
     is(State.s0){
         when (io.f1 === 1.U && io.f2 === 0.U){
            stateReg := s1
         }
         when (io.f1 === 0.U && io.f2 === 1.U){
             stateReg := s5
         }
         when (io.f1 === 1.U && io.f2 === 1.U){
             stateReg := s1
         }
         .otherwise{
            stateReg := s0
         }
     }
    
     is(State.s1){
       when (io.f1 === 0.U && io.r1 === 0.U){
       stateReg := s1
       }
       when (io.f1 === 0.U){
         stateReg := s2
       }
       when (io.f1 === 0.U && io.r1 === 1.U){
         stateReg := s0
       }
         .otherwise{
            stateReg := s1
         }
     }

     is (State.s2){
        io.out := 3.U 

       when (io.f1 === 1.U){
          stateReg := s3
       }
       when(io.f1 === 0.U && io.r1===1.U){
         stateReg := s1
       }
        .otherwise{
            stateReg := s0
        }
    }
     is (State.s3){
            stateReg := s0
        }   
     is (State.s4){
        io.out := 7.U
        when(io.f2===1.U){
            stateReg := s3
        } 
        when(io.f2===0.U && io.r2===1.U){
            stateReg := s5
        }
        .otherwise{
            stateReg := s4
        }
     }
     is (State.s5){
        when(io.f2===1.U){
            stateReg :=s4
        }
        when(io.f2===0.U && io.r2===1.U){
            stateReg := s0
        }
        .otherwise{
            stateReg := s5
        }
     }
 }
}
