.class public EmployeeJas
.super java/lang/Object

.field public ID I
.field public name Ljava/lang/String;
.field static n I

.method public <init>()V
  aload_0
  invokespecial java/lang/Object/<init>()V
  return
.end method

.method public <init>(java/lang/Object)V
   aload_0
   invokespecial    ;Method java/lang/Object."<init>":()V
   aload_0
   iload_1      ;Field ID:I
   putfield
   aload_0
   aload_2       ;Field name:Ljava/lang/String; 
   putfield
   return  
.end method

.method public static main([Ljava/lang/String;)V
  .limit stack 3
  .limit locals 3
  
  new     ;class Employee
  dup           
  iconst_1      
  ldc "Bob"       ;String Bob
  invokespecial       ;Method "<init>":(ILjava/lang/String;)V
  astore_1      
  iconst_5      
  putstatic     ; Field n:5
  
  return
.end method
