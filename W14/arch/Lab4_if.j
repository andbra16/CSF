.class public Lab4_if
.super java/lang/Object

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 4
  .limit locals 2

  iconst_5
  istore_1
  iload_1
  iconst_2
  irem

  ifne Skip
  iload_1
  iconst_2
  idiv
  istore_1
  goto End 

  Skip:
  iload_1
  iconst_1
  isub
  istore_1
  goto End

  End:
  getstatic java/lang/System/out Ljava/io/PrintStream;
  iload_1
  invokevirtual java/io/PrintStream/println(I)V

  return
.end method
