package SingleCycle_IR
import chisel3._ 
import chisel3.util._ 
import chisel3.util.experimental.loadMemoryFromFile

class TopModule extends Module{
    val io=IO(new Bundle{
        // val out = Output(SInt(32.W))
    })

    val pc=Module(new Pc)
    dontTouch(pc.io)
    val registerFile=Module(new RagFile)
    val IM=Module(new InstMem("/home/maha/Downloads/Scala-Chisel-Learning-Journey-main/src/main/scala/gcd/SingleCycle_IR/input.txt"))
    val Alu=Module(new ALU)
    // val BR=Module(new Branch)
    val DM=Module(new dataMem)
    val IG=Module(new ImmGen)
    val cu=Module(new CU)
    val str=Module(new Store)
    val ld=Module(new Load)

    //pc
    pc.io.in:=Mux(IM.io.data_out(6,0)==="b1101111".U,(IG.io.imm).asUInt,//jal
    Mux(IM.io.data_out(6,0)==="b1100011".U,// branch
    Mux(Alu.io.out===1.S,(IG.io.imm<<1.U).asUInt,4.U),
    Mux(IM.io.data_out(6,0)==="b1100111".U, (Alu.io.out).asUInt,4.U)))//jalr

    //pc enable is used to jump
    pc.io.enb:=cu.io.jump_pc
    registerFile.io.Wback := 0.S

    //registerfile
    registerFile.io.rs1:=cu.io.rs1
    registerFile.io.rs2:=cu.io.rs2
    registerFile.io.rd:=cu.io.rd
    when(cu.io.inst(6,0)==="b0110011".U){//r-typr
    registerFile.io.Wback:= Alu.io.out
   }
    .elsewhen(cu.io.inst(6,0)==="b0010011".U){//i-type
    registerFile.io.Wback:= Alu.io.out
   }
    .elsewhen(cu.io.inst(6,0)==="b1100011".U){//branch
    registerFile.io.Wback:= Alu.io.out
   }
   .elsewhen(cu.io.inst(6,0)==="b0000011".U){//load
    registerFile.io.Wback:= ld.io.out
   }
    .elsewhen(cu.io.inst(6,0)==="b0110111".U){//u-type
    registerFile.io.Wback:= IG.io.imm
   }
    .elsewhen(cu.io.inst(6,0)==="b0010111".U){//auipc
    registerFile.io.Wback:=((pc.io.out).asSInt + IG.io.imm)
   }
    .elsewhen(cu.io.inst(6,0)==="b1101111".U){//j-type
    registerFile.io.Wback:=((pc.io.out).asSInt+(4.S))
   }
    .elsewhen(cu.io.inst(6,0)==="b1100111".U){//jalr
    registerFile.io.Wback:=(pc.io.out).asSInt+(4.S)
   }.otherwise{
   registerFile.io.Wback:=0.S
   }
    registerFile.io.writeEnable := cu.io.WB

    //InstructionMemory
    IM.io.data_in:=0.S
    IM.io.enb:=cu.io.WB
    IM.io.address:=pc.io.out

    //ALU
    Alu.io.in_A:=registerFile.io.read_rs1
    Alu.io.in_B:=Mux((IM.io.data_out(6,0)==="b0110011".U )||
     (IM.io.data_out(6,0)==="b0100011".U )||
     (IM.io.data_out(6,0)==="b1100011".U ), registerFile.io.read_rs2, //store ya R 
    Mux((IM.io.data_out(6,0)==="b0010011".U )|| 
    (IM.io.data_out(6,0)==="b0000011".U )|| 
    (IM.io.data_out(6,0)==="b1100111".U ) , IG.io.imm, 0.S))
    Alu.io.opcode:=cu.io.inst(6,0)
    Alu.io.alu_Op:=cu.io.fun3_7

    //data memory
     // val cal = RegInit (0.U(32.W))
      // val cal = Output(SInt(32.W))
      DM.io.mask(0):=str.io.mask(0)
      DM.io.mask(1):=str.io.mask(1)
      DM.io.mask(2):=str.io.mask(2)
      DM.io.mask(3):=str.io.mask(3)


      DM.io.fun3:=cu.io.fun3_7
    //   cal:=(Cat(cu.io.inst(31,25),cu.io.inst(11,7))+(registerFile.io.read_rs1).asUInt).asUInt
       DM.io.addr:=Mux(cu.io.inst(6,0)==="b0000011".U,(Alu.io.out).asUInt,
       Mux(cu.io.inst(6,0)==="b0100011".U,(Cat(cu.io.inst(31,25),cu.io.inst(11,7))+(registerFile.io.read_rs1).asUInt).asUInt,0.U))
       DM.io.enb:=cu.io.WB
       DM.io.writeData:= str.io.out
       DM.io.store := cu.io.store
       DM.io.load := cu.io.load

    //imm generator
    IG.io.ins:=IM.io.data_out

    //control unit
    cu.io.inst:=IM.io.data_out

    //store
    str.io.fun3:=cu.io.fun3_7
    str.io.in:=(registerFile.io.read_rs2).asUInt
    str.io.adr:=Mux(cu.io.inst(6,0)==="b0000011".U,(Alu.io.out).asUInt,
    Mux(cu.io.inst(6,0)==="b0100011".U,(Cat(cu.io.inst(31,25),cu.io.inst(11,7))+(registerFile.io.read_rs1).asUInt).asUInt,0.U))
    // when(cu.io.inst(6,0)==="b0100011".U){
    //     str.io.adr:=(Cat(cu.io.inst(31,25),cu.io.inst(11,7)))+(registerFile.io.read_rs1).asUInt
    // }.otherwise{
    //     str.io.adr:=0.U
    // }

    //load
    ld.io.fun3:=cu.io.fun3_7
    ld.io.in:=DM.io.readData
    ld.io.adr:=(Alu.io.out(1,0)).asUInt

    // io.out := registerFile.io.Wback

}
   