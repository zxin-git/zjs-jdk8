package com.zxin.java.design.structure.facade;

/**
 * 门面模式，对外提供封装的门面的接口
 * @author ZHANGXIN130
 */
public class FacadeExample {

}

/* Complex parts */

class CPU {
    public void freeze() {
//        ...
    }
    public void jump(long position) {
//        ...
    }
    public void execute() {
//        ...
    }
}

class Memory {
    public void load(long position, byte[] data) {
//		...
    }
}

class HardDrive {
    public byte[] read(long lba, int size) {
//		...
        return null;
    }
}

/* Façade */

class Computer {

    private CPU cpu = new CPU();

    private Memory memory = new Memory();

    private HardDrive hardDrive = new HardDrive();

    public void startComputer() {
        cpu.freeze();
//        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
//        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

/* Client */

class You {
    public static void main(String[] args) {
        Computer facade = new Computer();
        facade.startComputer();
    }
}
