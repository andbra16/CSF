public class Employee {
  int ID;

  java.lang.String name;

  static int n;

  Employee(int, java.lang.String);
    Code:
       0: aload_0       
       1: invokespecial #13                 // Method java/lang/Object."<init>":()V
       4: aload_0       
       5: iload_1       
       6: putfield      #16                 // Field ID:I
       9: aload_0       
      10: aload_2       
      11: putfield      #18                 // Field name:Ljava/lang/String;
      14: return        

  public static void main(java.lang.String[]);
    Code:
       0: new           #1                  // class Employee
       3: dup           
       4: iconst_1      
       5: ldc           #26                 // String Bob
       7: invokespecial #28                 // Method "<init>":(ILjava/lang/String;)V
      10: astore_1      
      11: iconst_5      
      12: putstatic     #30                 // Field n:I
      15: return        
}
