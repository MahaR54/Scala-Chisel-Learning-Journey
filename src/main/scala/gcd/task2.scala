package Lab_3
import chisel3 . _
import chisel3 . util . _
class task2 extends Bundle {
val instr = Input ( UInt (32. W ) )
val immd_se = Output ( UInt (32. W ) )
}
class ImmdValGen extends Module {
val io = IO ( new task2 )
// io.instr := 0.U
io.immd_se := 0.U

switch(io.instr(6,0)){
    is("b0010011".U){ //I
        io.immd_se:= Cat(Fill(20,0.U), io.instr(31, 20))
    }
    is("b0100011".U){ //S
        io.immd_se:= Cat(Fill(20,0.U),Cat(io.instr(31,24),io.instr(12,7)))
    
    }
    is("b1100011".U){ //B
        io.immd_se:= Cat(Fill(20,0.U),Cat(Cat(io.instr(31),io.instr(7)),Cat(io.instr(30,26),io.instr(11,8))))

    }
    is("b0110011".U){ //U
        io.immd_se:= Cat(Fill(12,0.U), io.instr(19,0))
    }
    is("b0000011".U){ //L
        io.immd_se:= Cat(Fill(20,0.U), io.instr(31,20))
    }
    is("b1100111".U){ //J
        io.immd_se:=Cat(Fill(20,0.U), Cat(Cat(io.instr(31), io.instr(30,21),Cat(io.instr(20), io.instr(19,12)))))
    }
}
}