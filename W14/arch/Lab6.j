.class public Lab6
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
        .limit stack 3
        .limit locals 3

                     ; #0 is reserved
                     ; #1 is loop counter i
                     ; #2 is number of iterations initially 5
      iconst_0
      istore_1       ; i = 0
      iconst_5
      istore_2
Loop:
      getstatic java/lang/System/out Ljava/io/PrintStream;
      iload_1
      dup
      imul
      invokevirtual java/io/PrintStream/println(I)V
      
      ;You can't move the print statements with the i*i below where you increment
      ;because then you would change the value of what you printed and the comparison
      ;has to be the last thing before the end of the loop
      
      iload_1
      iconst_1       
      iadd     
      istore_1
      iload_1
      iload_2
      if_icmplt     Loop  

      return
.end method
