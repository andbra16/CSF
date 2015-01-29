.class public Lab3A
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

    sipush 240
    sipush 170
    iand

    invokevirtual java/io/PrintStream/println(I)V
	
    getstatic java/lang/System/out Ljava/io/PrintStream;

    sipush 240
    sipush 170
    ior

    invokevirtual java/io/PrintStream/println(I)V

    getstatic java/lang/System/out Ljava/io/PrintStream;
	
    sipush 240
    sipush 170
    ixor

    invokevirtual java/io/PrintStream/println(I)V

    return
.end method
