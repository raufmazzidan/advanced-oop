package tp1;

public class One {

  static void printArray(String title, String[] arr) {
    System.out.print(title);

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println("");
  }

  public static void main(String[] args) {
    String[] sourceArray = { "a", "b", "c", "d", "e" };
    printArray("Source : ", sourceArray);

    // Using Looping
    String[] usingLoop = new String[sourceArray.length];
    for (int i = 0; i < sourceArray.length; i++) {
      usingLoop[i] = sourceArray[i];
    }
    printArray("Using Looping : ", usingLoop);

    // Using clone
    String[] usingClone = sourceArray.clone();
    printArray("Using clone : ", usingClone);

    // Using arraycopy
    String[] usingArrayCopy = new String[sourceArray.length];
    System.arraycopy(sourceArray, 0, usingArrayCopy, 0, sourceArray.length);
    printArray("Using arraycopy : ", usingArrayCopy);
  }
}
