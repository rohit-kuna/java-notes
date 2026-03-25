# Thread
- Thread vs Process
- Thread creation process
    - extending Thread class
    - implementing Runnable Interface / lambda passing
- start() vs run()
- join()
- setPriority()
- Implementing Callable

# Synchronization
- synchronized keyword
    - method level
    - block level
- intrinsic lock
- Object vs Class level lock
- Conditions
- Locks
    - ReentrantLock
    - ReadWriteLock
    - Fair vs Unfair locks
- Deadlock and Resolution

# Inter thread communication
- wait and notify
- Producer - Consumer problem
- wait() vs sleep()
- notify vs notifyAll()

# Java concurrency package
- Why not create threads manually
- Executor Service
- Thread pools
    - FixedThreadPool
    - CachedThreadPool
    - SingleThreadExecutor
- submit() vs execute()

# Runnable, Callable, Future, Completable Future
- Runnable vs Callable
- executorService
- submit vs execute
- Future vs Completable Future
- Async programming

# Synchronizers
- CountDownLatch : one time event
- CyclicBarrier : reusable sync point
- Semaphores : permits manager

# Concurrent Collection
- Concurrent HashMap
- HashMap vs Concurrent HashMap
- CopyOnWriteArrayList -> visualize like a branches git merge

# Atomic variables
- Atomic int, long

# ForkJoin Framework
- Fork Join Pool

# Comparison Questions
- `Runnable` vs `Callable`
- `start()` vs `run()`
- `synchronized` vs `Lock`
- `wait()` vs `sleep()`
- `notify()` vs `notifyAll()`
- `volatile` vs `Atomic`
- `HashMap` vs `ConcurrentHashMap`
- `Future` vs `CompletableFuture`
