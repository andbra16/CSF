.class public Lab4_loop5
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 4
  .limit locals 3

  ;local variable for i
  iconst_0
  istore_1
  ;local variable for total
  iconst_0
  istore_2
  
  Loop:
  iload_1
  iconst_5
  if_icmpge Skip

  ;update total
  iload_2
  iload_1
  iadd
  istore_2

  ;increment i
  iinc 1 1
  goto Loop
  
  Skip:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload_2
  invokevirtual java/io/PrintStream/println(I)V

  return
.end method
