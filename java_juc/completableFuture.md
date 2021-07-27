#Future
Futrue 在 Java 里面，通常用来表示一个异步任务的引用，比如我们将任务提
交到线程池里面，然后我们会得到一个 Futrue，在 Future 里面有 isDone 方
法来 判断任务是否处理结束，还有 get 方法可以一直阻塞直到任务结束然后获
取结果，但整体来说这种方式，还是同步的，因为需要客户端不断阻塞等待或
者不断轮询才能知道任务是否完成。

#CompletableFuture  
`CompletableFuture`用于异步编程，