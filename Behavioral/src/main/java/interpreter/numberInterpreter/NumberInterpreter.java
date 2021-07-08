package interpreter.numberInterpreter;

public class NumberInterpreter {

  public String getBinaryFormat(Integer i) {
    return Integer.toBinaryString(i);
  }

  public String getHexadecimalFormat(Integer i) {
    return Integer.toHexString(i);
  }
}
