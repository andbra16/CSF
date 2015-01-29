.class public Lab7
.super java/lang/Object

.method public <init>()V
    aload_0
    invokespecial java/lang/Object/<init>()V
    return
.end method

.method public static main([Ljava/lang/String;)V
    .limit stack 6
    .limit locals 4

    iconst_0
    istore_1  ;1 is loop counter i=0
    
    bipush 10
    istore_2  ;2 is number of iterations = 10

    bipush 10
    newarray int
    astore_3   ;3 is address of array
    
    Loop:
    iload_1
    iconst_2
    if_icmpge Skip ;checks if i is greater than 2
    
    aload_3
    iload_1
    iload_1
    iastore  ;stores i in index i of the array

    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload_3
    iload_1
    iaload
    invokevirtual java/io/PrintStream/println(I)V ;print index i
    
    iinc 1 1
    goto Loop
    
    Skip:
    aload_3 ;array address
    iload_1  ;index

    aload_3
    iload_1
    iconst_1
    isub  ;[i-1]
    iaload ;fib[i-1]
    
    aload_3
    iload_1
    iconst_2
    isub  ;[i-2]
    iaload ;fib[i-2]

    iadd ;fib[i-1] + fib[i-2]
    iastore ;store fib[i] in index i
    
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload_3
    iload_1
    iaload
    invokevirtual java/io/PrintStream/println(I)V ;print index[i] 

    iinc 1 1

    iload_1
    iload_2
    if_icmplt Loop

    return
.end method
