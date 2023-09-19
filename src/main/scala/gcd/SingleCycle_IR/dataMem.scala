package SingleCycle_IR
import chisel3._
import chisel3.util._

class dataMem extends Module {
  val io = IO(new Bundle {
    val addr = Input(UInt(8.W))
    val writeData = Input(Vec(4, UInt(8.W)))
    val enb = Input(Bool())
    val fun3 = Input(UInt(4.W))
    val mask = Input (Vec (4, Bool()))
    val store = Input(Bool())
    val load = Input(Bool())
    val readData = Output(Vec(4, UInt(8.W)))
    // val readData = Output(SInt(dataWidth.W))
  })
  io.readData(0):=1.U
  io.readData(1):=1.U
  io.readData(2):=1.U
  io.readData(3):=1.U
   val mem = Mem(1024, Vec(4, UInt(8.W)))

  // val mem = Mem(depth, SInt(dataWidth.W))

  when(io.store) {
    mem.write(io.addr, io.writeData, io.mask)
  }.otherwise{
  io.readData := mem(io.addr)
  }
  
}
//   val io = IO(new Bundle {
//     val address = Input(UInt(32.W))       // Memory address
//     val writeData = Input(UInt(32.W))     // Data to be written
//     val writeEnable = Input(Bool())       // Write enable signal
//     val writeMask = Input(UInt(4.W))      // Byte masking for writes (1 bit per byte)
//     val readData = Output(UInt(32.W))     // Data read from memory
//   })

//   val memSize = 1024
//   val mem = Mem(memSize, UInt(8.W))      // Byte-addressable memory

//   val byteData = Wire(Vec(4, UInt(8.W))) // Byte-level data

//   // Read data from memory
//   io.readData := Cat(
//     mem.read(io.address, 0.U),          // Byte 0
//     mem.read(io.address + 1.U, 0.U),    // Byte 1
//     mem.read(io.address + 2.U, 0.U),    // Byte 2
//     mem.read(io.address + 3.U, 0.U)     // Byte 3
//   )

//   // Write data to memory with masking
//   when(io.writeEnable) {
//     byteData(0) := Mux(io.writeMask(0), io.writeData(7, 0), mem.read(io.address, 0.U))
//     byteData(1) := Mux(io.writeMask(1), io.writeData(15, 8), mem.read(io.address + 1.U, 0.U))
//     byteData(2) := Mux(io.writeMask(2), io.writeData(23, 16), mem.read(io.address + 2.U, 0.U))
//     byteData(3) := Mux(io.writeMask(3), io.writeData(31, 24), mem.read(io.address + 3.U, 0.U))
//   }.otherwise {
//     byteData := VecInit(Seq.fill(4)(0.U(8.W)))
//   }

//   // Write byteData back to memory
//   mem.write(io.address, byteData(0), io.writeEnable && io.writeMask(0))
//   mem.write(io.address + 1.U, byteData(1), io.writeEnable && io.writeMask(1))
//   mem.write(io.address + 2.U, byteData(2), io.writeEnable && io.writeMask(2))
//   mem.write(io.address + 3.U, byteData(3), io.writeEnable && io.writeMask(3))
// }
