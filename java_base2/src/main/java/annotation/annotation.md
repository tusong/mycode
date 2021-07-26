#AnnotatedElement
  
Represents an annotated element of the program currently running in this VM. This interface allows annotations to be read reflectively. All annotations returned by methods in this interface are immutable and serializable. The arrays returned by methods of this interface may be modified by callers without affecting the arrays returned to other callers.  
表示当前在此虚拟机中运行的程序的注解元素。该接口允许以反射方式读取注解。该接口中方法返回的所有注解都是不可变的和可序列化的。调用者可以修改此接口方法返回的数组，而不影响返回给其他调用者的数组。
The getAnnotationsByType(Class) and getDeclaredAnnotationsByType(Class) methods support multiple annotations of the same type on an element. If the argument to either method is a repeatable annotation type (JLS 9.6), then the method will "look through" a container annotation (JLS 9.7), if present, and return any annotations inside the container. Container annotations may be generated at compile-time to wrap multiple annotations of the argument type.
`getAnnotationsByType(Class)`和getDeclaredAnnotationsByType(Class)方法支持一个元素上的多个相同类型的注解。如果任何方法的参数都是可重复的注解类型(JLS 9.6)，那么该方法将“查看”容器注解(JLS 9.7)，如果存在，并返回容器内的任何注解。容器注解可以在编译时生成，以包装参数类型的多个注解。
The terms directly present, indirectly present, present, and associated are used throughout this interface to describe precisely which annotations are returned by methods:
这个接口中使用了直接呈现、间接呈现、呈现和关联的术语来精确描述方法返回的注解:
An annotation A is directly present on an element E if E has a RuntimeVisibleAnnotations or RuntimeVisibleParameterAnnotations or RuntimeVisibleTypeAnnotations attribute, and the attribute contains A.
如果元素E具有RuntimeVisibleAnnotations或RuntimeVisibleParameterAnnotations或RuntimeVisibleTypeAnnotations属性，并且该属性包含A，则注解A将直接出现在元素E上。
An annotation A is indirectly present on an element E if E has a RuntimeVisibleAnnotations or RuntimeVisibleParameterAnnotations or RuntimeVisibleTypeAnnotations attribute, and A 's type is repeatable, and the attribute contains exactly one annotation whose value element contains A and whose type is the containing annotation type of A 's type.
如果元素E具有RuntimeVisibleAnnotations或RuntimeVisibleParameterAnnotations或RuntimeVisibleTypeAnnotations属性,并且A的类型是可重复的,该属性只包含一个注释，其值元素包含A，其类型是包含A类型的注解类型。
An annotation A is present on an element E if either:
在以下情况下，元素E上会出现注释A:
A is directly present on E; or
A直接存在于E上;或
No annotation of A 's type is directly present on E, and E is a class, and A 's type is inheritable, and A is present on the superclass of E.
E上没有A类型的注释，E是一个类，A的类型是可继承的，A存在于E的超类上。
An annotation A is associated with an element E if either:
A is directly or indirectly present on E; or
No annotation of A 's type is directly or indirectly present on E, and E is a class, and A's type is inheritable, and A is associated with the superclass of E.
The table below summarizes which kind of annotation presence different methods in this interface examine.
Overview of kind of presence detected by different AnnotatedElement methods

Kind of Presence
Method
Directly Present
Indirectly Present
Present
Associated
T
getAnnotation(Class<T>)


X

Annotation[]
getAnnotations()


X

T[]
getAnnotationsByType(Class<T>)



X
T
getDeclaredAnnotation(Class<T>)
X



Annotation[]
getDeclaredAnnotations()
X



T[]
getDeclaredAnnotationsByType(Class<T>)
X
X


For an invocation of get[Declared]AnnotationsByType( Class < T >), the order of annotations which are directly or indirectly present on an element E is computed as if indirectly present annotations on E are directly present on E in place of their container annotation, in the order in which they appear in the value element of the container annotation.
There are several compatibility concerns to keep in mind if an annotation type T is originally not repeatable and later modified to be repeatable. The containing annotation type for T is TC.
Modifying T to be repeatable is source and binary compatible with existing uses of T and with existing uses of TC. That is, for source compatibility, source code with annotations of type T or of type TC will still compile. For binary compatibility, class files with annotations of type T or of type TC (or with other kinds of uses of type T or of type TC) will link against the modified version of T if they linked against the earlier version. (An annotation type TC may informally serve as an acting containing annotation type before T is modified to be formally repeatable. Alternatively, when T is made repeatable, TC can be introduced as a new type.)
If an annotation type TC is present on an element, and T is modified to be repeatable with TC as its containing annotation type then:
The change to T is behaviorally compatible with respect to the get[Declared]Annotation(Class<T>) (called with an argument of T or TC) and get[Declared]Annotations() methods because the results of the methods will not change due to TC becoming the containing annotation type for T.
The change to T changes the results of the get[Declared]AnnotationsByType(Class<T>) methods called with an argument of T, because those methods will now recognize an annotation of type TC as a container annotation for T and will "look through" it to expose annotations of type T.
If an annotation of type T is present on an element and T is made repeatable and more annotations of type T are added to the element:
The addition of the annotations of type T is both source compatible and binary compatible.
The addition of the annotations of type T changes the results of the get[Declared]Annotation(Class<T>) methods and get[Declared]Annotations() methods, because those methods will now only see a container annotation on the element and not see an annotation of type T.
The addition of the annotations of type T changes the results of the get[Declared]AnnotationsByType(Class<T>) methods, because their results will expose the additional annotations of type T whereas previously they exposed only a single annotation of type T.
If an annotation returned by a method in this interface contains (directly or indirectly) a Class-valued member referring to a class that is not accessible in this VM, attempting to read the class by calling the relevant Class-returning method on the returned annotation will result in a TypeNotPresentException.
Similarly, attempting to read an enum-valued member will result in a EnumConstantNotPresentException if the enum constant in the annotation is no longer present in the enum type.
If an annotation type T is (meta-)annotated with an @Repeatable annotation whose value element indicates a type TC, but TC does not declare a value() method with a return type of T[], then an exception of type AnnotationFormatError is thrown.
Finally, attempting to read a member whose definition has evolved incompatibly will result in a annotation.AnnotationTypeMismatchException or an annotation.IncompleteAnnotationException.