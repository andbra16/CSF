; Brandon Anderson
; andbra16

.class public LeapYear
.super java/lang/Object

.method public <init>()V
        aload_0
        invokespecial java/lang/Object/<init>()V
        return
.end method

.method public static main([Ljava/lang/String;)V
        .limit stack 4

        getstatic java/lang/System/out Ljava/io/PrintStream;

        sipush 2014
        sipush 1980
        isub
        bipush 4
        idiv
        
        invokevirtual java/io/PrintStream/println(I)V

        return
.end method
