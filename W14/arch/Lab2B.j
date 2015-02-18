.class public Lab2B
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 4
    .limit locals 2

    getstatic java/lang/System/out Ljava/io/PrintStream;

    ldc 1
    ldc 3
    iadd

    invokevirtual java/io/PrintStream/println(I)V

    return
.end method
